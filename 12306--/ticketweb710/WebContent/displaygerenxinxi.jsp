<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path =request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>个人信息</title>
		<link rel="stylesheet" href="../css/dd.css" />
		<script type="text/javascript">
	
	//根据用户编号修改用户信息
	function queryUserById(userID){
		window.location.href='<%=path%>/UpdateInputServlet?userID='+userID;
	}
</script>
	</head>
	
	<style> 
		body{background:url(img/xinxibeijing.jpg) no-repeat center top} 
		body{background-size:1057px 520px}
	</style>
	
	<body >
		<div align="center" style="position: relative; top: 100px;">
			
			<table align="center">
				<c:choose>
				<c:when test="${empty data}">
		  		<tr>
		  			<td colspan="9">查无数据!</td>
		  		</tr>
		  		</c:when>
		  		<c:otherwise>
		  		<c:forEach items="${data}" var="v">
				<tr>
					<td><span>*</span>编号:</td><td>${v[0]}</td>
				</tr>
				<tr>
					<td><span>*</span>用户名:</td><td>${v[1]}</td>
				</tr>
				<tr>
					<td><span>*</span>姓名:</td><td>${v[2]}</td>
				</tr>
				<tr>
					<td><span>*</span>性别:</td><td>${v[3]}</td>
				</tr>
				<tr>
					<td><span>*</span>电话号码:</td><td>${v[4]}</td>
				</tr>
				<tr>
					<td><span>*</span>证件类型:</td><td>${v[5]}</td>
				</tr>
				<tr>
					<td><span>*</span>证件号码:</td><td>${v[6]}</td>
				</tr>
				<tr>
					<td><span>*</span>旅客类型:</td><td>${v[7]}</td>
				</tr>
				<tr>
					<td>&nbsp;操作:</td>
					<td>
					<a href="javaScript:queryUserById(${v[0]})">
					<input type="button" value="修改" style="font-size:1px"/>
					</a></td>
				</tr>
				</c:forEach>
		  	</c:otherwise>
		  </c:choose>	
		</div>
		
		
	</body>
</html>
