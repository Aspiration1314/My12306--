<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path =request.getContextPath();
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>12306订票系统后台管理</title>
	

	</head>
    
    <frameset rows="15%,*" border="5">
    	<frame src="top.jsp" name="top"/ noResize scrolling="no">
    	<frameset cols="14%,*">
    		<frame src="left.jsp" name="left"/>
    		<frame src="welcome.jsp" name="welcome" />
    	</frameset>
    </frameset>
    
</html>
