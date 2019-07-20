<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
%>

<!-- http://localhost:8080/ticketweb/frame.jsp -->

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>个人信息</title>
		<style type="text/css">
			html,body,ul,li,ol,dl,dd,dt,p,h1,h2,h3,h4,h5,h6,form,fieldset,legend,img{margin:0;padding:0}
			body{font-family: "微软雅黑"; font-size: 14px;}
		</style>
		
		<link rel="stylesheet" href="css/hengfu.css" />
		<link rel="stylesheet" href="css/daohang.css" />
	</head>
	
    <frameset rows="16%,*" border="3">	
    	<frame src="welcome.jsp" name="top"/ noResize scrolling="no">
    	<frameset cols="21%,*" border="3">
    	   <frame src="left.jsp" tppabs="left.html" />
    	   
    	   	<frame src="gerenxinxitupian.jsp" name="right"/>
    		<frame src="displaygerenxinxi.jsp" name="right"/>
    		<frame src="gerenxinxixiugai.jsp" name="right"/>

    		<frame src="wwc.jsp" name="right"/>
    		<frame src="wcx.jsp" name="right"/>
    		<frame src="lsdd.jsp" name="right"/>
    	</frameset>
    </frameset>
</html>