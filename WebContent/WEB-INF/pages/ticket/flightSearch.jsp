<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="common.jsp"></jsp:include>
<title>main</title>

<script type="text/javascript">
  $(function(){
    $('#returnDate').hide();
  })

</script>
<script type="text/javascript">
	function format(date) {
		//alert(date);
		//return   date.getFullYear() + '-' + date.getMonth() +'-' + date.getDate();
		var month=date.getMonth()+1;
		return date.getFullYear() + '-' +month  +'-' + date.getDate();
	}
	
	function tripClick()
	{
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
		<h1>天津航空</h1>
		<hr>
	</div>
	<div>
		<form action="search-low-fare-trips.do" method="post">
			<ul>
				<li>出发地 <input id="origin" class="easyui-combobox "
					name="origin" panelHeight="auto"
					data-options="valueField:'code',textField:'name',url:'${pageContext.request.contextPath}/common/getCities.do',method:'get'"></li>
				<li>目的地 <input id="destination" class="easyui-combobox "
					name="destination" panelHeight="auto"
					data-options="valueField:'code',textField:'name',url:'${pageContext.request.contextPath}/common/getCities.do',method:'get'"></li>

				<li>出发时间 <input class="easyui-datebox" style="width: 150px"
					id="date" name="date" data-options="formatter: format"></li>
					
				<li>成人 <input name="adtNum" value="1"> 儿童 <input name="cnnNum" value="0"> 婴儿<input name="infNum" value="0"></li>
				
				<li>单程 <input type="radio"  onclick="tripClick()" name="trip" checked="checked" value="0">
				          往返 <input type="radio"  onclick="tripClick()" name="trip" value="1" >
				</li>	
					 <li ><div id="returnDate">返程时间 <input class="easyui-datebox" style="width: 150px"
					id="dater" name="dater" data-options="formatter: format"> </div></li>

				<li>固定日期 <input type="radio" name="flexible" value="false">是
						<input type="radio" name="flexible" value="true" checked="checked">否
					</li>
			</ul>

			<hr>
				<div align="center">
					<input type="submit" value="查   询">
				</div>
		</form>

	</div>
	
	<div>
	  <a href="test/AirLowFareSearch.do">航班查询</a>
	  <a href="test/tripCalculation.do">计算税费</a>
	</div>
</body>
</html>