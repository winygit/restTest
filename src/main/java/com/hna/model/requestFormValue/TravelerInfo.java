/**
 * 
 */
package com.hna.model.requestFormValue;

import java.lang.reflect.Field;

import org.springframework.util.StringUtils;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月26日
 */
public class TravelerInfo {

    private String code;
    private String fName;
    private String lName;
    private String mobilePhoneNumber;
    private String dateOfBirth;
    private String documentType;
    private String documentNumber;
    private String documentCountry;
    private String documentExpirationDate;

    private String citizenship;
    // private String placeOfBirth;
    private String gender;

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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentCountry() {
        return documentCountry;
    }

    public void setDocumentCountry(String documentCountry) {
        this.documentCountry = documentCountry;
    }

    public String getDocumentExpirationDate() {
        return documentExpirationDate;
    }

    public void setDocumentExpirationDate(String documentExpirationDate) {
        this.documentExpirationDate = documentExpirationDate;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    // public String getPlaceOfBirth() {
    // return placeOfBirth;
    // }
    //
    // public void setPlaceOfBirth(String placeOfBirth) {
    // this.placeOfBirth = placeOfBirth;
    // }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        // return "code:" + code + ";fName:" + fName + ";lName:" + lName +
        // ";mobilePhone.number:" + mobilePhoneNumber
        // + ";dateOfBirth:" + dateOfBirth + ";document.type:" + documentType +
        // ";document.number:"
        // + documentNumber + ";document.country:" + documentCountry +
        // ";document.expirationDate:"
        // + documentExpirationDate + ";citizenship:" + citizenship + ";gender:"
        // + gender;
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
            return str.replace("documentType", "document.type").replace("mobilePhoneNumber", "mobilePhone.number")
                    .replace("documentNumber", "document.number").replace("documentCountry", "document.country")
                    .replace("documentExpirationDate", "document.expirationDate");
        }
        return null;
    }

}
