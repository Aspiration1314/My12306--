<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>12306订票系统</title>
		<style type="text/css">
			html,body,ul,li,ol,dl,dd,dt,p,h1,h2,h3,h4,h5,h6,form,fieldset,legend,img{margin:0;padding:0}
			body{font-family: "微软雅黑"; font-size: 14px;}
		</style>
		
	<script type="text/javascript">  
    	if (window.top!=window.self){  
        window.top.location="index.jsp"; //这是重要的！
   		 }  
    </script> 
		
		<link rel="stylesheet" href="css/hengfu.css" />
		<link rel="stylesheet" href="css/daohang.css" />
	</head>
	<body>
		<!--
			横幅设计版块
		-->
		<div id="hengfu">
			<!--<p>欢迎使用12306订票系统</p>-->
		</div>
		<div id="plogo">
			<img src="img/logo.jpg" alt="hengfu">
		</div>
		<div id="xiushi">
			<img src="img/train.png" alt="xiushi">
		</div>
		<div>
			<form action="#" method="get">
				<input type="text" name="search" value="搜索车票/相关章程" class="searchstyle"/>
			</form>
		<div>
		<div id="search">
			<input type="image" name="submit"  value="#" src="img/search.png" height="30px" />
		</div>
		<div>
			<a id="denglu" href="login.jsp" target="_self">登录</a>
			<a id="zhuce" href="zhuce.jsp" target="_self">注册</a>
		</div>
		<!--
			导航栏版块设计
		-->
		<div id="daohang">
			<ul>
				<li><a href="#">首页</a></li>
				<li><a href="chepiaoframe.jsp" target="_blank">车次查询</a></li>
				<li><a href="tieluxinwen.jsp" target="_blank">铁路新闻</a></li>
				<li><a href="frame.jsp" target="_blank">个人信息</a></li>
				<li><a href="customerservice.jsp" target="_blank">在线客服</a></li>
				<li><a href="jishuzhichi.jsp" target="_blank">技术支持</a></li>
			</ul>
			<div style="clear: both;"></div>
		</div>
		<!--
			滚动图片设计
		-->
		<div>
			<img src="img/banner12.jpg" width="1350px" />
		</div>
		<table align="center">
			<tr>
				<td><a href="#"><img src="img/abanner01.jpg" width="503px" height="138px" /></a></td>
			    <td><a href="#"><img src="img/abanner02.jpg" width="503px" height="138px" /></a></td>
			</tr>
				<td><a href="#"><img src="img/abanner03.jpg" width="503px" height="138px" /></a></td>
				<td><a href="#"><img src="img/abanner04.jpg" width="503px" height="138px" /></a></td>
		</table>
		<div>
			<img src="img/weiduan.png" width="1350px" />
		</div>
	</body>
</html>
