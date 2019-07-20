<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>用户登录</title>
		<script type="text/javascript">
			//验证登录用户名输入的合法性
			function validateloginname(){
				//1.获取输入的登录用户名
				var _loginname = document.getElementById('loginname').value;
				var pattern= /^\w{1,20}$/;
				if(!pattern.test(_loginname)){
					window.alert('用户名输入不合法');
					return false;
				}
				
				 return true;
			}
			
			//校验密码的合法性
			function validatepwd(){
				var _loginpwd =document.getElementById('loginpwd').value;
				var pattern = /^.{6,20}$/;
				if(!pattern.test(_loginpwd)){
					window.alert('密码长度必须是6~20位');
					return false;
				}
				return  true;
			}
			
			function validatemanager(){
				if(validateloginname()==true && validatepwd()==true){
					return true;
				}
				return false;
			}
        </script>
        
        	
	  

        
		<style type="text/css">
			html,body,ul,li,ol,dl,dd,dt,p,h1,h2,h3,h4,h5,h6,form,fieldset,legend,img{margin:0;padding:0}
			body{font-family: "微软雅黑"; font-size: 14px;}
		</style>
		
		
		<link rel="stylesheet" href="css/hengfu.css" />
		<link rel="stylesheet" href="css/daohang.css">
	</head>
	<center>
	<body background="img/023.jpg">
		<td></br></td>
		<td></br></td>
			<h1>欢迎使用12306订票系统</h1>
	
<td></br></td>
		<h1>管理员登录</h1>
		<td></br></td>
		<form action="<%=path%>/LoginServlet" method="get" onsubmit="return validateuser();">
		<table>
			<tr>
				<td>登录用户名</td>
				<td><input id='loginname' type="text" size="20" maxlength="20" name="loginname"></td>
			</tr>
			<td></br></td>
			<tr>
				<td>登录密码</td>
				<td><input id='loginpwd' type="password" size="20" maxlength="20" name="loginpwd"></td>
			</tr>
				</table>
			<td></br></td>
			<tr>
				<td>
					<input type="submit" name="submit"  value="确定" />
	
				</td>
			</tr>
	

		</form>
	</center>		
	</body>
</html>
