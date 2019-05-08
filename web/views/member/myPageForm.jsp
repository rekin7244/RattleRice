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

<script>
	function fnMove(seq) {
		var offset = $("#div" + seq).offset();
		$('html, body').animate({
			scrollTop : offset.top
		}, 800);
	}
</script>
<style>
img {
	width: 100%;
}

#bg-img {
	height: 650px;
	background-image: url('images/main.jpg');
	background-repeat: no-repeat;
	background-size: cover;
	background-position: 50% 50%;
	background-attachment: fixed;
}

#bgtext {
	transition-duration: 1s;
}

#bgtext:hover {
	color: orangered;
	text-shadow: 3px 3px orange;
	font-weight: bold;
	font-size: 100px;
}

#bgtext {
	padding: 100px;
	padding-left: 70px;
	text-align: center;
	color: white;
	font-size: 53px;
	font-family: 'Megrim', cursive;
	text-shadow: 0px 0px 10px #000, 0px 0px 10px #000, 0px 0px 10px #000,
		0px 0px 10px #000, 0px 0px 10px #000;
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
	padding: 10px;
	text-align: center;
	background: yellowgreen;
}
/* 우측하단 채팅방 아이콘 고정 */
.fixed {
	position: fixed;
	top: 90%;
	right: 3%;
}

.fixed .far {
	font-size: 3em;
}

body::-webkit-scrollbar {
	display: none;
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
	<br>
	<br>
	<br>
	<br>





	<br>
	<br>


	<br>
	<br>

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
		} else {
	%>
	<%
		}
	%>
	<div class="footer">
		<%@ include file="../common/footer.jsp"%>
	</div>

</body>
</html>