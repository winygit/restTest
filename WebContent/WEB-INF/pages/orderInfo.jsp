<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<%@include file="common.jsp" %>

<script type="text/javascript">
$(function(){
 var node="${serviceResult.data.purchase}";
 if(node.length==0)
 {
   $("#purchase").hide();
 }
 
 
}) 

</script>
</head>
<body>
<div>
<!-- 订单基本信息(订单号，订单状态，渠道，描述)   联系人信息-->
<h3>订单基本信息</h3>
		<table>
			<tr>
				<td>订单号</td>
				<td>${serviceResult.data.code}</td>
				<td>订单状态</td>
				<td>${serviceResult.data.status}</td>
				<td>订单来源</td>
				<td>${serviceResult.data.source}</td>
			</tr>
			<tr>
				<td>用户名</td>
				<td>${serviceResult.data.customer[0].lastName}
					${serviceResult.data.customer[0].firstName}</td>
				<td>用户手机号</td>
				<td>${serviceResult.data.customer[0].phone[0].phoneNumber}</td>
				<td>用户Email</td>
				<td>${serviceResult.data.customer[0].email[0].emailAddress}</td>
			</tr>
			<tr>
				<td>订单描述</td>
				<td colspan="3">${serviceResult.data.description}</td>
			</tr>
		</table>
	</div>

<div  id="purchase">
<!-- 支付信息-->
<h3>支付信息</h3>
<table>
			<tr>
				<td>支付形式</td>
				<td>${serviceResult.data.purchase.formOfPayment}</td>
				<td>银行标示</td>
				<td>${serviceResult.data.purchase.paymentCardTypeCode}</td>
				<td>金额</td>
				<td>${serviceResult.data.purchase.purchaseAmount}</td>
			</tr>
		</table>

</div>

<div>
<!-- 航段费用信息-->
<h3>航段信息</h3>
		<table>
		<thead>
				<tr class="panel-header">
				    <th>乘机人类型</th>
					<th>产品代码</th>
				    <th>航班</th>
				    <th>机型</th>
					<th>航段</th>
					<th>出发时间</th>
					<th>达到时间</th>
					<th>耗时</th>
					<th>基本费用</th>
				</tr>
			</thead>
		<c:forEach var="air"  items="${serviceResult.data.reservationElement[0].air.airTrip.flightFare}">
			<tr>
			<td>${air.guestCode}</td>
			<td>${air.fareFamilyRef}</td>
			<td>${air.flightSegmentMo.marketingAirline} ${air.flightSegmentMo.flightNumber}</td>
			<td>${air.flightSegmentMo.equipmentCode}</td>
			<td>${air.flightSegmentMo.originCode}-${air.flightSegmentMo.destinationCode}</td>
             <td>${air.flightSegmentMo.departureDate}</td>
             <td>${air.flightSegmentMo.arrivalDate}</td>
             <td>${air.flightSegmentMo.totalFlightDuration}</td>
             <td>${air.fare.baseFareAmount}</td>
			</tr>
	    </c:forEach>
		</table>

	</div>

<div>
<!-- 电子客票信息-->
<h3>电子客票信息</h3>
<table>
		<thead>
				<tr class="panel-header">
				    <th>乘机人姓名</th>
					<th>类型</th>
					<th>联系电话</th>
				    <th>生日</th>
				    <th>证件类型</th>
					<th>证件号</th>
					<th>票号</th>
					<th>状态</th>
				</tr>
			</thead>
		<c:forEach var="document"  items="${serviceResult.data.reservationElement[0].document}">
			<tr>
			<td>${document.traveler.lastName} ${document.traveler.firstName}</td>
			<td>${document.traveler.guestTypeCode}</td>
			<td>${document.traveler.phone[0].phoneNumber} </td>
			<td>${document.traveler.dateOfBirth}</td>
			<td>${document.traveler.formOfIdentification.formOfIdentificationType}</td>
			<td>${document.traveler.formOfIdentification.formOfIdentificationNumber}</td>
             <td>${document.number}</td>
             <td>${document.status}</td>
			</tr>
	    </c:forEach>
		</table>

</div>

<div>
<!-- 费用信息-->
<h3>费用信息</h3>
<table>
		<thead>
				<tr class="panel-header">
				    <th>乘客类型</th>
					<th>人数</th>
					<th>总费用</th>
				    <th>基本费用</th>
				    <th>Fee</th>
				    <th>Fee名称</th>
					<th>金额</th>
					<th>Tax</th>
					<th>Tax名称</th>
					<th>金额</th>
				</tr>
			</thead>
		<c:forEach var="farePrice"  items="${serviceResult.data.reservationElement[0].air.airTrip.tripPricing.travelerTripPricing}">
			<tr>
			<td>${farePrice.guestType.code} </td>
			<td>${farePrice.guestType.quantity}</td>
			<td>${farePrice.fare.totalFareAmount}</td>
			<td>${farePrice.fare.baseFareAmount}</td>
			<!-- Fees Taxes 用的是map -->
			<td>${farePrice.fare.fees.Fee[0].taxFeeRef}</td>
			<td>${farePrice.fare.fees.Fee[0].amount}</td>
			<td>${farePrice.fare.fees.Fee[0].taxFee.entry[0].name}</td>
		    <td>${farePrice.fare.taxes.Tax[0].taxFeeRef}</td>
			<td>${farePrice.fare.taxes.Tax[0].amount}</td>
			<td>${farePrice.fare.taxes.Tax[0].taxFee.entry[0].name}</td>
			</tr>
	    </c:forEach>
		</table>

</div>

</body>
</html>