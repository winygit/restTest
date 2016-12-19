/**
 * 
 */
package com.hna.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.hna.tdp.model.TaxFeeMo;
import com.hna.tdp.model.TaxOrFeeEMo;
import com.hna.tdp.model.TravelerTripPricingMo;
import com.hna.tdp.model.TripMo;
import com.hna.view.TravelerTripPrice;
import com.hna.view.TripCalculation;

@Component
public class TripCalculationRSHelper {

    // model-->value (model和value是一个对象)
    public void getTripCalculationVo(TripMo tripMo) {

        // 主要是实例化TaxFeeRef代表的对象
        for (TravelerTripPricingMo tripPricingMo : tripMo.getTripPricing().getTravelerTripPricing()) {

            if (tripPricingMo.getFare().getFees() != null) {
            for (TaxOrFeeEMo fee : tripPricingMo.getFare().getFees().get("Fee")) {
                String taxFeeRef = fee.getTaxFeeRef();
                TaxFeeMo taxFee = getTaxOrFeeById(tripMo, taxFeeRef);
                fee.setTaxFee(taxFee);
            }

            }

            // 儿童婴儿可能没有tax
            if (tripPricingMo.getFare().getTaxes() != null) {
            for (TaxOrFeeEMo tax : tripPricingMo.getFare().getTaxes().get("Tax")) {
                String taxFeeRef = tax.getTaxFeeRef();
                TaxFeeMo taxFee = getTaxOrFeeById(tripMo, taxFeeRef);
                tax.setTaxFee(taxFee);
            }
            }

        }
    }

    private TaxFeeMo getTaxOrFeeById(TripMo tripMo, String taxFeeRef) {
        for (TaxFeeMo taxFeeMo : tripMo.getTaxFeeContent().get("TaxFee")) {
            if (taxFeeRef.equals(taxFeeMo.getID())) {
                return taxFeeMo;
            }
        }
        return null;
    }
    
    public TripCalculation geTripCalculationData(TripMo tripMo) {

        TripCalculation tripCalculation = new TripCalculation();
        List<TravelerTripPrice> travelerTripPrices = new ArrayList<TravelerTripPrice>();
        BeanUtils.copyProperties(tripMo.getTripPricing(), tripCalculation);

        for (TravelerTripPricingMo ttpriceMo : tripMo.getTripPricing().getTravelerTripPricing()) {
            TravelerTripPrice ttprice = new TravelerTripPrice();

            BeanUtils.copyProperties(ttpriceMo.getFare(), ttprice);
            ttprice.setCode(ttpriceMo.getGuestType().getCode());
            ttprice.setQuantity(ttpriceMo.getGuestType().getQuantity());

            if (ttpriceMo.getFare().getTaxes() != null) {
                ttprice.setTaxAmount(ttpriceMo.getFare().getTaxes().get("Tax").get(0).getAmount());

                ttprice.setTaxID(ttpriceMo.getFare().getTaxes().get("Tax").get(0).getTaxFeeRef());
                ttprice.setTaxname(
                        ttpriceMo.getFare().getTaxes().get("Tax").get(0).getTaxFee().getEntry().get(0).getName());
            }

            if (ttpriceMo.getFare().getFees() != null) {
                ttprice.setFeeAmount(ttpriceMo.getFare().getFees().get("Fee").get(0).getAmount());
                ttprice.setFeeID(ttpriceMo.getFare().getFees().get("Fee").get(0).getTaxFeeRef());
                ttprice.setFeename(
                        ttpriceMo.getFare().getFees().get("Fee").get(0).getTaxFee().getEntry().get(0).getName());
            }

            travelerTripPrices.add(ttprice);

        }
        tripCalculation.setTravelerTripPricing(travelerTripPrices);
        return tripCalculation;
    }

}
