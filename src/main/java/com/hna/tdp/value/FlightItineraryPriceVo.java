/**
 * 
 */
package com.hna.tdp.value;

import java.util.List;

import com.hna.tdp.model.FlightInformationMo;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月9日
 */
public class FlightItineraryPriceVo {

    private int Leg;
    private int Index;
    // private List<Map<String, String>> FlightInformationAttributes;

    private List<FlightInformationAttributeVo> FlightInformationAttributes;
    private FlightInformationMo flightInformationVo;
    private PriceVo priceVo;

    public int getLeg() {
        return Leg;
    }

    public void setLeg(int leg) {
        Leg = leg;
    }

    public int getIndex() {
        return Index;
    }

    public void setIndex(int index) {
        Index = index;
    }

    public FlightInformationMo getFlightInformationVo() {
        return flightInformationVo;
    }

    public void setFlightInformationVo(FlightInformationMo flightInformationVo) {
        this.flightInformationVo = flightInformationVo;
    }

    public PriceVo getPriceVo() {
        return priceVo;
    }

    public void setPriceVo(PriceVo priceVo) {
        this.priceVo = priceVo;
    }

    public List<FlightInformationAttributeVo> getFlightInformationAttributes() {
        return FlightInformationAttributes;
    }

    public void setFlightInformationAttributes(List<FlightInformationAttributeVo> flightInformationAttributes) {
        FlightInformationAttributes = flightInformationAttributes;
    }


}
