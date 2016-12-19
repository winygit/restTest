<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>单人单程</title>
<script type="text/javascript"> 
 function submitp1t1()
 {
       //单人单程
       var legp1t1="index:0;origin:"+$("#orgp1t1").val()+";originType:A;destination:"+$("#dstp1t1").val()
       +";destinationType:A;date:"+$("#detimep1t1").val();
       $("#legp1t1").val(legp1t1);
       
       //单人往返
        var leg1p1t2="index:0;origin:"+$("#orgp1t2").val()+";originType:A;destination:"+$("#dstp1t2").val()
       +";destinationType:A;date:"+$("#detimep1t2").val();
       
       var leg2p1t2="index:1;origin:"+$("#dstp1t2").val()+";originType:A;destination:"+$("#orgp1t2").val()
       +";destinationType:A;date:"+$("#artimep1t2").val();
       
       $("#leg1p1t2").val(leg1p1t2);
       $("#leg2p1t2").val(leg2p1t2);
       
       //多人单程
        var legpnt1="index:0;origin:"+$("#orgpnt1").val()+";originType:A;destination:"+$("#dstpnt1").val()
       +";destinationType:A;date:"+$("#detimepnt1").val();
       
       $("#legpnt1").val(legpnt1);
 }
</script>
</head>
<body>

<h2>单人单程 </h2> 
<h3>查询航线 </h3> 

出发地三字码<input type="text" id="orgp1t1" maxlength="200" value="TSN"></input>
目的地三字码<input type="text" id="dstp1t1"  maxlength="200" value="WUH"></input>
出发时间<input type="text" id="detimep1t1" maxlength="200" value="2017-02-15"></input>

<form action="${pageContext.request.contextPath}/<%=searchTrips%>" method="post" onsubmit="submitp1t1()" >

<input type="hidden"  id="legp1t1" name="leg"  ></input>
<input type="hidden" name="traveler" value="code:ADT"  ></input>
<input type="hidden" name="flexible" value="false"></input>
<input type="hidden" name="cabin" value="Economy"></input>
<input type="submit"  value="查询航线"/>
</form>

<!--***************************************************************-->
<h3>计算税费</h3>

<form action="${pageContext.request.contextPath}/<%=calculateTrip%>" method="post">
searchId (@Uri)<input type="text" name="searchId"  value=""></input>
index (航段号)<input type="text" name="index" value=""></input>
<input type="submit" value="计算税费"/>
</form>

<!--***************************************************************-->
<h3> 创建订单</h3>

<form action="${pageContext.request.contextPath}/<%=createReservation %>" method="post" onsubmit="crSubmit()">
tripId<input type="text" name="tripOptionId"  value=""></input>
乘机人
<select name="traveler" style="width:80px;">
  <option value=<%=travelerADT1 %> >成人一</option>
  <option value=<%=travelerADT2 %>>成人二</option>
  <option value=<%=travelerADT3 %>>成人三</option>
  <option value=<%=travelerADT4 %>>成人四</option>
  <option value=<%=travelerCNN1 %>>儿童一</option>
  <option value=<%=travelerCNN2 %>>儿童二</option>
  <option value=<%=travelerCNN3 %>>儿童三</option>
  <option value=<%=travelerINF1 %>>婴儿一</option>
  <option value=<%=travelerINF1 %>>婴儿二</option>
</select>
<br />
联系人(请修改成自己的手机号)<input type="text" name="customer"  id="customerText" value=<%=customer1 %>></input>
<input type="hidden" name="login" value=${sessionScope.login}></input>
<input type="submit" value="创建订单"/>
</form>



</body>
</html>