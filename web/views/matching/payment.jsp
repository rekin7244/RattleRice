<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Sematic UI -->
<script src="/rr/js/semantic.min.js"></script>
<link rel="stylesheet" href="/rr/css/semantic.min.css">
<!-- 부트스트랩 -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<!-- 메뉴바 스타일 -->
<link rel="stylesheet" type="text/css" href="../../css/matching/bar.css">
<title>Insert title here</title>
<script>
	$(function() {
		$(window).resize(function() {
			window.resizeTo(410, 600);
		});
	});
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<%@ include file="menubar.jsp"%>
</body>
</html>