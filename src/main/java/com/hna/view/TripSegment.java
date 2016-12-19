/**
 * 
 */
package com.hna.view;

import java.math.BigDecimal;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月10日
 */
public class TripSegment {

    // 航程号
    private int leg;
    // 航段号
    private int index;
    // 产品名字
    private String farefamilyName;
    // 退改签规则
    private String ffAttribute;
    // 票面价
    private BigDecimal baseFareAmount;
    // 总价
    private BigDecimal totalFareAmount;
    // Y舱全价
    private BigDecimal fullYFareAmount;
    //出发时间
    private String departureDate;
    //到达时间
    private String arrivalDate;
    //机型
    private String equipmentCode;
    //航班号
    private  String FlightNumber;
    //总耗时
    private String TotalFlightDuration;
    //剩余座位数
    private int seatsAvailable;
    //仓位
    private String bookingClass;
    //仓位类型
    private String cabinClass;

    public int getLeg() {
        return leg;
    }

    public void setLeg(int leg) {
        this.leg = leg;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getFarefamilyName() {
        return farefamilyName;
    }

    public void setFarefamilyName(String farefamilyName) {
        this.farefamilyName = farefamilyName;
    }

    public String getFfAttribute() {
        return ffAttribute;
    }

    public void setFfAttribute(String ffAttribute) {
        this.ffAttribute = ffAttribute;
    }

    public BigDecimal getBaseFareAmount() {
        return baseFareAmount;
    }

    public void setBaseFareAmount(BigDecimal baseFareAmount) {
        this.baseFareAmount = baseFareAmount;
    }

    public BigDecimal getTotalFareAmount() {
        return totalFareAmount;
    }

    public void setTotalFareAmount(BigDecimal totalFareAmount) {
        this.totalFareAmount = totalFareAmount;
    }

    public BigDecimal getFullYFareAmount() {
        return fullYFareAmount;
    }

    public void setFullYFareAmount(BigDecimal fullYFareAmount) {
        this.fullYFareAmount = fullYFareAmount;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    public String getFlightNumber() {
        return FlightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        FlightNumber = flightNumber;
    }

    public String getTotalFlightDuration() {
        return TotalFlightDuration;
    }

    public void setTotalFlightDuration(String totalFlightDuration) {
        TotalFlightDuration = totalFlightDuration;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public String getBookingClass() {
        return bookingClass;
    }

    public void setBookingClass(String bookingClass) {
        this.bookingClass = bookingClass;
    }

    public String getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }


}
