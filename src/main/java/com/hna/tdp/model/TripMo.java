/**
 * 
 */
package com.hna.tdp.model;

import java.util.List;
import java.util.Map;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月11日
 */
public class TripMo {

    private String Uri;
    private TripPricingMo TripPricing;
    private Map<String, List<TaxFeeMo>> TaxFeeContent;

    public String getUri() {
        return Uri;
    }

    public void setUri(String uri) {
        Uri = uri;
    }

    public TripPricingMo getTripPricing() {
        return TripPricing;
    }

    public void setTripPricing(TripPricingMo tripPricing) {
        TripPricing = tripPricing;
    }

    public Map<String, List<TaxFeeMo>> getTaxFeeContent() {
        return TaxFeeContent;
    }

    public void setTaxFeeContent(Map<String, List<TaxFeeMo>> taxFeeContent) {
        TaxFeeContent = taxFeeContent;
    }


}
