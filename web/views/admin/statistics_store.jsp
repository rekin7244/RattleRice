<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,java.sql.*,java.io.*,com.kh.rr.admin.model.service.*"%>
<%
String fullPath = "C:/Users/rekin/git/RattleRice/web/files";
//places.csv 세팅
request.setCharacterEncoding("utf-8");	//한글 인코딩

try {
	ArrayList<HashMap<String,Object>> list = new StatisticsService().getStores();
	BufferedWriter fw = new BufferedWriter(new FileWriter(fullPath+"/places.csv",false));

	fw.write("name,lat,lon");
	fw.newLine();
	for (HashMap<String, Object> h : list) {
		fw.write(h.get("brand")+","+h.get("lat")+","+h.get("lon"));
		fw.newLine();
	}
	fw.flush();
	fw.close();
} catch (IOException e) {
	e.printStackTrace();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제휴 매장 분포도</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0/dist/Chart.min.js"></script>
<script src="http://d3js.org/d3.v3.min.js"></script>
<script src="http://d3js.org/topojson.v1.min.js"></script>
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
					<a>제휴 매장 분포</a>
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
			<div class="mapview">  
  				<div id="chart" class="feature-box light-gray-bg bordered text-center" style="height:450px;"></div>
			<canvas id="tableChart" height="250px"></canvas>
			</div>
		</div>
	</div>
<script>
//data loading
$(function(){
	$.ajax({
		url:"<%=request.getContextPath()%>/statisticsStore.st",
		type:"post",
		data:{},
		success:function(data){
			console.log(data);
		},
		error:function(data){
			console.log("로드 실패");
		}
	});
});

var width = 700
var height = 500;

var svg = d3.select("#chart").append("svg")
.attr("width", width)
.attr("height", height);

var map = svg.append("g").attr("id", "map"),
places = svg.append("g").attr("id", "places");

var projection = d3.geo.mercator()
.center([126.9895, 37.5651])
.scale(100000)
.translate([width/2, height/2]);

var path = d3.geo.path().projection(projection);



//map 세팅
d3.json("<%=request.getContextPath()%>/files/seoul_municipalities_topo.json", function(error, data) {
var features = topojson.feature(data, data.objects.seoul_municipalities_geo).features;
map.selectAll('path')
  .data(features)
.enter().append('path')
  .attr('class', function(d) { console.log(); return 'municipality c' + d.properties.code })
  .attr('d', path);

map.selectAll('text')
  .data(features)
.enter().append("text")
  .attr("transform", function(d) { return "translate(" + path.centroid(d) + ")"; })
  .attr("dy", ".35em")
  .attr("class", "municipality-label")
  .text(function(d) { return d.properties.name; })
});

//data 세팅
d3.csv("<%=request.getContextPath()%>/files/places.csv", function(data) {
places.selectAll("circle")
    .data(data)
  .enter().append("circle")
    .attr("cx", function(d) { return projection([d.lon, d.lat])[0]; })
    .attr("cy", function(d) { return projection([d.lon, d.lat])[1]; })
    .attr("r", 10);

places.selectAll("text")
    .data(data)
  .enter().append("text")
    .attr("x", function(d) { return projection([d.lon, d.lat])[0]; })
    .attr("y", function(d) { return projection([d.lon, d.lat])[1] + 8; })
    .text(function(d) { return d.name });
});
////////////////////////////////////////////////////////////
//주석 제거
//백업 해둠
////////////////////////////////////////////////////////////////////

</script>
</body>
</html>