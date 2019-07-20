<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
%>

<!-- 127.0.0.1:8080/QueryOrderServlet/left.jsp -->

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>左边列表</title>
		
		<link rel="stylesheet" href="../css/dd.css" />
		<link rel="stylesheet" href="css/daohang.css" />
		
	</head>
	<body style="background-color:khaki">
		<div id="changeleft" >
			<ul>
				<li type="none">
					<h3><font face="黑体" color="royalblue">个人信息</font></h3>
					<ul>
						<li>
							<a href="<%=path%>/QueryUserServlet" target="right">查看个人信息</a>
						</li>
					</ul>
				</li>
				<li type="none">
					<h3><font face="黑体" color="royalblue">个人订单</font></h3>
					<ul>
						<li>
							<a href="<%=path%>/QueryOrderServlet" target="right">未完成订单</a>
						</li>
						<li>
							<a href="<%=path%>/QueryOrder1Servlet" target="right">未出行订单</a>
						</li>
						<li>
							<a href="lsdd.html" target="right">历史订单</a>
						</li>
					</ul>
				</li>
				
			</ul>
		</div>
	</body>
</html>
