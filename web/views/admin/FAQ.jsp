<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>커뮤니티 관리</title>
<style>
/* ---------------------------------------------------
    CONTENT STYLE
----------------------------------------------------- */
#content {
	width: calc(100% - 250px);
	padding: 40px;
	min-height: 100vh;
	transition: all 0.3s;	
	position: absolute;
	top: 10;
	right: 0;
}

#content.active {
	width: 100%;
}

#mainbar {
	background-color: lightgreen;
	font-size: 1.5em;
	padding: 5px;
	border-radius: 10px;
}

#update{
	margin-left:1500px;
	padding:10px;
}

#img{
	width:20px;
	height:20px;
}

</style>
</head>

<body>
	<%@ include file="menubar_admin.jsp" %>
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
					<a>Q & A</a>
				</div>

				<iframe name='action' width="0" height="0" frameborder="0"
					scrolling='yes'></iframe>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="nav navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link" href="adminForm.jsp">회원관리</a></li>
						<li class="nav-item active"><a class="nav-link" href="community.jsp">커뮤니티</a></li>
						<li class="nav-item"><a class="nav-link" href="calculate.jsp">정산</a></li>
						<li class="nav-item"><a class="nav-link" href="sms.jsp">SMS</a></li>
						<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath() %>/logout.me">로그아웃</a></li>
					</ul>
				</div>
			</div>

		</nav>
		
	<br><br>
	
	    <button id="update">글 등록</button>
		
		<div class="page-wrapper">
			<div class="container-fluid">
				<div class="col-lg-8">
					<!--게시판 넓이 -->

				</div>
				<div class="panel panel-default">
					<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>글번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일</th>
									<th>조회수</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>포인트 환불받을 수 있나요?</td>
									<td>user01</td>
									<td>2018-03-01 19:31</td>
									<td>196</td>
								</tr>
								<tr>
									<td>2</td>
									<td><img id="img" src="../../images/enter-arrow.png"> 포인트 환불받을 수 있나요?</td>
									<td>관리자</td>
									<td>2019-03-02 12:10</td>
									<td>56</td>
								</tr>
								<tr>
									<td>3</td>
									<td>방이 안들어가져요</td>
									<td>loveje</td>
									<td>2019-05-09 11:11</td>
									<td>18</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>

</html>