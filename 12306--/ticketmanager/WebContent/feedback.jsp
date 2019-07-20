<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>反馈信息处理</title>
<script type="text/javascript">
	//根据反馈信息编号删除用户信息
	function delFeedbackByID(informationID){
		console.log(informationID);
		if(window.confirm("确定是否删除反馈信息编号为:" + informationID +"的反馈信息吗?")){
			window.location.href='<%=path%>/DelFeedbackServlet?informationID=' + informationID;
		}
	}
	function queryFeedbackByID(informationID){
	
			window.location.href='<%=path%>/UpdateInputFeedbackServlet?informationID=' + informationID;
		}
	
</script >
	</head>
	<center>
	<body background="img/020.jpg">
		<center>
	<h1>用户信息反馈</h1></center>
	<tr>

    <form action="<%=path%>/QueryFeedbackServlet" method="get">
 
    <td>处理状态</td>
				<td><input id="operation" type="text" size="20" maxlength="20" name="operation" value="${operation}"></td>
			</tr>
		
          <td></br></td>
	 <td></br></td>

				
				<input type='submit' name='submit' value='查询'>
				  
     </form>
		

		<div align="center" style="position:relative; top:20px" >
			<table border="1px">
				<tr>
					<td>信息编号</td>
					<td>用户编号</td>
					<td>管理员编号</td>
					<td width="200px" style="padding-left: 220px;">信息内容</td>
					<td>处理状态</td>
					<td width="200px" style="padding-left: 220px;">处理结果</td>
					<td>操作</td>
				</tr>
	 <c:choose>
  	<c:when test="${empty data}">
  		<tr>
  			<td colspan="7">查无数据!</td>
  		</tr>
  	</c:when>
  	<c:otherwise>
  		<c:forEach  items="${data}" var="v">
  			<tr>
		    <td>${v.informationID}</td>
		  	<td>${v.userID}</td>
		  	<td>${v.managerID}</td>
		  	<td>${v.information}</td>
		  	<td>${v.operation}</td>
		  	<td>${v.operationresult}</td>
		  	
		  	<td><a href="javaScript:queryFeedbackByID(${v.informationID})">修改</a>
		<a href="javaScript:delFeedbackByID(${v.informationID})">删除</a></td>  	
		  </tr>
		
  		</c:forEach>
  	</c:otherwise>
  </c:choose>
  <tr>
  			<td colspan="7">总页数:${totalpage }&nbsp;&nbsp;
  			当前页:${currentpage }&nbsp;&nbsp;
  			<a href="<%=path%>/QueryFeedbackServlet?setcurrentpage=1&operation=${operation}">首页</a>&nbsp;&nbsp;
  			 <a href="<%=path%>/QueryFeedbackServlet?setcurrentpage=${currentpage <=1? 1:(currentpage-1)}&operation=${operation}">上一页</a>&nbsp;&nbsp;
  			<a href="<%=path%>/QueryFeedbackServlet?setcurrentpage=${currentpage >=totalpage?totalpage:(currentpage+1)}&operation=${operation}">  下一页  </a>&nbsp;&nbsp;
  			 <a href="<%=path%>/QueryFeedbackServlet?setcurrentpage=${totalpage }&operation=${operation}">末页</td>
  
  </tr>
</div>				
</table>
<td></br></td>
<td></br></td>

<a href="welcome.jsp"><input type="reset" name="reset" value="返回" /></a>
	</body>
	</center>
</html>
