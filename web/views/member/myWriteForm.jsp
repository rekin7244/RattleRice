<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.rr.member.model.vo.Member"%>

<%
	Member loginUser = (Member) session.getAttribute("loginUser");
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
	padding: 10px;
	text-align: center;
	background: yellowgreen;
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
	font-family: 'Poppins', sans-serif;
	background: #fafafa;
	overflow: hidden
}

/* 메뉴 */
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
.container-fluid{
padding: 0;
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
		<h1>작성글 조회</h1>
	</div>
	<div class="wrapper">

		<!-- Sidebar  -->
		<nav id="sidebar">
			<div class="sidebar-header"></div>
			<ul class="list-unstyled components">
				<p>
					<b>메뉴</b>
				</p>
				<li><a href="myPageForm.jsp">마이페이지</a></li>
				<li><a href="myWriteForm.jsp" class="active">작성글 조회</a></li>
				<li><a href="myPointForm.jsp">포인트</a></li>
			</ul>
		</nav>
	</div>

	<!-- Page Content  -->
	<div id="content">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
				<div id="jb-content">
					<h2>Content</h2>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Aenean nec mollis nulla. Phasellus lacinia tempus mauris eu
						laoreet. Proin gravida velit dictum dui consequat malesuada.
						Aenean et nibh eu purus scelerisque aliquet nec non justo. Aliquam
						vitae aliquet ipsum. Etiam condimentum varius purus ut ultricies.
						Mauris id odio pretium, sollicitudin sapien eget, adipiscing
						risus.</p>
				</div>
			</div>
		</nav>
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

</body>
</html>