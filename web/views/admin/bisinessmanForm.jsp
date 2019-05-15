<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.kh.rr.member.model.vo.Member, java.util.*"%>
<%
	ArrayList<Member> bisilist = (ArrayList<Member>) request.getAttribute("bisilist");
	ArrayList<Member> bisiSelect = (ArrayList<Member>) request.getAttribute("bisiSelect");
%>
<!DOCTYPE html>
<html>

<head>
<title>회원 관리</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
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
					<a>사업자 정보 조회</a>
				</div>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="nav navbar-nav ml-auto">
						<li class="nav-item active"><a class="nav-link"
							href="<%=request.getContextPath() + "/memberlist.ad"%>">회원관리</a></li>
						<li class="nav-item"><a class="nav-link" href="community.jsp">커뮤니티</a></li>
						<li class="nav-item"><a class="nav-link" href="calculate.jsp">정산</a></li>
						<li class="nav-item"><a class="nav-link" href="sms.jsp">SMS</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath()%>/logout.me">로그아웃</a></li>
					</ul>
				</div>
			</div>

		</nav>
		<br> <br>

		<form action="<%=request.getContextPath()%>/bisinessSelect.ad"> 
			<select name="keyField" id="keyField">
				<option value="0">정렬</option>
				<option value="M_ID">아이디</option>
				<option value="M_NAME">이름</option>
			</select> <input type="text" placeholder="검색어 입력" id="keyword" name="keyword">
			<button type="button" id="keywordclick">검색</button>
			
		 </form>


		<form action="<%=request.getContextPath()%> /bisinesslist.ad"
			method="post">

			<table class="table table-bordered" id="bisinesslist">

				<thead>
					<tr style="background: lightgray" align="center">
						<th><input type="checkbox" id="checkmember"></th>
						<th>번호</th>
						<th>아이디</th>
						<!-- <th>비밀번호</th> -->
						<th>사업자번호</th>
						<th>상호명</th>
						<th>사업자명</th>
						<th>계좌</th>
						<th>휴대폰번호</th>
						<th>등급</th>
					</tr>

				</thead>

				<%-- <% System.out.println(bisilist); %> --%>



				<%
					if (bisilist != null) {
				%>
				<%
					for (int i = 0; i < bisilist.size(); i++) {
				%>


				<tbody id="bisinesslistFrom">
					<tr>
						<td><input type="checkbox" id="checkmember"></td>
						<td>1</td>
						<td><%=bisilist.get(i).getUserId()%></td>
						<%-- <td><%= bisilist.get(i).getUserPwd() %></td> --%>
						<td>123-456789-123456</td>
						<td>홍콩반점</td>
						<td><%=bisilist.get(i).getUserName()%></td>
						<td><button>상세보기</button></td>
						<td>010-1111-1111</td>
						<td><select>
								<option>level1</option>
								<option>level2</option>
								<option>level3</option>
						</select> &nbsp; &nbsp;
							<button>수정</button></td>
				</tbody>


				<%
					}
					} else {
				%>
				<tr>
					<td colspan="9" align="center">저장된 값이 없습니다.</td>
				</tr>
				<%
					}
				%>
			
	</div>

	<!-- 		 <tbody align="center">
				<tr>
					<td><input type="checkbox" id="checkmember"></td>
					<td>1</td>
					<td>user100</td>
					<td>1234</td>
					<td>123-456789-123456</td>
					<td>홍콩반점</td>
					<td>백종원</td>
					<td><button>상세보기</button></td>
					<td>010-1111-1111</td>
					<td><select>
							<option>level1</option>
							<option>level2</option>
							<option>level3</option>
					</select> &nbsp; &nbsp;
						<button>수정</button></td>

			</tbody> -->
	</table>
	</form>
</body>
<script>
	$("#keywordclick")
			.click(
					function() {
						//var keyword
						//var keyfield
						var blist = $("#bisinesslist");
					
					
						/* console.log("실행"); */
						$.ajax({
									url : "bisinessSelect.ad",
									//data : key,val
									success : function(data) {

										$(blist).children('#bisinesslistFrom')
												.remove(); 
										
										console.log(data);
										
										for(var key in data){
									 	var user = data[key];
									 	console.log(user.userId);
									 	
									 	$(blist).append('<tr>');
									 	$(blist).append('<td><input type="checkbox" id="checkmember"></td>');
										$(blist).append('<td>1</td>');
										$(blist).append(user.userId);
										$(blist).append('<td>123-456789-123456</td>');
										$(blist).append('<td>홍콩반점</td>');
										$(blist).append(user.userName);
										$(blist).append('<td><button>상세보기</button></td>');
										$(blist).append('<td>010-1111-1111</td>');
										$(blist).append('<td><select><option>level1</option></select></select> &nbsp; &nbsp;<button>수정</button></td>');
										$(blist).append('</tr>');
										}
									
										

									},
									error : function() {
										colsole.log("실패");
									}
								})

					})
</script>

</html>