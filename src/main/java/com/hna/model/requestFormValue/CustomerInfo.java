/**
 * 
 */
package com.hna.model.requestFormValue;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月26日
 */
public class CustomerInfo {

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
        return "code:" + code + ";fName:" + fName + ";lName:" + lName + ";mobilePhone.number:" + mobilePhoneNumber
                + ";email:" + email + ";userName:" + userName + ";userId:" + userId;
    }


}
