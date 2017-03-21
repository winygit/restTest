<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<%@include file="CommonPage.jsp" %>
<%@include file="common.jsp" %>
 
<script type="text/javascript">
    $(function(){
      $.each($("input[type=checkbox]"),function(i,n){
       if(n.checked)
       {
         $(n.value).show();
       }
       else
       {
         $(n.value).hide();
       }
    })
    })   

  $(function(){
  
      $("input[type=checkbox]").bind("click",function(){
       var item=$(this).val();
       if($(this).attr("checked")=="checked")
       {
          $(item).show();
       }
       else // 未选中
       {
           $(item).hide();
       }
     })
    
   $.each($("input[type=checkbox]"), function(i, n){
     if(n.checked)
     {
       $().show();
     }else
     {
        $(n.value).hide();
     }
   })
    
     $("h2").css("color","red");
     //$("input").attr("size","10");
    // $("input[name=leg]").attr("size","70");
     //$("input[name=traveler]").attr("size","90");
    // $("input[name=customer]").attr("size","90");
  
      $("input[type=submit]").css("background","#ffbbaa");
      $("input[type=submit]").css("border-radius","4px");
      $("input[type=submit]").css("font-size","16px");
     //加上ticket
      //$("input[type=submit]").before($("#ticket"));
     //加上otacode等参数
     // $("input[type=submit]").before($("#comm"));
      $("input[name='category']").css("margin","5px 10px");
     
  })
</script>

<style type="text/css">
  body { padding:0px 150px;}
  #customerText {width:450px;}
  .indiv{background-color:#FCFCFC;border-radius:6px;margin: 10px; padding:5px; border-style: solid; border-width: 1px;}
</style>

</head>
<body>

<div class="indiv">
    <input type="checkbox" name="category" value="#flightSearch" />航班查询 
    <input type="checkbox" name="category" value="#calculateTrip" />计算税费
    <input type="checkbox" name="category" value="#createReservation"  />创建订单 
    <input type="checkbox" name="category" value="#document"  />出票
    <input type="checkbox" name="category" value="#query" />订单查询
    <input type="checkbox" name="category" value="#refund"  />退票
     <input type="checkbox" name="category" value="#ibe"  />IBE
</div>

<!--***************************************************************-->
<!--***************************************************************-->
<div id="flightSearch" class="indiv" ><%@ include file="ticket/flightSearch.jsp" %></div>
<div id="calculateTrip" class="indiv" ><%@ include file="ticket/calculateTrip.jsp" %></div>
<div id="createReservation" class="indiv"><%@ include file="ticket/createReservation.jsp" %></div>
<div id="document" class="indiv" title="出票"><%@ include file="ticket/document.jsp" %></div>
<div id="query" class="indiv" title="查询"><%@ include file="ticket/query.jsp" %></div>
<div id="refund" class="indiv" title="退票"><%@ include file="ticket/refund.jsp" %></div>
<div id="ibe" class="indiv" title="IBE"><%@ include file="ibe.jsp" %></div>

<!--***************************************************************-->
<!--***************************************************************-->
</body>
</html>