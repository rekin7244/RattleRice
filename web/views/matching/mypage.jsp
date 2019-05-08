<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.rr.member.model.vo.*"%>
<% 
	UserInfo reqUi = (UserInfo) request.getAttribute("reqUi");
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Sematic UI -->
<script src="/rr/js/semantic.min.js"></script>
<link rel="stylesheet" href="/rr/css/semantic.min.css">
<!-- 부트스트랩 -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<!-- 메뉴바 스타일 -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
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

	<div class="content bar">

		<div class="img" align="center">
			<img src="<%=request.getContextPath() %>/images/profile.PNG"><br>
			<!-- 성별별로 아이콘 다르게 나옴 -->
			<p>
			<%if(reqUi.getGender().equals("M")){ %>
				<i class="fas fa-mars" style="color:blue;"></i><%=reqUi.getNickName() %>
			<%}else{ %>
				<i class="fas fa-venus" style="color:red;"></i><%=reqUi.getNickName() %>
			<%} %>
			</p>
		</div>
		<form action="<%= request.getContextPath()%>/update.ui" method="get">
			<input type="hidden" name="nickName" value="<%= reqUi.getNickName()%>">
			<div class="info line">
				<div class="title">
					<label for="status">상태메세지</label>
				</div>
				<div class="contents">
					<input type="text" class="form-control" id="status"
						placeholder="상태메세지를 입력해주세요." name="msg" value="<%= reqUi.getMsg()%>">
				</div>
			</div>
			<div class="job line">
				<div class="title">
					<label for="job">직업</label>
				</div>
				<div class="contents" style="border: none;">
					<input type="text" class="form-control" id="job" value="<%=reqUi.getJob() %>"
						readonly>
				</div>
			</div>
			<div class="age line">
				<div class="title">
					<label for="age">나이</label>
				</div>
				<div class="contents" style="border: none;">
					<input type="text" class="form-control" id="age" value="<%=reqUi.getAge() %>"
						readonly>
				</div>
			</div>
			<br> <br>
			<div class="line" align="right">
				<button type="submit" class="btn btn-default">변경</button>
			</div>
		</form>

		<br>

		<div class="cash">
			<div class="coin pay">
				<a href="payment.jsp"> <label><i class="bell icon"
						style="color: gold"></i>보유 bell </label> <label><span
						style="color: #4abeca;">10</span>벨</label>
				</a>
			</div>
			<div class="point pay">
				<a href="payment.jsp"> <label><i
						class="money bill alternate icon" style="color: gold"></i>보유 bill
				</label> <label><span style="color: #4abeca;">10000</span>빌</label>
				</a>
			</div>
		</div>

	</div>

	<%@ include file="menubar.jsp"%>
</body>
</html>