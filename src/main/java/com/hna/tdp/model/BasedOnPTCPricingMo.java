/**
 * 
 */
package com.hna.tdp.model;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月10日
 */
public class BasedOnPTCPricingMo {

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
