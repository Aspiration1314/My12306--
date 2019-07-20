<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>修改车票</title>
	</head>
	
	
	<center>
<body background="img/020.jpg">
		<h1>修改车票信息</h1>

<form action="<%=path%>/UpdateTicketServlet" >
		<input type="hidden" name="ticketID" value="${obj.ticketID }">
			<table border="0">
			<tr>
				<td>管理员ID</td>
				<td><input id="managerID" type="text" size="20" maxlength="20"name="managerID" value="${obj.managerID }"></td>
			</tr>
			<tr>
				<td>车次</td>
				<td><input id="trainnumber" type="text" size="20" maxlength="20" name="trainnumber"value="${obj.trainnumber}"></td>
			</tr>
			<td>起始站</td>
				<td><input id="startstation" type="text" size="20" maxlength="20" name="startstation"value="${obj.startstation }"></td>
			</tr>
			<tr>
				<td>目的站</td>
				<td><input id="endstation" type="text" size="20" maxlength="20" name="endstation"value="${obj.endstation }"></td>
			</tr>
			
				<td>开车时间</td>
				<td><input id="starttime" type="text" size="20" maxlength="20" name="starttime"value="${obj.starttime }"></td>
			</tr>
			 <tr>
				<td>到达时间</td>
				<td><input id="endtime" type="text" size="20" maxlength="20" name="endtime"value="${obj.endtime }"></td>
			</tr>
			<tr>
				<td>历时</td>
				<td><input id="duration" type="text" size="20" maxlength="20" name="duration"value="${obj.duration }"></td>
			</tr>
				<td>增加数量</td>
				<td>
				软卧<input id="softsleepernumber" type="text" size="5" maxlength="4" name="softsleepernumber"value="${obj.softsleepernumber }">张&nbsp;&nbsp;&nbsp;&nbsp;
				硬卧<input  id="hardsleepernumber" type="text" size="5" maxlength="4" name="hardsleepernumber"value="${obj.hardsleepernumber }">张&nbsp;&nbsp;&nbsp;&nbsp;
				硬座<input  id="hardseatnumber" type="text" size="5" maxlength="4" name="hardseatnumber"value="${obj.hardseatnumber }">张&nbsp;&nbsp;&nbsp;&nbsp;
				无座<input  id="noseatnumber" type="text" size="5" maxlength="4" name="noseatnumber"value="${obj.noseatnumber }">张&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
			</tr>

			<tr>
				<td>车票单价</td>
				<td>
				软卧<input  id="softsleeperprice" type="text" size="5" maxlength="4" name="softsleeperprice"value="${obj.softsleeperprice }">元&nbsp;&nbsp;&nbsp;&nbsp;
				硬卧<input id="hardsleeperprice"type="text" size="5" maxlength="4"name="hardsleeperprice"value="${obj.hardsleeperprice }">元&nbsp;&nbsp;&nbsp;&nbsp;
				硬座<input id="hardseatprice"type="text" size="5" maxlength="4"name="hardseatprice"value="${obj.hardseatprice }">元&nbsp;&nbsp;&nbsp;&nbsp;
				无座<input id="noseatprice"type="text" size="5" maxlength="4"name="noseatprice"value="${obj.noseatprice }">元&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
			</tr>
					<tr>
			
		</table>
	<td></br></td>

<tr>
				<td colspan="2">
					<input type="submit" name="submit" value="确定" />
					<input type="reset" name="reset" value="取消" />
				</td>
			</tr>
</table>
				</td>
			</form>
	</body>
	</center>
</html>

