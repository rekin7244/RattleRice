<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 인증 등록</title>
</head>
<body>
	<%@ include file="menubar_admin.jsp"%>
	<!-- nav -->
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
					<a>정산 설정</a>
				</div>

				<iframe name='action' width="0" height="0" frameborder="0"
					scrolling='yes'></iframe>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="nav navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath() + "/memberlist.ad"%>">회원관리</a></li>
						<li class="nav-item active"><a class="nav-link"
							href="<%=request.getContextPath() %>/views/admin/updateMainForm.jsp">커뮤니티</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath() %>/views/admin/coinRecord.jsp">정산</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath() %>/views/admin/sms.jsp">SMS</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath()%>/logout.me">로그아웃</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<br>

		<div class="outer">
			<button onclick="authorize()">인증 및 계좌 등록</button>
		</div>
	</div>


</body>
<script>
	var authData = {
			response_type:"code",
			client_id:"l7xxd9be245c44cd42f6bcb18778877284a5",
			redirect_uri:"http://localhost:8001/rr/views/admin/regSettlement.jsp",
			scope:"login transfer inquiry",
			client_info:"testInfo"
		};
	
	var cbackWindow;
	function authorize() {
		console.log("<%=request.getContextPath()%>");
		$.ajax({
			url:"https://testapi.open-platform.or.kr/oauth/2.0/authorize2",
			type:"get",
			data:authData,
			success:function(data) {
				console.log(data);
				/* cbackWindow = open('about:blank');
				cbackWindow.document.write(data); */
				document.write(data);
			},
			error:function(data) {
				console.log("실패");
			}
		});
	}
</script>
</html>