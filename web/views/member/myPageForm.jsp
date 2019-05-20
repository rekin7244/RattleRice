<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.kh.rr.member.model.vo.Member ,java.util.*"%>

<%
	Member loginUser = (Member) session.getAttribute("loginUser");
	ArrayList<HashMap<String, Object>> list = (ArrayList<HashMap<String, Object>>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<title>딸랑밥</title>
<style>
body::-webkit-scrollbar { 
    display: none; 
}
.navbar-inverse {
	background: #F4AC8A;
	border: none;
}

.navbar-inverse .navbar-nav>li>a {
	color: black;
}

.contact-form {
	margin: 0 auto;
	padding-right: 10px;
	text-align: center;
	background: yellowgreen;
	text-align: center;
}

.fixed {
	position: fixed;
	top: 90%;
	right: 3%;
}

.fixed .far {
	font-size: 3em;
}

@import
	"https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700";

body {
	background: #fafafa;
	/* 	overflow: hidden */
}

/* 메뉴 */
p {
	text-align: center;
	font-family: 'Poppins', sans-serif;
	font-size: 1.1em;
	font-weight: 300;
	line-height: 1.7em;
}

/* sidebar menu*/
a, a:hover, a:focus {
	color: inherit;
	text-decoration: none;
	transition: all 0.3s;
}

#sidebar {
	top: 0;
	left: 0;
	z-index: 999;
	color: black;
	transition: all 0.3s;
}

a[data-toggle="collapse"] {
	position: relative;
}

#content {
	width: calc(100% - 250px);
	padding: 40px;
	transition: all 0.3s;
	position: absolute;
	top: 10;
	right: 0;
	padding: 0;
}

#jb-header {
	text-align: center;
}

#jb-header h1 {
	margin-top: 0;
	margin-bottom: 20px;
}

#jb-content {
	padding: 20px;
	border-left: 1px solid black;
	height: 700px;
}

.active {
	background: gray;
	color: white;
}

.row {
	/* width: 1530px; */
	
}

.content h3 {
	margin-top: 0;
	margin-bottom: 20px;
}

.in-content {
	width: 100%;
	margin: 0 auto;
	text-align: center;
	padding-bottom: 10px;
}

#div1 {
	width: 45%;
	height: 250px;
	display: inline-block;
}

#div2 {
	width: 45%;
	height: 250px;
	display: inline-block;
}

#div3 {
	width: 49%;
	display: inline-block;
}

#div4 {
	width: 49%;
	display: inline-block;
}

.container-fluid {
	padding: 0;
}

.profile {

}

.form1, .form2 {
	margin-top: 30px;
}

.img {

}

.form-input {
	width: auto;
	display: inline-block;
}

#profileImgArea {
	cursor: pointer;
	
}

#inProfileImg {
	object-fit: cover;
	border-radius: 50%;
}

.form-group {
	display: block;
}

#userUpdateBtn {
	
}

#userArea {
	margin-left: 120px;
	margin-right: 100px;
}

.form-control {
	width: 20%;
}

input, textarea {
	text-align: center;
}


.col-sm-5 {
	width: auto;
}

#profileImgUpdateBtn {
	background-color: lightgray;
}

/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 450px;
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>

