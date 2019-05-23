<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.kh.rr.transaction.model.vo.Transaction"%>
<%
	ArrayList<Transaction> list = (ArrayList<Transaction>) request.getAttribute("list");
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

					<a>결제 내역 조회</a>
				</div>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="nav navbar-nav ml-auto">
						<li class="nav-item active"><a class="nav-link"
							href="<%=request.getContextPath()%>/memberlist.ad">회원관리</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath()%>/communitylist.ad">커뮤니티</a></li>
						<li class="nav-item"><a class="nav-link" href="calculate.jsp">정산</a></li>
						<li class="nav-item"><a class="nav-link"
							href="views/admin/sms.jsp">SMS</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath()%>/logout.me">로그아웃</a></li>
					</ul>
				</div>
			</div>

		</nav>
		<br> <br>

		<form action="<%=request.getContextPath()%>/paymentlist.ad"
			method="post">

			<table class="table table-bordered" id="paylist">
				<thead>
					<tr style="background: lightgray" align="center">
						<th><input type="checkbox" id="checkmember"></th>
						<th>번호</th>
						<th>아이디</th>
						<th>거래일시</th>
						<th>거래금액</th>
						<th>구분</th>
						<th>상태</th>
					</tr>
				</thead>

				<%
					if (list != null) {
						for (int i = 0; i < list.size(); i++) {
				%>

				<tbody align="center">
					<tr>
						<th><input type="checkbox"></th>
						<td><%=i + 1%></td>
						<td><%=list.get(i).getUserId()%></td>
						<td><%=list.get(i).gettDate()%></td>
						<td><%=list.get(i).gettPrice()%></td>
						<td><%=list.get(i).getType()%></td>
						<td><%=list.get(i).getUnit()%></td>
						<td style="color: orange;">결제완료</td>
					</tr>
					<%
						}
						} else {
					%>
					<tr>
						<td colspan="7" align="center">저장된 값이 없습니다.</td>
					</tr>
					<%
						}
					%>

				</tbody>
			</table>
		</form>
</body>

</html>