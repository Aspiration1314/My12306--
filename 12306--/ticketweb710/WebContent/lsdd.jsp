<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>历史订单</title>
		<script type="text/javascript">
		  function msg()
		  {
		  	alert("订单已删除");
		  }
		</script>
		
		<style> 
			body{background:url(img/xinxibeijing.jpg) no-repeat center top} 
			body{background-size:1057px 520px}
		</style>
		
	</head>
	<body >
		<div align="center" style="position: relative; top: 100px;">
			<table border="1">
			<tr bgcolor="#1E90FF">
				<td>订单编号</td>
				<td>车次</td>
				<td>出发站</td>
				<td>到达站</td>
				<td>出发日期</td>
				<td>出发时间</td>
				<td>到达时间</td>
				<td>旅客姓名</td>
				<td>证件类型</td>
				<td>火车类型</td>
				<td>车票类型</td>
				<td>票价</td>
				<td>车票状态</td>
				<td>备注</td>
			</tr>
			<tr bgcolor="#F5F5F5">
				<td>3</td>
				<td>T28</td>
				<td>北京南</td>
				<td>上海虹桥</td>
				<td>2019-06-30</td>
				<td>15：45</td>
				<td>16: 42</td>
				<td>小张</td>
				<td>居民身份证</td>
				<td>软卧</td>
				<td>学生票</td>
				<td>200元</td>
				<td>已支付</td>
				<td>
					<input type="button" value="删除" onclick="msg()"/>
					<!--
                    	作者：1091388204@qq.com
                    	时间：2019-07-01
                    	描述：在此需跳转回上一界面
                    -->
				</td>
			</tr>
		</div>
	</body>
</html>
