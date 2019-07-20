<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>用户注册</title>
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
			
			function validateuser(){
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
	<body bgcolor="#F0F8FF">
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
		<center>
		<img src="img/abanner02.jpg" >
		<h1>用户注册</h1>
        <form action="<%=path%>/AddUserServlet" method="get" onsubmit="return validateuser();">
		
		<table>
			<tr>
				<td>登录用户名</td>
				<td><input id='loginname' type="text" size="20" maxlength="20" name="loginname">*(用户名只能包含字母，数字，下划线)</td>
			</tr>
			<tr>
				<td>登录密码</td>
				<td><input id='loginpwd' type="password" size="21" maxlength="21" name="loginpwd">*(密码长度是6~20位)</td>
			</tr>
			<tr>
				<td>确认密码</td>
				<td><input type="password" size="21" maxlength="21" name="confirmpassword"></td>
			</tr>
			<tr>
				<td>真实姓名</td>
				<td><input type="text" size="20" maxlength="10" name="realname"></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td>
					<input type="radio" name="gender"  checked="checked" value='男'/>男
					<input type="radio" name="gender"  value='女'/>女
				</td>
			</tr>
			<tr>
				<td>电话号码</td>
				<td><input type="text" size="20" maxlength="20" name="telnumber"></td>
			</tr>
			<tr>
				<td>证件类型:</td>
				<td>
					<select name="cardtype">
						<option value="-1">请选择证件类型</option>
						<option value="港澳台居民身份证" >港澳台居民身份证</option>
						<option value="中国居民身份证">中国居民身份证</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>证件号码</td>
				<td><input type="text" size="20" name="cardno"></td>
			</tr>
			<tr>
				<td>乘客类型:</td>
				<td>
					<select name="usertype">
						<option value="-1">请选择乘客类型</option>
						<option value="1">成人</option>
						<option value="2">学生</option>	
			        </select>
				</td>
			</tr>
			
			
			<tr>
				<td colspan="2">
					<input type="submit" name="submit" value="确定"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" name="reset" value="取消" />
				</td>
				
			</tr>
		</table>
		</form>
		</center>	
	</body>
</html>
