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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<!-- 은행권 공동 오픈플랫폼 : 오픈 API -->
<script type="text/javascript" src="<%=request.getContextPath() %>/js/settlement/constants.js"></script><!-- 상수 js -->
<script type="text/javascript" src="<%=request.getContextPath() %>/js/settlement/common.js"></script><!-- 사용자정의 js -->
<script type="text/javascript" src="<%=request.getContextPath() %>/ext_lib/bootstrap-3.3.6-dist/js/modal.js"></script>
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
							href="/views/admin/adminForm.jsp">회원관리</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/views/admin/community.jsp">커뮤니티</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/views/admin/calculate.jsp">정산</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/views/admin/sms.jsp">SMS</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath()%>/logout.me">로그아웃</a></li>
					</ul>
				</div>
			</div>

		</nav>


		<br>
		<br> <select>
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
		var svrOpts = {
			test : {
				name : '테스트서버',
				bs_style : 'primary',
				base_web_uri : 'https://twww.open-platform.or.kr',
				base_api_uri : 'https://testapi.open-platform.or.kr',
				redirect_uri : 'http://localhost:8001/views/admin/callback.html',
				client_id : 'l7xx93ba6a582b784910857c584b77578cee',
				client_secret : '79a1e5e8035747339d11816da73c0e93',
				client_info : 'test whatever you want'
			}
		};

		function settlement() {
			if(isEmptyElem('token')){
				showMsg('Access Token을 먼저 획득해 주십시오.');
				return;
			}
			
			$.ajax({
				url: getSvrProps('base_api_uri') + '/transfer/deposit2',
				type: 'post',
				headers: {
					'Authorization': ('Bearer ' + $('#token').val())
				},
				data: js($.extend({}, getFormParamObj('depositFrm'), {
					req_list: reqList
				}))
			})
			.done(function(data, textStatus, jqXHR){
				if(isGatewayException(data)){ return; } // ajax 응답이 Gateway Exception일 경우 이후 처리를 종료한다.		
				
				// UI에 결과값 바인딩
				$('#resultTextArea').val(js(data));
			});
		}
		
			
	</script>
</body>

</html>