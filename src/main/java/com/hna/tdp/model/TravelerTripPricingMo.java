/**
 * 
 */
package com.hna.tdp.model;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月11日
 */
public class TravelerTripPricingMo {

    private FareMo Fare;
    private GuestMo GuestType;

    public FareMo getFare() {
        return Fare;
    }

    public void setFare(FareMo fare) {
        Fare = fare;
    }

    public GuestMo getGuestType() {
        return GuestType;
    }

    public void setGuestType(GuestMo guestType) {
        GuestType = guestType;
    }

}
