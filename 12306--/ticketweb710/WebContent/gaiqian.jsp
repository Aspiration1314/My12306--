<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
    
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>改签</title>

		<style type="text/css">
			html,body,ul,li,ol,dl,dd,dt,p,h1,h2,h3,h4,h5,h6,form,fieldset,legend,img{margin:0;padding:0}
			body{font-family: "微软雅黑"; font-size: 14px;}
		</style>
		
		<link rel="stylesheet" href="css/hengfu.css" />
		<link rel="stylesheet" href="css/daohang.css" />
</head>
	
<body>
	
		
		<center>
			<div style="position: relative; top:20px">
			<table border="1">
			
			<tr bgcolor="#1E90FF">
				<td>车次</td>
				<td>出发站</td>
				<td>到达站</td>
				<td>出发时间</td>
				<td>到达时间</td>
				<td>历时</td>
				<td>软卧数量</td>
				<td>硬卧数量</td>
				<td>硬座数量</td>
				<td>无座数量</td>
				<td>软卧票价</td>
				<td>硬卧票价</td>
				<td>硬座票价</td>
				<td>站票票价</td>
				<td>备注</td>
			</tr>
			 <c:choose>
			  	<c:when test="${empty data}">
			  		<tr>
			  			<td colspan="15">查无数据!</td>
			  		</tr>
			  	</c:when>
				<c:otherwise>
				<c:forEach  items="${data}" var="v">
				<tr bgcolor="#F5F5F5">
					<td>${v.trainnumber}</td>
					<td>${v.startstation}</td>
					<td>${v.endstation}</td>
					<td>${v.starttime}</td>
					<td>${v.endtime}</td>
					<td>${v.duration}</td>
					<td>${v.softsleepernumber}</td>
					<td>${v.softsleeperprice}</td>
					<td>${v.hardsleepernumber}</td>
					<td>${v.hardsleeperprice}</td>
					<td>${v.hardseatnumber}</td>
					<td>${v.hardseatprice}</td>
					<td>${v.noseatnumber}</td>
					<td>${v.noseatprice}</td>
					<td>
					
						<%-- <form name="checichaxun" action="<%=path%>/AddOrderServlet" method="get" target="sypost"> --%>
						<form name="checibiangeng" action="<%=path%>/GaiQianServlet" method="get" >
								<%-- 注意：此处要修改ticketDao，一定要添加查询ticketID字段，否则${v.ticketID}永远为0 --%>
								<input type='hidden' name='ticketID' value='${v.ticketID}' />
								<input type='hidden' name='orderID' value='${orderID}' />
								<select id="seatchoose" style="width:50px; height:25px;" name="seattype" >
									<option value ="软卧">软卧</option>
  									<option value ="硬卧">硬卧</option>
  									<option value="硬座">硬座</option>
  									<option value="无座">无座</option>
								</select>
								<input type="submit" name="search" value="确认变更到本车次" />
						</form>
					</td>
				</tr>
				</c:forEach>
				</c:otherwise>
			 </c:choose>
			</table>
		</div>
		
</body>
</html>