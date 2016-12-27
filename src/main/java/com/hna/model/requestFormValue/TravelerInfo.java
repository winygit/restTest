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

    @Override
    public String toString() {
        return "code:" + code + ";fName:" + fName + ";lName:" + lName + ";mobilePhone.number:" + mobilePhoneNumber
                + ";dateOfBirth:" + dateOfBirth + ";document.type:" + documentType + ";document.number:"
                + documentNumber + ";document.country:" + documentCountry + ";document.expirationDate:"
                + documentExpirationDate;
    }

}
