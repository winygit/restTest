/**
 * 
 */
package com.hna.tdp.value;

import com.hna.tdp.model.FlightSegmentMo;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月10日
 */
public class FlightInformationAttributeVo {

    private String BookingClass;
    private String CabinClass;
    private int SeatsAvailable;
    private FlightSegmentMo FlightSegment;

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

    public FlightSegmentMo getFlightSegment() {
        return FlightSegment;
    }

    public void setFlightSegment(FlightSegmentMo flightSegment) {
        FlightSegment = flightSegment;
    }

}
