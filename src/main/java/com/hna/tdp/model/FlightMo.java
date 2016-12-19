/**
 * 
 */
package com.hna.tdp.model;

import java.util.List;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月10日
 */
public class FlightMo {

    private String TotalTravelDuration;
    private List<FlightSegmentMo> FlightSegment;

    public String getTotalTravelDuration() {
        return TotalTravelDuration;
    }

    public void setTotalTravelDuration(String totalTravelDuration) {
        TotalTravelDuration = totalTravelDuration;
    }

    public List<FlightSegmentMo> getFlightSegment() {
        return FlightSegment;
    }

    public void setFlightSegment(List<FlightSegmentMo> flightSegment) {
        FlightSegment = flightSegment;
    }


}
