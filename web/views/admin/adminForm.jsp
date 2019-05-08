<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>관리자 페이지</title>
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
						<a>회원 정보 조회</a>
					</div>

					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="nav navbar-nav ml-auto">
							<li class="nav-item active"><a class="nav-link" href="#">회원관리</a></li>
							<li class="nav-item"><a class="nav-link"
								href="community.jsp">커뮤니티</a></li>
							<li class="nav-item"><a class="nav-link"
								href="calculate.jsp">정산</a></li>
							<li class="nav-item"><a class="nav-link" href="sms.jsp">SMS</a></li>
							<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath() %>/logout.me">로그아웃</a></li>
						</ul>
					</div>
				</div>

			</nav>
	<br>
	<br>
	<table class="table table-bordered">

		<thead>
			<tr style="background: lightgray">
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>성별</th>
				<th>휴대폰번호</th>
				<th>등급</th>
			</tr>
		</thead>
		
		<tbody>
			<tr>
				<td>user01</td>
				<td>1234</td>
				<td>강다니엘</td>
				<td>23</td>
				<td>남</td>
				<td>010-1234-1111</td>
				<td>
					<select>
						<option>level1</option>
						<option>level2</option>
						<option>level3</option>
					</select>
					<button>수정</button>
				</td>
			</tr>
			
		</tbody>
	</table>

</body>

</html>