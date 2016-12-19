<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<%@include file="common.jsp"%>
<script type="text/javascript">
	
</script>
<style type="text/css">
   body  {padding:30px; }
   #main {padding:20px 40px;margin:0 auto; width:450px; border:solid 1px #a0c6e5;font-size:15px;background-color: #e7e7e7;border-radius:16px;}
  fieldset {padding:15px 10px;margin:10px auto; border:solid 1px gray}
  p { margin:5px;padding:5px 15px;}
  #submit {width:50%;margin:0 auto; background-color:008CBA;border-radius: 8px;font-size: 20px}
</style>

</head>
<body>
   <div id="main">
	<form id="login" action="${pageContext.request.contextPath}/app/login.do" method="post">
		<center><h2>OTA接口测试</h2> </center>
		<fieldset id="inputs">
			<p>用户名 <input name="username" id="username" type="text" placeholder="Username" autofocus required> </p>
			<p>密&nbsp;码 <input name="password" id="password" type="password" placeholder="Password" required> </p>
		    <p><input type="hidden" name="logintype" value="nlogin"></input></p>
		</fieldset>
		<fieldset >
		<p>
		环境选择 <select name="env" style="width: 80px; height:25px; margin:0px 60px 0px 10px">
			<option value="uat" selected="selected">UAT</option>
			<option value="pro">生产</option>
		</select> 
		</p>
		<p>
		渠道选择 <select style="width: 80px;height:25px;margin:0px 30px 0px 10px" name="otaCode">
			<option value="mobile" selected="selected">手机APP</option>
			<option value="qunar">去哪儿</option>
			<option value="hbgj">航班管家</option>
		</select>
		</fieldset>
		</p>
		<p style="color:red; ">${loginRs}</p>
		<fieldset id="actions">
			<center><input type="submit" id="submit" value="登   录"></center>
		</fieldset>
	</form>

</div>
</body>
</html>