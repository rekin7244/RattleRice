<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>사업자 페이지</title>

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

/* ---------------------------------------------------
    SIDEBAR STYLE
----------------------------------------------------- */
.wrapper {
	display: flex;
	width: 100%;
}

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

#sidebar .sidebar-header {
	text-align: right;
	padding: 10px;
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

a.download {
	background: #fff;
	color: #7386D5;
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
	top: 0;
	right: 0;
}

#content.active {
	width: 100%;
}

/* ---------------------------------------------------
    MEDIAQUERIES
----------------------------------------------------- */
@media ( max-width : 768px) {
	#sidebar {
		margin-left: -250px;
	}
	#sidebar.active {
		margin-left: 0;
	}
	#content {
		width: 100%;
	}
	#content.active {
		width: calc(100% - 250px);
	}
	#sidebarCollapse span {
		display: none;
	}
}

.container ul {
	list-style: none;
	padding: 0;
}

.li2 {
	float: right;
}
.buttonPadding{
padding-bottom: 30px;
}
</style>
</head>

<body>

	<div class="wrapper">
		<!-- Sidebar  -->
		<nav id="sidebar">
			<div class="sidebar-header">
				<h3>Businessman Page</h3>
			</div>

			<ul class="list-unstyled components">
				<p>
					<b>___ 사업자님 환영합니다.</b>
				</p>
				<li class="active"><a href="#homeSubmenu"
					data-toggle="collapse" aria-expanded="false"
					class="dropdown-toggle">예약관리</a>
					<ul class="collapse list-unstyled" id="homeSubmenu">
						<li><a href="reservationForm.jsp">예약 신청 현황</a></li>
						<li><a href="pastReservationForm.jsp">지난 예약 기록</a></li>
					</ul></li>

				<li><a href="#pageSubmenu" data-toggle="collapse"
					aria-expanded="false" class="dropdown-toggle">매장관리</a>
					<ul class="collapse list-unstyled" id="pageSubmenu">
						<li><a href="businessFormShop.jsp">매장 정보</a></li>
						<li><a href="businessFormUpdate.jsp">매장 정보 수정</a></li>
						<li><a href="businessFormSales.jsp">통계</a></li>
					</ul></li>

			</ul>


		</nav>

		<!-- Page Content  -->
		<div id="content">

			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="container-fluid">

					<button type="button" id="sidebarCollapse" class="btn btn-info">
						<i class="fas fa-align-left"></i> <span>menu</span>
					</button>
					<button class="btn btn-dark d-inline-block d-lg-none ml-auto"
						type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<i class="fas fa-align-justify"></i>
					</button>

					<button class="btn btn-dark d-inline-block d-lg-none ml-auto"
						type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<i class="fas fa-align-justify"></i>
					</button>

					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="nav navbar-nav ml-auto">
							<li class="nav-item"><a class="nav-link"
								href="reservationForm.jsp">예약관리</a></li>
							<li class="nav-item active"><a class="nav-link"
								href="businessFormShop.jsp">매장관리</a></li>

						</ul>
					</div>
				</div>
			</nav>


			<div class="container col-sm-9">
				<div class="buttonPadding">
					<ul>
						<li class="li2"><button type="submit" style="float: right;">적용</button></li>
						<li class="li2"><button style="float: right;">미리보기</button>
					</ul>
				</div>
				<div class="container col-sm-9"
					style="border: 0.5px solid lightgray;  height: 90%; overflow-x: auto;">
					<h4 align="center">매장정보</h4>
					<br> <br>
					<form action="#" method="post">
						<table align="center"
							style="min-width: 500px; border-collapse: separate; border-spacing: 0 10px;">
							<tr>
								<td><label>hp : </label></td>
								<td><input type="tel" name="phone"></td>
							</tr>
							<tr>
								<td><label>위치 : </label></td>
								<td><input type="text" name="address"></td>
							</tr>
							<tr>
								<td><label>영업시간(평일) : </label></td>
								<td><input type="time" name="openTime1"></td>
								<td><input type="time" name="closeTime1"></td>
							</tr>
							<tr>
								<td><label>영업시간(공휴일) : </label></td>
								<td><input type="time" name="openTime1"></td>
								<td><input type="time" name="closeTime2"></td>
							</tr>
							<tr>
								<td><label>간단한 소개 : </label></td>
								<td><input type="text" name="introducer"
									style="width: 175px; height: 80px;"></td>
							</tr>

						</table>
					</form>
				</div>
				<div class="container col-sm-9"
					style="border: 0.5px solid lightgray;  height: 90%; overflow-x: auto;">
					<h4 align="center">메뉴</h4>
					<br> <br>
					<form action="#" method="post">
						<table class="table table-bordered" style="min-width: 500px;">
							<thead>
								<tr style="background: lightgray">
									<th align="center">메뉴명</th>
									<th align="center">가격</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input type="text" name="menu1"></td>
									<td><input type="number" name="menuPrice1"></td>
								</tr>
								<tr>
									<td><input type="text" name="menu2"></td>
									<td><input type="number" name="menuPrice1"></td>
								</tr>
								<tr>
									<td><input type="text" name="menu3"></td>
									<td><input type="number" name="menuPrice1"></td>
								</tr>
								<tr>
									<td><input type="text" name="menu4"></td>
									<td><input type="number" name="menuPrice1"></td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>

				<div class="container col-sm-9"
					style="border: 0.5px solid lightgray;   height: 90%;">
					<form action="#" method="post">
						<h4 align="center">사진첨부</h4>
						<div
							style="border: 0.5px solid lightgray; margin 0 auto; height: 65%;">
							<h4>
								<a href="#">사진첨부링크</a>
							</h4>
						</div>
					</form>
				</div>

			</div>
		</div>


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

	<script type="text/javascript">
		$(document).ready(function() {
			$("#sidebar").mCustomScrollbar({
				theme : "minimal"
			});

			$('#sidebarCollapse').on('click', function() {
				$('#sidebar, #content').toggleClass('active');
				$('.collapse.in').toggleClass('in');
				$('a[aria-expanded=true]').attr('aria-expanded', 'false');
			});
		});
	</script>
</body>

</html>