/**
 * 
 */
package com.hna.tdp.model.ReservationRetrieve;

import com.hna.tdp.model.FareMo;
import com.hna.tdp.model.FlightSegmentMo;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月13日
 */
public class FlightFareMo {


    private String ArrivalAirport;
    private String DepartureAirport;
    private String FareBasisCode;
    private String FareFamilyRef;
    private String FilingAirline;
    private String GuestCode;
    private FareMo Fare;

    private FlightSegmentsMo FlightSegments;

    private FlightSegmentMo flightSegmentMo;

    public class FlightSegmentsMo {
        public String FlightSegmentRef;

        public String getFlightSegmentRef() {
            return FlightSegmentRef;
        }

        public void setFlightSegmentRef(String flightSegmentRef) {
            FlightSegmentRef = flightSegmentRef;
        }

    }

    public String getArrivalAirport() {
        return ArrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        ArrivalAirport = arrivalAirport;
    }

    public String getDepartureAirport() {
        return DepartureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        DepartureAirport = departureAirport;
    }

    public String getFareBasisCode() {
        return FareBasisCode;
    }

    public void setFareBasisCode(String fareBasisCode) {
        FareBasisCode = fareBasisCode;
    }

    public String getFareFamilyRef() {
        return FareFamilyRef;
    }

    public void setFareFamilyRef(String fareFamilyRef) {
        FareFamilyRef = fareFamilyRef;
    }

    public String getFilingAirline() {
        return FilingAirline;
    }

    public void setFilingAirline(String filingAirline) {
        FilingAirline = filingAirline;
    }

    public String getGuestCode() {
        return GuestCode;
    }

    public void setGuestCode(String guestCode) {
        GuestCode = guestCode;
    }

    public FareMo getFare() {
        return Fare;
    }

    public void setFare(FareMo fare) {
        Fare = fare;
    }

    public FlightSegmentsMo getFlightSegments() {
        return FlightSegments;
    }

    public void setFlightSegments(FlightSegmentsMo flightSegments) {
        FlightSegments = flightSegments;
    }

    public FlightSegmentMo getFlightSegmentMo() {
        return flightSegmentMo;
    }

    public void setFlightSegmentMo(FlightSegmentMo flightSegmentMo) {
        this.flightSegmentMo = flightSegmentMo;
    }

}
