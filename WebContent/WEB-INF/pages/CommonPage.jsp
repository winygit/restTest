<%@ page import="com.hna.model.OtaConfig" %>
 <%
 
   String userName =(String) request.getSession().getAttribute("userName");
   String userId =(String) request.getSession().getAttribute("userId");
    // 西安--榆林
    //单程
   // String leg0 = "index:0;origin:XIY;originType:A;destination:UYN;destinationType:A;date:2017-02-10";
    //往返
    //String leg1 = "index:1;origin:UYN;originType:A;destination:XIY;destinationType:A;date:2016-02-14";

     //天津--武汉
    //单程
    String leg0 = "index:0;origin:TSN;originType:A;destination:WUH;destinationType:A;date:2017-02-10";
    //往返
    String leg1 = "index:1;origin:WUH;originType:A;destination:TSN;destinationType:A;date:2017-02-14";

    //customer
    String customer1 = "code:ADT;fName:otatest;lName:Test;mobilePhone.number:15527209215;email:winy95@foxmail.com;userName:"+userName+";userId:"+userId;
    //traveler
    String travelerADT1 = "code:ADT;fName:Shi;lName:Ce;mobilePhone.number:15527209215;dateOfBirth:1993-04-05;document.type:ID_CARD;document.number:413026199304055419;document.country:CN;document.expirationDate:2999-10-11";
    String travelerADT2 = "code:ADT;fName:ShiA;lName:Ce;mobilePhone.number:15527209215;dateOfBirth:1998-09-09;document.type:MI_CARD;document.number:987110488;document.country:CN;document.expirationDate:2999-10-11";
    String travelerADT3 = "code:ADT;fName:ShiB;lName:Ce;mobilePhone.number:15527209215;dateOfBirth:1992-03-28;document.type:ID_CARD;document.number:231026199203285519;document.country:CN;document.expirationDate:2999-10-11";
    String travelerADT4 = "code:ADT;fName:ShiC;lName:Ce;mobilePhone.number:15527209215;dateOfBirth:1990-07-22;document.type:ID_CARD;document.number:42010619900722481X;document.country:CN;document.expirationDate:2999-10-11";
    
    String travelerCNN1 = "code:CNN;fName:CNNA;lName:test;mobilePhone.number:15527209258;dateOfBirth:2010-08-08;document.type:ID_CARD;document.number:421181201008087635;document.country:CN;document.expirationDate:2999-10-11";
    String travelerCNN2 = "code:CNN;fName:CNNB;lName:test;mobilePhone.number:18672471011;dateOfBirth:2007-07-02;document.type:ID_CARD;document.number:510304200707025825;document.country:CN;document.expirationDate:2999-10-11";
    String travelerCNN3 = "code:CNN;fName:CNNB;lName:test;mobilePhone.number:15527209258;dateOfBirth:2010-02-10;document.type:MI_CARD;document.number:480249320090;document.country:CN;document.expirationDate:2999-10-11";
    
   String travelerINF1 = "code:INF;fName:INFA;lName:test;mobilePhone.number:15527209258;dateOfBirth:2016-02-10;document.type:MI_CARD;document.number:125465;document.country:CN;document.expirationDate:2999-10-11";
   String travelerINF2 = "code:INF;fName:INFB;lName:test;mobilePhone.number:15527209258;dateOfBirth:2016-03-11;document.type:OTHER_ID;document.number:654321;document.country:CN;document.expirationDate:2999-10-11";

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

