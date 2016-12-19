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
function  nextVerify()
{
  var str="";
  $('input:radio:checked').each(function(i,e){
     str=str+e.value+" ,";
  })
  alert(str);
}

function ffclick()
{
   $('#ffcont').get(0).innerHTML ="show  here";
}
</script>

<style type="text/css">
 table {border-collapse:collapse;padding:10px 30px;maggin:10px 50px;}
 th, td  {border: solid 1px #a0c6e5; height: 15px; padding:5px;}
</style>

</head>
<body>
<div> 
<!-- 
<h3>查询信息</h3>
 -->
</div>

<div>
<h3>航线信息</h3>
		<table >
			<thead>
				<tr class="panel-header">
				    <th>选择</th>
				    <th>航程</th>
				    <th>航段</th>
					<th>产品</th>
					<th>票面价</th>
					<!--  
					<th>总价</th>
					-->
					<th>Y舱全价</th>
					<th>出发时间</th>
					<th>到达时间</th>
					<th>机型</th>
					<th>航班号</th>
					<th>仓位等级</th>
					<th>仓位</th>
					<th>剩余座位</th>
				</tr>
			</thead>
			<tbody>
			     <c:forEach var="data" items="${tripsDatas}" varStatus="status" >
			     <tr>
			       <td> <input type="radio" name="${data.leg}" value="${data.index}"></input></td>
			        <td> <c:out value="${data.leg}" /></td>
			        <td> <c:out value="${data.index}" /></td>
			       <td> <label class="ff" onclick="ffclick('${data}')" >${data.farefamilyName}</label></td>
			       <td> <c:out value="${data.baseFareAmount}" />  </td>
			       <!--
			       <td> <c:out value="${data.totalFareAmount}" />  </td>
			         -->
			       <td> <c:out value="${data.fullYFareAmount}" />  </td>
			       <td> <c:out value="${data.departureDate}" />  </td>
			       <td> <c:out value="${data.arrivalDate}" />  </td>
			       <td> <c:out value="${data.equipmentCode}" />  </td>
			       <td><c:out value="${data.flightNumber}" /> </td>
			       <td> <c:out value="${data.bookingClass}" />  </td>
			       <td><c:out value="${data.cabinClass}" /> </td>
			        <!--  
			       <td> <c:out value="${data.seatsAvailable}" />  </td>
			        -->
			      
			       <td> 
			       <c:choose>
			          <c:when test="${data.seatsAvailable ==0}"> <c:out value="充足" /> </c:when>
			          <c:otherwise > <c:out value="${data.seatsAvailable}" /></c:otherwise>
			       </c:choose>
			       </td>
			      
			     </tr>
                  </c:forEach>
                   <tr>
                     <td  colspan="14"> 计算税费Uri: ${airLowFareSearchRSVo.uri}  </td>
                  </tr>
                  
                  <!-- 
                  <tr>
                    <td colspan="3">
                                                    退改规则
                    </td>
                    <td colspan="11">
                    <div id="ffcont"> 
                    
                    </div>
                    </td>
                  </tr>
                   -->
               
			</tbody>
		</table>
		<!-- 
		<button onclick="nextVerify()" > 下一步</button>
		 -->
	</div>
</body>
</html>