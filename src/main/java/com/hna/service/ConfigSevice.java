/**
 * 
 */
package com.hna.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.hna.model.OtaConfig;

/*
 * 确定otaConfig
 */
@Component
public class ConfigSevice {

    public OtaConfig getOtaConfig(String env, String ota) {

        @SuppressWarnings("resource")
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mvc.xml");
        String beanName = ota + env;
        return (OtaConfig) applicationContext.getBean(beanName.toLowerCase());
    }

    // 登录接口使用的ota只能是mobile
    public OtaConfig getLoginOtaConfig(String env, String ota) {
        return getOtaConfig(env, "mobile");
    }
}
