/**
 * 
 */
package com.hna.model.requestFormValue;

/**
 * <p>
 *
 * </p>
 * 
 * @author winy
 * @date 2016年12月20日
 */
public class TripSearchFv {

    private String origin;
    private String destination;
    private String date;
    private Integer adtNum = 0;
    private Integer cnnNum = 0;
    private Integer infNum = 0;
    private Integer trip;
    private String returnDate;
    private String flexible;



    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getAdtNum() {
        return adtNum;
    }

    public void setAdtNum(Integer adtNum) {
        this.adtNum = adtNum;
    }

    public Integer getCnnNum() {
        return cnnNum;
    }

    public void setCnnNum(Integer cnnNum) {
        this.cnnNum = cnnNum;
    }

    public Integer getInfNum() {
        return infNum;
    }

    public void setInfNum(Integer infNum) {
        this.infNum = infNum;
    }

    public Integer getTrip() {
        return trip;
    }

    public void setTrip(Integer trip) {
        this.trip = trip;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getFlexible() {
        return flexible;
    }

    public void setFlexible(String flexible) {
        this.flexible = flexible;
    }


}
