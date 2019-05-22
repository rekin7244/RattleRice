<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>SMS 관리</title>
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

.sms {
	display: inline-block;
}

#smsinput>label {
	background: lightgray;
	width: 100px;
	text-align: center;
}

#phone {
	margin-top: -100px;
}

.smsform .sms-text {
	margin-top: -500px;
	margin-left: 30px;
}

#smsinput {
	width: 500px;
	margin-left: 450px;
	margin-top: -450px;
}

.smsform {
	margin: 100px;
}

.smsform #btn button {
	padding: 40px;
}

#btn {
	margin-top: 30px;
	margin-left: 30px;
}
</style>
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
					<a>SMS 발송</a>
				</div>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="nav navbar-nav ml-auto">
						<li class="nav-item active"><a class="nav-link"
							href="<%=request.getContextPath() %>/memberlist.ad">회원관리</a></li>
						<li class="nav-item"><a class="nav-link" 
							href="<%=request.getContextPath()%>/communitylist.ad">커뮤니티</a></li>
						<li class="nav-item"><a class="nav-link" href="calculate.jsp">정산</a></li>
						<li class="nav-item"><a class="nav-link" href="views/admin/sms.jsp">SMS</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath() %>/logout.me">로그아웃</a></li>
					</ul>
				</div>
			</div>
		</nav>

		<br>
		<br>

		<form action="<%=request.getContextPath() %>/smslistInsert.ad"
			method="post">
			<h3>
				<b>문자 보내기</b>
			</h3>
			<br>

			<div class="smsform">
				<%-- <form action="<%=request.getContextPath() %>/smslistInsert.ad" method="post"> --%>
				<img id="phone" src="../../images/smartphone.png" width="320px"
					height="600px">

				<div class="sms-text">
					<textarea autofocus cols="30" rows="10" name="content"></textarea>
				</div>

				<div id="btn">
					<button type="reset">재작성</button>
					<button type="submit">보내기</button>
				</div>

				<div id="smsinput">
					<label>제목</label> <input type="text" placeholder="필수 입력 값이 아닙니다.">
					<br> <label>회신번호</label> <select>
						<option name="from">010-2993-3144</option>
					</select><br> <label>받는사람</label> <input name="to" type="text"
						placeholder="전화번호('-'제외)">
					<button>추가</button>
					<br>
					<textarea cols="40" rows="10"></textarea>
				</div>

			</div>
	</div>
</body>
</form>

</html>