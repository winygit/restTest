/**
 * 
 */
package com.hna.tdp.model.ReservationRetrieve;

import java.util.List;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月13日
 */
public class TravelerMo {

    private String DateOfBirth;
    private String FirstName;
    private String GuestTypeCode;
    private String LastName;
    private String ID;

    private FormOfIdentificationMo FormOfIdentification;
    private List<PhoneMo> Phone;

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getGuestTypeCode() {
        return GuestTypeCode;
    }

    public void setGuestTypeCode(String guestTypeCode) {
        GuestTypeCode = guestTypeCode;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public FormOfIdentificationMo getFormOfIdentification() {
        return FormOfIdentification;
    }

    public void setFormOfIdentification(FormOfIdentificationMo formOfIdentification) {
        FormOfIdentification = formOfIdentification;
    }

    public List<PhoneMo> getPhone() {
        return Phone;
    }

    public void setPhone(List<PhoneMo> phone) {
        Phone = phone;
    }

}
