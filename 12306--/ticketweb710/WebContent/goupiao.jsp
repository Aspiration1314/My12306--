<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
%>

<!-- 127.0.0.1:8080/ticketweb/goupiao.jsp -->

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>车票购买</title>
		<style type="text/css">
			html,body,ul,li,ol,dl,dd,dt,p,h1,h2,h3,h4,h5,h6,form,fieldset,legend,img{margin:0;padding:0}
			body{font-family: "微软雅黑"; font-size: 14px;}
		</style>
		
		<%--  <script type="text/javascript">
		 	function getIdandChoose(ticketID){
		 		var select=document.getElementById("seatchoose");
	            var optionVal=select.value;
			window.location.href="<%=path%>/SeatChooseServlet?seattype="+optionVal+"&ticketID="+ticketID;
		}
   		 </script> --%>
   		 
			<link rel="stylesheet" href="css/hengfu.css" />
		    <link rel="stylesheet" href="css/daohang.css">
		
	</head>
	<body bgcolor="#F0F8FF">
		
	
	<p align="center"><img src ="img/abanner03.jpg"   width="800px" height="100px" ></p>
	
	<div style="position: relative; top:30px" align="center">
		<form name="checichaxun" action="<%=path%>/AddOrderServlet" method="get" target="sypost">
			<input type='hidden' name='ticketID' value='${obj.ticketID}'>
			<span style="position: relative; left:-50px">出发时间：<input  style="width:80px; height:20px;" type="text" 
			name="starttime" value="${obj.starttime}"  /></span>
			<span style="position: relative; top:20px">历时：<input style="width:80px; height:20px;" type="text" 
			name="duringtime" value="${obj.duration}"/></span>
			<span style="position: relative; left:50px">到达时间：<input style="width:80px; height:20px;" type="text" 
			name="endtime" value="${obj.endtime}"/></span><br/>
			
			<span style="position: relative; left:-50px; top:80px">出发地：<input  style="width:80px; height:20px;" type="text" 
			name="startstation" value="${obj.startstation}"/></span>
			<span style="position: relative; top:50px">车次：<input style="width:80px; height:20px;" type="text" 
			name="duringtime" value="${obj.trainnumber}"/></span>
			<span style="position: relative; left:65px; top:80px">目的地：<input style="width:80px; height:20px;" type="text" 
			name="endstation" value="${obj.endstation}"/></span><br/>
			
	<%-- <div style="position: relative; left:-60px; top:100px">
		座位类型：<select id="seatchoose" style="width:50px; height:25px;" name="seattype" 
						onchange="getIdandChoose(${obj.ticketID})">
					<option value ="软卧">软卧</option>
  					<option value ="硬卧">硬卧</option>
  					<option value="硬座">硬座</option>
  					<option value="无座">无座</option>
				</select>
	</div>
	 --%>
	<div style="position: relative; left:-60px; top:100px">
		座位类型：<select id="seatchoose" style="width:50px; height:25px;" name="seattype" >
					<option value ="软卧">软卧</option>
  					<option value ="硬卧">硬卧</option>
  					<option value="硬座">硬座</option>
  					<option value="无座">无座</option>
				</select>
	</div>
	
			<%-- <span style="position: relative; left:80px; top:75px">票价：<input  style="width:80px; height:20px;" 
				type="text" name="price" value="${data[0]}"/></span> --%>
			
			<div style="position: relative; left:20px; top:100px">
				<input type="submit" value="确认订单" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="index.jsp" target="_self">
					<input type="button" name="quxiao" value="取消订单" />
				</a>
			</div>
		</form>
		<img style="position: absolute; left:600px; top:48px" src="img/jiantou.jpg" width="200px" height="23px">

	</div>
	
	
	</body>
</html>
