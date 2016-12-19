package com.hna.model;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.hna.util.MD5;



/**
 * OTA渠道管理
 * 
 * @author winy 2016-8-29
 */
@Component(value = "default")
public class OtaConfig {

    @Value("${gs.mobile.OTACode}")
	private String OTACode;
    @Value("${gs.uat.mobile.key}")
	private String key;
    @Value("${hostIP}")
	private String hostIP;
    @Value("${gs.uat.restUrl}")
    private String restUrl;
    // @Value("${envName}")
    // private String envName;

    private String token;
    private String timestamp;

	public String getOTACode() {
		return OTACode;
	}

	public void setOTACode(String oTACode) {
		OTACode = oTACode;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getHostIP() {
		return hostIP;
	}

	public void setHostIP(String hostIP) {
		this.hostIP = hostIP;
	}

    public String getRestUrl() {
        return restUrl;
    }

    public void setRestUrl(String restUrl) {
        this.restUrl = restUrl;
    }


    public String getToken() {
        // token = this.OTACode + this.hostIP + this.getTimestamp() +
        // this.getKey();
        // this.setIpAuto();
        String text = this.getOTACode() + this.getHostIP() + this.timestamp + this.getKey();
        // token = MD5.getmd5(token);
        // System.err.println("-----------*****************------------------");
        // System.err.println(token);
        token = MD5.toMD5(text);
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTimestamp() {
        timestamp = System.currentTimeMillis() + "";
        setTimestamp(timestamp);
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setIpAuto() {
        try {
            InetAddress ia = InetAddress.getLocalHost();
            this.hostIP = ia.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "OtaConfig [OTACode=" + OTACode + ", key=" + key + ", hostIP=" + hostIP + ", restUrl=" + restUrl
                + ", token=" + this.getToken() + ", timestamp=" + this.getTimestamp() + "]";
    }

}
