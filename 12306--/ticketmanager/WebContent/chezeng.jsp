<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>增加车票</title>
	</head>
	<center>
<body background="img/020.jpg">
		<h1>增加车票</h1>
<form action="<%=path%>/AddTicketServlet" >
			<table border="0">
		
			<tr>
				<td>车次</td>
				<td><input id="trainnumber" type="text" size="20" maxlength="20" name="trainnumber"></td>
			</tr>
			<td>起始站</td>
				<td><input id="startstation" type="text" size="20" maxlength="20" name="startstation"></td>
			</tr>
			<tr>
				<td>目的站</td>
				<td><input id="endstation" type="text" size="20" maxlength="20" name="endstation"></td>
			</tr>
			
				<td>开车时间</td>
				<td><input id="starttime" type="text" size="20" maxlength="20" name="starttime"></td>
			</tr>
			 <tr>
				<td>到达时间</td>
				<td><input id="endtime" type="text" size="20" maxlength="20" name="endtime"></td>
			</tr>
			<tr>
				<td>历时</td>
				<td><input id="duration" type="text" size="20" maxlength="20" name="duration"></td>
				</table>
				 <td></br></td>
				<table>
			</tr>
				<td>增加数量</td>
				<td>
				软卧<input id="softsleepernumber" type="text" size="5" maxlength="4" name="softsleepernumber">张&nbsp;&nbsp;&nbsp;&nbsp;
				硬卧<input  id="hardsleepernumber" type="text" size="5" maxlength="4" name="hardsleepernumber">张&nbsp;&nbsp;&nbsp;&nbsp;
				硬座<input  id="hardseatnumber" type="text" size="5" maxlength="4" name="hardseatnumber">张&nbsp;&nbsp;&nbsp;&nbsp;
				无座<input  id="noseatnumber" type="text" size="5" maxlength="4" name="noseatnumber">张&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
			</tr>

			<tr>
				<td>车票单价</td>
				<td>
				软卧<input  id="softsleeperprice" type="text" size="5" maxlength="4" name="softsleeperprice">元&nbsp;&nbsp;&nbsp;&nbsp;
				硬卧<input id="hardsleeperprice"type="text" size="5" maxlength="4"name="hardsleeperprice">元&nbsp;&nbsp;&nbsp;&nbsp;
				硬座<input id="hardseatprice"type="text" size="5" maxlength="4"name="hardseatprice">元&nbsp;&nbsp;&nbsp;&nbsp;
				无座<input id="noseatprice"type="text" size="5" maxlength="4"name="noseatprice">元&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
			</tr>
					<tr>
			
		</table>
	<td></br></td>
		<td colspan="2">
<a href="/AddTicketServlet"><input type="submit" name="submit" value="增加" /></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="welcome.jsp"><input type="reset" name="reset" value="返回" /></a>
</table>
				</td>
			</form>
	</body>
	</center>
</html>

