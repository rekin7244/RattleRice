<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<style>
.components li {
	display: inline-block;
	width: 33%;
}

#sidebar ul {
	border: 1px solid black;
}

#sidebar ul li a {
	padding: 10px;
	font-size: 1.1em;
	display: block;
	text-align: center;
	width: 100.9%;
}
#sidebar ul p {
	color: black;
	padding: 10px;
}


#sidebar ul li a:hover {
	color: black;
	background: lightgray;
}
</style>
</head>
<body>
	<div id="jb-header">
		<h1>내 정보</h1>
	</div>
	<nav id="sidebar">
		<ul class="list-unstyled components">
			<li><a id="profile" onclick="goProfile()"
				style="cursor: pointer;">마이페이지</a></li>
			<li><a id="write" onclick="gotBoard()" style="cursor: pointer;">작성글
					조회</a></li>
			<li><a id="point" onclick="goPoint()" style="cursor: pointer;">포인트</a></li>
		</ul>
	</nav>
</body>
<script>
	function goProfile() {
		location.href = "/rr/selectPro";
	};
	 function gotBoard() {
		location.href = "/rr/selectWrite";
	}; 
	function goPoint() {
		location.href = "/rr/selectPoint";
	};
</script>
</html>