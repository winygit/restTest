/**
 * 
 */
package com.hna.model.requestFormValue;

import java.util.List;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月26日
 */
public class CreateReservationFv {

    private String login;
    private String tripOptionId;
    private List<TravelerInfo> traveler;
    private CustomerInfo customer;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTripOptionId() {
        return tripOptionId;
    }

    public void setTripOptionId(String tripOptionId) {
        this.tripOptionId = tripOptionId;
    }

    public List<TravelerInfo> getTraveler() {
        return traveler;
    }

    public void setTraveler(List<TravelerInfo> traveler) {
        this.traveler = traveler;
    }

    public CustomerInfo getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerInfo customer) {
        this.customer = customer;
    }


}
