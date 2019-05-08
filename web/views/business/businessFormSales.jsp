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

.col-sm-3 col-md-3{
	position: relative;
    float: left;
    min-height: 1px;
    padding-right: 15px;
    padding-left: 15px;
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
						<i class="fas fa-align-left"></i> <span>Toggle Sidebar</span>
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
							<li class="nav-item active"><a class="nav-link" href="reservationForm.jsp">예약관리</a>
							</li>
							<li class="nav-item"><a class="nav-link" href="businessFormShop.jsp">매장관리</a></li>
							
						</ul>
					</div>
				</div>
			</nav>

			<div class="col-md-8">
				<p>매출분석</p>
				<ul id="topMenu">
					<li>test(사업장명)</li>
					<li><label>기준년월 : <input type="date"></label>
					<li><button>검색하기</button></li>
				</ul>
				<br>
				<ul>

					<!-- 엑셀파일 다운로드 -->
					<li class="li2"><button>엑셀다운로드</button></li>
				</ul>

				<table class="table table-bordered">
					<thead>
						<tr style="background: lightgray">
							<th>구분</th>
							<th>18.11</th>
							<th>18.12</th>
							<th>19.01</th>
							<th>19.02</th>
							<th>19.03</th>
							<th>19.04</th>
							<th>19.05</th>
							<th>19.06</th>
							<th>합계</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>목표</td>
							<td>0.0</td>
							<td>0.0</td>
							<td>0.0</td>
							<td>0.0</td>
							<td>0.0</td>
							<td>0.0</td>
							<td>0.0</td>
							<td>0.0</td>
							<td>0.0</td>
						</tr>
						<tr>
							<td>합계</td>
							<td>0.0</td>
							<td>0.0</td>
							<td>0.0</td>
							<td>0.0</td>
							<td>0.0</td>
							<td>0.0</td>
							<td>0.0</td>
							<td>0.0</td>
							<td>0.0</td>
						</tr>
						<tr>
							<td>전액</td>
							<td>0.0</td>
							<td>0.0</td>
							<td>0.0</td>
							<td>0.0</td>
							<td>0.0</td>
							<td>0.0</td>
							<td>0.0</td>
							<td>0.0</td>
							<td>0.0</td>
						</tr>
						<tr>
							<td>주문</td>
							<td>0.0</td>
							<td>0.0</td>
							<td>0.0</td>
							<td>0.0</td>
							<td>0.0</td>
							<td>0.0</td>
							<td>0.0</td>
							<td>0.0</td>
							<td>0.0</td>
						</tr>
					</tbody>
				</table>
				<div class="col-sm-9"
					style="border: 0.5px solid lightgray; width: 95%; height: 90%;">
					<h3>그래프 들어갈 부분</h3>
				</div>
			</div>
			<div class="col-sm-3 col-md-3"
				style="border: 0.5px solid lightgray; width: 25%; height: 80%; background: gray;">
				<h3 align="center">정산 금액</h3>
				<br>
				<h2 align="center">Day-4</h2>
				<h3 align="center">85,664원</h3>
				<p>영원히 투명하되 때까지 돋고, 실로 인류의 가슴이 그들은 것이다. 과실이 눈이 고 행을 실현에 주며,
					사막이다. 곳으로 그들의 얼마나 방황하였으며, 낙원을 우리의 꽃이 보는 위하여 사막이다. 무엇을 살았으며, 같은 보라.
					청춘은 이 상의 내려온 있으며, 그들은 위하여, 피고 어디 위하여, 아니다. 발휘하기 대한 두손을 인간이 때문이다.
					웅대한 생명을 뭇 사막이다. 그것을 소담스러운 인도하겠 다는 스며들어 힘있다. 눈이 청춘은 주는 위하여서 소담스러운
					창공에 낙원을 대한 물방아 것이다. 일월과 생의 행복스럽고 반짝이는 속에서 우리의 것이다. 생명을 열락의 피에 위하여서.</p>
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