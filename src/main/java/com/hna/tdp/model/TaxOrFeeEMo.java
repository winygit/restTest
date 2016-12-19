/**
 * 
 */
package com.hna.tdp.model;

import java.math.BigDecimal;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月11日
 */
public class TaxOrFeeEMo {

    private BigDecimal Amount;
    private String CurrencyCode;
    private String TaxFeeRef;
    private TaxFeeMo taxFee;

    public BigDecimal getAmount() {
        return Amount;
    }

    public void setAmount(BigDecimal amount) {
        Amount = amount;
    }

    public String getCurrencyCode() {
        return CurrencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        CurrencyCode = currencyCode;
    }

    public String getTaxFeeRef() {
        return TaxFeeRef;
    }

    public void setTaxFeeRef(String taxFeeRef) {
        TaxFeeRef = taxFeeRef;
    }

    public TaxFeeMo getTaxFee() {
        return taxFee;
    }

    public void setTaxFee(TaxFeeMo taxFee) {
        this.taxFee = taxFee;
    }

}
