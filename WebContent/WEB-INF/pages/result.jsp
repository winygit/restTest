<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Result</title>
<%@include file="common.jsp" %>

<script type="text/javascript">
$(function () {
 $('#jsonData').hide();
 $('#box').accordion({
        //fit : true,
        //width : 900,
		//border : false,
		//animate : false,
		multiple : true,
		selected : 1,
})

})

function backtomain()
{
    location.href='${pageContext.request.contextPath}/api/main.do';
}


function getOriginalJson()
{

  // $('#parsedData').empty();
   $('#parsedData').hide();
   $('#jsonData').show();
}

function parsedData()
{

   //$('#jsonData').empty();
   $('#jsonData').hide();
   $('#parsedData').show();
}



function recall()
{
	    var params = $("#params").val().trim();
		// console.log(params);
		var params1 = params.substr(1, params.length - 2);
		//  console.log(params1);
		var params2 = params1.replace(new RegExp(",", "g"), "&");
		//console.log(params2);

		//var url = '${pageContext.request.contextPath}'+"${serviceResult.method}".substr(4) + "?" + params2;
		var url = "${serviceResult.method}".substr(4) + "?" + params2;
		
		//去掉换行和空格
		var url2 = url.replace(/\s/g, "").replace(/[\r\n]/g,"");
		//console.log(url2);
		location.href = url2;

	}
</script>

<style type="text/css">
   body{magin:10px 150px; padding:0px 150px;}
  ul li {magin: 10px; padding:5px; list-style-type:none}
  #box {margin:0 auto; }
  #jsonData , #parsedData{magin:10px; padding:5px;}
  h3 {color:red;}
</style>

</head>
<body>

<div id="box" >

	<div title="请求参数">
	 <ul>
	    <li>url:  ${serviceResult.url}  </li>
	    <li>请求参数: <br />
	    <textarea rows="5" cols="100" id="params" >  ${serviceResult.params} </textarea> 
	    </li>
	    <li> <button onmousedown="recall()"> 再次提交 </button> </li>
	    <li>返回状态码:${serviceResult.code}  &nbsp;&nbsp;   响应时间:${serviceResult.respondTime}ms</li>
	 </ul>
   </div>
	 

	<div title="返回结果"  id="result">
			<div id="parsedData">
				<c:choose>
					<c:when test="${serviceResult.resultJsp =='default'}">
				      ${serviceResult.result}
					</c:when>
					<c:otherwise>
						<jsp:include page="${serviceResult.resultJsp}" />
						<p>
					     <button onmousedown="getOriginalJson()">查看原始json</button> &nbsp;&nbsp; 
					      <button style="margin:0  50;" onmousedown="backtomain()">回主页</button>
					    </p>
					</c:otherwise>
				</c:choose>
			</div>

			<div id="jsonData" >
				${serviceResult.result}
				<p>
				   <button onmousedown="parsedData()">返回</button> 
				</p>
			</div>
	</div>
</div>

</body>
</html>