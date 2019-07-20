<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
%>



<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>左边列表</title>

		
	</head>
	<body>
	<td></br></td>
	<td></br></td>

		<div id="changeleft" >
			<ul>
				<li type="none">
					<h3><font face="黑体" color="royalblue">票务管理</font></h3>
					<ul>
						<li>
							<a href="chezeng.jsp" target="welcome">增加车票</a>
						</li>
						<td></br></td>
						<li>
							<a href="<%=path%>/QueryTicketServlet" target="welcome">票务管理</a>
						</li>
					</ul>
				</li>
				<li type="none">
					<h3><font face="黑体" color="royalblue">用户与订单管理</font></h3>
					<ul>
						<li>
							<a href="<%=path%>/QueryUserServlet" target="welcome">用户管理</a>
						</li>
						<td></br></td>
						<li>
							<a href="<%=path%>/QueryOrderServlet" target="welcome">订单管理</a>
						</li>
						
					</ul>
				</li>
				
				<li type="none">
					<h3><font face="黑体" color="royalblue">反馈信息管理</font></h3>
					<ul>
						<li>
							<a href="<%=path%>/QueryFeedbackServlet" target="welcome">反馈信息</a>
						</li>
						
					</ul>
				</li>
			</ul>
		</div>
	</body>
</html>
