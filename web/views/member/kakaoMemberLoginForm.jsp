<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


<style>
body {
	background: #f5f5f5;
}

.container {
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

.btn-warning {
	margin-bottom: 1px;
}

.btn-primary {
	width: 70px;
	padding: 0%;
	padding-top: 5px;
	padding-bottom: 5px;
	margin-bottom: 2px;
}

.form-control {
	width: 300px;
	display: inline-block;
}

.test {
	text-align: center;
}

#userId, #tel, #curjob {
	width: 215px;
	height: 35px;
}

#userPwd, #userPwd2, #userName, #birthday, #email {
	height: 35px;
}
</style>
<title>딸랑밥 회원가입</title>
</head>
<body>
	<div class="container">
		<h2>딸랑밥 회원가입</h2>
		<div class="row insertForm">
			<div class="panel panel-join">
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-12">
							<form id="join-form"
								action="<%=request.getContextPath()%>/insertKakaoMember"
								method="post" role="form" style="display: block;">
								<input type="hidden" name="memberType" id="memberType" value="1">
								 <div class="form-group">
									<input type="hidden" name="userId" id="userId"
										class="form-control" placeholder="아이디" >
								</div>
								<div class="form-group">
									<input type="hidden" name="userPwd" id="userPwd"
										class="form-control" placeholder="비밀번호" required>
								</div>
								<div class="form-group">
									<input type="hidden" name="userPwd2" id="userPwd2"
										class="form-control" placeholder="비밀번호 확인" required>
								</div>

								<div class="form-group">
									<input type="text" name="userName" id="userName"
										class="form-control" placeholder="이름" readonly >
								</div>
								<div class="form-group">
									<label>생년월일 : </label> <input type="date" name="birthday"
										id="birthday" class="form-control" style="width: 233px;"
										required>
								</div>
								<div>
									<label>성별 : </label>&nbsp;&nbsp;&nbsp;&nbsp; <input
										type="radio" name="gender" id="male" value="M" required>
									<label for="male">남자</label> &nbsp;&nbsp;&nbsp; <input
										type="radio" name="gender" id="female" value="F" required>
									<label for="female">여자</label>
								</div>
								<br>
								<div>
									<label for="male">직종 : </label>&nbsp;&nbsp;&nbsp;<select
										class="form-control"
										style="width: 233px; height: 32px; border-radius: 3px 3px 3px 3px; border: 1px solid lightgray;"
										id="job" name="curjob">
										<option value="무직">무직</option>
										<option value="학생">학생</option>
										<option value="IT">IT</option>
										<option value="언론">언론</option>
										<option value="공무원">공무원</option>
										<option value="군인">군인</option>
										<option value="서비스업">서비스업</option>
										<option value="교육">교육</option>
										<option value="금융/증권/보험업">금융/증권/보험업</option>
										<option value="유통업">유통업</option>
										<option value="예술">예술</option>
										<option value="의료">의료</option>
										<option value="법률">법률</option>
										<option value="건설업">건설업</option>
										<option value="제조업">제조업</option>
										<option value="부동산업">부동산업</option>
										<option value="운송업">운송업</option>
										<option value="농/수/임/광산업">농/수/임/광산업</option>
										<option value="가사">가사</option>
										<option value="기타">기타</option>
									</select>
								</div>
								<br>
								<div class="form-group">
									<input type="tel" name="phone" id="phone" class="form-control"
										placeholder="휴대폰번호" required>
								</div>
								<div class="form-group">
									<input type="email" name="email" id="email"
										class="form-control" placeholder="이메일" required>
									
								</div>
								<div class="form-group">
									<div class="row">

										<input type="submit" name="register-submit"
											id="register-submit" class="form-control btn btn-register"
											value="회원가입" onclick="success()">
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

		
		
	
	</script>

</body>
</html>