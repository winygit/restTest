<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
</head>
<body>

<h2>退票</h2> 
<h3> 退票查询</h3>
<!-- 
<form action="${pageContext.request.contextPath}/app/refundDetail.json" method="post">
 -->
<form action="${pageContext.request.contextPath}/<%=refundDetail %>" method="post">
订单号<input type="text" name="reservationCode"  value=""></input>
<input type="hidden" name="login" value=${sessionScope.login}></input>
<input type="submit" value="退票查询"/>
</form>
<!--***************************************************************-->
<!-- 
<h3> 退票费计算</h3>
<div>
<form action="${pageContext.request.contextPath}/" method="post">
reservationCode<input type="text" name="reservationCode"  value=""></input>
paxIds<input type="text" name="paxIds" value=""></input>
refundType<input type="text" name="refundType" value="VOLUNTARY"></input>
remark<input type="text" name="remark" value="app test" ></input>

<input type="submit" value="退票费计算"/>
</form>
</div>
 -->
<!--***************************************************************-->

<h3> 退票申请</h3>
<!--  
<form action="${pageContext.request.contextPath}/app/refundApply.json" method="post">
-->
<form action="${pageContext.request.contextPath}/<%=refundApply %>" method="post">
订单号<input type="text" name="reservationCode"  value=""></input>
paxIds<input type="text" name="paxIds" value=""></input>
退票类型
<select style="width: 80px" name="refundType">
			<option value="VOLUNTARY" >自愿退票</option>
			<option value="INVOLUNTARY ">非自愿退票</option>
		</select>
退票理由<input type="text" name="remark" value="" ></input>
<input type="hidden" name="login" value=${sessionScope.login}></input>
<input type="submit" value="退票申请"/>
</form>
<!--***************************************************************-->
<!--***************************************************************-->


</div>

</body>
</html>