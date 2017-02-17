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
 
 function drParaminti()
 {
      //设置支付参数
      var now=new Date();
      var year=now.getFullYear();
      var month=now.getMonth()+1;
      if(month<10)
      {
         month="0"+month;
      }
      var date=now.getDate();
      if(date<10)
      {
        date="0"+date;
      }
      
      var hours=now.getHours();
      var minutes=now.getMinutes();
      var second=now.getSeconds();
      var millseconds=now.getMilliseconds();
      
      //alert("hhh:"+year+"-"+month+"-"+date);
      
      $("#drpayDate").val(year+"-"+month+"-"+date);
      $("#drpayTime").val(hours+":"+minutes+":"+second);
      
       $("#dralipaySeq").val(year+month+date+hours+minutes+second+millseconds+"99"+'1122334455');
      $("#drpaymentSeq").val(year+month+date+hours+minutes+second+millseconds+"99"+'1122334455');
 
 }

</script>
</head>
<body >
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
<ul>
<li>订单号<input type="text" name="reservationCode"  value=""></input> 
支付金额<input type="text" name="amount" value="" onblur="drParaminti()"></input></li>
<br/>
<li>货币种类<input type="text" name="currencyCode" value="CNY"></input>
支付日期<input type="text" name="payDate" id="drpayDate" value=""></input>
支付时间<input type="text" name="payTime" id="drpayTime" value=""></input></li>
<li>支付平台流水号<input type="text" name="alipaySeq" style="width:220px;" id="dralipaySeq" value=""></input>
业务平台流水号<input type="text" style="width:220px;" name="paymentSeq" id="drpaymentSeq" value=""></input></li>
<br/>
<li>银行组标示<input type="text" name="bankGroupCode" value="APAY"></input>
银行组 ID <input type="text" name="bankGroupID" value="800"></input></li>
<li>银行标示 <input type="text" name="bankCode" value="yue"></input>
银行 ID <input type="text" name="bankID" value="801"></input>
信用卡标示<input type="text" name="creditCardCompanyCode" value="F1"></input></li>
</ul>
<input type="submit" value="支付出票"/>
</form>

</c:if>
<c:if test="${sessionScope.env=='pro'}">
 <P> 生产环境请去官网支付出票！！！</P>
</c:if>

<h3> 取消订单</h3>
<form action="${pageContext.request.contextPath}/<%=cancelReservation %>">
订单号<input type="text" name="reservationCode"  value=""></input>
<input type="submit" value="取消订单"/>
</form>
</body>
</html>