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
<script type="text/javascript">

</script>

<style type="text/css">
 table {border-collapse:collapse;}
 th, td  {border: solid 1px #a0c6e5; height: 20px; }
</style>

</head>
<body>
<div>
 <h3>费用信息 </h3>
 url：${trip.uri}
 <hr/>
 总费用：${tripCalculation.totalFareAmount}
 <table >
			<thead>
				<tr class="panel-header">
				    <th>乘客类型</th>
				    <th>人数</th>
				    <th>总费用</th>
				    <th>基本费用</th>
					<th>费(代码)</th>
					<th>费(名称)</th>
					<th>数目</th>
					<th>税(代码)</th>
					<th>税(名称)</th>
					<th>数目</th>
				</tr>
			</thead>
  <c:forEach var="data" items="${tripCalculation.travelerTripPricing}" varStatus="status" >
    <tr>
			       <td> <c:out value="${data.code}" />  </td>
			       <td> <c:out value="${data.quantity}" />  </td>
			       <td> <c:out value="${data.totalFareAmount}" />  </td>
			       <td> <c:out value="${data.baseFareAmount}" />  </td>
			       <td> <c:out value="${data.feeID}" />  </td>
			       <td> <c:out value="${data.feename} " />  </td>
			       <td> <c:out value="${data.feeAmount}" />  </td>
			       <td> <c:out value="${data.taxID}" />  </td>
			        <td> <c:out value="${data.taxname}" />  </td>
			       <td> <c:out value="${data.taxAmount}" />  </td>
			     </tr>
  
  </c:forEach>
  	</table>
 </div>
</body>
</html>