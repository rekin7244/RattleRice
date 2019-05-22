<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


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

.panel-join input:hover, .panel-join input:focus {
	outline: none;
	-webkit-box-shadow: none;
	-moz-box-shadow: none;
	box-shadow: none;
	border-color: #ccc;
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

.form-control {
	width: 300px;
	display: inline-block;
}


#nowUserPwd, #userPwd, #checkUserPwd {
	height: 35px;
}
</style>
<title>비밀번호 변경</title>
</head>
<body>
	<div class="container">

		<div class="row insertForm">
			<div class="panel panel-join">
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-12">
							<form id="join-form"
								action="<%=request.getContextPath()%>/updatePwd.me"
								method="post" role="form" style="display: block;">
								<h2>비밀번호 변경</h2>
								<div class="form-group">
									<input type="password" name="nowUserPwd" id="nowUserPwd"
										class="form-control" placeholder="현재 비밀번호" required>
								</div>
								<div class="form-group">
									<input type="password" name="userPwd" id="userPwd"
										class="form-control" placeholder="변경할 비밀번호" required onkeyup="checkCode()">
								</div>
								<div class="form-group">
									<input type="password" name="checkUserPwd" id="checkUserPwd"
										class="form-control" placeholder="비밀번호 확인" required onkeyup="checkCode()">
								</div>
								<div id="checkCode"></div> <br>
								
								<div class="form-group">
									<div class="row">
										<input type="submit" name="register-submit"
											id="register-submit" class="form-control btn btn-register"
											value="변경" disabled>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

<script>
function checkCode(){
	  var userPwd = $("#userPwd").val();
	  var checkUserPwd = $("#checkUserPwd").val();
	  if(userPwd!=checkUserPwd){
		  $("#checkUserPwd").css("border", "solid 2px red");
		  $("#checkCode").css("color", "red");
		   document.getElementById('checkCode').innerHTML = "비밀번호가 일치하지 않습니다.";
		   $("#register-submit").attr("disabled", "disabled");
	  }else{
		  $("#checkUserPwd").css("border", "solid 2px lightgreen");
		  $("#checkCode").css("color", "green");
		   document.getElementById('checkCode').innerHTML = "비밀번호가 일치합니다.";
		   $("#register-submit").removeAttr("disabled");
	  }
	 }

</script>
</html>