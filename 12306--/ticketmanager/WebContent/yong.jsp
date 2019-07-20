<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path =request.getContextPath();
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>用户管理系统</title>
		<script type="text/javascript">
	//根据反馈信息编号删除用户信息
	function delUserByID(userID){
		console.log(userID);
		if(window.confirm("确定是否删除用户编号为:" + userID +"的用户信息吗?")){
			window.location.href='<%=path%>/DelUserServlet?userID=' + userID;
		}
	}
</script >
	</head>
	<center>
    <body background="img/020.jpg">
      <form action="<%=path%>/QueryUserServlet" method="get">
    	<h1>用户管理系统</h1>
    	<table border="0">
    		 
            <tr>
				<td>真实姓名</td>
				<td><input type="text" size="20" maxlength="10" name="realname"value="${realname}"></td>
			</tr>
			</table>
			<tr></br></tr>
			<tr>
				
			
					<input type="submit" name="submit" value="查找" />
			
				  </form>
	
			</tr>
 
 <td></br></td>

    <table border="6">
  <tr>
  <td>用户编号</td>
  <td>用户名</td>
   <td>用户密码</td>
  <td>真实姓名</td>
  <td>性别</td>

  <td>电话</td>
  <td>证件类型</td>
  <td>证件号码</td>
  <td>旅客类型</td>
  
    <td>选项</td>
  </tr>

   <c:choose>
  			<c:when test="${empty data}">
  				<tr>
  					<td colspan="10">查无数据!</td>
  				</tr>
  			</c:when>
			
			<c:otherwise>
			<tr >
			<c:forEach items="${data}" var="v">
				<td>${v[0]}</td>
				<td>${v[1]}</td>
				<td>${v[2]}</td>
				<td>${v[3]}</td>
				<td>${v[4]}</td>
				<td>${v[5]}</td>
				<td>${v[6]}</td>
				<td>${v[7]}</td>
				<td>${v[8]}</td>
		
	<td><a href="javaScript:delUserByID(${v[0]})">删除</a></td>	
			
			</tr>
			</c:forEach>
			</c:otherwise>
			</c:choose>
			<tr>
  			<td colspan="10">总页数:${totalpage }&nbsp;&nbsp;
  			当前页:${currentpage }&nbsp;&nbsp;
  			<a href="<%=path%>/QueryUserServlet?setcurrentpage=1&realname=${realname}">首页</a>&nbsp;&nbsp;
  			 <a href="<%=path%>/QueryUserServlet?setcurrentpage=${currentpage <=1? 1:(currentpage-1)}&realname=${realname}">上一页</a>&nbsp;&nbsp;
  			<a href="<%=path%>/QueryUserServlet?setcurrentpage=${currentpage >=totalpage?totalpage:(currentpage+1)}&realname=${realname}">  下一页  </a>&nbsp;&nbsp;
  			 <a href="<%=path%>/QueryUserServlet?setcurrentpage=${totalpage }&realname=${realname}">末页</td>
  
  </tr>
			
  
				
</table>
<td></br></td>
<td></br></td>

<a href="welcome.jsp"><input type="reset" name="reset" value="返回" /></a>
	</body>
	</center>
</html>
