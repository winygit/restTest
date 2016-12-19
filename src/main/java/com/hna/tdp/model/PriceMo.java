/**
 * 
 */
package com.hna.tdp.model;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月9日
 */
public class PriceMo {

    private String ID;
    private String FareFamilyRef;

    private BasedOnPTCPricingMo BasedOnPTCPricing;

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getFareFamilyRef() {
        return FareFamilyRef;
    }

    public void setFareFamilyRef(String fareFamilyRef) {
        FareFamilyRef = fareFamilyRef;
    }

    public BasedOnPTCPricingMo getBasedOnPTCPricing() {
        return BasedOnPTCPricing;
    }

    public void setBasedOnPTCPricing(BasedOnPTCPricingMo basedOnPTCPricing) {
        BasedOnPTCPricing = basedOnPTCPricing;
    }


}
