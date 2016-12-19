/**
 * 
 */
package com.hna.tdp.model.ReservationRetrieve;

import java.util.List;
import java.util.Map;

import com.hna.tdp.model.TaxFeeMo;
import com.hna.tdp.model.TripPricingMo;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月13日
 */
public class AirTripMo {

    private List<FlightFareMo> FlightFare;
    private Map<String, List<FlightReMo>> FlightInformation;

    private TripPricingMo TripPricing;
    private Map<String, List<TaxFeeMo>> TaxFeeContent;

    public List<FlightFareMo> getFlightFare() {
        return FlightFare;
    }

    public void setFlightFare(List<FlightFareMo> flightFare) {
        FlightFare = flightFare;
    }

    public TripPricingMo getTripPricing() {
        return TripPricing;
    }

    public void setTripPricing(TripPricingMo tripPricing) {
        TripPricing = tripPricing;
    }

    public Map<String, List<FlightReMo>> getFlightInformation() {
        return FlightInformation;
    }

    public void setFlightInformation(Map<String, List<FlightReMo>> flightInformation) {
        FlightInformation = flightInformation;
    }

    public Map<String, List<TaxFeeMo>> getTaxFeeContent() {
        return TaxFeeContent;
    }

    public void setTaxFeeContent(Map<String, List<TaxFeeMo>> taxFeeContent) {
        TaxFeeContent = taxFeeContent;
    }

}
