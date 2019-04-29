<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>관리자 페이지</title>

<!-- Bootstrap CSS CDN -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
<!-- Our Custom CSS -->
<link rel="stylesheet" href="style2.css">
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

<style>
@import
	"https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700";

/* contents영역 */
body {
	font-family: 'Poppins', sans-serif;
	background: #fafafa;
}

/* 환영메세지 */
p {
	text-align: center;
	font-family: 'Poppins', sans-serif;
	font-size: 1.1em;
	font-weight: 300;
	line-height: 1.7em;
	color: #999;
}

/* sidebar menu*/
a, a:hover, a:focus {
	color: inherit;
	text-decoration: none;
	transition: all 0.3s;
}

/* .wrapper {
	display: flex;
	width: 100%;
} */
#sidebar {
	width: 250px;
	position: fixed;
	top: 0;
	left: 0;
	height: 100vh;
	z-index: 999;
	background: #7386D5;
	color: #fff;
	transition: all 0.3s;
}

#sidebar.active {
	margin-left: -250px;
}

/* page표시 */
#sidebar .sidebar-header {
	text-align: right;
	padding: 20px;
	background: #aaaaaa;
}

#sidebar ul.components {
	padding: 20px 0;
	border-bottom: 1px solid #47748b;
}

#sidebar ul p {
	color: #fff;
	padding: 10px;
}

#sidebar ul li a {
	padding: 10px;
	font-size: 1.1em;
	display: block;
}

#sidebar ul li a:hover {
	color: black;
	background: #fff;
}

#sidebar ul li.active>a, a[aria-expanded="true"] {
	color: #fff;
	background: #6d7fcc;
}

a[data-toggle="collapse"] {
	position: relative;
}

.dropdown-toggle::after {
	display: block;
	position: absolute;
	top: 50%;
	right: 20px;
	transform: translateY(-50%);
}

ul ul a {
	font-size: 0.9em !important;
	padding-left: 30px !important;
	background: #739BE1;
}

ul.CTAs {
	padding: 20px;
}

ul.CTAs a {
	text-align: center;
	font-size: 0.9em !important;
	display: block;
	border-radius: 5px;
	margin-bottom: 5px;
}

a.article, a.article:hover {
	background: #6d7fcc !important;
	color: #fff !important;
}

/* ---------------------------------------------------
    CONTENT STYLE
----------------------------------------------------- */
#content {
	width: calc(100% - 250px);
	padding: 40px;
	min-height: 100vh;
	transition: all 0.3s;
	position: absolute;
	top: 10;
	right: 0;
}

#content.active {
	width: 100%;
}

#mainbar {
	background-color: lightgreen;
	font-size: 1.5em;
	padding: 5px;
	border-radius: 10px;
}
</style>
</head>

<body>

	<div class="wrapper">
		<!-- Sidebar  -->
		<nav id="sidebar">
			<div class="sidebar-header">
				<h3>Admin Page</h3>
			</div>

			<ul class="list-unstyled components">
				<p>
					<b>___ 관리자 님 환영합니다.</b>
				</p>
				<li class="active"><a href="#homeSubmenu"
					data-toggle="collapse" aria-expanded="false"
					class="dropdown-toggle">회원관리</a>
					<ul class="collapse list-unstyled" id="homeSubmenu">
						<li><a href="#">회원 정보 조회</a></li>
						<li><a href="#">등급 조회 / 수정</a></li>
						<li><a href="#">사업자 정보 조회</a></li>
						<li><a href="#">탈퇴 회원 조회</a></li>
						<li><a href="#">결제 내역 조회</a></li>
					</ul></li>

				<li><a href="#pageSubmenu" data-toggle="collapse"
					aria-expanded="false" class="dropdown-toggle">커뮤니티 관리</a>
					<ul class="collapse list-unstyled" id="pageSubmenu">
						<li><a href="community.jsp">공지사항</a></li>
						<li><a href="#">Q & A</a></li>
						<li><a href="#">후기게시판</a></li>
					</ul></li>

				<li><a href="#pageSubmenu2" data-toggle="collapse"
					aria-expanded="false" class="dropdown-toggle">정산관리</a>
					<ul class="collapse list-unstyled" id="pageSubmenu2">
						<li><a href="calculate.jsp">취소 / 환불</a></li>
						<li><a href="#">사업자 정산</a></li>
						<li><a href="#">포인트정산</a></li>
					</ul></li>

				<li><a href="#pageSubmenu3" data-toggle="collapse"
					aria-expanded="false" class="dropdown-toggle">SMS관리</a>
					<ul class="collapse list-unstyled" id="pageSubmenu3">
						<li><a href="sms.jsp">SMS 발송</a></li>
						<li><a href="#">내역 조회</a></li>
					</ul></li>
			</ul>
		</nav>

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
						<a>회원 정보 조회</a>
					</div>

					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="nav navbar-nav ml-auto">
							<li class="nav-item active"><a class="nav-link" href="#">회원관리</a></li>
							<li class="nav-item"><a class="nav-link"
								href="community.jsp">커뮤니티</a></li>
							<li class="nav-item"><a class="nav-link"
								href="calculate.jsp">정산</a></li>
							<li class="nav-item"><a class="nav-link" href="sms.jsp">SMS</a></li>
							<li class="nav-item"><a class="nav-link" href="#">로그아웃</a></li>
						</ul>
					</div>
				</div>

			</nav>


			<br>
			<br>
			<table class="table table-bordered">

				<thead>
					<tr style="background: lightgray">
						<th>아이디</th>
						<th>비밀번호</th>
						<th>이름</th>
						<th>나이</th>
						<th>성별</th>
						<th>휴대폰번호</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>user01</td>
						<td>1234</td>
						<td>김짐빔</td>
						<td>28</td>
						<td>남</td>
						<td>010-1234-1111</td>
					</tr>
					<tr>
						<td>kbcl</td>
						<td>55555</td>
						<td>박호세</td>
						<td>20</td>
						<td>남</td>
						<td>010-1234-5678</td>
					</tr>
					<tr>
						<td>swss</td>
						<td>shirmp</td>
						<td>강다니엘</td>
						<td>22</td>
						<td>남</td>
						<td>010-2993-2222</td>
					</tr>
				</tbody>
			</table>
		</div>


		<!-- jQuery CDN - Slim version (=without AJAX) -->
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
			integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
			crossorigin="anonymous"></script>
		<!-- Popper.JS -->
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
			integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
			crossorigin="anonymous"></script>
		<!-- Bootstrap JS -->
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
			integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
			crossorigin="anonymous"></script>
		<!-- jQuery Custom Scroller CDN -->
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.concat.min.js"></script>

		<!-- 메뉴 밀기 -->
		<script type="text/javascript">
				$(document).ready(
						function() {
							$("#sidebar").mCustomScrollbar({
								theme : "minimal"
							});

							$('#sidebarCollapse').on(
									'click',
									function() {
										$('#sidebar, #content').toggleClass(
												'active');
										$('.collapse.in').toggleClass('in');
										$('a[aria-expanded=true]').attr(
												'aria-expanded', 'false');
									});
						});
			</script>
</body>

</html>