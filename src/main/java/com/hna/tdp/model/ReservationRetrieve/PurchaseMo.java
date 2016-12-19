/**
 * 
 */
package com.hna.tdp.model.ReservationRetrieve;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月13日
 */
public class PurchaseMo {

    private String FormOfPayment;
    private String PaymentCardTypeCode;
    private String PurchaseAmount;
    private String PurchaseCurrency;
    private String PurchaserReference;
    
    public String getFormOfPayment() {
        return FormOfPayment;
    }

    public void setFormOfPayment(String formOfPayment) {
        FormOfPayment = formOfPayment;
    }

    public String getPaymentCardTypeCode() {
        return PaymentCardTypeCode;
    }

    public void setPaymentCardTypeCode(String paymentCardTypeCode) {
        PaymentCardTypeCode = paymentCardTypeCode;
    }

    public String getPurchaseAmount() {
        return PurchaseAmount;
    }

    public void setPurchaseAmount(String purchaseAmount) {
        PurchaseAmount = purchaseAmount;
    }

    public String getPurchaseCurrency() {
        return PurchaseCurrency;
    }

    public void setPurchaseCurrency(String purchaseCurrency) {
        PurchaseCurrency = purchaseCurrency;
    }

    public String getPurchaserReference() {
        return PurchaserReference;
    }

    public void setPurchaserReference(String purchaserReference) {
        PurchaserReference = purchaserReference;
    }

}
