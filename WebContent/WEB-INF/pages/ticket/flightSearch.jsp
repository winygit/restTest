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
    
    $(".placeSelect").combobox({
     valueField: 'code',
     textField: 'name',
	 data :HNA_FLIGHT_CITIES,
	
	});
	
	$(".traNum").numberbox({
	  min: 0,
	  max: 5,
	  suffix:'位',
	})
	
	})
	
	
</script>
<script type="text/javascript">
	function format(date) {
		//alert(date);
		//return   date.getFullYear() + '-' + date.getMonth() +'-' + date.getDate();
		 //alert($("#ddd").datebox('getValue'));
		var month=date.getMonth()+1;
		var day=date.getDate();
		month=(month<10)?'0'+month:month;
		day=(day<10)?'0'+day:day;
		return date.getFullYear() + '-' +month  +'-' + day;
	}
	
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
		<h3>航班查询</h3>
	</div>
	<div>
		<form action="${pageContext.request.contextPath}/new/<%=searchTrips%>" method="post">
			<ul>
				<li>出发地 
				
				<input  name="origin" class="placeSelect" />
				</li>
				<li>
				 目的地 
				<input  name="destination" class="placeSelect" />
				 </li>
				 
				<li>出发时间 <input class="easyui-datebox" style="width: 200px"  
					 name="date" data-options="formatter: format"></li>
		 			
				<li>成人 <input name="adtNum" class="traNum" value="1"> 
				          儿童 <input name="cnnNum" class="traNum" value="0"> 
				          婴儿<input name="infNum"  class="traNum" value="0">
				 </li>
				
				<li>单程 <input type="radio"  onclick="tripClick()" name="trip" checked="checked" value="0">
				          往返 <input type="radio"  onclick="tripClick()" name="trip" value="1" >
				</li>	
					 <li ><div id="returnDate">返程时间 <input class="easyui-datebox" 
					 name="returnDate" data-options="formatter: format"> </div></li>

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