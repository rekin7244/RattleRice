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

    $('#login-form-link').click(function(e) {
		$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#register-form-link').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});

});
	$(function() {
		$(window).resize(function() {
			window.resizeTo(400, 500);
		});
	})
</script>
<style>
body {
	padding-top: 90px;
}

.panel-login {
	border-color: #ccc;
	-webkit-box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.2);
	-moz-box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.2);
	box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.2);
}

.panel-login>.panel-heading {
	color: #00415d;
	background-color: #fff;
	border-color: #fff;
	text-align: center;
}

.panel-login>.panel-heading a {
	text-decoration: none;
	color: #666;
	font-weight: bold;
	font-size: 15px;
	-webkit-transition: all 0.1s linear;
	-moz-transition: all 0.1s linear;
	transition: all 0.1s linear;
}

.panel-login>.panel-heading a.active {
	color: #029f5b;
	font-size: 18px;
}

.panel-login>.panel-heading hr {
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

.panel-login input[type="text"], .panel-login input[type="email"],
	.panel-login input[type="password"] {
	height: 45px;
	border: 1px solid #ddd;
	font-size: 16px;
	-webkit-transition: all 0.1s linear;
	-moz-transition: all 0.1s linear;
	transition: all 0.1s linear;
}

.panel-login input:hover, .panel-login input:focus {
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
</style>
<title>딸랑밥 회원가입</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="searchUser.jsp" >아이디 찾기</a>
							</div>
							<div class="col-xs-6">
								<a href="searchUserPwd.jsp" class="active" >비밀번호 찾기</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
							
								<%!public int getRandom() {
									int random = 0;
									random = (int) Math.floor((Math.random() * (99999 - 10000 + 1))) + 10000;
									return random;
								}%>

								<!-- 아이디 찾기 -->
									<input type="text" readonly="readonly" name="code_check" id="code_check" value="<%=getRandom()%>" />

								<form id="login-form" method="post" role="form"
									style="display: block;">
									<div class="form-group">
									
										<input type="text" name="username" id="username"
											class="form-control" placeholder="이름 입력" value="">
											
									</div>
									
									<div class="form-group">
									
										<input type="text" name="userId" id="userId"
											class="form-control" placeholder="아이디 입력" value="">
											
									</div>
									
									<div class="form-group">
									
										<input type="email" name="email" id="email"
											class="form-control" placeholder="이메일 입력"
											style="width: 75%; display: inline-block;" value="">
											
										<button type="button" class="btn btn-warning" style="display: inline-block;" onclick="checkUserPwd()">인증번호
											발송</button>
											
									</div>

									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
											
												<input type="text" name="code" id="code"
													class="form-control" style="width: 100%"
													onkeyup="checkCode()" placeholder="인증번호를 입력하세요." />
													
												<div id="checkCode"></div>
												
												<br> <input type="hidden" name="login-submit"
													id="login-submit" onclick="showId()"
													class="form-control btn btn-login" value="비밀번호 확인하기">
											</div>
										</div>
									</div>
								</form>

								<!-- 인증 확인 -->

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



	

</body>
<script>
//비밀번호 찾기
var findPwd = null;
var checkSuccess=0;

function checkUserPwd() {
	
	var userName = $("#username").val();
	var userId = $("#userId").val();
	var email = $("#email").val();
	var code = $("#code_check").val();
	
	
	if(email != "" &&  userName != "" && userId != ""){
		$.ajax({
			url:"<%=request.getContextPath()%>/checkEmailPwd.me",
			data: {userName:userName,userId:userId, email:email ,userPwd:code},
			type:"post",
			success:function(data){
				checkSuccess = data;
				console.log("위 :"+checkSuccess);
			}
		});
		
		emailSubmit();
		
	}else{
		alert("정보를 입력해 주세요!");
	}
};





function emailSubmit() {
	
	console.log("아래 : "+checkSuccess);
if(checkSuccess != 0){
		
		$.ajax({
			url:"<%=request.getContextPath()%>/send",
			data: {email:email,code:code},
			type:"post",
			success:function(data){
				alert("인증번호가 발송되었습니다.");
			},
		});
		
		}else{
			alert("정보를 다시 확인해 주세요!");
		}
	
}

	function checkCode(){
		  var v1 = $("#code_check").val();
		  var v2 = $("#code").val();
		  if(v1!=v2){
			   document.getElementById('checkCode').style.color = "red";
			   document.getElementById('checkCode').innerHTML = "잘못된인증번호";
               makeNull();
		  }else{
			   document.getElementById('checkCode').style.color = "blue";
			   document.getElementById('checkCode').innerHTML = "인증되었습니다."; 
			   makeReal();
			   $("#login-submit").show();
		  }
		 }
	function makeReal(){
		var hi = document.getElementById("login-submit");
		hi.type="submit";
	}
    function makeNull(){
		var hi = document.getElementById("login-submit");
		hi.type="hidden";
	}
    
    function showId() {
		alert("새로 지정된 암호는 \" " + findPwd+" \" 입니다. 로그인후 비밀번호를 변경해 주세요!");
	}

    
</script>
</html>