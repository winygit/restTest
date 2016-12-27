/**
 * 
 */
package com.hna.response;

import java.util.List;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月12日
 */
public class ServiceResult {

    public String url;
    public List<String> params;
    // http 请求返回的状态码
    public int code;
    // result 为返回的json 字符串
    public String result;
    public Object data;
    public String resultJsp = "default";
    public String method;

    public long respondTime;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getResultJsp() {
        return resultJsp;
    }

    public void setResultJsp(String resultJsp) {
        this.resultJsp = resultJsp;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public long getRespondTime() {
        return respondTime;
    }

    public void setRespondTime(long respondTime) {
        this.respondTime = respondTime;
    }

}