</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">
	<div id="div0" class="container-fluid"></div>
	<!-- 상단바 -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav" id='selectmenu'>
					<li><a href="<%=request.getContextPath()%>/index.jsp">Home</a></li>

				</ul>
				<%
					if (loginUser != null) {
				%>
				<ul class="nav navbar-nav navbar-right">
					<li><a
						style="font-family: 'Megrim', cursive; font-weight: bold;"><%=loginUser.getUserName()%>님</a></li>
					<li><a
						style="font-family: 'Megrim', cursive; font-weight: bold;"
						href="<%=request.getContextPath()%>/logout.me"><span
							class="glyphicon glyphicon-log-in"></span> Logout</a></li>
				</ul>
				<%
					} else {
						request.setAttribute("msg", "잘못된 경로로 접근하셨습니다.");
						request.getRequestDispatcher("../common/errorPage.jsp").forward(request, response);
					}
				%>
			</div>
		</div>
	</nav>

	<!-- 내용 -->
	<br>
	<br>
	<br>
	<br>
	<div class="row">

		<%@ include file="myPageMenubar.jsp"%>
	</div>



	<div class="container-fluid text-center">
		<div class="row content" style="border-bottom: 0px;">
			<div class="col-sm-6 form1 well">
				<div class="">
					<h2>프로필</h2>
					<div>
					<form action="<%=request.getContextPath()%>/updateProImg"
						method="post" encType="multipart/form-data">
						<div>
							<!-- 이미지첨부-->
							<div id="fileArea">
								<input type="file" id="profileImg" name="profileImg"
									onchange="loadImg(this)">
							</div>
							&nbsp;&nbsp;&nbsp;
							<!-- 이미지 -->
							<div class="profile img" id="profileImgArea">
								<%
									HashMap<String, Object> hmap = null;
									for (int i = 0; i < list.size(); i++) {
										hmap = list.get(i);
								%>
								<img id="inProfileImg"
									src="/rr/profileImg_upload/<%=hmap.get("changeName")%>"
									width="200px" height="200px">
								<%
									}
								%>
							</div>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

						</div>
						<button type="submit" class="btn btn-warning"
							id="profileImgUpdateBtn" disabled onclick="updateAlert()">
							프로필 사진 변경</button>
					</form>
					</div>
					
					<div>
					<form action="<%=request.getContextPath()%>/updatePro">
						<div class="profile" style="margin-top: 30px;">
							<label>닉네임</label> <br><input type="text" class="form-control" 
								name="nickName" id="nickName" value="<%=hmap.get("nickName")%>"><br><br>
							<label>상태 메세지</label><br>
							<textarea style="resize: none; width: 60%; height: 50px;"
								class="form-control" name="msg" id="msg"><%=hmap.get("msg")%></textarea>
							<br>
						</div>
						<button type="submit" class="btn btn-warning"
							id="profileUpdateBtn" onclick="updateAlert()">프로필 수정</button>
					</form>
					</div>
				</div>
			</div>

			<div class="col-sm-6 form2 well">
				<div class="">
					<h2>개인정보</h2>
					<br>
					<form action="<%=request.getContextPath()%>/updateUser">

						<div class="profile" id="userArea">
							<div class="form-group">
								<label>이메일</label><br> <input type="text" class="form-control"
									value="<%=hmap.get("email")%>" name="email">
							</div>
							<div class="form-group">
								<label>연락처</label><br> <input type="tel" class="form-control"
									value="0<%=hmap.get("phone")%>" name="tel">
							</div>
							<div class="form-group">
								<label>생일</label><br> <input type="date" class="form-control"
									id="birthday" value="<%=hmap.get("birthday")%>" name="birthday">
							</div>
							<div class="form-group">
								<div id="jobArea">
									<input type="text" id="jobText" name="jobText"
										value="<%=hmap.get("job")%>">
								</div>
								<label>직업</label><br> <select class="form-control"
									style="width: 160px; height: 33px; border-radius: 3px 3px 3px 3px; border: 1px solid lightgray;"
									id="job" name="job">
								</select>
							</div>
						</div>
						<button type="submit" class="btn btn-warning" id="userUpdateBtn"
							onclick="updateAlert()">개인정보 수정</button>

					</form>
					<br> <br> <br>

					<button type="button" class="btn btn-danger" data-toggle="modal"
						data-target="#pwdUpdateModal">비밀번호 변경</button>
					&nbsp;&nbsp;
					<button type="button" class="btn btn-danger" data-toggle="modal"
						data-target="#deleteMemberModal">탈퇴</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="pwdUpdateModal" role="dialog">
		<div class="modal-dialog">
			<%@include file="memberPwdUpdateForm.jsp"%>
			<!-- Modal content-->
		</div>
	</div>

	<div class="modal fade" id="deleteMemberModal" role="dialog">
		<div class="modal-dialog">
			<%@include file="memberDeleteForm.jsp"%>
			<!-- Modal content-->
		</div>
	</div>


	<script>
		$(function() {
			$("#fileArea").hide();
			$('#profile').addClass('active');

			$("#profileImgArea").click(function() {
				$("#profileImg").click();

			});

		});

		function loadImg(value) {
			if (value.files && value.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$("#inProfileImg").removeAttr("src");
					$("#inProfileImg").attr("src", e.target.result);
				}
				reader.readAsDataURL(value.files[0]);
				$("#profileImgUpdateBtn").removeAttr("disabled");
				$(".btn-warning").css("background", "#f0ad4e");
			}
		};

		function goProfile() {
			location.href = "/rr/selectPro";
		};

		$(function() {
			$("#jobArea").hide();
			$.ajax({
				url : "jobSelect",
				type : "post",
				success : function(data) {
					$select = $("#job");
					for (var i = 0; i < data.length; i++) {
						var name = decodeURIComponent(data[i].job);
						var selected = (name == $("#jobText").val()) ? "selected": "";
						$select.append("<option value='"+data[i].job+"' "+selected+">"+ name + "</option>");
					}
				}
			});
		});

		function updateAlert() {
			alert("수정이 완료되었습니다 ><");
		};
	</script>

</body>
</html>