<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script> -->
<script>
	$(function() {
		$(window).resize(function() {
			window.resizeTo(400, 500);
		});
	})
</script>
<style>
.panel-join {
	border-color: #ccc;
	-webkit-box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.2);
	-moz-box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.2);
	box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.2);
	width: 500px;
	height: 300px;
	margin: 0 auto;
}

.panel-join>.panel-heading {
	color: #00415d;
	background-color: #fff;
	border-color: #fff;
	text-align: center;
}

.panel-join>.panel-heading a {
	text-decoration: none;
	color: #666;
	font-weight: bold;
	font-size: 15px;
	-webkit-transition: all 0.1s linear;
	-moz-transition: all 0.1s linear;
	transition: all 0.1s linear;
}

.panel-join>.panel-heading a.active {
	color: #ffb100;
	font-size: 18px;
}

.panel-join>.panel-heading hr {
	margin-top: 10px;
	margin-bottom: 0px;
	clear: both;
	border: 0;
	height: 1px;
	background-image: -webkit-linear-gradient(left, rgba(0, 0, 0, 0),
		rgba(0, 0, 0, 0.15), rgba(0, 0, 0, 0));
	background-image: -moz-linear-gradient(left, rgba(0, 0, 0, 0),
		rgba(0, 0, 0, 0.15), rgba(0, 0, 0, 0));
	background-image: -ms-linear-gradient(left, rgba(0, 0, 0, 0),
		rgba(0, 0, 0, 0.15), rgba(0, 0, 0, 0));
	background-image: -o-linear-gradient(left, rgba(0, 0, 0, 0),
		rgba(0, 0, 0, 0.15), rgba(0, 0, 0, 0));
}

.panel-join input[type="text"], .panel-join input[type="email"],
	.panel-join input[type="password"] {
	height: 45px;
	border: 1px solid #ddd;
	font-size: 16px;
	-webkit-transition: all 0.1s linear;
	-moz-transition: all 0.1s linear;
	transition: all 0.1s linear;
}

.panel-join input:hover, .panel-join input:focus {
	outline: none;
	-webkit-box-shadow: none;
	-moz-box-shadow: none;
	box-shadow: none;
	border-color: #ccc;
}

.btn-login {
	background-color: #59B2E0;
	outline: none;
	color: #fff;
	font-size: 14px;
	height: auto;
	font-weight: normal;
	padding: 14px 0;
	text-transform: uppercase;
	border-color: #59B2E6;
}

.btn-login:hover, .btn-login:focus {
	color: #fff;
	background-color: #53A3CD;
	border-color: #53A3CD;
}

.forgot-password {
	text-decoration: underline;
	color: #888;
}

.forgot-password:hover, .forgot-password:focus {
	text-decoration: underline;
	color: #666;
}

.btn-register {
	background-color: #1CB94E;
	outline: none;
	color: #fff;
	font-size: 14px;
	height: auto;
	font-weight: normal;
	padding: 14px 0;
	text-transform: uppercase;
	border-color: #1CB94A;
}

.btn-register:hover, .btn-register:focus {
	color: #fff;
	background-color: #1CA347;
	border-color: #1CA347;
}

.rows {
	display: inline-block;
}

.form-group {
	text-align: center;
}

.btn-primary, .btn-warning {
	width: 30%;
}

.box {
	background: lightgray;
	height: 150px;
	border-width: 2px;
	border-radius: 10px;
	background: lightgray;
	text-align: center;
}

.one {
	padding-top: 15px;
	width: 200px;
	text-align: center;
	display: inline-block;
}

.center {
	width: 30px;
	text-align: center;
	display: inline-block;
}

.selectImg {
	width: auto;
}
</style>
<title>딸랑밥 회원가입</title>
</head>
<body>
	<div class="panel panel-join">
		<div class="panel-heading">
			<div class="row">
				<div>
					<a class="active" id="login-form-link">어떤 타입의 회원이신가요?</a>
				</div>
			</div>
			<hr>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-lg-12">
					<form id="login-form" action="#" method="post" role="form">

						<div class="box">
							<div class="one">만 19세 이상 국내 거주자</div>
							<div class="center"></div>
							<div class="one">사업자 등록증을 소지한 사업자</div>
							<div class="one">
								<img src="images/user.PNG" class="selectImg">
							</div>
							<div class="center">or</div>
							<div class="one">
								<img src="images/bUser.PNG" class="selectImg">
							</div>
						</div>

						<br>

						<div class="form-group">
							<input type="button" name="login-submit" id="login-submit"
								tabindex="4" class="form-control btn btn-warning" value="일반회원"
								onclick="login()">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="button" name="login-submit" id="login-submit"
								tabindex="4" class="form-control btn btn-warning" value="사업자 회원"
								onclick="bLogin()">
						</div>

					</form>
				</div>
			</div>
		</div>
	</div>
	<script>
	

	function login() {
		cw=450;
		ch=620;
		sw=screen.availWidth;
		sh=screen.availHeight;
		px=(sw-cw)/2;
		py=(sh-ch)/2;

		window.open('views/member/memberJoinForm.jsp', '', 'status=no, height='+ch+', width='+cw+', left='+ px + ', top=10');
	}
	
	function bLogin() {
		cw=450;
		ch=730;
		sw=screen.availWidth;
		sh=screen.availHeight;
		px=(sw-cw)/2;
		py=(sh-ch)/2;

		window.open('views/member/businessMemberJoinForm.jsp', '', 'status=no, height='+ch+', width='+cw+', left='+ px + ', top=10');
	}
	
	</script>
	
</body>
</html>