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
public class ReservationInfoMo {

    private String Code;
    private String Description;
    private String Source;
    private String Status;

    private PurchaseMo Purchase;
    private List<ReservationElementMo> ReservationElement;

    private List<CustomerMo> Customer;
    private List<TravelerMo> Traveler;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public List<CustomerMo> getCustomer() {
        return Customer;
    }

    public void setCustomer(List<CustomerMo> customer) {
        Customer = customer;
    }

    public PurchaseMo getPurchase() {
        return Purchase;
    }

    public void setPurchase(PurchaseMo purchase) {
        Purchase = purchase;
    }

    public List<ReservationElementMo> getReservationElement() {
        return ReservationElement;
    }

    public void setReservationElement(List<ReservationElementMo> reservationElement) {
        ReservationElement = reservationElement;
    }

    public List<TravelerMo> getTraveler() {
        return Traveler;
    }

    public void setTraveler(List<TravelerMo> traveler) {
        Traveler = traveler;
    }

}
