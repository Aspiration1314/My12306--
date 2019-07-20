<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>这是技术支持者</title>
</head>
<style>
	
	#box{
		position:relative;
		width: 200px;
		height: 500px;
		left: 300px;
	}
	img{
		position:absolute;
/*		定义旋转基点 轴心*/
		transform-origin: left bottom;
		transition: 1.5s;		
	}
	#box:hover img:nth-child(7){
		transform: rotate(45deg);
	}
	#box:hover img:nth-child(6){
		transform: rotate(25deg);
	}
	#box:hover img:nth-child(5){
		transform: rotate(10deg);
	}
		#box:hover img:nth-child(3){
		transform: rotate(-10deg);
	}
		#box:hover img:nth-child(2){
		transform: rotate(-25deg);
	}
		#box:hover img:nth-child(1){
		transform: rotate(-45deg);
	}
	img:hover{
		z-index: 99;
	}	
</style>
<body background="img/bj.jpeg">
	<table>
		<tr >
			<td width="500px" >
					<table >
					<tr>
						<td>
							<p><h2>郭鹏科</h2></p>
							&nbsp;&nbsp;了解多种计算机语言，拥有良好的编程能力。在学习过程中，
							喜欢深入分析原理性的问题，善于总结和发现。不断尝试并总结经验，解决问题过程中，
							拥有极强耐心。有良好的自主学习能力，热爱编程。有着极强的责任感，吃苦耐劳。
						</td>
					</tr>
					<tr>
						<td>
							<p><h2>张圆梦</h2></p>
							&nbsp;&nbsp;大家好，我是来自河北的女汉子，和男孩子一样喜欢玩电子游戏，
							我是一个阳光开朗的女孩，最初见到我的时候可能会觉得我很严肃，时间长了就会发现我其实很幽默！
							我做事情有自己的计划，在我专心做事的时候喜欢将自己封闭起来，例如听听音乐。
							在团队合作中我会积极发表自己的意见，幽默的我常常会成为团队的开心果和粘合剂！

						</td>
					</tr>
					<tr>
						<td>
							<p><h2>张梅</h2></p>
							&nbsp;&nbsp;一个来自计算机科学与技术专业，性格开朗，生活纯良的“秃头铝孩”。每天在代码中挣扎，
							与bug抗争，目前幸存，生命力极其顽强。兴趣广泛，琴棋书画样样不精通。热爱生活,
							希望生活尽早发现苦苦挣扎的我，带我走上人生巅峰。欧耶
						</td>
					</tr>
					<tr>
						<td>
							<p><h2>张玲</h2></p>
							&nbsp;&nbsp;hiahiahia~~~地方不够写了
						</td>
					</tr>
					</table>
				
				
			</td>
			
			<td width="50px">
				<div id="box" width="50px">
							<img src="img/zym.jpg" height="550px" weight="250px">
							<img src="img/my.jpg" height="550px" weight="250px">
							<img src="img/zl.jpeg" height="550px" weight="250px">
							<img src="img/le.jpeg" height="550px" weight="250px">
							<img src="img/gpk.jpeg" height="550px" weight="250px">
							<img src="img/pk.jpeg" height="550px" weight="250px">
							<img src="img/zm.jpg" height="550px" weight="250px">
							<img src="img/ym.jpg" height="550px" weight="250px">
				</div>
			</td>
		</tr>
	</table>		
</body>

</html>