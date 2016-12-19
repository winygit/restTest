/**
 * 
 */
package com.hna.view;

import java.util.List;

import javax.swing.text.Document;

import com.hna.tdp.model.ReservationRetrieve.CustomerMo;
import com.hna.tdp.model.ReservationRetrieve.FlightFareMo;
import com.hna.tdp.model.ReservationRetrieve.PurchaseMo;
import com.hna.tdp.model.ReservationRetrieve.TravelerMo;

/**
 * <p>
 * 订单详情 Form Object
 * </p>
 * 
 * @author winy
 * @date 2016年12月13日
 */
public class ReservationFo {

    /*
     * 直接使用model对象
     */
    private String Code;
    private String Source;
    private String Status;

    private List<TravelerMo> Traveler;
    private List<CustomerMo> Customer;
    private PurchaseMo Purchase;

    /*
     * 主要是Document,价格信息 和 航班信息
     */
    private List<Document> Document;
    private TravelerTripPrice TripPrices;
    private List<FlightFareMo> FlightFares;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
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

    public List<TravelerMo> getTraveler() {
        return Traveler;
    }

    public void setTraveler(List<TravelerMo> traveler) {
        Traveler = traveler;
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

    public List<Document> getDocument() {
        return Document;
    }

    public void setDocument(List<Document> document) {
        Document = document;
    }

    public TravelerTripPrice getTripPrices() {
        return TripPrices;
    }

    public void setTripPrices(TravelerTripPrice tripPrices) {
        TripPrices = tripPrices;
    }

    public List<FlightFareMo> getFlightFares() {
        return FlightFares;
    }

    public void setFlightFares(List<FlightFareMo> flightFares) {
        FlightFares = flightFares;
    }

}
