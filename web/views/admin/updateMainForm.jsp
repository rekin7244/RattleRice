<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지 관리</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<style>
thead {
	background: lightgray;
	align: center;
}

td {
	text-align: center;
}
</style>
<script>
	$(function(){
		$.ajax({
			url:"<%=request.getContextPath()%>/indexInfo.if",
			type:"get",
			success:function(data){
				$("#contactTd").text(data.contact);
				$("#introTd").text(data.sInfo);
				$("#termsArea").html(data.terms);
			}
		});
	});
</script>
</head>
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
					<a>메인페이지</a>
				</div>

				<iframe name='action' width="0" height="0" frameborder="0"
					scrolling='yes'></iframe>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="nav navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link" href="adminForm.jsp">회원관리</a></li>
						<li class="nav-item active"><a class="nav-link"
							href="community.jsp">커뮤니티</a></li>
						<li class="nav-item"><a class="nav-link" href="calculate.jsp">정산</a></li>
						<li class="nav-item"><a class="nav-link" href="sms.jsp">SMS</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath()%>/logout.me">로그아웃</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<!-- updateForm -->
		<div class="outer">
			<form action="<%=request.getContextPath()%>/updateSiteInfo.if" method="get">
				<table class="table table-bordered">
					<thead>
						<tr align="center">
							<th>연락처</th>
							<th>사업체 소개</th>
							<th>수정</th>
						</tr>
					</thead>
					<tr>
						<td id="contactTd"></td>
						<td id="introTd"></td>
						<td></td>
					</tr>
					<tr>
						<td><input type="text" name="aContact" /></td>
						<td><input type="text" name="aIntro" /></td>
						<td><button type="submit">수정</button></td>
					</tr>
				</table>
			</form>
		</div>
		<div class="termsTextArea">
			<form action="<%=request.getContextPath()%>/updateTerms.if" method="get">
				<h2>약관 수정</h2>
				<textarea name="termsArea" id="termsArea" cols="70" rows="10"></textarea>
				<button type="submit">약관 수정</button>
			</form>
		</div>
	</div>
	<!-- content area end -->


</body>
</html>