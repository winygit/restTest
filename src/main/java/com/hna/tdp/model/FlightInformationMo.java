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
 * @date 2016年12月9日
 */
public class FlightInformationMo {

    private String ID;
    private List<FlightMo> Flight;

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public List<FlightMo> getFlight() {
        return Flight;
    }

    public void setFlight(List<FlightMo> flight) {
        Flight = flight;
    }

}
