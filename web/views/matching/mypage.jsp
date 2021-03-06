<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.rr.member.model.vo.*,java.util.*,com.kh.rr.transaction.model.vo.*"%>
<% 
	Member loginUser = (Member) session.getAttribute("loginUser");
	ArrayList<HashMap<String, Object>> list = (ArrayList<HashMap<String, Object>>) request.getAttribute("list");
	ArrayList<Transaction> trList = (ArrayList<Transaction>)request.getAttribute("trList");
	
	HashMap<String, Object> hmap = null;
	for (int i = 0; i < list.size(); i++) {
		hmap = list.get(i);
	}
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 부트스트랩 -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<!-- 메뉴바 스타일 -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
<script>
	$(function() {
		$(window).resize(function() {
			window.resizeTo(410, 600);
		});
		
		$(".cash").click(function(){
			location.href="<%= request.getContextPath()%>/selectAll.tr"
		});
	});
</script>
<title>Insert title here</title>
<style>
	body::-webkit-scrollbar { 
	    display: none; 
	}
	.pay:hover {
		cursor: pointer;
	}
	.img {
		width:155px;
		margin:0 auto;
	}
</style>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="content bar">

		<div class="img" align="center">
			<img src="/rr/profileImg_upload/<%=hmap.get("changeName")%>" style="width:100%; border-radius:6em;"><br>
			<!-- 성별별로 아이콘 다르게 나옴 -->
		<%-- 	<p>
			<%if(loginUser.getGender().equals("M")){ %>
				<i class="fas fa-mars" style="color:blue;"></i><%=loginUser.getUserName() %>
			<%}else{ %>
				<i class="fas fa-venus" style="color:red;"></i><%=loginUser.getUserName() %>
			<%} %>
			</p> --%>
		</div>
		<form action="<%= request.getContextPath()%>/update.ui" method="get">
			<input type="hidden" name="nickName" value="<%= hmap.get("nickName")%>">
			<div class="info line">
				<div class="title">
					<label for="status">상태메세지</label>
				</div>
				<div class="contents">
					<input type="text" class="form-control" id="status"
						placeholder="상태메세지를 입력해주세요." name="msg" value="<%= hmap.get("msg")%>">
				</div>
			</div>
			<div class="job line">
				<div class="title">
					<label for="job">직업</label>
				</div>
				<div class="contents" style="border: none;">
					<input type="text" class="form-control" id="job" value="<%=hmap.get("job") %>"
						readonly>
				</div>
			</div>
			<div class="age line">
				<div class="title">
					<label for="age">나이</label>
				</div>
				<div class="contents" style="border: none;">
					<input type="text" class="form-control" id="age" value="<%=hmap.get("birthday") %>"
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
				<label><i class="bell icon"
						style="color: gold"></i>보유 bell </label> <label><span
						style="color: #4abeca;"><%=hmap.get("bell") %></span>벨</label>
				
			</div>
			<div class="point pay">
				<label><i
						class="money bill alternate icon" style="color: gold"></i>보유 Point
				</label> <label><span style="color: #4abeca;"><%=hmap.get("point") %></span>포인트</label>
				
			</div>
		</div>

	</div>

	<%@ include file="menubar.jsp"%>
</body>
</html>