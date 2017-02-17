<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<script type="text/javascript"> 

function traAdtSel(sel,i)
{
    //alert(sel.value);
    //alert(i+"--"+this.value());
	switch (sel.value) {
		case "1":
		    setTraveler(i,"Test","adtA","15527209215","1993-04-05","ID_CARD","413026199304055419","2999-10-11","CN","WUHAN");
			break;
		case "2":
		     setTraveler(i,"Test","adtB","15527209215","1998-09-09","MI_CARD","987110488","2999-10-11","CN","WUHAN");
			break;
		case "3":
		     setTraveler(i,"Test","adtC","15565457899","1992-03-28","ID_CARD","231026199203285519","2999-10-11","CN","WUHAN");
			break;
		case "4":
		    setTraveler(i,"Test","adtD","15512345678","1999-09-28","OTHER_ID","654321","2999-10-11","CN","WUHAN");
			break;
		case "5":
		    setTraveler(i,"Test","adtE","15527209215","1990-09-09","2.DOC","98765412","2999-10-11","CN","WUHAN");
			break;
		default:
		    setTraveler(i,"","","","","ID_CARD","","","","");
		    break;
		}
}

function traCnnSel(sel,i)
{
	switch (sel.value) {
		case "1":
		    setTraveler(i,"Test","cnnA","15527209215","2010-08-08","ID_CARD","421181201008087635","2999-10-11","CN","WUHAN");
			break;
		case "2":
		    setTraveler(i,"Test","cnnB","15598765432","2008-08-08","OTHER_ID","480249320090","2999-10-11","CN","WUHAN");
			break;
		case "3":
		    setTraveler(i,"Test","cnnC","15565457899","2007-07-02","ID_CARD","510304200707025825","2999-10-11","CN","WUHAN");
			break;
		default:
		      setTraveler(i,"","","","","ID_CARD","","","","");
		      break;
		}
}

function traInfSel(sel,i)
{
	switch (sel.value) {
		case "1":
		    setTraveler(i,"Test","infA","15527209215","2016-08-08","MI_CARD","135790","2999-10-11","CN","WUHAN");
			break;
		case "2":
		    setTraveler(i,"Test","infB","15527209258","2015-10-18","OTHER_ID","24680","2999-10-11","CN","WUHAN");
			break;
		default:
		    setTraveler(i,"","","","","ID_CARD","","","","");
		    break;
		}
}

function setTraveler (index,lName,fName,mobilePhoneNumber,dateOfBirth,documentType,documentNumber,documentExpirationDate,citizenship,placeOfBirth)
{
             $("input[name='traveler["+index+"].lName'").val(lName) ;  
             $("input[name='traveler["+index+"].fName'").val(fName) ;  
             $("input[name='traveler["+index+"].mobilePhoneNumber'").val(mobilePhoneNumber) ;  
             $("input[name='traveler["+index+"].dateOfBirth'").val(dateOfBirth) ;  
             $("select[name='traveler["+index+"].documentType'").val(documentType) ;
             $("input[name='traveler["+index+"].documentNumber'").val(documentNumber) ;  
             $("input[name='traveler["+index+"].documentExpirationDate'").val(documentExpirationDate) ; 
             
             $("input[name='traveler["+index+"].citizenship'").val(citizenship) ;
             $("input[name='traveler["+index+"].placeOfBirth'").val(placeOfBirth) ;
              
}

