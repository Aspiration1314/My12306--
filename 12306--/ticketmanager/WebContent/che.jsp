<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path =request.getContextPath();
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
	<head>
	
		<meta charset="utf-8" />
		<title>票务管理</title>
		<script type="text/javascript">
	//根据反馈信息编号删除用户信息
	function delTicketByID(ticketID){
		console.log(ticketID);
		if(window.confirm("确定是否删除车票编号为:" + ticketID +"的车票信息吗?")){
			window.location.href='<%=path%>/DelTicketServlet?ticketID=' + ticketID;
		}
	}
	//根据用户编号修改用户信息
	function queryTicketByID(ticketID){
		window.location.href='<%=path%>/UpdateInputTicketServlet?ticketID='+ticketID;
	}
</script >
	</head>
	<center>
    <body background="img/020.jpg">
    	<h1>票务管理</h1>
				
 <table border="0">


    <form action="<%=path%>/QueryTicketServlet" method="get">
 <tr>
    <td>车次</td>
				<td><input id="trainnumber" type="text" size="20" maxlength="20" name="trainnumber"value="${trainnumber}"></td>
	</tr>
	<tr>
			<td>起始站</td>
				<td><input id="startstation" type="text" size="20" maxlength="20" name="startstation"value="${startstation}"></td>
			</tr>
			<tr>
				<td>目的站</td>
				<td><input  id="endstation" type="text" size="20" maxlength="20" name="endstation"value="${endstation}"></td>
			</tr>
	
     <tr>
  
          </table>
          <td></br></td>

				<input type='submit' name='submit' value='查询'>
				  
     </form>
	
			</tr>
 
 <td></br></td>
<td></br></td>
    <table border="6">
  <tr>
  <td>编号</td>
  <td>车次</td>
  <td>起始站</td>
  <td>目的站</td>

  <td>开车时间</td>
  <td>到达时间</td>
  <td>历时</td>
  <td>软卧票数</td>
   <td>软卧单价</td>
  <td>硬卧票数</td>
   <td>硬卧单价</td>
  <td>硬座票数</td>
    <td>硬座单价</td>
  <td>无座票数</td>
    <td>无座单价</td>
    <td>选项</td>
  </tr>

   <c:choose>
  	<c:when test="${empty data}">
  		<tr>
  			<td colspan="16">查无数据!</td>
  		</tr>
  	</c:when>
  	<c:otherwise>
  		<c:forEach  items="${data}" var="v">
  			<tr>
		    <td>${v.ticketID}</td>
		  	<td>${v.trainnumber}</td>
		  	<td>${v.startstation}</td>
		  	<td>${v.endstation}</td>
		  	<td>${v.starttime}</td>
		  	<td>${v.endtime}</td>
		  	<td>${v.duration}</td>
		  	<td>${v.softsleepernumber }</td>
		  	<td>${v.softsleeperprice}</td>
		  	<td>${v.hardsleepernumber}</td>
		  	<td>${v.hardsleeperprice}</td>
		  	<td>${v.hardseatnumber}</td>
		  	<td>${v.hardseatprice}</td>
		  	<td>${v.noseatnumber}</td>
		  	<td>${v.noseatprice}</td>
		  	<td><a href="javaScript:queryTicketByID(${v.ticketID})">修改</a>|
		  	<a href="javaScript:delTicketByID(${v.ticketID})">删除</a></td>  	 	
		  </tr>
		
  		</c:forEach>
  	</c:otherwise>
  </c:choose>
  <tr>
  			<td colspan="16">总页数:${totalpage }&nbsp;&nbsp;
  			当前页:${currentpage }&nbsp;&nbsp;
  			<a href="<%=path%>/QueryTicketServlet?setcurrentpage=1&trainnumber=${trainnumber}&startstation=${startstation}&endstation=${endstation}">首页</a>&nbsp;&nbsp;
  			 <a href="<%=path%>/QueryTicketServlet?setcurrentpage=${currentpage <=1? 1:(currentpage-1)}&trainnumber=${trainnumber}&startstation=${startstation}&endstation=${endstation}">上一页</a>&nbsp;&nbsp;
  			<a href="<%=path%>/QueryTicketServlet?setcurrentpage=${currentpage >=totalpage?totalpage:(currentpage+1)}&trainnumber=${trainnumber}&startstation=${startstation}&endstation=${endstation}">  下一页  </a>&nbsp;&nbsp;
  			 <a href="<%=path%>/QueryTicketServlet?setcurrentpage=${totalpage }&trainnumber=${trainnumber}&startstation=${startstation}&endstation=${endstation}">末页</td>
  
  </tr>
				
</table>
<td></br></td>
<td></br></td>

<a href="welcome.jsp"><input type="reset" name="reset" value="返回" /></a>
	</body>
	</center>
</html>