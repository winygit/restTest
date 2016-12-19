/**
 * 
 */
package com.hna.view;

import java.math.BigDecimal;
import java.util.List;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月11日
 */
public class TripCalculation {

    // 总费用
    private BigDecimal TotalFareAmount;
    // 费用明细
    private List<TravelerTripPrice> TravelerTripPricing;

    public BigDecimal getTotalFareAmount() {
        return TotalFareAmount;
    }

    public void setTotalFareAmount(BigDecimal totalFareAmount) {
        TotalFareAmount = totalFareAmount;
    }

    public List<TravelerTripPrice> getTravelerTripPricing() {
        return TravelerTripPricing;
    }

    public void setTravelerTripPricing(List<TravelerTripPrice> travelerTripPricing) {
        TravelerTripPricing = travelerTripPricing;
    }

}
