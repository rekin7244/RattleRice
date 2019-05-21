<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>정산 관리</title>

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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<!-- 은행권 공동 오픈플랫폼 : 오픈 API -->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/settlement/constants.js"></script>
<!-- 상수 js -->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/settlement/common.js"></script>
<!-- 사용자정의 js -->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/ext_lib/bootstrap-3.3.6-dist/js/modal.js"></script>
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
					<a>취소 / 환불</a>
				</div>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="nav navbar-nav ml-auto">
						<li class="nav-item active"><a class="nav-link"
							href="<%=request.getContextPath() + "/memberlist.ad"%>">회원관리</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath() %>/views/admin/updateMainForm.jsp">커뮤니티</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath() %>/views/admin/coinRecord.jsp">정산</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath() %>/views/admin/sms.jsp">SMS</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath()%>/logout.me">로그아웃</a></li>
					</ul>
				</div>
			</div>

		</nav>


		<br> <br> <select>
			<option>정렬</option>
		</select> <input type="text">
		<button>검색</button>
		<table class="table table-bordered">

			<thead>
				<tr style="background: lightgray" align="center">
					<th><input type="checkbox" id="checkmember"></th>
					<th>번호</th>
					<th>아이디</th>
					<th>결제일시</th>
					<th>결제취소일</th>
					<th>결제번호</th>
					<th>결제금액</th>
					<th>결제방법</th>
					<th>상태</th>
					<th>관리</th>
				</tr>
			</thead>

			<tbody align="center">
				<tr>
					<th><input type="checkbox" id="checkmember"></th>
					<td>1</td>
					<td>user01</td>
					<td>2019-05-08</td>
					<td>2019-05-09</td>
					<td>2019050812345</td>
					<td>20,000</td>
					<td>국민카드</td>
					<td>취소요청</td>
					<td><button onclick="settlement()">확인</button>&nbsp;
						<button>취소</button></td>
				</tr>
			</tbody>
		</table>
	</div>
	<script>
		function settlement(){
			location.href="<%=request.getContextPath()%>/settlement.st";
		}
	</script>
</body>

</html>