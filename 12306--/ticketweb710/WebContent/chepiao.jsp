<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>输入查询条件</title>
		<style type="text/css">
			html,body,ul,li,ol,dl,dd,dt,p,h1,h2,h3,h4,h5,h6,form,fieldset,legend,img{margin:0;padding:0}
			body{font-family: "微软雅黑"; font-size: 14px;}
		</style>
		
		<link rel="stylesheet" href="css/cp.css" />
		<link rel="stylesheet" href="css/hengfu.css" />
		<link rel="stylesheet" href="css/daohang.css" />
	</head>
	<body>	
		<!--
			横幅设计版块
		-->
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
		
	<div style="background-image: url(img/u=1110469124,2453812319&fm=26&gp=0.jpg); height: 800px;">
		<center>
		<div style="position: relative; top:20px" id="shuru">
			<form name="checichaxun" action="<%=path%>/QueryTicketServlet" method="get" target="below">
			
				出发站：<input type="text" size="10" maxlength="10" name="startstation" value='${startstation }'>&nbsp;&nbsp;
				到达站：<input type="text" size="10" maxlength="10" name="endstation" value='${endstation }'>&nbsp;&nbsp;
					<a href="chepiao.jsp" target="top"><input type='submit' name='submit' value='查询'/></a>
			</form>
		</div>
		<div id="beijing">
			<ul>
				<li type="none">
				</li>
			</ul>
		</div>
		
		
	</div>	
		
	</body>
</html>
