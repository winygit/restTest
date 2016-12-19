package com.hna.tdp.model;

import java.util.List;
import java.util.Map;

public class AirLowFareSearchRSMo {

    private String Uri;
    private String Clientid;

    private Map<String, List<FlightItineraryPriceMo>> FlightItineraryPricePoints;
    private Map<String, List<FareFamilyMo>> FareFamilyContent;
    private Map<String, List<FlightInformationMo>> FlightInformationSummary;
    private Map<String, List<PriceMo>> PricePointSummary;
    // private Map<String, Map<String, List<String>>> SelectedTrip;

    public String getUri() {
        return Uri;
    }

    public void setUri(String uri) {
        Uri = uri;
    }

    public String getClientid() {
        return Clientid;
    }

    public void setClientid(String clientid) {
        Clientid = clientid;
    }

    public Map<String, List<FlightItineraryPriceMo>> getFlightItineraryPricePoints() {
        return FlightItineraryPricePoints;
    }

    public void setFlightItineraryPricePoints(Map<String, List<FlightItineraryPriceMo>> flightItineraryPricePoints) {
        FlightItineraryPricePoints = flightItineraryPricePoints;
    }

    public Map<String, List<FareFamilyMo>> getFareFamilyContent() {
        return FareFamilyContent;
    }

    public void setFareFamilyContent(Map<String, List<FareFamilyMo>> fareFamilyContent) {
        FareFamilyContent = fareFamilyContent;
    }

    public Map<String, List<FlightInformationMo>> getFlightInformationSummary() {
        return FlightInformationSummary;
    }

    public void setFlightInformationSummary(Map<String, List<FlightInformationMo>> flightInformationSummary) {
        FlightInformationSummary = flightInformationSummary;
    }

    public Map<String, List<PriceMo>> getPricePointSummary() {
        return PricePointSummary;
    }

    public void setPricePointSummary(Map<String, List<PriceMo>> pricePointSummary) {
        PricePointSummary = pricePointSummary;
    }





}

