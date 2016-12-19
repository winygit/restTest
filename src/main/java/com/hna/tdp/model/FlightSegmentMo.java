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
public class FlightSegmentMo {

    private String ID;
    private int Sequence;
    private String ArrivalDate;
    private String DepartureDate;
    private String DestinationCode;
    private String DestinationLocationName;
    private String EquipmentCode;
    private String FlightNumber;
    private String MarketingAirline;
    private int NumberOfStops;
    private String OriginCode;
    private String OriginLocationName;
    private String TotalFlightDuration;

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public int getSequence() {
        return Sequence;
    }

    public void setSequence(int sequence) {
        Sequence = sequence;
    }

    public String getArrivalDate() {
        return ArrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        ArrivalDate = arrivalDate;
    }

    public String getDepartureDate() {
        return DepartureDate;
    }

    public void setDepartureDate(String departureDate) {
        DepartureDate = departureDate;
    }

    public String getDestinationCode() {
        return DestinationCode;
    }

    public void setDestinationCode(String destinationCode) {
        DestinationCode = destinationCode;
    }

    public String getDestinationLocationName() {
        return DestinationLocationName;
    }

    public void setDestinationLocationName(String destinationLocationName) {
        DestinationLocationName = destinationLocationName;
    }

    public String getEquipmentCode() {
        return EquipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        EquipmentCode = equipmentCode;
    }

    public String getFlightNumber() {
        return FlightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        FlightNumber = flightNumber;
    }

    public String getMarketingAirline() {
        return MarketingAirline;
    }

    public void setMarketingAirline(String marketingAirline) {
        MarketingAirline = marketingAirline;
    }

    public int getNumberOfStops() {
        return NumberOfStops;
    }

    public void setNumberOfStops(int numberOfStops) {
        NumberOfStops = numberOfStops;
    }

    public String getOriginCode() {
        return OriginCode;
    }

    public void setOriginCode(String originCode) {
        OriginCode = originCode;
    }

    public String getOriginLocationName() {
        return OriginLocationName;
    }

    public void setOriginLocationName(String originLocationName) {
        OriginLocationName = originLocationName;
    }

    public String getTotalFlightDuration() {
        return TotalFlightDuration;
    }

    public void setTotalFlightDuration(String totalFlightDuration) {
        TotalFlightDuration = totalFlightDuration;
    }

}
