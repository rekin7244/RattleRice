<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서비스 통계</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0/dist/Chart.min.js"></script>
<style>
svg circle {
          fill: orange;
          opacity: .5;
          stroke: white;
        }
        svg circle:hover {
          fill: red;
          stroke: #333;
        }
        svg text {
          pointer-events: none;
        }
        svg .municipality {
          fill: #efefef;
          stroke: #fff;
        }
        svg .municipality-label {
          fill: #bbb;
          font-size: 12px;
          font-weight: 300;
          text-anchor: middle;
        }
        svg #map text {
          color: #333;
          font-size: 10px;
          text-anchor: middle;
        }
        svg #places text {
          color: #777;
          font: 10px sans-serif;
          text-anchor: start;
        }
</style>
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
					<a>시간대별 통계</a>
				</div>

				<iframe name='action' width="0" height="0" frameborder="0"
					scrolling='yes'></iframe>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="nav navbar-nav ml-auto">
						<li class="nav-item active"><a class="nav-link" href="">서비스통계</a></li>
						<li class="nav-item"><a class="nav-link" href="statistics_sales.jsp">매출통계</a></li>
						<li class="nav-item"><a class="nav-link" href="statistics_member.jsp">관리통계</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath()%>/logout.me">로그아웃</a></li>
					</ul>
				</div>
			</div>
		</nav>
		
		<!-- content -->
		<div class="outer">
			<canvas id="tableChart" height="150px"></canvas>
			<table class="table table-bordered" id="serviceTable">
				<thead>
					<td>시간대</td>
					<td>이용방</td>
				</thead>
				<tbody></tbody>
			</table>
		</div>
	</div>
<script>
var serviceData;
//tableChart 생성
var ctx = $("#tableChart");
var tableChart = new Chart(ctx, {
	type:"bar",
	data:{
		labels:[],
		datasets: [{
			label:['시간대별 채팅방 수'],
			data:[],
			backgroundColor:[
				'rgba(255,99,132,0.2)',
				'rgba(54,162,235,0.2)',
				'rgba(255,206,86,0.2)',
				'rgba(75,192,192,0.2)',
				'rgba(153,102,255,0.2)',
				'rgba(255,159,64,0.2)',
				'rgba(100,100,100,0.2)',
				'rgba(0,255,120,0.2)'
			],
			borderColor:[
				'rgba(255,99,132,1)',
				'rgba(54,162,235,1)',
				'rgba(255,206,86,1)',
				'rgba(75,192,192,1)',
				'rgba(153,102,255,1)',
				'rgba(255,159,64,1)',
				'rgba(100,100,100,1)',
				'rgba(0,255,120,1)'
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
		url:"<%=request.getContextPath()%>/statisticsServiceTime.st",
		type:"post",
		data:{},
		success:function(data){
			serviceData = data;
			console.log(data);
			removeData(tableChart);
			
			$tableBody = $("#serviceTable tbody");
			$tableBody.html('');
			$.each(serviceData, function(index, value){
				var $tr = $("<tr>");
				var $timeTd = $("<td>").text(value.time+'시~'+((value.time)*1+1)+'시');
				var $countTd = $("<td>").text(value.value);
				
				$tr.append($timeTd);
				$tr.append($countTd);
				$tableBody.append($tr);
				
				addData(tableChart,value.time+'시~'+((value.time)*1+1)+'시',value.value);
			});
		},
		error:function(data){
			console.log("로드 실패");
		}
	});
});

function addData(chart, label, data) {
	tableChart.data.labels.push(label);
	tableChart.data.datasets.forEach((dataset) => {
        dataset.data.push(data);
    });
	tableChart.update();
}

function removeData(chart) {
	tableChart.data.labels.pop();
	tableChart.data.datasets.forEach((dataset) => {
        dataset.data.pop();
    });
	tableChart.update();
}
</script>
</body>
</html>