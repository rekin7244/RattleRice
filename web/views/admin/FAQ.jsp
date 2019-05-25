<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.kh.rr.board.model.vo.Board"%>
<%
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>커뮤니티 관리</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
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
	
	padding:10px;
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
					<a>FAQ</a>
				</div>

				<iframe name='action' width="0" height="0" frameborder="0"
					scrolling='yes'></iframe>

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
		
	<br><br>
	
	    
		<div class="page-wrapper">
			<div class="container-fluid">
				<div class="col-lg-8">
 					<!--게시판 넓이 -->
 	
				</div>
				<div class="panel panel-default">
					<div class="panel-body">
					<button id="update"
					onclick = "location.href='views/admin/FAQInsert.jsp'">글 등록</button>
						
				
						<table class="table table-hover" id="listArea">
						
							
								<tr>
									<th>글번호</th>
									<th>구분</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일</th>
									<th>조회수</th>
								</tr>
							
							
							
							 <% for(int i = 0; i<list.size(); i++){ %>
							<tr>
								<td><%=list.get(i).getFbid() %></td>
								<td><%=list.get(i).getfCategory()%></td>
								<td><%=list.get(i).getTitle() %></td>
								<td><%=list.get(i).getWriter() %></td>
								<td><%=list.get(i).getbDate() %></td>
								<td><%=list.get(i).getbCount() %></td>
							</tr>
							<% } %> 
					
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	
<script>
	$(function(){
		$("#listArea td").click(function(){
			 var num = $(this).parent().children().eq(0).text();
			
			console.log(num);
			
			location.href = "<%=request.getContextPath()%>/FAQselectOne.ad?num=" + num;
		})
	})
</script>

</body>

</html>