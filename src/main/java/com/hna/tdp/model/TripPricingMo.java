/**
 * 
 */
package com.hna.tdp.model;

import java.math.BigDecimal;
import java.util.List;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月11日
 */
public class TripPricingMo {

    private BigDecimal TotalFareAmount;
    private String TotalFareCurrency;

    private List<TravelerTripPricingMo> TravelerTripPricing;

    public BigDecimal getTotalFareAmount() {
        return TotalFareAmount;
    }

    public void setTotalFareAmount(BigDecimal totalFareAmount) {
        TotalFareAmount = totalFareAmount;
    }

    public String getTotalFareCurrency() {
        return TotalFareCurrency;
    }

    public void setTotalFareCurrency(String totalFareCurrency) {
        TotalFareCurrency = totalFareCurrency;
    }

    public List<TravelerTripPricingMo> getTravelerTripPricing() {
        return TravelerTripPricing;
    }

    public void setTravelerTripPricing(List<TravelerTripPricingMo> travelerTripPricing) {
        TravelerTripPricing = travelerTripPricing;
    }

}
