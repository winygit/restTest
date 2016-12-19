/**
 * 
 */
package com.hna.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.hna.model.OtaConfig;

@Component
public class ConfigSevice {

    public OtaConfig getOtaConfig(String env, String ota) {

        @SuppressWarnings("resource")
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mvc.xml");
        String beanName = ota + env;
        return (OtaConfig) applicationContext.getBean(beanName.toLowerCase());
        // if (env.equalsIgnoreCase("uat")) {
        // switch (ota.toLowerCase()) {
        // case "qunar":
        // return (OtaConfig) applicationContext.getBean("qunarUat");
        // case "hbgj":
        // return (OtaConfig) applicationContext.getBean("hbgjUat");
        // default:
        // return (OtaConfig) applicationContext.getBean("mobileUat");
        // }
        // }
        // else {
        // switch (ota.toLowerCase()) {
        // case "qunar":
        // return (OtaConfig) applicationContext.getBean("qunarPro");
        // case "hbgj":
        // return (OtaConfig) applicationContext.getBean("hbgjPro");
        // default:
        // return (OtaConfig) applicationContext.getBean("mobilePro");
        // }
        //
        // }

    }
}