</script>
</head>
<body >
	<div align="center">
		<h2>创建订单</h2>
	</div>
	<form  action="${pageContext.request.contextPath}/new/<%=createReservation%>"  method="post">
	    <p>
	    <span style="margin:0px 20px 0px 0px; font-weight:bold;" >tripId</span>
	    <input type="text" name="tripOptionId"  ></input>
	    <input type="hidden" name="login" value=${sessionScope.login}></input>
	    </p>
	    
	    <p>
	       <h3>乘机人</h3>
		<c:forEach begin="1" step="1" end="${sessionScope.adtNum}" var="adt"
			varStatus="status">
		第 ${status.index} 位成人：
			<ul>
				<li><select  onchange="traAdtSel(this,'${status.index-1}')" style="width: 80px; color:red;font-weight:blod;">
				        <option value="">手动输入</option>
						<option value="1">成人一</option>
						<option value="2">成人二</option>
						<option value="3">成人三</option>
						<option value="4">成人四</option>
						<option value="5">成人五</option>
				</select> 
				<input  name="traveler[${status.index-1}].code" value="ADT" type="hidden"></input> 
				姓<input  name="traveler[${status.index-1}].lName" ></input> 
				  名<input name="traveler[${status.index-1}].fName" ></input>
					
				</li>
				<li>证件类型
					<select name="traveler[${status.index-1}].documentType">
					  <option value="ID_CARD">身份证</option>
					   <option value="2.DOC">护照</option>
					   <option value="MI_CARD">军官证</option>
					    <option value="OTHER_ID">其他</option>
					</select>
					证件号<input
					name="traveler[${status.index-1}].documentNumber" ></input>
				         有效期<input
					name="traveler[${status.index-1}].documentExpirationDate" ></input> 
					签发国<input title="证件签发国" type="text" name="traveler[${status.index-1}].documentCountry"
					value="CN"></input>
				</li>
				<li>
				出生日期<input name="traveler[${status.index-1}].dateOfBirth"></input> 
				手机号<input name="traveler[${status.index-1}].mobilePhoneNumber"	></input>
				</li>
				<li>
				citizenship<input name="traveler[${status.index-1}].citizenship"></input> 
				<!--  出生地可以不输
				placeOfBirth<input name="traveler[${status.index-1}].placeOfBirth"></input>
				 -->
				性别<input name="traveler[${status.index-1}].gender"></input>
				</li>
			</ul>
		</c:forEach>
		
		<c:forEach begin="1" step="1" end="${sessionScope.cnnNum}" var="cnn"
			varStatus="status">
		第 ${status.index} 位儿童：
			<ul>
				<li><select  onchange="traCnnSel(this,'${status.index+sessionScope.adtNum-1}')" style="width: 80px; color:red;font-weight:blod;" >
						<option value="">手动输入</option>
						<option value="1">儿童一</option>
						<option value="2">儿童二</option>
						<option value="3">儿童三</option>
				</select>
                <input  name="traveler[${status.index+sessionScope.adtNum-1}].code" value="CNN" type="hidden"></input>
				姓<input  name="traveler[${status.index+sessionScope.adtNum-1}].lName" ></input> 
				 名<input name="traveler[${status.index+sessionScope.adtNum-1}].fName" "></input>
					
				</li>
				<li>证件类型
				     <select name="traveler[${status.index+sessionScope.adtNum-1}].documentType">
					  <option value="ID_CARD">身份证</option>
					   <option value="2.DOC">护照</option>
					   <option value="MI_CARD">军官证</option>
					    <option value="OTHER_ID">其他</option>
					</select> 
					证件号<input name="traveler[${status.index+sessionScope.adtNum-1}].documentNumber" />
				         有效期<input name="traveler[${status.index+sessionScope.adtNum-1}].documentExpirationDate" /> 
					签发国<input title="证件签发国" type="text" name="traveler[${status.index+sessionScope.adtNum-1}].documentCountry"
					value="CN"/>
				</li>
				<li>
				出生日期<input name="traveler[${status.index+sessionScope.adtNum-1}].dateOfBirth"/>
				手机号<input name="traveler[${status.index+sessionScope.adtNum-1}].mobilePhoneNumber"/>
				</li>
					<li>
				citizenship<input name="traveler[${status.index+sessionScope.adtNum-1}].citizenship"></input> 
				placeOfBirth<input name="traveler[${status.index+sessionScope.adtNum-1}].placeOfBirth"></input>
				性别<input name="traveler[${status.index+sessionScope.adtNum-1}].gender"></input>
				</li>
			</ul>
		</c:forEach>
		
		<c:forEach begin="1" step="1" end="${sessionScope.infNum}" var="adt"
			varStatus="status">
		第 ${status.index} 位婴儿：
			<ul>
				<li><select onchange="traInfSel(this,'${status.index+sessionScope.adtNum+sessionScope.cnnNum-1}')"  style="width: 80px; color:red;font-weight:blod;">
						<option value="">手动输入</option>
						<option value='1'>婴儿一</option>
						<option value='2'>婴儿二</option>
				</select> 
				<input  name="traveler[${status.index+sessionScope.adtNum+sessionScope.cnnNum-1}].code" value="INF" type="hidden"/>
				姓<input  name="traveler[${status.index+sessionScope.adtNum+sessionScope.cnnNum-1}].lName" ></input> 
				 名<input name="traveler[${status.index+sessionScope.adtNum+sessionScope.cnnNum-1}].fName" ></input>
					
				</li>
				<li>证件类型
				    <select name="traveler[${status.index+sessionScope.adtNum+sessionScope.cnnNum-1}].documentType">
					  <option value="ID_CARD">身份证</option>
					   <option value="2.DOC">护照</option>
					   <option value="MI_CARD">军官证</option>
					    <option value="OTHER_ID">其他</option>
					</select> 
					证件号<input
					name="traveler[${status.index+sessionScope.adtNum+sessionScope.cnnNum-1}].documentNumber"></input>
				         有效期<input
					name="traveler[${status.index+sessionScope.adtNum+sessionScope.cnnNum-1}].documentExpirationDate" /> 
					签发国<input title="证件签发国" type="text" name="traveler[${status.index+sessionScope.adtNum+sessionScope.cnnNum-1}].documentCountry"
					value="CN"></input>
				</li>
				<li>
				出生日期<input name="traveler[${status.index+sessionScope.adtNum+sessionScope.cnnNum-1}].dateOfBirth"/> 
				手机号<input name="traveler[${status.index+sessionScope.adtNum+sessionScope.cnnNum-1}].mobilePhoneNumber"/>
				</li>
					<li>
				citizenship<input name="traveler[${status.index+sessionScope.adtNum+sessionScope.cnnNum-1}].citizenship"></input> 
				placeOfBirth<input name="traveler[${status.index+sessionScope.adtNum+sessionScope.cnnNum-1}].placeOfBirth"></input>
				性别<input name="traveler[${status.index+sessionScope.adtNum+sessionScope.cnnNum-1}].gender"></input>
				</li>
			</ul>
		</c:forEach>
		</p>
		<p>
		<h3>联系人</h3>
		<ul>
		<li>
		  <input name="customer.code"  value="ADT"  type="hidden"/>
		  <input name="customer.userName"  value=${sessionScope.userName} type="hidden" />
		  <input name="customer.userId"  value=${sessionScope.userId}  type="hidden"/>
		     姓 <input name="customer.lName"  value="Test" />
		     名 <input name="customer.fName"  value="otaRest" />
		     电话 <input name="customer.mobilePhoneNumber" />
		     邮箱 <input name="customer.email"  />
		</li>
		</ul>
	   </p>
	   <div align="center">
					<input type="submit" value="确   定">
		</div>
	</form>

</body>
</html>