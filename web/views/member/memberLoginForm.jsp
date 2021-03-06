<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
	$(function() {
		$(window).resize(function() {
			window.resizeTo(400, 500);
		});
	})
</script>
<style>
.panel-login {
	border-color: #ccc;
	-webkit-box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.2);
	-moz-box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.2);
	box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.2);
	width: 350px;
	height: 400px;
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
	color: #ffb100;
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

.rows {
	display: inline-block;
}

.form-group {
	text-align: center;
}

.btn-primary, .btn-success {
	width: 30%;
}
img{
width: auto;
}
</style>
<title>딸랑밥 로그인</title>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
</head>
<body>
	<div class="panel panel-login">
		<div class="panel-heading">
			<div class="row">
				<div>
					<a class="active" id="login-form-link">딸랑밥 로그인</a>
				</div>
			</div>
			<hr>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-lg-12">
					<form id="login-form" action="<%= request.getContextPath() %>/loginMember.me" method="post" role="form">
						<div class="form-group">
							<input type="text" name="userId" id="userId" tabindex="1"
								class="form-control" placeholder="ID" value="">
						</div>
						<div class="form-group">
							<input type="password" name="userPwd" id="userPwd" tabindex="2"
								class="form-control" placeholder="PASSWORD">
						</div>

						<div class="form-group">

							<input type="submit" name="login-submit" id="login-submit"
								tabindex="4" class="form-control btn btn-success" value="회원가입"
								data-toggle="modal" data-dismiss="modal"
								data-target="#joinModal"> <input type="submit"
								name="login-submit" id="login-submit" tabindex="4"
								class="form-control btn btn-primary" value="로그인">

							<div class="modal" id="joinModal" aria-hidden="true"
								style="display: none;">
								<div class="modal-dialog modal-lg">
									<div class="modal-content">
										<%@ include file="memberJoinSelectForm.jsp"%>
									</div>
								</div>
							</div>


						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-lg-12">
									<div class="text-center">
										<a onclick="searchUser()"  target="_blank"
											tabindex="5" class="forgot-password" style="cursor: pointer;">아이디 / 비밀번호 찾기</a>
									</div>
								</div>
							</div>
							<br> <a id="kakao-login-btn"></a> <a
								href="http://developers.kakao.com/logout"></a>
								
							<script type='text/javascript'>
							var openWin;
							
						    // 사용할 앱의 JavaScript 키를 설정해 주세요.
						    Kakao.init('bf07de78ccb40d07273cceb9edaf6165');
						    // 카카오 로그인 버튼을 생성합니다.
						    Kakao.Auth.createLoginButton({
						      container: '#kakao-login-btn',
						      success: function(authObj) {
						        // 로그인 성공시, API를 호출합니다.
						        Kakao.API.request({
						          url: '/v2/user/me',
						          success: function(res) {
						        	//내가 만든 함수로 값 전달
						            getKey(res.id, res.properties['nickname']);
						          },
						          fail: function(error) {
						            alert(JSON.stringify(error));
						          }
						        });
						      },
						      fail: function(err) {
						        alert(JSON.stringify(err));
						      }
						    });
							
						    //카카오톡 로그인 성공 시, 아이디 int 값과 닉네임을 전달받는 메소드
						    function getKey(data, name){
						    	
						    	//전달받은 아이디를 그대로 전달하는것 하나, 암호화 필터에 걸리는것 하나 총 두개 전달함
						    	var key = data;
						    	var key2 = data;
						    	var nickName = name;
						    	$.ajax({
						    		url:"<%=request.getContextPath()%>/loginKakao.me",
						    		data:{userPwd:key, userId:key2},
						    		type:"post",
						    		success:function(data){
						    			
						    			//기존회원이 아닌경우 회원가입 폼을 띄움
						    			if(data != '기존회원'){
							    			   alert('최초 카카오톡 로그인 시 개인정보를 설정 해주셔야 해요!');
										       window.name = "main";
										       openWin = window.open('/rr/views/member/kakaoMemberLoginForm.jsp','childForm',
													'top=50px, left=800px, height=500, width=400');
										           
									           var userPwd = data.split(",")[0];
									           var userId = data.split(",")[1];
									           
									           timer = setInterval(function(){
									        	   //받아온 정보들을 새로띄운 회원가입 창에 입력함(보이지는 않음)
									        	    openWin.$("#userId").val(userId);
										   			openWin.$("#userPwd").val(data);
										   			openWin.$("#userPwd2").val(data);
										   			openWin.$("#userName").val(nickName);
									   		}, 1000);
						    			}else{
						    				//기존 회원인 경우 서블릿에서 로그인 처리 하고, 새로고침해줌
						    				window.location.reload();
						    			}
						    		},
						    		error:function(){
						    			console.log("실패!");
						    		}
						    	});
						    }
						    
						    function searchUser() {
								cw=450;
								ch=500;
								sw=screen.availWidth;
								sh=screen.availHeight;
								px=(sw-cw)/2;
								py=(sh-ch)/2;

								window.open('views/member/searchUser.jsp', '', 'status=no, height='+ch+', width='+cw+', left='+ px + ', top=10');
							}
							</script>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>