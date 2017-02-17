<%@ page import="com.hna.model.OtaConfig" %>
 <%
 
   String userName =(String) request.getSession().getAttribute("userName");
   String userId =(String) request.getSession().getAttribute("userId");
 
%>
<%
   
   String searchTripsApi="api/search-low-fare-trips.json";
   String searchTripsApp="app/searchLowFareTrips.json";
   String searchTrips=searchTripsApi;
   
   String calculateTripApi="api/calculate-trip.json";
   String calculateTripApp="app/calculateTrip.json";
   String calculateTrip=calculateTripApi;
   
   String verifyTripApi="api/verify-trip.json";
   String verifyTripApp="app/verifyTrip.json";
   String verifyTrip=verifyTripApi;
   
   
   String getReservationApi="api/get-reservation.json";
   String getReservationApp="app/get-reservation.json";
   String getReservation=getReservationApi;
   
   String createReservationApi="api/create-reservation.json";
   String createReservationApp="app/createReservation.json";
   String  createReservation=createReservationApi;
   
   
   String documentReservationApi="api/document-reservation.json";
   String documentReservationApp="app/documentReservation.json";
   String  documentReservation=documentReservationApi;
   
    
   String refundDetailApi="api/refund-detail.json";
   String refundDetailApp="app/refundDetail.json";
   String refundDetail=refundDetailApi;
   
   String refundApplyApi="api/refund-apply.json";
   String  refundApplyApp="app/refundApply.json";
   String refundApply= refundApplyApi;
   
   String  cancelReservation="api/cancel-reservation.do";
   
   OtaConfig  otaConfig=(OtaConfig)request.getSession().getAttribute("otaconfig");
   if((otaConfig!=null) && (otaConfig.getOTACode().contains("MOBILE") ||otaConfig.getOTACode().contains("WECHAT")))
   {
    
    searchTrips=searchTripsApp;
   
    calculateTrip=calculateTripApp;
   
    verifyTrip=verifyTripApp;
   
    getReservation=getReservationApp;
   
     createReservation=createReservationApp;
   
     documentReservation=documentReservationApp;
   
    refundDetail=refundDetailApp;
   
    refundApply= refundApplyApp;
   
   }

 %>

