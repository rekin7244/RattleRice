<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.kh.rr.board.model.vo.Board"%>
<%
	Board community = (Board)request.getAttribute("community");
%>
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

/* #content.active {
	width: 100%;
} */

#mainbar {
	background-color: lightgreen;
	font-size: 1.5em;
	padding: 5px;
	border-radius: 10px;
}



#detail{
	width : 1000px;
	margin-left:50px;
}


#delete{
	margin-left:900px;
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
					<a>공지사항</a>
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

		<div class="page-wrapper">
			<div class="container-fluid">
				<div class="col-lg-8">
					<!--게시판 넓이 -->
 	
				</div>
				
				<!-- 게시판 -->
				
					<div class="page-wrapper">
			<div class="container-fluid">
				<div class="col-lg-8">
					<!--게시판 넓이 -->
 	
				</div>
				
				<!-- 게시판 -->
				
				<div class="container">
					<div class="row">
						<form action="<%=request.getContextPath()%>/communityInsert.ad" method="post">
							<table class="table table-striped" id="detail"
								style="text-align:center; border:1px solid #dddddd">
								<thead>
									<tr>
										<th colspan="2" style="background-color:#eeeeee;
										text-align:center;">
										게시판 상세보기</th>
									</tr>
								</thead>
								
								<tbody>
							
									<tr>
										<td><%= community.getTitle() %></td>
										<td type="hidden" name="nbid" value="<%=community.getNbid()%>"></td>
									</tr>
									
									<tr>
										<td><textarea readonly class="form-control"  name="content" 
												maxlength="2048" style="height:400px;"><%=community.getbContent() %></textarea></td>
									</tr>
									
												
								</tbody>
							</table>
							
							
								<button class="btn btn-primary pull-right" id="before" onclick="location.href='<%=request.getContextPath() %>/communitylist.ad'">이전</button>
								<button class="btn btn-primary pull-right" id="update">수정</button>
								<button class="btn btn-primary pull-right" id="delete">
								<a href="<%= request.getContextPath()%>/communityDelete.ad">삭제</a></button>
							
							
						</form>
					</div>
				</div>

				
			
				
				
				
				
				
	
				
			</div>
		</div>
	</div>


</body>

</html>