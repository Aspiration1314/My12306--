<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
%>

	
	<!-- <script type="text/javascript">  
    	if (window.top!=window.self){  
        window.top.location="pay.jsp"; //这是重要的！
   		 }  
    </script>  -->

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>支付界面</title>

		<style type="text/css">
			html,body,ul,li,ol,dl,dd,dt,p,h1,h2,h3,h4,h5,h6,form,fieldset,legend,img{margin:0;padding:0}
			body{font-family: "微软雅黑"; font-size: 14px;}
		</style>
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
	<div align="center">
		<img src="img/mmqrcode1562666546264.png" width="200px" height="200px"/><br/>
		<span style="color: red; font-size: 13px;">请扫描二维码付款，并点击确认完成此次交易</span><br/>
		<form name="payorder" action="<%=path%>/OrderStatSetServlet" method="get" target="sypost">
			<input type='hidden' name='ticketID' value='${data[0]}'><br/>
			<input type='hidden' name='userID' value='${data[1]}'>
			<input type="submit" name="yifukuan" value="确认" />
		</form>
	</div>
</body>
</html>
