<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.kh.rr.member.model.vo.Member, java.util.*"%>
<%
	ArrayList<Member> bmlist = (ArrayList<Member>)request.getAttribute("bmlist");
%>
<!DOCTYPE html>
<html>
<head>
<title>회원 관리</title>
</head>

<body>
	<%@ include file="menubar_admin.jsp"%>
	<!-- Page Content  -->
	<div id="content">

		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">

				<button type="button" id="sidebarCollapse" class="btn btn-info">
					<i class="fas fa-align-left"></i> <span> menu</span>
				</button>


				<button class="btn btn-dark d-inline-block d-lg-none ml-auto"
					type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<i class="fas fa-align-justify"></i>
				</button>
				&nbsp; &nbsp;
				<div id="mainbar">
					<a>탈퇴 회원 조회</a>
				</div>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="nav navbar-nav ml-auto">
						<li class="nav-item active"><a class="nav-link" href="adminForm.jsp">회원관리</a></li>
						<li class="nav-item"><a class="nav-link" href="community.jsp">커뮤니티</a></li>
						<li class="nav-item"><a class="nav-link" href="calculate.jsp">정산</a></li>
						<li class="nav-item"><a class="nav-link" href="sms.jsp">SMS</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath() %>/logout.me">로그아웃</a></li>
					</ul>
				</div>
			</div>

		</nav>
		<br> <br> 
		
		<form action="<%=request.getContextPath() %>/memberSelect.ad" > 
			<select name="keyField" id="keyField">
				<option value="0">정렬</option>
				<option value="M_ID">아이디</option>
				<option value="M_NAME">이름</option>
			</select> <input type="text" placeholder="검색어 입력" id="keyword" name="keyword">
			<button type="button" id="keywordclick">검색</button>
			
		 </form>
		
		<table class="table table-bordered" id="memberlist">
		
		<form id="NonMemberlist"
			action="<%= request.getContextPath() %>/nonMember.ad" method="post">

			<thead>
				<tr style="background: lightgray" align="center">
					<th><input type="checkbox" id="checkmember"></th>
					<th>번호</th>
					<th>아이디</th>
					<!-- <th>비밀번호</th> -->
					<th>이름</th>
					<th>성별</th>
					<th>휴대폰번호</th>
					<th>이메일</th>
					<!-- <th>등급</th>
					<th>마지막 접속일</th>
					<th>탈퇴사유</th>
					<th>상태</th> -->
				</tr>
			</thead>
			
			<% if(bmlist != null){
			   			for (int i = 0; i<bmlist.size(); i++){ 
			   				
			   			 String gender = "";
						 if(bmlist.get(i).getGender().equals("F")){
						 gender="여자";
						 }else{
						 gender="남자";}
						 
			   			%>

			<tbody align="center"  id="memberlistFrom">
				<tr>
					<th><input type="checkbox" id="checkmember"></th>
					<td><%= i + 1 %></td>
					<td><%= bmlist.get(i).getUserId() %></td>					
					<td><%= bmlist.get(i).getUserName() %></td>					
					<td><%=gender %></td>
					<td><%=bmlist.get(i).getPhone() %></td>
					<td><%=bmlist.get(i).getEmail() %>
					<!-- <td>해야함</td>	
					<td>2019-05-08 15:02:00</td>		
					<td>서비스 불만</td>
					<td><button>확인</button></td> -->
				</tr>
				<% }
			}else{
			   			%>
			   			<tr>
					<td colspan="6" align="center">저장된 값이 없습니다.</td>
				</tr>
				<%} %>
			   		<tr>
			
			</tbody>
		</table>
</body>

<script>
	$("#keywordclick")
			.click(
					function() {
						
					
						var keyField = $("#keyField").val();	
						var keyword = $("#keyword").val();	
						var list = $("#memberlist");
						var gender="";
						
						var search = {keyField:keyField, keyword:keyword};
						console.log(search);
						
						$.ajax({
									url : "memberSelect.ad",
									data:search,
									type:"get",
									success : function(data) {

										console.log(data);
										$(list).children('#memberlistFrom')
												.remove(); 
										
										for(var key in data){
											var user = data[key];
											if(user.gender == "F"){
												gender="여자";
											}else{
												gender="남자";
											}
										
										$(list).append('<tr>');
										$(list).append('<td><input type="checkbox" id="checkmember"></td>');
										$(list).append('<td>1</td>');
										$(list).append('<td>' + user.userId + '</td>');
										$(list).append('<td>' + user.userName + '</td>');
										$(list).append('<td>' + gender + '</td>');
										$(list).append('<td>' + user.phone + '</td>');
										$(list).append('<td>' + user.email + '</td>,');
										
											
										}
										
								
										

									},
									error : function() {
										colsole.log("실패");
									}
								}) 

					})
</script>

</html>