/**
 * 
 */
package com.hna.view;

import java.math.BigDecimal;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月11日
 */
public class TravelerTripPrice {

    private BigDecimal BaseFareAmount;
    private BigDecimal TotalFareAmount;
    private String Code;
    private int Quantity;

    /*
     * 考虑 fee和tax都只有一种或者没有
     */
    private BigDecimal feeAmount = BigDecimal.ZERO;
    private String feename = null;
    private String feeID = null;

    private BigDecimal taxAmount = BigDecimal.ZERO;
    private String taxname = null;
    private String taxID = null;

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

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public BigDecimal getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getFeename() {
        return feename;
    }

    public void setFeename(String feename) {
        this.feename = feename;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getTaxname() {
        return taxname;
    }

    public void setTaxname(String taxname) {
        this.taxname = taxname;
    }

    public String getFeeID() {
        return feeID;
    }

    public void setFeeID(String feeID) {
        this.feeID = feeID;
    }

    public String getTaxID() {
        return taxID;
    }

    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

}
