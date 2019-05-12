<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지 관리</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<style>
thead {
	background: lightgray;
	align: center;
}

td {
	text-align: center;
}
</style>
<script>
	function updateIndexDate(){
		console.log("test");
	}
	window.onload=function(){
		 window.focus(); // 현재 window 즉 익스플러러를 윈도우 최상단에 위치
		window.moveTo(0,0); // 웹 페이지의 창 위치를 0,0 (왼쪽 최상단) 으로 고정
		window.resizeTo(1280,800); // 웹페이지의 크기를 가로 1280 , 세로 800 으로 고정(확장 및 축소)
		window.scrollTo(0,250); // 페이지 상단 광고를 바로 볼 수 있게 스크롤 위치를 조정
	}
</script>
</head>
<body onresize="parent.resizeTo(1024,768)" onload="parent.resizeTo(1024,768)">
	<%@ include file="menubar_admin.jsp"%>
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
					<a>메인페이지</a>
				</div>

				<iframe name='action' width="0" height="0" frameborder="0"
					scrolling='yes'></iframe>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="nav navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link" href="adminForm.jsp">회원관리</a></li>
						<li class="nav-item active"><a class="nav-link"
							href="community.jsp">커뮤니티</a></li>
						<li class="nav-item"><a class="nav-link" href="calculate.jsp">정산</a></li>
						<li class="nav-item"><a class="nav-link" href="sms.jsp">SMS</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath()%>/logout.me">로그아웃</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<!-- updateForm -->
		<div class="outer">
			<table class="table table-bordered">
				<thead>
					<tr align="center">
						<th>사업체 정보</th>
						<th>연락처</th>
						<th>약관</th>
					</tr>
				</thead>
				<tr>
					<td>딸랑밥</td>
					<td>010-****-****</td>
					<td><button id="updateTermsBtn">수정</button></td>
				</tr>
				<tr>
					<td><input type="text" name="aTitle" /></td>
					<td><input type="text" name="aContact" /></td>
					<td><button onclick="updateIndexData();">수정</button></td>
				</tr>
			</table>
		</div>
		<div class="textArea"></div>
	</div>
	<!-- content area end -->


</body>
</html>