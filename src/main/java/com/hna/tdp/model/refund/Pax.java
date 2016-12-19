/**
 * 
 */
package com.hna.tdp.model.refund;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月14日
 */
public class Pax {

    private String Cabin;
    private String DepTime;
    private String Dst;
    private String FlightDate;

    private String FlightNo;
    private String ID;
    private String Org;

    private String RefundRule;
    private String TicketNo;
    private String TicketStatus;
    private String Name;

    public String getCabin() {
        return Cabin;
    }

    public void setCabin(String cabin) {
        Cabin = cabin;
    }

    public String getDepTime() {
        return DepTime;
    }

    public void setDepTime(String depTime) {
        DepTime = depTime;
    }

    public String getDst() {
        return Dst;
    }

    public void setDst(String dst) {
        Dst = dst;
    }

    public String getFlightDate() {
        return FlightDate;
    }

    public void setFlightDate(String flightDate) {
        FlightDate = flightDate;
    }

    public String getFlightNo() {
        return FlightNo;
    }

    public void setFlightNo(String flightNo) {
        FlightNo = flightNo;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getOrg() {
        return Org;
    }

    public void setOrg(String org) {
        Org = org;
    }

    public String getRefundRule() {
        return RefundRule;
    }

    public void setRefundRule(String refundRule) {
        RefundRule = refundRule;
    }

    public String getTicketNo() {
        return TicketNo;
    }

    public void setTicketNo(String ticketNo) {
        TicketNo = ticketNo;
    }

    public String getTicketStatus() {
        return TicketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        TicketStatus = ticketStatus;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

}
