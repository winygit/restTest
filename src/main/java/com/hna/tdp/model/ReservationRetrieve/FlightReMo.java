/**
 * 
 */
package com.hna.tdp.model.ReservationRetrieve;

import com.hna.tdp.model.FlightSegmentMo;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月13日
 */
public class FlightReMo {

    private String ID;
    private String TotalTravelDuration;
    private FlightSegmentMo FlightSegment;

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getTotalTravelDuration() {
        return TotalTravelDuration;
    }

    public void setTotalTravelDuration(String totalTravelDuration) {
        TotalTravelDuration = totalTravelDuration;
    }

    public FlightSegmentMo getFlightSegment() {
        return FlightSegment;
    }

    public void setFlightSegment(FlightSegmentMo flightSegment) {
        FlightSegment = flightSegment;
    }


}
