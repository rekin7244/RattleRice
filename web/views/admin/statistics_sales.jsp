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
					<a>포인트 매출 분석</a>
				</div>

				<iframe name='action' width="0" height="0" frameborder="0"
					scrolling='yes'></iframe>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="nav navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link" href="">서비스통계</a></li>
						<li class="nav-item active"><a class="nav-link" href="statistics_sales.jsp">매출통계</a></li>
						<li class="nav-item"><a class="nav-link" href="statistics_member.jsp">관리통계</a></li>
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
		var salesData;
		//first Chart 생성
		var ctx = $("#firstChart");
		var salesChart = new Chart(ctx, {
			type:"line",
			data:{
				labels:[],
				datasets: [{
					label:"포인트 매출 금액 (만원)",
					data:[],
					backgroundColor:'rgba(75,182,192,0.4)',
					borderColor:'rgba(255,99,132,1)',
					borderCapStyle:"butt",
					borderDash:[],
					borderDashOffset:0.0,
					borderJoinStyle:"miter",
					pointBorderColor:'rgba(75,192,192,1)',
					pointBackgroundColor:'#fff',
					pointBorderWidth:1,
					pointHoverRadius:5,
					pointHoverBackgroundColor:'rgba(75,192,192,1)',
					pointHoverBorderColor:'rgba(220,220,220,1)',
					pointHoverBorderWidth:2,
					pointRadius:1,
					pointHitRadius:10,
					spanGaps:false
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
		
		$(function(){
			$.ajax({
				url:"<%=request.getContextPath()%>/statisticsSales.st",
				type:"post",
				data:{},
				success:function(data){
					salesData = data;
					console.log(salesData);
					removeData(salesChart);
					for ( var key in salesData) {
						addData(salesChart,salesData[key].month+'월',salesData[key].sales);						
					}
				},
				error:function(){
					console.log("로드 실패");
				}
			});
		});
		
		function addData(chart, label, data) {
			salesChart.data.labels.push(label);
			salesChart.data.datasets.forEach((dataset) => {
		        dataset.data.push(data);
		    });
			salesChart.update();
		}

		function removeData(chart) {
			salesChart.data.labels.pop();
			salesChart.data.datasets.forEach((dataset) => {
		        dataset.data.pop();
		    });
			salesChart.update();
		}
	</script>
</body>
</html>