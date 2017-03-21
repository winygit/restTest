/**
 * 
 */
package com.hna.model;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2017年3月9日
 */
public class EvnInfo {

    private String evn = "uat";
    private String otaCode = "mobile";
    private String userName;
    private String userID;
    private String login;

    public String getEvn() {
        return evn;
    }

    public void setEvn(String evn) {
        this.evn = evn;
    }

    public String getOtaCode() {
        return otaCode;
    }

    public void setOtaCode(String otaCode) {
        this.otaCode = otaCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
