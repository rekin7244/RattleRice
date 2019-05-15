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

#sidebar ul{
border: 1px solid black;
}
</style>
</head>
<body>
	<div id="jb-header">
		<h1>내 정보</h1>
	</div>
	<nav id="sidebar">
		<ul class="list-unstyled components">
			<li><a onclick="goProfile()" style="cursor: pointer;">마이페이지</a></li>
			<li><a
				href="<%=request.getContextPath()%>/views/member/myWriteForm.jsp">작성글
					조회</a></li>
			<li><a
				href="<%=request.getContextPath()%>/views/member/myPointForm.jsp">포인트</a></li>
		</ul>
	</nav>
</body>
<script>
	function goProfile() {
		location.href = "/rr/selectPro";
	};
</script>
</html>