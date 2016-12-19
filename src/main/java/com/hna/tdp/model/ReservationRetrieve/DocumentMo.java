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
public class DocumentMo {

    private String Number;
    private String Status;
    private String Type;

    private String TravelerReference;
    private TravelerMo traveler;

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getTravelerReference() {
        return TravelerReference;
    }

    public void setTravelerReference(String travelerReference) {
        TravelerReference = travelerReference;
    }

    public TravelerMo getTraveler() {
        return traveler;
    }

    public void setTraveler(TravelerMo traveler) {
        this.traveler = traveler;
    }

}
