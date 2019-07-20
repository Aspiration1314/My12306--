<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>查询后的车票信息</title>
		<style type="text/css">
			html,body,ul,li,ol,dl,dd,dt,p,h1,h2,h3,h4,h5,h6,form,fieldset,legend,img{margin:0;padding:0}
			body{font-family: "微软雅黑"; font-size: 14px;}
		</style>
		
		<link rel="stylesheet" href="css/cp.css" />
		<link rel="stylesheet" href="css/hengfu.css" />
		<link rel="stylesheet" href="css/daohang.css" />
		<script type="text/javascript">
		//根据车票编号修改用户信息
		function queryticketById(ticketID){
			window.location.href='<%=path%>/OrderInputServlet?ticketID='+ticketID;
		}
		</script>
		
	</head>
	<body>	
		
	<div style="background-image: url(img/u=1110469124,2453812319&fm=26&gp=0.jpg); height: 800px;">	
		<div id="beijing">
			<ul>
				<li type="none">
					
				</li>
			</ul>
		</div>
		
		<center>
			<div style="position: relative; top:20px">
			<table border="1">
			
			<tr bgcolor="#1E90FF">
				<td>车次</td>
				<td>出发站</td>
				<td>到达站</td>
				<td>出发时间</td>
				<td>到达时间</td>
				<td>历时</td>
				<td>软卧数量</td>
				<td>硬卧数量</td>
				<td>硬座数量</td>
				<td>无座数量</td>
				<td>软卧票价</td>
				<td>硬卧票价</td>
				<td>硬座票价</td>
				<td>站票票价</td>
				<td>备注</td>
			</tr>
			 <c:choose>
			  	<c:when test="${empty data}">
			  		<tr>
			  			<td colspan="15">查无数据!</td>
			  		</tr>
			  	</c:when>
				<c:otherwise>
				<c:forEach  items="${data}" var="v">
				<tr bgcolor="#F5F5F5">
					<td>${v.trainnumber}</td>
					<td>${v.startstation}</td>
					<td>${v.endstation}</td>
					<td>${v.starttime}</td>
					<td>${v.endtime}</td>
					<td>${v.duration}</td>
					<td>${v.softsleepernumber}</td>
					<td>${v.softsleeperprice}</td>
					<td>${v.hardsleepernumber}</td>
					<td>${v.hardsleeperprice}</td>
					<td>${v.hardseatnumber}</td>
					<td>${v.hardseatprice}</td>
					<td>${v.noseatnumber}</td>
					<td>${v.noseatprice}</td>
					<td>
						<a href="javaScript:queryticketById(${v.ticketID})" target="_top">
							<%-- 注意：此处要修改ticketDao，一定要添加查询ticketID字段，否则${v.ticketID}永远为0 --%>
							<input type="submit" name="search" value="预订">
						</a>			
					</td>
				</tr>
				</c:forEach>
				</c:otherwise>
			 </c:choose>
			</table>
		    <table>
		    	<tr>
  				<td colspan="4">总页数:${totalpage }&nbsp;&nbsp;
		  			当前页:${currentpage }&nbsp;&nbsp;
		  			<a href="<%=path%>/QueryTicketServlet?setcurrentpage=1&startstation=${startstation}&endstation=${endstation}">首页</a>&nbsp;&nbsp;
		  			 <a href="<%=path%>/QueryTicketServlet?setcurrentpage=${currentpage <=1? 1 :(currentpage-1)}&startstation=${startstation}&endstation=${endstation}">上一页</a>&nbsp;&nbsp;
		  			<a href="<%=path%>/QueryTicketServlet?setcurrentpage=${currentpage >=totalpage?totalpage:(currentpage+1)}&startstation=${startstation}&endstation=${endstation}">  下一页  </a>&nbsp;&nbsp;
		  			 <a href="<%=path%>/QueryTicketServlet?setcurrentpage=${totalpage }&startstation=${startstation}&endstation=${endstation}">末页</td>
		  		</tr>
		    </table>
			</div>
		</center>
	</div>	
	</body>
</html>
