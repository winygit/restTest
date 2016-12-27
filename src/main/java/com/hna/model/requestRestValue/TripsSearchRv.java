/**
 * 
 */
package com.hna.model.requestRestValue;

import java.util.List;

/**
 * <p>
 *
 * </p>
 * 
 * @author winy
 * @date 2016年12月20日
 */
public class TripsSearchRv {
    private List<String> legs;
    private List<String> traveler;
    private String flexible;
    // 固定参数
    private String cabin = "Economy";

    public List<String> getLegs() {
        return legs;
    }

    public void setLegs(List<String> legs) {
        this.legs = legs;
    }

    public List<String> getTraveler() {
        return traveler;
    }

    public void setTraveler(List<String> traveler) {
        this.traveler = traveler;
    }

    public String getFlexible() {
        return flexible;
    }

    public void setFlexible(String flexible) {
        this.flexible = flexible;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

}
