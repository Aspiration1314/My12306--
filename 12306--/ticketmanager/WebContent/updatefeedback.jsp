<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>修改反馈信息</title>
	</head>
	
	
	<center>
<body background="img/020.jpg">
		<h1>修改反馈信息</h1>

<form action="<%=path%>/UpdateFeedbackServlet" method="get">

	<input type='hidden' name='informationID' value='${obj.informationID}'>
			<table border="0">
			<tr>
				<td>用户编号</td>
				<td><input id="userID" type="text" size="20" maxlength="20" name="userID"value="${obj.userID}"></td>
			</tr>
			<tr>
				
			<td>信息内容</td>
				<td><input id="information" type="text" size="20" maxlength="20" name="information"value="${obj.information }"></td>
			</tr>
			<tr>
				<td>处理状态</td>
				<td>
					<select id="operation" name="operation"value="${obj.operation }">
						<option value="-1">未处理</option>
						<option value="1" >已处理</option>
						
					</select>
				</td>
			
			</tr>
				<td>处理结果</td>
				<td><input id="operationresult" type="text" size="20" maxlength="20" name="operationresult"value="${obj.operationresult }"></td>
			</tr>
			
		</table>
	<td></br></td>

<tr>
				<td colspan="2">
					<input type="submit" name="submit" value="确定" />
				<a href="feedback.jsp">	<input type="reset" name="reset" value="取消" /></a>
				</td>
			</tr>
</table>
				</td>
			</form>
	</body>
	</center>
</html>

