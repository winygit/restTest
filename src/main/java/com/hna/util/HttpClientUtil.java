package com.hna.util;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hna.model.OtaConfig;
import com.hna.response.ServiceResult;
import com.hna.service.ConfigSevice;

@Component
public class HttpClientUtil {

    private static Logger log = LoggerFactory.getLogger(HttpClientUtil.class);

    private static final HttpClient httpClient;

    @Resource(name = "default")
    private OtaConfig otaConfigDefault;
    @Autowired
    private ConfigSevice configSevice;


    static {
        HttpConnectionManager httpConnectionManager = new MultiThreadedHttpConnectionManager();
        HttpConnectionManagerParams params = httpConnectionManager.getParams();
        params.setConnectionTimeout(300000);
        params.setSoTimeout(300000);
        params.setDefaultMaxConnectionsPerHost(32);// very important!!
        params.setMaxTotalConnections(256);// very important!!
        httpClient = new HttpClient(new HttpClientParams(), httpConnectionManager);
        httpClient.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler(0, false));
        httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
    }

    /**
     * @param request
     * @param URI
     * @return
     */
    public static Object sendGetRequest(HttpServletRequest request, String URI) {
        try {
            StringBuffer url = new StringBuffer(URI);

            Map<String, String[]> parameters = request.getParameterMap();
            for (Map.Entry<String, String[]> entry : parameters.entrySet()) {
                String[] values = entry.getValue();
                String name = entry.getKey();

                for (String value : values) {
                    log.debug(name + "=" + value);
                    url.append("&").append(name).append("=").append(URLEncoder.encode(value, "UTF-8"));
                }
            }
            return sendGetRequest(url.toString().replace(".json&", ".json?"));
        } catch (Exception e) {
            log.error("Send  request error:  ", e);
            return null;
        }
    }

    /**
     * @param url
     * @return
     */
    public static Object sendGetRequest(String url) {
        GetMethod getMethod = null;
        try {
            getMethod = new GetMethod(url);
            getMethod.setRequestHeader("Accept", "application/json");

            log.info("Call  URL:  " + url);
            int statusCode = httpClient.executeMethod(getMethod);

            if (statusCode != HttpStatus.SC_OK) {
                log.error("Method failed: " + getMethod.getStatusLine());
                return null;
            }
            byte[] responseBody = getMethod.getResponseBody();

            String response = new String(responseBody, "UTF-8");

            log.info(response);
            return response;
        } catch (Exception e) {
            log.error("Send request error:  ", e);
            return null;
        } finally {
            // 释放连接
            if (getMethod != null)
                getMethod.releaseConnection();
        }
    }

    /**
     * @param url
     * @return
     */
    public static Object sendPost(String url, Map<String, Object> params) {
        PostMethod postMethod = null;
        try {
            postMethod = new PostMethod(url);
            postMethod.setRequestHeader("Accept", "application/json");
            log.debug("Call  URL:  " + url);
            if (params != null && params.size() > 0) {
                for (String key : params.keySet()) {
                    // 非list
                    if (!ArrayList.class.isAssignableFrom(params.get(key).getClass())) {
                        postMethod.addParameter(new NameValuePair(key, params.get(key).toString()));
                        log.debug("{}:{}", key, params.get(key));
                    }
                    // list
                    else
                    {
                        for(String value:(List<String>)params.get(key) )
                        {
                            postMethod.addParameter(new NameValuePair(key, value));
                            log.debug("{}:{}", key, value);
                        }
                    }
                }
            }

            int statusCode = httpClient.executeMethod(postMethod);

            if (statusCode != HttpStatus.SC_OK) {
                log.error("Method failed: " + postMethod.getStatusLine());
                return postMethod.getStatusLine();
            }

            String response = IOUtils.toString(postMethod.getResponseBodyAsStream(), "utf-8");

            // log.debug(response);
            return response;
        } catch (Exception e) {
            log.error("Send Post error:  ", e);
            return null;
        } finally {
            // 释放连接
            if (postMethod != null) {
                postMethod.releaseConnection();
            }
        }
    }

    public ServiceResult sendPostRequest(HttpServletRequest request, String method) {

        OtaConfig  otaConfig= (OtaConfig) request.getSession().getAttribute("otaconfig");
        
        // 默认值
        if (otaConfig == null) {
            otaConfig = otaConfigDefault;
        }

        // 登录
        if (method.contains("login"))
        {
            // 如果是生产环境
            if ("pro".equalsIgnoreCase(request.getParameter("env"))) {
                otaConfig = configSevice.getOtaConfig("pro", "mobile");
            } else {
                otaConfig = configSevice.getOtaConfig("uat", "mobile");
            }
        }
        
        ServiceResult serviceReult = new ServiceResult();
        List<String> params = new ArrayList<String>();
        String url = otaConfig.getRestUrl() + method;

        // .do 结尾的去掉.do
        if (url.endsWith(".do")) {
            url = url.substring(0, url.length() - 3);
        }

        PostMethod postMethod = null;
        try {
            postMethod = new PostMethod(url);
            log.debug("Call  URL:  " + url);
            serviceReult.setUrl(url);

            Map<String, String[]> parameters = request.getParameterMap();
            for (Map.Entry<String, String[]> entry : parameters.entrySet()) {
                String[] values = entry.getValue();
                String name = entry.getKey();
                // 密码需要加密处理
                if ("password".equals(name)) {
                    String val0 = values[0].trim();
                    String val = new String(Base64.encodeBase64(MD5.toMD5(val0).getBytes()));
                    postMethod.addParameter(new NameValuePair(name, val));
                    params.add(name + "=" + val);
                    continue;
                }

                for (String value : values) {
                    log.debug("{}:{}", name, value);
                    postMethod.addParameter(new NameValuePair(name, value.trim()));
                    params.add(name + "=" + value);

                }
            }

            // 添加必须的访问参数
            log.debug("----------必带的参数-------------");
            if (!parameters.keySet().contains("OTACode")) {
                log.debug("{}:{}", "OTACode", otaConfig.getOTACode());
                postMethod.addParameter(new NameValuePair("OTACode", otaConfig.getOTACode()));
                params.add("OTACode=" + otaConfig.getOTACode());
            }

            if (!parameters.keySet().contains("timestamp")) {
                log.debug("{}:{}", "timestamp", otaConfig.getTimestamp());
                postMethod.addParameter(new NameValuePair("timestamp", otaConfig.getTimestamp()));
                params.add("timestamp=" + otaConfig.getTimestamp());
            }

            if (!parameters.keySet().contains("token")) {
                log.debug("{}:{}", "token", otaConfig.getToken());
                postMethod.addParameter(new NameValuePair("token", otaConfig.getToken()));
                params.add("token=" + otaConfig.getToken());
            }


            serviceReult.setParams(params);

            int statusCode = httpClient.executeMethod(postMethod);

            serviceReult.setCode(statusCode);

            if (statusCode != HttpStatus.SC_OK) {
                log.error("Method failed: " + postMethod.getStatusLine());
                // serviceReult.setResult(
                // "Method failed: " + postMethod.getStatusLine() + " " +
                // postMethod.getResponseBodyAsString());
                serviceReult.setResult(
                        postMethod.getResponseBodyAsString());

                return serviceReult;
            }

            String response = IOUtils.toString(postMethod.getResponseBodyAsStream(), "UTF-8");
            // log.debug(response);
            serviceReult.setResult(response);
            return serviceReult;
        } catch (Exception e) {
            log.error(" RUL: " + url + ",Send Post error:  ", e);
            serviceReult.setResult("Error: " + e.getLocalizedMessage());
            return serviceReult;
        } finally {
            // 释放连接
            if (postMethod != null) {
                postMethod.releaseConnection();
            }
        }
    }

}
