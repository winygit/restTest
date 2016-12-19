<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<jsp:include page="common.jsp"></jsp:include>

<style type="text/css">
 table {border-collapse:collapse;}
 th, td  {border: solid 1px #a0c6e5; height: 20px; padding:5px}
</style>

</head>
<body>
  <div>
  <h3>订单列表 </h3>
	<table >
			<thead>
				<tr class="panel-header"> 
				    <th>序号</th>
				    <th>订单号</th>
					<th>PNR</th>
				    <th>状态</th>
				    <th>航班号</th>
					<th>来源</th>
					<th>订票人</th>
					<th>描述</th>
				</tr>
			</thead>
			<tbody>
			     <c:forEach var="order" items="${orders}" varStatus="status" >
			     <tr>
			       <td> <c:out value="${status.index}" />  </td>
			       <td> <c:out value="${order.code}" />  </td>
			       <td> <c:out value="${order.primaryAirRecordLocator}" />  </td>
			       <td> <c:out value="${order.reservationStatus}" />  </td>
			       <td> <c:out value="${order.firstFlightAirlineCode}-${order.firstFlightFlightNumber}" />  </td>
			       <td> <c:out value="${order.source}" />  </td>
			       <td><c:out value="${order.customerLastName}  ${order.customerFirstName}" /> </td>
			       <td> <c:out value="${order.reservationDescription}" />  </td>
			     </tr>
                  </c:forEach>
			</tbody>

		</table>
</div>

</body>
</html>