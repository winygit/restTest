/**
 * 
 */
package com.hna.tdp.model;

import java.util.List;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月9日
 */
public class FlightItineraryPriceMo {

    private String ID;
    private int Index;
    private int Leg;
    ///
    private String FlightInformationRef;
    ///
    private String PricePointRef;

    ///
    private List<FlightInformationAttributeMo> FlightInformationAttributes;

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public int getIndex() {
        return Index;
    }

    public void setIndex(int index) {
        Index = index;
    }

    public int getLeg() {
        return Leg;
    }

    public void setLeg(int leg) {
        Leg = leg;
    }

    public String getFlightInformationRef() {
        return FlightInformationRef;
    }

    public void setFlightInformationRef(String flightInformationRef) {
        FlightInformationRef = flightInformationRef;
    }

    public String getPricePointRef() {
        return PricePointRef;
    }

    public void setPricePointRef(String pricePointRef) {
        PricePointRef = pricePointRef;
    }

    public List<FlightInformationAttributeMo> getFlightInformationAttributes() {
        return FlightInformationAttributes;
    }

    public void setFlightInformationAttributes(List<FlightInformationAttributeMo> flightInformationAttributes) {
        FlightInformationAttributes = flightInformationAttributes;
    }

    @Override
    public String toString() {
        return "FlightItineraryPrice [ID=" + ID + ", Index=" + Index + ", Leg=" + Leg + ", FlightInformationRef="
                + FlightInformationRef + ", PricePointRef=" + PricePointRef + ", FlightInformationAttributes="
                + FlightInformationAttributes + "]";
    }

}
