<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>코인 내역 조회</title>

<!-- Bootstrap CSS CDN -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">

<!-- Our Custom CSS -->
<!-- <link rel="stylesheet" href="style2.css"> -->
<!-- Scrollbar Custom CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css">

<!-- Font Awesome JS -->
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"
	integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ"
	crossorigin="anonymous"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"
	integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY"
	crossorigin="anonymous"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<style>
</style>
</head>

<body>
	<%@ include file="menubar_admin.jsp"%>
	<!-- Page Content  -->
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
					<a>코인 내역 조회</a>
				</div>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="nav navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath() + "/memberlist.ad"%>">회원관리</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath() %>/views/admin/updateMainForm.jsp">커뮤니티</a></li>
						<li class="nav-item active"><a class="nav-link"
							href="<%=request.getContextPath() %>/views/admin/coinRecord.jsp">정산</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath() %>/views/admin/sms.jsp">SMS</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath()%>/logout.me">로그아웃</a></li>
					</ul>
				</div>
			</div>

		</nav>
		
		<!-- content -->
		
		<div id="table area">
			<table class="table table-bordered" id="tableArea">
				<thead>
					<tr>
						<td>일시</td>
						<td>아이디</td>
						<td>코인</td>
						<td>비고</td>
					</tr>
				</thead>
				<tbody></tbody>
			</table>
		</div>
		
		<br> <br> 
		<div align="center">
		<select id="selectOption">
			<option value="">정렬</option>
			<option value="CH">충전</option>
			<option value="RE">사용</option>
		</select>
		<p>유저 Id 입력 : </p><input type="text" id="inputUserId" placeholder="userid">
		<button onclick="paging(1);">검색</button>
		</div>
		<div id="pagingArea" align="center">
			<ul id="paging" class="pagination"></ul>
		</div>
	</div>
	<script>
		$(function(){
			$.ajax({
				url:"<%=request.getContextPath()%>/loadCoinRecord.ad",
				type:"post",
				data:{currentPage:1},
				success:function(data){
					//console.log(data);
					var pi = data.pi;
					var recordData = data.list;
					
					var $tablebody = $("#tableArea tbody");
					for ( var key in recordData) {
						var $tr = $("<tr>");
						var $dateTd = $("<td>").text(recordData[key].date);
						var $idTd = $("<td>").text(recordData[key].userId);
						var $coinTd = $("<td>").text(recordData[key].amount);
						if(recordData[key].type == 'CH'){
							var $etcTd = $("<td>").text('충전')
												  .css("background","aqua");
						}else{
							var $etcTd = $("<td>").text('사용')
												  .css("background","lightgrey");
						}
						
						$tr.append($dateTd);
						$tr.append($idTd);
						$tr.append($coinTd);
						$tr.append($etcTd);
						
						$tablebody.append($tr);						
					}
					$paging = $("#paging");
					$paging.html('');
					var $firstLi = $('<li><button onclick="paging(1)">&laquo;</button></li>');
					$paging.append($firstLi);
					for (var i = 0; i < pi.maxPage; i++) {
						$paging.append('<li><button onclick="paging('+(i+1)+');">'+(i+1)+'</button></li>');
					}
					var $endLi = $('<li><button onclick="paging('+pi.maxPage+');">&raquo;</button></li>');
					$paging.append($endLi);
				},
				error:function(){
					console.log("로드 실패!");
				}
			});
		});
		
		function paging(currentPage){
			var condition = $("#selectOption").val();
			var userId = $("#inputUserId").val();
			$.ajax({
				url:"<%=request.getContextPath()%>/searchCoinRecord.ad",
				type:"post",
				data:{currentPage:currentPage,condition:condition,userId:userId},
				success:function(data){
					//console.log(data);
					var pi = data.pi;
					var recordData = data.list;
					
					var $tablebody = $("#tableArea tbody");
					$tablebody.html('');
					for ( var key in recordData) {
						var $tr = $("<tr>");
						var $dateTd = $("<td>").text(recordData[key].date);
						var $idTd = $("<td>").text(recordData[key].userId);
						var $coinTd = $("<td>").text(recordData[key].amount);
						if(recordData[key].type == 'CH'){
							var $etcTd = $("<td>").text('충전')
												  .css("background","aqua");
						}else{
							var $etcTd = $("<td>").text('사용')
												  .css("background","lightgrey");
						}
						
						$tr.append($dateTd);
						$tr.append($idTd);
						$tr.append($coinTd);
						$tr.append($etcTd);
						
						$tablebody.append($tr);						
					}
					$paging = $("#paging");
					$paging.html('');
					var $firstLi = $('<li><button onclick="paging(1)">&laquo;</button></li>');
					$paging.append($firstLi);
					for (var i = 0; i < pi.maxPage; i++) {
						$paging.append('<li><button onclick="paging('+(i+1)+');">'+(i+1)+'</button></li>');
					}
					var $endLi = $('<li><button onclick="paging('+pi.maxPage+');">&raquo;</button></li>');
					$paging.append($endLi);
				},
				error:function(){
					console.log("로드 실패!");
				}
			});
		}
	</script>
</body>

</html>