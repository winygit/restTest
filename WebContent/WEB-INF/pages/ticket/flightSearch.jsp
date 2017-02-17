<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/flightCity.js"></script>

<title>main</title>

<style type="text/css">
 input {margin:0px;}

</style>

<script type="text/javascript">
  $(function(){
   
    $('#returnDate').hide();
    
  
	$(".traNum").numberbox({
	  min: 0,
	  max: 6,
	  suffix:'位',
	})
	
	})
	
	
</script>
<script type="text/javascript">

	function tripClick()
	{
	  // alert($("#ddd").datebox('getValue'));
	  // alert($('input:radio:checked').val());
	   if($('input:radio:checked').val()==0)
	   {
	     $('#returnDate').hide();
	   
	   }
	   else
	   {
	       $('#returnDate').show();
	   }
	   
	}

</script>

<style type="text/css">
  ul li {magin: 10px; padding:5px; list-style-type:none}
  input {magin: 6px ; padding:5px;}
</style>

</head>
<body>
<div align="center">
		<h2>航班查询</h2>
	</div>
	<div>
		<form action="${pageContext.request.contextPath}/new/<%=searchTrips%>" method="post">
			<ul>
				<li>出发地 
				
				<input  name="origin"  type="text"/>
				</li>
				<li>
				 目的地 
				<input  name="destination" type="text" />
				 </li>
				 
				<li>出发时间 <input 
					 name="date" type="text"  id="date1"></li>
		 			
				<li>成人 <input name="adtNum" class="traNum" value="1"> 
				          儿童 <input name="cnnNum" class="traNum" value="0"> 
				          婴儿<input name="infNum"  class="traNum" value="0">
				 </li>
				
				<li>单程 <input type="radio"  onclick="tripClick()" name="trip" checked="checked" value="0">
				          往返 <input type="radio"  onclick="tripClick()" name="trip" value="1" >
				</li>	
					 <li ><div id="returnDate">返程时间 <input  
					 name="returnDate" type="text"> </div></li>

				<li>固定日期 <input type="radio" name="flexible" value="false">是
						<input type="radio" name="flexible" value="true" checked="checked">否
					</li>
			</ul>

				<div align="center">
					<input type="submit" value="查   询">
				</div>
		</form>

	</div>
	
	
</body>
</html>