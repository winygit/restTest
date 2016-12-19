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
public class CustomerMo {

    private String FirstName;
    private String LastName;

    private List<EmailMo> Email;

    private List<PhoneMo> Phone;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public List<EmailMo> getEmail() {
        return Email;
    }

    public void setEmail(List<EmailMo> email) {
        Email = email;
    }

    public List<PhoneMo> getPhone() {
        return Phone;
    }

    public void setPhone(List<PhoneMo> phone) {
        Phone = phone;
    }

}
