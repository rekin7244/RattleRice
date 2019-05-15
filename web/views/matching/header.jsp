<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<style>
#menu i {
	font-size: 1.7em;
	color: white;
}

#header i {
	font-size: 1.5em;
	color: white;
}

#header .search {
	float: right;
	position: absolute;
}

.navbar-nav {
	margin: 0;
}

.mainbar>li {
	display: inline-block;
	width: 24%;
	text-align: center;
}

.navbar {
	background: #1ABC9C;
}
/* 마이페이지 css */
ul, body {
	margin: 0 !important;
}

.cash>div>a {
	text-decoration: none;
	color: black;
}

.img i {
	font-size: 1.3em;
	margin-left: 0.3em;
}

.content {
	padding: 15px;
	margin-bottom: 14%;
	margin-top: 15%;
}

.content .line>div {
	display: inline-block;
	margin-top: 20px;
}

.line {
	margin: 0 5%;
}

.pay {
	margin: 0 5%;
}

.title {
	width: 30%;
	font-weight: bold;
}

.line .contents {
	border: none;
	width: 67%;
}

.img .icon {
	font-size: 1.5em;
	color: red;
}
</style>
</head>
<nav class="navbar navbar-default navbar-fixed-top"
	style="padding: 3px 0">
	<div class="container">
		<div id="header">
		<!-- 채팅방에 입장했을때 : rno는 방번호 입니다 -->
			<%if(request.getParameter("rno") != null) { %>
				<ul class="nav navbar-nav mainbar">
					<li class="" style="left: -3%;"><a href="<%= request.getContextPath()%>/selectAll.cr"
					style="padding: 0;margin-top: 9px;">
					<i class="fas fa-sign-out-alt" style="font-size:1.8em;"></i></a></li>
					<li data-toggle="modal" data-target="#chatSub" class="search"
						style="right: 0%;"><a href="#chatSub">
						<i class="fas fa-bars"></i></a></li>
				</ul>
			<%}else if(request.getParameter("info") != null){ %>
				<!-- 채팅방이 아닌 나머지 경우 -->
				<ul class="nav navbar-nav mainbar">
					<li class="" style="left: -3%;"><a href="<%= request.getContextPath()%>/selectAll.cr">
					<i class="fas fa-arrow-left"></i></a></li>
				</ul>
			<%}else{ %>
				<ul class="nav navbar-nav mainbar">
					<li class="" style="left: -3%;"><a href="<%= request.getContextPath()%>/selectAll.cr">
					<i class="fas fa-arrow-left"></i></a></li>
					<li data-toggle="modal" data-target="#msearch" class="search"
						style="right: 0%;"><a href="#msearch">
						<i class="fas fa-bars"></i></a></li>
					<li data-toggle="modal" data-target="#ksearch" class="search"
						style="right: 13%;"><a href="#ksearch">
						<i class="fas fa-search"></i></a></li>
				</ul>
			<%} %>
		</div>
	</div>
</nav>