/**
 * 
 */
package com.hna.model.requestFormValue;

import java.lang.reflect.Field;

import org.springframework.util.StringUtils;

import com.hna.util.ClassToString;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月26日
 */
public class CustomerInfo extends ClassToString {

    private String code;
    private String fName;
    private String lName;
    private String mobilePhoneNumber;
    private String email;
    private String userName;
    private String userId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        Field[] declaredFields = this.getClass().getDeclaredFields();
        StringBuilder sb = new StringBuilder();

        for (Field field : declaredFields) {
            try {
                if (!StringUtils.isEmpty(field.get(this))) {
                sb.append(field.getName() + ":" + field.get(this) + ";");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (!StringUtils.isEmpty(sb.toString())) {
            String str = sb.toString().substring(0, sb.length() - 1);
            return str.replace("mobilePhoneNumber", "mobilePhone.number");
        }
        return null;
        // return "code:" + code + ";fName:" + fName + ";lName:" + lName +
        // ";mobilePhone.number:" + mobilePhoneNumber
        // + ";email:" + email + ";userName:" + userName + ";userId:" + userId;
    }

    public static void main(String[] args) {
        CustomerInfo test = new CustomerInfo();
        test.setCode("oopp");
        test.setEmail("winy@163.com");
        test.setlName("test");
        System.out.println(test);
        System.out.println(test.getString(test));
    }

}
