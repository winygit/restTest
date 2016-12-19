package com.hna.tdp.value;

import com.hna.tdp.model.BasedOnPTCPricingMo;
import com.hna.tdp.model.FareFamilyMo;

public class PriceVo {
    private String ID;
    private FareFamilyMo FareFamily;

    private BasedOnPTCPricingMo BasedOnPTCPricing;

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public FareFamilyMo getFareFamily() {
        return FareFamily;
    }

    public void setFareFamily(FareFamilyMo fareFamily) {
        FareFamily = fareFamily;
    }

    public BasedOnPTCPricingMo getBasedOnPTCPricing() {
        return BasedOnPTCPricing;
    }

    public void setBasedOnPTCPricing(BasedOnPTCPricingMo basedOnPTCPricing) {
        BasedOnPTCPricing = basedOnPTCPricing;
    }

}
