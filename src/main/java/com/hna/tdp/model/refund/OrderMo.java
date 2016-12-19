/**
 * 
 */
package com.hna.tdp.model.refund;

import java.util.List;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月14日
 */
public class OrderMo {

    private String OrderNo;
    private String Status;

    private CustomerMo Customer;
    private List<GuestMo> Guests;
    
    public String getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(String orderNo) {
        OrderNo = orderNo;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public CustomerMo getCustomer() {
        return Customer;
    }

    public void setCustomer(CustomerMo customer) {
        Customer = customer;
    }

    public List<GuestMo> getGuests() {
        return Guests;
    }

    public void setGuests(List<GuestMo> guests) {
        Guests = guests;
    }

}
