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
		<title>未完成订单</title>
		
		<style> 
		body{background:url(img/xinxibeijing.jpg) no-repeat center top} 
		body{background-size:1057px 520px}
		</style>
		
		<script type="text/javascript">
			
			//根据订单编号取消订单
			function CancelTicketById(orderID){
				console.log(orderID);
				if(window.confirm("确定是否取消用户编号为:" + orderID +"的订单?")){
					window.location.href='<%=path%>/CancelTicketServlet?orderID=' + orderID;
				}
			}
			
			//根据订单编号更新订单状态
			function changeStatTicketById(orderID){
				console.log(orderID);
				if(window.confirm("点击确定付款?")){
					window.location.href='<%=path%>/changeStatTicketServlet?orderID=' + orderID;
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
			<a href="javaScript:changeStatTicketById(${v[0]})" target="_top">
			<!-- 这里的逻辑很简单，只需要传递order编号，然后修改订单状态即可 -->
				<input type="button" value="确认付款" style="font-size:1px"/>
			</a>
		  	<a href="javaScript:CancelTicketById(${v[0]})">
		  		<input type="button" value="取消订单" style="font-size:1px"/>
			</a>
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
