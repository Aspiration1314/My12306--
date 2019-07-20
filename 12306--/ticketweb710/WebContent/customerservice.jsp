<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
      String path =request.getContextPath();
%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv=”Content-Type” content=”text/html; charset=UTF-8”>
		<title>在线客服</title>
		<style type="text/css">
			html,body,ul,li,ol,dl,dd,dt,p,h1,h2,h3,h4,h5,h6,form,fieldset,legend,img{margin:0;padding:0}
			body{font-family: "微软雅黑"; font-size: 14px;}
			.box {
            width: 600px;
            height: 20px;
            margin: 0 auto;
            border: 1px solid #ff6700;
            overflow: hidden;
            background-color:azure;
        }

        .animate {
            padding-left: 20px;
            font-size: 12px;
            font-family:"微软雅黑";
            color: #000;
            display: inline-block;
            white-space: nowrap;
            animation: 10s wordsLoop linear infinite normal;
        }

        @keyframes wordsLoop {
            0% {
                transform: translateX(200px);
                -webkit-transform: translateX(200px);
            }
            100% {
                transform: translateX(-100%);
                -webkit-transform: translateX(-100%);
            }
        }

        @-webkit-keyframes wordsLoop {
            0% {
                transform: translateX(200px);
                -webkit-transform: translateX(200px);
            }
            100% {
                transform: translateX(-100%);
                -webkit-transform: translateX(-100%);
            }
        }
		</style>
		<link rel="stylesheet" href="css/hengfu.css" />
		<link rel="stylesheet" href="css/daohang.css" />
		<link rel="stylesheet" href="css/shuruyu.css" />
		<script type="text/javascript">
			
			function msg(){
				if(window.confirm("确认提交你的反馈?")){
					window.location.href='<%=path%>/AddFeedbackServlet';
				}
			}
			
			
		</script>
		
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
		<div class="box">
    		<span class="animate">好消息：有话就说，我们需要您的宝贵建议！！！</span><br/>
		</div>
		<div id="shuru">
			<form action="<%=path%>/AddFeedbackServlet" method="post" >
			<%-- <form action="<%=path%>/AddFeedbackServlet" method="get" > --%>
				请输入要反馈的信息：
				<textarea rows="10" cols="50" name="information"></textarea>
				<!-- <input type="text" name="information"> -->
				<input type="submit" value="我要反馈" onclick="msg()"/>
				
			</form>
		</div>
		<div id="chakan">
			<form action="<%=path%>/QueryFeedbackServlet" method="get">
				<p>您有<font color="red">N</font>条消息未查看<input type="submit" value="点击显示详情" /></p>
				<input type="text" value="${data[0]}" />
			</form>
		</div>
	</div>
	</body>
</html>
