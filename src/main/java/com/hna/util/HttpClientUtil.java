package com.hna.util;

import java.util.ArrayList;
import java.util.Date;
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
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hna.model.OtaConfig;
import com.hna.response.ServiceResult;
import com.hna.service.ConfigSevice;

@Component
public class HttpClientUtil {

    // private static Logger log =
    // LoggerFactory.getLogger(HttpClientUtil.class);

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
     * @param url
     * @return
     */
    @SuppressWarnings("unchecked")
    public static void sendPost(String url, Map<String, Object> params, ServiceResult serviceResult) {

        PostMethod postMethod = null;
        List<String> paramsList = new ArrayList<>();
        try {
            postMethod = new PostMethod(url);
            postMethod.setRequestHeader("Accept", "application/json");
            // log.debug("Call URL: " + url);
            if (params != null && params.size() > 0) {
                for (String key : params.keySet()) {
                    Object values = params.get(key);
                    if (values instanceof String) {
                        if ("password".equals(key)) {
                            String val = new String(Base64.encodeBase64(MD5.toMD5(values.toString()).getBytes()));
                            postMethod.addParameter(new NameValuePair(key, val));
                            paramsList.add(key + "=" + val);
                            continue;
                        }
                        postMethod.addParameter(new NameValuePair(key, (String) values));
                        paramsList.add(key + "=" + values.toString());
                    } else if (values instanceof List) {
                        for (String value : (ArrayList<String>) values) {
                            postMethod.addParameter(new NameValuePair(key, value));
                            paramsList.add(key + "=" + value);
                        }
                    }

                }
            }
            serviceResult.setParams(paramsList);

            long start = new Date().getTime();
            int statusCode = httpClient.executeMethod(postMethod);
            long end = new Date().getTime();
            serviceResult.setRespondTime(end - start);
            serviceResult.setCode(statusCode);

            if (statusCode != HttpStatus.SC_OK) {
                // log.error("Method failed: " + postMethod.getStatusLine());
                serviceResult.setResult(postMethod.getResponseBodyAsString());
               // return postMethod.getStatusLine();
            }

            String response = IOUtils.toString(postMethod.getResponseBodyAsStream(), "utf-8");
            serviceResult.setResult(response);
           // return response;
        } catch (Exception e) {
            // log.error("Send Post error: ", e);
            serviceResult.setResult(e.getMessage());
           // return null;
        } finally {
            // 释放连接
            if (postMethod != null) {
                postMethod.releaseConnection();
            }
        }
    }

    public void sendPostRequest(HttpServletRequest request, String method, ServiceResult serviceResult) {

        OtaConfig  otaConfig= (OtaConfig) request.getSession().getAttribute("otaconfig");
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
        
        String url = otaConfig.getRestUrl() + request.getServletPath().replace("/new", "").substring(1);
        sendPostRequest(request, url, otaConfig, serviceResult);
    }

    public static void sendPostRequest(HttpServletRequest request, String url, OtaConfig otaConfig,
            ServiceResult serviceResult) {

        List<String> params = new ArrayList<String>();

        PostMethod postMethod = null;
        try {
            postMethod = new PostMethod(url);
            // log.debug("Call URL: " + url);

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
                    // log.debug("{}:{}", name, value);
                    postMethod.addParameter(new NameValuePair(name, value.trim()));
                    params.add(name + "=" + value);

                }
            }

            // 添加必须的访问参数
            if (!parameters.keySet().contains("OTACode")) {
                // log.debug("{}:{}", "OTACode", otaConfig.getOTACode());
                postMethod.addParameter(new NameValuePair("OTACode", otaConfig.getOTACode()));
                params.add("OTACode=" + otaConfig.getOTACode());
            }

            if (!parameters.keySet().contains("timestamp")) {
                // log.debug("{}:{}", "timestamp", otaConfig.getTimestamp());
                postMethod.addParameter(new NameValuePair("timestamp", otaConfig.getTimestamp()));
                params.add("timestamp=" + otaConfig.getTimestamp());
            }

            if (!parameters.keySet().contains("token")) {
                // log.debug("{}:{}", "token", otaConfig.getToken());
                postMethod.addParameter(new NameValuePair("token", otaConfig.getToken()));
                params.add("token=" + otaConfig.getToken());
            }

            serviceResult.setParams(params);

            long start = new Date().getTime();
            int statusCode = httpClient.executeMethod(postMethod);
            long end = new Date().getTime();
            serviceResult.setRespondTime(end - start);

            serviceResult.setCode(statusCode);

            if (statusCode != HttpStatus.SC_OK) {
                // log.error("Method failed: " + postMethod.getStatusLine());
                // serviceReult.setResult(
                // "Method failed: " + postMethod.getStatusLine() + " " +
                // postMethod.getResponseBodyAsString());
                serviceResult.setResult(postMethod.getResponseBodyAsString());
            }

            String response = IOUtils.toString(postMethod.getResponseBodyAsStream(), "UTF-8");
            // //log.debug(response);
            serviceResult.setResult(response);
        } catch (Exception e) {
            // log.error(" RUL: " + url + ",Send Post error: ", e);
            serviceResult.setResult("Error: " + e.getLocalizedMessage());
        } finally {
            // 释放连接
            if (postMethod != null) {
                postMethod.releaseConnection();
            }
        }

    }

}
