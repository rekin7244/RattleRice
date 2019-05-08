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
					<a>사업자 정보 조회</a>
				</div>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="nav navbar-nav ml-auto">
						<li class="nav-item active"><a class="nav-link" href="#">회원관리</a></li>
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
		<select>
			<option>정렬</option>
		</select> <input type="text">
		<button>검색</button>
		<table class="table table-bordered">

			<thead>
				<tr style="background: lightgray" align="center">
					<th><input type="checkbox" id="checkmember"></th>
					<th>번호</th>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>사업자번호</th>
					<th>상호명</th>
					<th>사업자명</th>
					<th>계좌</th>
					<th>휴대폰번호</th>
					<th>등급</th>
				</tr>
			</thead>

			<tbody align="center">
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
				</tr>

			</tbody>
		</table>
</body>

</html>