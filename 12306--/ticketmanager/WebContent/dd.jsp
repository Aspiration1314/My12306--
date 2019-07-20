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
		<title>用户订单查询</title>
		<script type="text/javascript">
	//根据反馈信息编号删除用户信息
	function delOrderByID(orderID){
		console.log(orderID);
		if(window.confirm("确定是否删除订单编号为:" + orderID +"的订单信息吗?")){
			window.location.href='<%=path%>/DelOrderServlet?orderID=' + orderID;
		}
	}
</script >
	</head>
	
	
	<body background="img/020.jpg">
		<center>
			<h1>用户订单查询</h1>
			 <form action="<%=path%>/QueryOrderServlet" method="get">
 
<table>
			<tr>
			<td>真实姓名</td>
				<td><input id="realname" type="text" size="20" maxlength="20" name="realname"value="${realname}"></td>
			
			</tr>

			<tr>
			<td>订单状态</td>
				<td><input id="orderstate" type="text" size="20" maxlength="20" name="orderstate"value="${orderstate}"></td>
			</tr>
          </table>
          
          
      
  <td></br></td>

				<input type='submit' name='submit' value='查询'>
				  
     </form>
	
			</tr>
 
 <td></br></td>

		<table border="6">
  <tr>
 	          <td>订单编号</td>
				<td>车次</td>
				<td>出发站</td>
				<td>到达站</td>
				<td>出发时间</td>
				<td>到达时间</td>
				<td>旅客姓名</td>
				<td>证件类型</td>
				<td>车票类型</td>
				<td>旅客类型</td>
	            <td>票价</td>
	            <td>下单时间</td>
				<td>车票状态</td>
				<td>备注</td>
			</tr>
			
			<c:choose>
  			<c:when test="${empty data}">
  				<tr>
  					<td colspan="14">查无数据!</td>
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
				<td>${v[9]}</td>
				<td>${v[10]}</td>
				<td>${v[11]}</td>
				<td>${v[12]}</td>
			 	<td><a href="javaScript:delOrderByID(${v[0]})">删除</a></td>
		
			
			</tr>
			</c:forEach>
			</c:otherwise>
			</c:choose>
			<tr>
  			<td colspan="14">总页数:${totalpage }&nbsp;&nbsp;
  			当前页:${currentpage }&nbsp;&nbsp;
  			<a href="<%=path%>/QueryOrderServlet?setcurrentpage=1&realname=${realname}&orderstate=${orderstate}">首页</a>&nbsp;&nbsp;
  			 <a href="<%=path%>/QueryOrderServlet?setcurrentpage=${currentpage <=1? 1:(currentpage-1)}&realname=${realname}&orderstate=${orderstate}">上一页</a>&nbsp;&nbsp;
  			<a href="<%=path%>/QueryOrderServlet?setcurrentpage=${currentpage >=totalpage?totalpage:(currentpage+1)}&realname=${realname}&orderstate=${orderstate}">  下一页  </a>&nbsp;&nbsp;
  			 <a href="<%=path%>/QueryOrderServlet?setcurrentpage=${totalpage }&realname=${realname}&orderstate=${orderstate}">末页</td>
  
  </tr>
		    </table>
<td></br></td>


<a href="welcome.jsp"><input type="reset" name="reset" value="返回" /></a>
	</body>
	</center>
</html>


    
  
	

