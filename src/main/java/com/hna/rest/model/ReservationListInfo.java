/**
 * 
 */
package com.hna.rest.model;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月12日
 */
public class ReservationListInfo {

    private String code;
    private String customerFirstName;
    private String customerLastName;
    private String customerUniqueID;
    private String reservationStatus;
    private String firstFlightAirlineCode;
    private String firstFlightFlightNumber;
    private String primaryAirRecordLocator;
    private String reservationDescription;
    private String source;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerUniqueID() {
        return customerUniqueID;
    }

    public void setCustomerUniqueID(String customerUniqueID) {
        this.customerUniqueID = customerUniqueID;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public String getFirstFlightAirlineCode() {
        return firstFlightAirlineCode;
    }

    public void setFirstFlightAirlineCode(String firstFlightAirlineCode) {
        this.firstFlightAirlineCode = firstFlightAirlineCode;
    }

    public String getFirstFlightFlightNumber() {
        return firstFlightFlightNumber;
    }

    public void setFirstFlightFlightNumber(String firstFlightFlightNumber) {
        this.firstFlightFlightNumber = firstFlightFlightNumber;
    }

    public String getPrimaryAirRecordLocator() {
        return primaryAirRecordLocator;
    }

    public void setPrimaryAirRecordLocator(String primaryAirRecordLocator) {
        this.primaryAirRecordLocator = primaryAirRecordLocator;
    }

    public String getReservationDescription() {
        return reservationDescription;
    }

    public void setReservationDescription(String reservationDescription) {
        this.reservationDescription = reservationDescription;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}
