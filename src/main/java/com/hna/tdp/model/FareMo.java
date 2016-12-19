/**
 * 
 */
package com.hna.tdp.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月10日
 */
public class FareMo {

    private BigDecimal BaseFareAmount;
    private String BaseFareCurrency;
    private BigDecimal TotalFareAmount;
    private String TotalFareCurrency;
    private BigDecimal FullYFareAmount;
    private String FullYFareCurrency;

    private Map<String, List<TaxOrFeeEMo>> Fees;
    private Map<String, List<TaxOrFeeEMo>> Taxes;

    public String getBaseFareCurrency() {
        return BaseFareCurrency;
    }

    public void setBaseFareCurrency(String baseFareCurrency) {
        BaseFareCurrency = baseFareCurrency;
    }

    public String getTotalFareCurrency() {
        return TotalFareCurrency;
    }

    public void setTotalFareCurrency(String totalFareCurrency) {
        TotalFareCurrency = totalFareCurrency;
    }

    public BigDecimal getBaseFareAmount() {
        return BaseFareAmount;
    }

    public void setBaseFareAmount(BigDecimal baseFareAmount) {
        BaseFareAmount = baseFareAmount;
    }

    public BigDecimal getTotalFareAmount() {
        return TotalFareAmount;
    }

    public void setTotalFareAmount(BigDecimal totalFareAmount) {
        TotalFareAmount = totalFareAmount;
    }

    public BigDecimal getFullYFareAmount() {
        return FullYFareAmount;
    }

    public void setFullYFareAmount(BigDecimal fullYFareAmount) {
        FullYFareAmount = fullYFareAmount;
    }

    public String getFullYFareCurrency() {
        return FullYFareCurrency;
    }

    public void setFullYFareCurrency(String fullYFareCurrency) {
        FullYFareCurrency = fullYFareCurrency;
    }

    public Map<String, List<TaxOrFeeEMo>> getFees() {
        return Fees;
    }

    public void setFees(Map<String, List<TaxOrFeeEMo>> fees) {
        Fees = fees;
    }

    public Map<String, List<TaxOrFeeEMo>> getTaxes() {
        return Taxes;
    }

    public void setTaxes(Map<String, List<TaxOrFeeEMo>> taxes) {
        Taxes = taxes;
    }

}
