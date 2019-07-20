<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path =request.getContextPath();
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>top</title>
	</head>
		<link rel="stylesheet" href="css/hengfu.css" />
		<style type="text/css">
			html,body,ul,li,ol,dl,dd,dt,p,h1,h2,h3,h4,h5,h6,form,fieldset,legend,img{margin:0;padding:0}
			body{font-family: "微软雅黑"; font-size: 14px;}
		</style>

	<body >
<div id="plogo">
			<img src="img/logo.jpg" alt="hengfu">
		</div>
		<div id="xiushi">
			<img src="img/train.png" alt="xiushi">
		</div>
		<div id="hengfu">
			<p>欢迎使用12306订票系统</p>
		</div>
		<!--
			导航栏版块设计
		-->
		<div id="daohang">
			
		</div>
		<center>
		<div>
<a href="index.jsp" target="_parent"><input type="reset" name="reset" value="返回管理员登录页面" /></a>
		</div></center>
	</body>
</html>
