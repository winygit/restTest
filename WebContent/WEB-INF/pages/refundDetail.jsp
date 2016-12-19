<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<jsp:include page="common.jsp"></jsp:include>
<script type="text/javascript">

</script>


</head>
<body>
<div>
  <div>
  <h3>订单信息</h3>
  </div>
  <ul>
  <li>
        订单号： ${serviceResult.data.orderNo} 订单状态：${serviceResult.data.status}
  </li>
  <li>
       订票人：${serviceResult.data.customer.lastName} ${serviceResult.data.customer.firstName} 
       手机号 ：${serviceResult.data.customer.email}
        邮箱：${serviceResult.data.customer.phone}
  </li>
  </ul>
  
  <div>
  <h3>航段信息</h3>
  <table >
			<thead>
				<tr class="panel-header">
				    <th>乘客姓名</th>
				    <th>客票状态</th>
				    <th>票号</th>
				    <th>PaxId</th>
					<th>乘客类型</th>
					<th>航段描述</th>
					<th>起飞时间</th>
					<th>退票规则</th>
				</tr>
			</thead>
		<c:forEach var="guest" items="${serviceResult.data.guests}" varStatus="status" >
		   <c:forEach var="pax" items="${guest.paxs}" varStatus="paxstatus" >
						<tr>
						<c:if test="${paxstatus.first}">
							<td rowspan="${fn:length(guest.paxs)}"><c:out value="${pax.name}" /></td>
						</c:if>
							<td><c:out value="${pax.ticketStatus}" /></td>
							<td><c:out value="${pax.ticketNo}" /></td>
							<td><c:out value="${pax.ID}" /></td>
							<td><c:out value="${guest.type}" /></td>
							<td><c:out value="${pax.flightNo}/${pax.org}-${pax.dst}" />
							</td>
							<td><c:out value="${pax.flightDate} ${pax.depTime} " /></td>
							<td><c:out value="${pax.refundRule} " /></td>

						</tr>
					</c:forEach>
		</c:forEach>
  	</table>
  </div>
  	
</body>
</html>