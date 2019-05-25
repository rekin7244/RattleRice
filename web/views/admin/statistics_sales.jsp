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
			<div id="barchart_material" style="width: 700px; height: 300px;"></div>
			<table class="table table-bordered" id="statTable" align="center">
				<thead>
					<td>기간</td>
					<td>포인트 매출 금액</td>
					<td>사업자 정산 금액</td>
					<td>포인트 순이익</td>
					<td>수수료 이익</td>
				</thead>
				<tbody></tbody>
			</table>
		</div>
	</div>
	<script>
    var cData;
	var options;
	var chart;
	var dataArr = new Array();
	$(function(){
	    google.charts.load('current', {'packages':['bar']});
	    google.charts.setOnLoadCallback(drawChart);
			
			$.ajax({
				url:"<%=request.getContextPath()%>/statisticsSales.st",
				type:"post",
				data:{},
				success:function(hmap){
					var salesData = hmap["list"];
					var settleData = hmap["list2"];
					var feeData = hmap["list3"];
					
					//차트 반영
					for(var i=0;i<5;i++) {
						dataArr[i] = [settleData[i].month, salesData[i].sales, settleData[i].sum, salesData[i].sales - settleData[i].sum];	
					}
					
					//테이블 반영
					var $tableBody = $("#statTable tbody");
					
					for(var i=0;i<5;i++) {
						var $tr = $("<tr>");
						var $monthTd = $("<td>").text(salesData[i].month+'월');
						var $salesTd = $("<td>").text(salesData[i].sales+'원');
						var $settleTd = $("<td>").text(settleData[i].sum+'원');
						var $feesTd = $("<td>").text(feeData[i].sum+'원');
						
						$tr.append($monthTd);
						$tr.append($salesTd);
						$tr.append($settleTd);
						$tr.append($("<td>").text(salesData[i].sales - settleData[i].sum+'원'));
						$tr.append($feesTd);
						$tableBody.append($tr);
					}
				},
				error:function(){
					console.log("로드 실패");
				}
			});
			
			//차트 그리기
			function drawChart() {
				cData = new google.visualization.DataTable();
				cData.addColumn('string', '월');
				cData.addColumn('number', '포인트 매출');
				cData.addColumn('number', '사업자 정산');
				cData.addColumn('number', '포인트 순이익');
				
				cData.addRows(dataArr);
		        options = {
		          chart: {
		            title: '매출 통계',
		            subtitle: '2019.01 ~ 2019.05',
		          },
		          //bars: 'horizontal' // Required for Material Bar Charts.
		        };

		        chart = new google.charts.Bar(document.getElementById('barchart_material'));

		        chart.draw(cData, google.charts.Bar.convertOptions(options));
				//chart.draw(cData, options);
		      }
			
		});
      
      function removeData(){
    	cData.removeRow(0);
  		chart.draw(cData, options)
      }
</script>
</body>
</html>