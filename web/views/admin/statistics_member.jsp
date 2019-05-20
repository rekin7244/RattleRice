<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 통계</title>
</head>
<body>
	<%@ include file="menubar_statistics.jsp"%>
	<!-- nav -->
	<div id="content">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">

				<button type="button" id="sidebarCollapse" class="btn btn-info">
					<i class="fas fa-align-left"></i> <span> menu</span>
				</button>


				<button class="btn btn-dark d-inline-block d-lg-none ml-auto"
					type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<i class="fas fa-align-justify"></i>
				</button>
				&nbsp; &nbsp;
				<div id="mainbar">
					<a>회원 분석</a>
				</div>

				<iframe name='action' width="0" height="0" frameborder="0"
					scrolling='yes'></iframe>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="nav navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link" href="">서비스통계</a></li>
						<li class="nav-item"><a class="nav-link" href="statistics_sales.jsp">매출통계</a></li>
						<li class="nav-item active"><a class="nav-link" href="statistics_member.jsp">관리통계</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath()%>/logout.me">로그아웃</a></li>
					</ul>
				</div>
			</div>
		</nav>
		
		<!-- content -->
		<div class="outer">
			<canvas id="firstChart" height="300px"></canvas>
		</div>
	</div>
	<script>
		var userData;
		//first Chart 생성
		var ctx = $("#firstChart");
		var firstChart = new Chart(ctx, {
			type:"pie",
			data:{
				labels:[],
				datasets: [{
					/* label:"회원 비율", */
					data:[],
					backgroundColor:[
						'rgba(255,99,132,0.2)',
						'rgba(54,162,235,0.2)',
						'rgba(255,206,86,0.2)'
					],
					borderColor:[
						'rgba(255,99,132,1)',
						'rgba(54,162,235,1)',
						'rgba(255,206,86,1)'
					],
					borderWidth:1
				}]
			},
			options:{
				scales:{
					yAxes:[{
						ticks:{
							beginAtZero:true
						}
					}]
				}
			}
		});
		
		//data loading
		$(function(){
			$.ajax({
				url:"<%=request.getContextPath()%>/statisticsMember.st",
				type:"post",
				data:{},
				success:function(data){
					var userData = data;
					console.log(userData);
					removeData(firstChart);
					addData(firstChart,"사용자",userData[0]);
					addData(firstChart,"사업자",userData[1]);
					addData(firstChart,"관리자",userData[2]);
				},
				error:function(data){
					console.log("로드 실패");
				}
			});
		});
		
		function addData(chart, label, data) {
			firstChart.data.labels.push(label);
			firstChart.data.datasets.forEach((dataset) => {
		        dataset.data.push(data);
		    });
			firstChart.update();
		}

		function removeData(chart) {
			firstChart.data.labels.pop();
			firstChart.data.datasets.forEach((dataset) => {
		        dataset.data.pop();
		    });
			firstChart.update();
		}
		
	</script>
</body>
</html>