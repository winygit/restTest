/**
 * 
 */
package com.hna.model.requestRestValue;

import java.util.List;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月26日
 */
public class CreateReservationRv {

    private String login;
    private String tripOptionId;
    private List<String> traveler;
    private String customer;

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

    public List<String> getTraveler() {
        return traveler;
    }

    public void setTraveler(List<String> traveler) {
        this.traveler = traveler;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

}
