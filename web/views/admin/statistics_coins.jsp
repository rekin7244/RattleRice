<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매출 통계</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
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
					<a>코인 내역 분석</a>
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
			<div id="curve_chart" style="width: 900px; height: 500px"></div>
			<table class="table table-bordered" id="coinTable">
				<thead>
					<td>월</td>
					<td>코인 충전양</td>
					<td>코인 사용양</td>
					<td>코인 차액</td>
				</thead>
				<tbody></tbody>
			</table>
		</div>
	</div>
	<script>
		var coinDataArr = new Array();
		
		$(function(){
			$.ajax({
				url:"<%=request.getContextPath()%>/statisticsCoin.st",
				type:"post",
				data:{},
				success:function(data){
					console.log(data);
					for(var i=0;i<5;i++) {
						coinDataArr[i] = [data[i].month, data[i].charge, data[i].use];	
					}
					
					//테이블 반영
					var $tableBody = $("#coinTable tbody");
					
					for(var i=0;i<5;i++) {
						var $tr = $("<tr>");
						var $monthTd = $("<td>").text(data[i].month+'월');
						var $chargeTd = $("<td>").text(data[i].charge+'벨');
						var $useTd = $("<td>").text(data[i].use+'벨');
						var $valueTd = $("<td>").text((data[i].charge-data[i].use)+'벨');
						
						$tr.append($monthTd);
						$tr.append($chargeTd);
						$tr.append($useTd);
						$tr.append($valueTd);
						$tableBody.append($tr);
					}
				},
				error:function(){
					console.log("로드 실패");
				}
			});
			
			google.charts.load('current', {'packages':['corechart']});
		    google.charts.setOnLoadCallback(drawChart);
			
		    function drawChart() {
		        cData = new google.visualization.DataTable();
		        cData.addColumn('string', '월');
		        cData.addColumn('number', '코인 충전');
		        cData.addColumn('number', '코인 사용');
				
		        cData.addRows(coinDataArr);
		        
		        var options = {
		          title: '코인 충전 사용',
		          curveType: 'function',
		          legend: { position: 'bottom' }
		        };

		        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

		        chart.draw(cData, options);
		      }
		});
	</script>
</body>
</html>