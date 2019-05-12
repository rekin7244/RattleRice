<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script>
	$(function() {
		$(window).resize(function() {
			window.resizeTo(400, 500);
		});
	})
</script>
<style>
body {
	background: #f5f5f5;
}

.container h2 {
	text-align: center;
}

.panel-join {
	border-color: #ccc;
	-webkit-box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.2);
	-moz-box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.2);
	box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.2);
	margin: auto;
	width: 400px;
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
	color: #029f5b;
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

.btn-primary {
	width: 70px;
	padding: 0%;
	padding-top: 5px;
	padding-bottom: 5px;
}

.btn-warning {
	width: 70px;
	padding: 0%;
	padding-top: 6px;
	padding-bottom: 10px;
	height: 35px;
}

.form-control {
	width: 300px;
	display: inline-block;
}

.test {
	text-align: center;
}

#userId {
	width: 223px;
}

.top {
	padding-left: 10%;
	padding-right: 10%;
}

.title {
	display: inline-block;
}

#topBtn {
	display: inline-block;
	float: right;
	width: 82px;
}

#businessNumber, #businessTitle, #businessName, #tel, #accountNumber,
	#userId, #userPwd, #userPwd2 {
	height: 35px;
}
</style>
<title>딸랑밥 회원가입</title>
</head>
<body>
	<div class="container">
		<h2>딸랑밥 회원가입</h2>
		<div class="row">
			<div class="panel panel-join">
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-12">
							<form id="join-form"
								action="<%=request.getContextPath()%>/insertBMember.me"
								method="post" role="form" style="display: block;">
								<input type="hidden" name="memberType" id="memberType" value="2">
								<div class="top">
									<h4 class="title">사업자 인증</h4>
									<button type="button" class="btn btn-primary" id="topBtn"
										style="background: white; color: gray;">사업자 인증</button>
								</div>
								<div class="form-group">
									<input type="text" name="businessNumber" id="businessNumber"
										class="form-control" placeholder="사업자 번호" readonly>

								</div>
								<div class="form-group">
									<input type="text" name="businessTitle" id="businessTitle"
										class="form-control" placeholder="상호명" readonly>
								</div>
								<div class="form-group">
									<input type="text" name="businessName" id="businessName"
										class="form-control" placeholder="사업자명" readonly>
								</div>

								<div class="form-group">
									<input type="tel" name="tel" id="tel" class="form-control"
										placeholder="휴대폰 번호" readonly>
								</div>
								<div class="form-group">
									<input type="text" name="accountNumber" id="accountNumber"
										class="form-control" placeholder="정산 계좌" readonly>
									<div style="text-align: right; width: 100%; padding: 0;">
										<input type="button" class="btn btn-primary"
											style="background: white; color: gray; margin-right: 33px; margin-top: 5px;"
											value="계좌 인증"></input>

									</div>
								</div>

								<hr>
								<div class="top">
									<h4 class="title">기본 정보</h4>
								</div>
								<div class="form-group">
									<input type="text" name="userId" id="userId"
										class="form-control" placeholder="아이디" required>
									<button type="button" class="btn btn-warning " id="idCheck"
										style="background: white; color: gray;">중복확인</button>
								</div>
								<div class="form-group">
									<input type="password" name="userPwd" id="userPwd"
										class="form-control" placeholder="비밀번호" required>
								</div>
								<div class="form-group">
									<input type="password" name="userPwd2" id="userPwd2"
										class="form-control" placeholder="비밀번호 확인" required>
								</div>

								<div class="form-group">
									<div class="row">
										<!-- <input type="submit" name="register-submit"
											id="register-submit" class="form-control btn btn-register"
											value="회원가입" > -->

										<input type="submit" name="register-submit"
											id="register-submit" class="form-control btn btn-register"
											value="회원가입" onclick="success()" disabled>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		var idCheck = "0";
		var pwdCheck = "0";

		$(function() {
			$("#idCheck").click(function() {
				var userId = $("#userId").val();

				$.ajax({
					url : "/rr/idCheck.me",
					type : "post",
					data : {
						userId : userId
					},
					success : function(data) {
						if (data === "fail") {
							alert("아이디가 중복됩니다.");
							idCheck = "0";
						} else {
							alert("사용 가능합니다.");
							idCheck = "1";
							$("#userId").attr("readonly","readonly");
						}
					},
					error : function() {
						console.log("실패");
					}
				});
			})
		});
		
		$(function() {
			$("#userPwd2").keyup(function() {
				var pwd1 = $("#userPwd").val();
				var pwd2 = $("#userPwd2").val();
				if (pwd1 != "" || pwd2 != "") {
					if (pwd1 == pwd2) {
						$("#userPwd2").css("border", "solid 2px lightgreen");
						// $("#register-submit").removeAttr("disabled");
						pwdCheck = "1";
					} else {
						$("#userPwd2").css("border", "solid 2px red");
						//  $("#register-submit").attr("disabled", "disabled");
						pwdCheck = "0";
					}
				}
			});
		});
		
		setInterval(function() {
			console.log("실행");
			console.log(idCheck);
			console.log(pwdCheck);
			if(idCheck == "1" && pwdCheck == "1"){
				$("#register-submit").removeAttr("disabled");
			}else{
				$("#register-submit").attr("disabled", "disabled");
			}
		},500);

		
	</script>
</body>
</html>