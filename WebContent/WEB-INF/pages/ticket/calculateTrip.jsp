<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>单人往返</title>

</head>
<body>

<h2>计算税费 </h2> 

<h3>单程</h3>
<form action="${pageContext.request.contextPath}/<%=calculateTrip %>" method="post">
searchId (@Uri)<input type="text" name="searchId"  value=""></input>
index (航 段)<input type="text" name="index" value=""></input>
<input type="submit" value="计算税费"/>
</form>

<h3>往返</h3>
<form action="${pageContext.request.contextPath}/<%=calculateTrip %>" method="post">
searchId (@Uri)<input type="text" name="searchId"  value=""></input>
index (航 段)<input type="text" name="index" value=""></input>
index (航 段)<input type="text" name="index" value=""></input>
<input type="submit" value="计算税费"/>
</form>

</body>
</html>