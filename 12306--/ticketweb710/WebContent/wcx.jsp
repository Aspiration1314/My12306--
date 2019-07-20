<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    <!-- 引入标签指令 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
%>
<!-- http://localhost:8080/ticketweb/frame.jsp -->

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>未出行订单</title>
		
		
		<style> 
			body{background:url(img/xinxibeijing.jpg) no-repeat center top} 
			body{background-size:1057px 520px}
		</style>
		
		<script type="text/javascript">
			//根据订单编号退票
			function BackTicketById(orderID){
				console.log(orderID);
				if(window.confirm("确定是否取消用户编号为" + orderID +"车票的购买?")){
					window.location.href='<%=path%>/BackTicketServlet?orderID=' + orderID;
				}
			}
			
			//根据订单号改签
			function gaiqanById(orderID){
				console.log(orderID);
				if(window.confirm("确定变更车次?")){
					window.location.href='<%=path%>/GetStationServlet?orderID=' + orderID;
				}
			}
			
			
		</script>
		
	</head>
	<body >
		<div align="center" style="position: relative; top: 100px;">
			
			<table border="1">
			<tr bgcolor="#1E90FF">
				<td>订单编号</td>
				<td>车次</td>
				<td>出发站</td>
				<td>到达站</td>
				<td>出发时间</td>
				<td>到达时间</td>
				<td>旅客姓名</td>
				<td>证件类型</td>
				<td>火车类型</td>
				<td>车票类型</td>
				<td>票价</td>
				<td>车票状态</td>
				<td>备注</td>
			</tr>
			
			<c:choose>
  			<c:when test="${empty data}">
  				<tr>
  					<td colspan="14">查无数据!</td>
  				</tr>
  			</c:when>
			
			<c:otherwise>
			<tr bgcolor="#F5F5F5">
			<c:forEach items="${data}" var="v">
				<td>${v[0]}</td>
				<td>${v[1]}</td>
				<td>${v[2]}</td>
				<td>${v[3]}</td>
				<td style="font-size:1px">${v[4]}</td>
				<td>${v[5]}</td>
				<td>${v[6]}</td>
				<td style="font-size:1px">${v[7]}</td>
				<td style="font-size:1px">${v[8]}</td>
				<td>${v[9]}</td>
				<td>${v[10]}</td>
				<td>${v[11]}</td>
			<td>
				<a href="javaScript:BackTicketById(${v[0]})">
					<input type="button" value="退票" style="font-size:1px"/>
				</a>
				<a href="javaScript:gaiqanById(${v[0]})">
		  			<input type="button" value="改签" style="font-size:1px" />
		  		</a>
		  	</td> 
					
				
			</tr>
			
			</c:forEach>
			</c:otherwise>
			</c:choose>
			
		    </table>
		</div>
		
	</body>
</html>
