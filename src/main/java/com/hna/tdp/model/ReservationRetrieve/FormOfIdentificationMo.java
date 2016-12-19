/**
 * 
 */
package com.hna.tdp.model.ReservationRetrieve;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月13日
 */
public class FormOfIdentificationMo {

    private String ExpiryDate;
    private String FormOfIdentificationNumber;
    private String FormOfIdentificationType;
    private String IssuingLocation;

    public String getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        ExpiryDate = expiryDate;
    }

    public String getFormOfIdentificationNumber() {
        return FormOfIdentificationNumber;
    }

    public void setFormOfIdentificationNumber(String formOfIdentificationNumber) {
        FormOfIdentificationNumber = formOfIdentificationNumber;
    }

    public String getFormOfIdentificationType() {
        return FormOfIdentificationType;
    }

    public void setFormOfIdentificationType(String formOfIdentificationType) {
        FormOfIdentificationType = formOfIdentificationType;
    }

    public String getIssuingLocation() {
        return IssuingLocation;
    }

    public void setIssuingLocation(String issuingLocation) {
        IssuingLocation = issuingLocation;
    }

}
