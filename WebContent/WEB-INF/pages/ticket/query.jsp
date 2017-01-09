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
	<div align="center">
		<h2>订单查询</h2>
	</div>
<h3>订单列表</h3>
<form action="${pageContext.request.contextPath}/app/queryOrder.do" method="post">
订单号(非必填)<input type="text" name="reservationCode"  value=""></input>
<input type="hidden" name="userId" value=${sessionScope.userId}></input>
起始创建时间<input type="text" name="creationDateTimeMin" value="2016-11-11 00:00:00"></input>
截止创建时间<input type="text" name="creationDateTimeMax" value="2017-10-10 00:00:00"></input>
<br />
最大返回条数<input type="text" name="maximumResponses" value="15"></input>
<input type="hidden" name="login" value=${sessionScope.login}></input>
<input type="submit" value="订单列表"/>
</form>

<!-- 
<h3> 推荐航线查询 </h3>
<div>
<form action="app/recommendLines/query.do" method="post">
<input type="submit" value="10. APP推荐航线查询"/>
</form>
<br/>
</div>
 -->

<!-- ************************ -->
<!-- 
<h3> 航班动态查询 </h3>
<div>
<form action="${pageContext.request.contextPath}/app/scheduledFlight.do" method="post">
航班号<input type="text" name="flightNo"  value=""></input>
起飞城市<input type="text" name="startCityCode" value=""></input>
目的地<input type="text" name="destCityCode" value=""></input>
date<input type="text" name="date" value="" ></input>
<input type="submit" value="航班动态查询"/>
</form>
<br/>
</div>
- -->
<!-- ***************get-entire-reservation *********************** -->
<h3>订单详情</h3> 
<!--  
<form action="app/get-entire-reservation.json" method="post"> -->
<form action="${pageContext.request.contextPath}/<%=getReservation %>" method="post">
订单号<input type="text" name="reservationCode" maxlength="200" value=""></input>
<input type="hidden" name="login" value=${sessionScope.login}></input>
<input type="submit" value="订单详情"/>
</form>

<!--***************************************************************-->
<!--  
<h3>检索订单</h3> 
<div>
<form action="api/get-reservation.xml" method="post">
reservationCode<input type="text" name="reservationCode" maxlength="200" value=""></input>
<input type="submit" value="1. 订单检索xml"/>
</form>
</div>

-->
</body>
</html>