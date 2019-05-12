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
	width: 250px;
	position: fixed;
	top: 0;
	left: 0;
	height: 100vh;
	z-index: 999;
	color: black;
	transition: all 0.3s;
}

/* page표시 */
#sidebar .sidebar-header {
	padding: 70px;
}

#sidebar ul.components {
	padding: 20px 0;
}

#sidebar ul p {
	color: black;
	padding: 10px;
}

#sidebar ul li a {
	padding: 10px;
	font-size: 1.1em;
	display: block;
	text-align: center;
}

#sidebar ul li a:hover {
	color: black;
	background: lightgray;
}

a[data-toggle="collapse"] {
	position: relative;
}

#content {
	width: calc(100% - 250px);
	padding: 40px;
	min-height: 100vh;
	transition: all 0.3s;
	position: absolute;
	top: 10;
	right: 0;
	padding: 0;
}

#jb-header {
	text-align: center;
	border-bottom: 1px solid black;
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

.content {
	border: 1px solid black;
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
	float: left;
}

.form1, .form2 {
	margin-top: 30px;
}

.form1 {
	padding-left: 30px;
}

.form2 {
	padding-right: 30px;
}

.img {
	width: 200px;
	height: 200px;
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

#profileUpdateBtn {
	margin-right: 50px;
}

#userUpdateBtn {
	
}

.profile {
	/* border: 1px solid red; */
	
}

#userArea {
	margin-left: 210px;
	margin-right: 210px;
}
.form-control{
width: 300px;
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
						style="font-family: 'Megrim', cursive; font-weight: bold;"><%=loginUser.getUserId()%>님</a></li>
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
	<div id="jb-header">
		<h1>마이페이지</h1>
	</div>
	<div class="wrapper">

		<!-- Sidebar  -->
		<nav id="sidebar">
			<div class="sidebar-header"></div>
			<ul class="list-unstyled components">
				<p>
					<b>메뉴</b>
				</p>
				<li><a class="active" onclick="goProfile()"
					style="cursor: pointer;">마이페이지</a></li>
				<li><a href="myWriteForm.jsp">작성글 조회</a></li>
				<li><a href="myPointForm.jsp">포인트</a></li>
			</ul>
		</nav>
	</div>




	<div class="container-fluid text-center">
		<div class="row content" style="border-bottom: 0px;">
			<div class="col-sm-2 sidenav"></div>
			<div class="col-sm-5 form1">
				<div class="well">
					<h2>프로필 설정</h2>
					<br>
					<form action="<%=request.getContextPath()%>/updatePro"
						method="post" encType="multipart/form-data"
						style="margin-left: 80px;">
						<div style="display: table-cell;">
							<!-- 이미지첨부-->
							<div id="fileArea">
								<input type="file" id="profileImg" name="profileImg"
									onchange="loadImg(this)">
							</div>
							&nbsp;&nbsp;&nbsp;
							<!-- 이미지 -->
							<div class="profile img"
								style="vertical-align: middle; border: 0px; margin-right: 50px; margin-top: 50px;"
								id="profileImgArea">
								<%
									for (int i = 0; i < list.size(); i++) {
										HashMap<String, Object> hmap = list.get(i);
								%>
								<img id="inProfileImg"
									src="/rr/profileImg_upload/<%=hmap.get("changeName")%>"
									width="200px" height="200px">
								<%
									}
								%>
							</div>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<div class="profile">
								<div class="form-group">
									<label>닉네임</label> <input type="text"
										class="form-control" id="nickName">
								</div>
								<div class="form-group">
									<label>상태 메세지</label>
									<textarea style="resize: none; width: 300px; height: 50px;"
										class="form-control" id="message"></textarea>
								</div>
								<div class="form-group">
									<label>생일</label> <input type="date"
										class="form-control" id="birthday">
								</div>
								<div class="form-group">
									<label>직업</label> <input type="text"
										class="form-control" id="job">
								</div>

							</div>
						</div>
						<button type="submit" class="btn btn-warning"
							id="profileUpdateBtn">수정</button>
					</form>
				</div>
			</div>

			<div class="col-sm-5 form2">
				<div class="well">
					<div>
						<h2>개인정보 수정</h2>
						<br>
						<form>

							<div class="profile" id="userArea">
								<div class="form-group">
									<label>이메일</label> <input type="email" class="form-control"
										id="usr">
								</div>
								<div class="form-group">
									<label>비밀번호</label> <input type="password" class="form-control"
										id="usr">
								</div>
								<div class="form-group">
									<label>연락처</label> <input type="tel" class="form-control"
										id="usr">
								</div>
							</div>
							<button type="submit" class="btn btn-warning" id="userUpdateBtn">수정</button>

						</form>


					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 채팅접속 아이콘 -->
	<%
		if (loginUser != null) {
	%>
	<div class="fixed">
		<a
			onclick="window.open('<%=request.getContextPath()%>/selectAll.ma', '', 'top=50px, left=800px, height=500, width=400')">
			<i class="far fa-comment"></i>
		</a>
	</div>
	<%
		}
	%>

	<script>
		$(function() {
			$("#fileArea").hide();

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
			}
		};

		function goProfile() {
			location.href = "/rr/selectPro";
		};
	</script>

</body>
</html>