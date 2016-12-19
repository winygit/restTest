/**
 * 
 */
package com.hna.tdp.model;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月10日
 */
public class FlightInformationAttributeMo {

    private String BookingClass;
    private String CabinClass;
    private int SeatsAvailable;
    private String FlightSegmentRef;

    public String getBookingClass() {
        return BookingClass;
    }

    public void setBookingClass(String bookingClass) {
        BookingClass = bookingClass;
    }

    public String getCabinClass() {
        return CabinClass;
    }

    public void setCabinClass(String cabinClass) {
        CabinClass = cabinClass;
    }

    public int getSeatsAvailable() {
        return SeatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        SeatsAvailable = seatsAvailable;
    }

    public String getFlightSegmentRef() {
        return FlightSegmentRef;
    }

    public void setFlightSegmentRef(String flightSegmentRef) {
        FlightSegmentRef = flightSegmentRef;
    }

}
