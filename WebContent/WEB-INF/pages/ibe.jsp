<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<jsp:include page="common.jsp"></jsp:include>

<script type="text/javascript"> 
function format(date) {
		var month=date.getMonth()+1;
		var day=date.getDate();
		month=(month<10)?'0'+month:month;
		day=(day<10)?'0'+day:day;
		return date.getFullYear() + '-' +month  +'-' + day;
	}

function pnrInfo(his)
{
    $.post("${pageContext.request.contextPath}/api/pnrinfo.do",
    {
      pnrno:$("input[name='pnrno']").val(),
      his:his,
    },
    function(data)
    {
      $("#result").html(data);
    }
    
    )
    
}

function tktInfo(his)
{
    $.post("${pageContext.request.contextPath}/api/tktinfo.do",
    {
      tktNo:$("#tktno").val(),
      his:his,
    },
    function(data)
    {
      $("#result").html(data);
    }
    
    )
}

function AVInfo(his)
{
    $.post("${pageContext.request.contextPath}/api/AVinfo.do",
    {
      org:$("input[name='Avorg']").val(),
      dst:$("input[name='Avdst']").val(),
      dateStr:$("input[name='AvdateStr']").val(),
    },
    function(data)
    {
      $("#result").html(data);
    }
    
    )
}
</script>

</head>
<body>
	<ol  style="border: double 1px #C0C0C0;margin:10px 5px">
		<li>
			<div>
				出发地<input type="text" name="Avorg" value="" ></input> 
				目的地<input type="text" name="Avdst" value=""></input> 
				日期<input type="text"  
					name="AvdateStr" value=""></input> 
				<input onclick="AVInfo()"
					type="submit" value="AV查询" />
			</div>
		</li>
		<li>
			<div>
				PNR<input type="text" name="pnrno" value=""></input>
				<input onclick="pnrInfo('false')" type="submit" value="PNR信息" /> <input
					onclick="pnrInfo('true')" type="submit" value="PNR历史信息" />
			</div>
		</li>
		<li>
			<div>
				电子客票号<input type="text" id="tktno" value=""></input> <input
					onclick="tktInfo('fasle')" type="submit" value="电子客票信息" /> <input
					onclick="tktInfo('true')" type="submit" value="电子客票历史信息" />
			</div>
		</li>
	</ol>

<div style="margin:20px 2px">
<h4>查询结果</h4>
<pre>
 <textarea   class="easyui-resizable" rows="22" cols="1000" id="result" readonly="readonly"
 style="border: solid 1px #a0c6e5; color:#00FF00;background-color:black ; width:800px;padding:5px"></textarea>
</pre>
</div>

</body>
</html>