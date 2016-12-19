/**
 * 
 */
package com.hna.tdp.value;

import java.util.List;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月9日
 */
public class AirLowFareSearchRSVo {

    private String Uri;
    private List<FlightItineraryPriceVo> flightItineraryPricesVos;


    public String getUri() {
        return Uri;
    }

    public void setUri(String uri) {
        Uri = uri;
    }

    public List<FlightItineraryPriceVo> getFlightItineraryPricesVos() {
        return flightItineraryPricesVos;
    }

    public void setFlightItineraryPricesVos(List<FlightItineraryPriceVo> flightItineraryPricesVos) {
        this.flightItineraryPricesVos = flightItineraryPricesVos;
    }


}
