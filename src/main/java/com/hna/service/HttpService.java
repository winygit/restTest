/**
 * 
 */
package com.hna.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.hna.model.OtaConfig;
import com.hna.response.ServiceResult;
import com.hna.util.HttpClientUtil;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月19日
 */
@Component
public class HttpService {

    public ServiceResult sendPost(String url, Map<String, Object> params, OtaConfig otaConfig) {

        ServiceResult serviceResult = new ServiceResult();
        url = urlPro(url);
        serviceResult.setUrl(url);

        if (!params.containsKey("OTACode")) {
            params.put("OTACode", otaConfig.getOTACode());
        }
        if (!params.containsKey("timestamp")) {
            params.put("timestamp", otaConfig.getTimestamp());
        }
        if (!params.containsKey("token")) {
            params.put("token", otaConfig.getToken());
        }

        // 调用Http请求
        HttpClientUtil.sendPost(url, params, serviceResult);
        // serviceResult.setResult(String.valueOf(result));
        return serviceResult;

    }

    public ServiceResult sendPost(String url, HttpServletRequest request, OtaConfig otaConfig) {

        ServiceResult serviceResult = new ServiceResult();
        url = urlPro(url);

        serviceResult.setUrl(url);

        HttpClientUtil.sendPostRequest(request, url, otaConfig, serviceResult);

        return serviceResult;
    }

    private String urlPro(String url) {

        if (url.endsWith(".do")) {
            url = url.substring(0, url.length() - 3);
        }
        return url;
    }

}
