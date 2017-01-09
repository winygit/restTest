<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>出票</title>
<script type="text/javascript"> 
 function drSubmit()
 {
      alert(" 为避免座位虚耗,测试完成后请及时退票! ");
 }
</script>
</head>
<body>
	<div align="center">
		<h2>出 票</h2>
	</div>
<!-- 
<h3>验证票价是否合理</h3>
<div>
<form action="${pageContext.request.contextPath}/<%=verifyTrip %>" method="post">
tripId (@Uri)<input type="text" name="tripId"  value=""></input>
<input type="submit" value="验证票价是否合理"/>
</form>
</div>
- -->
<!--***************************************************************-->
<c:if test="${sessionScope.env=='uat'}">
<h3> 支付出票</h3>
<form action="${pageContext.request.contextPath}/<%=documentReservation %>" method="post"  onsubmit="drSubmit()">
订单号<input type="text" name="reservationCode"  value=""></input>
<input type="hidden" name="alipaySeq" value="2014120500001000310038018115"></input>
<input type="hidden" name="paymentSeq" value="2016111111303910123456789"></input>
支付金额<input type="text" name="amount" value=""></input>

<input type="hidden" name="currencyCode" value="CNY"></input>
<input type="hidden" name="payDate" value="2016-11-11"></input>
<input type="hidden" name="payTime" value="11:30:39"></input>

<input type="hidden" name="bankGroupCode" value="APAY"></input>
<input type="hidden" name="bankGroupID" value="800"></input>
<input type="hidden" name="bankCode" value="yue"></input>
<input type="hidden" name="bankID" value="801"></input>
<input type="hidden" name="creditCardCompanyCode" value="F1"></input>

<input type="submit" value="支付出票"/>
</form>

</c:if>
<c:if test="${sessionScope.env=='pro'}">
 <P> 生产环境请去官网支付出票！！！</P>
</c:if>

</body>
</html>