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
	width:  calc(100% - 250px); 
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

#detailForm{
	
	width: 1200px;
    height: auto;
}


.form-control{
	height:500px;
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
				
				<!-- 게시판 -->
				
					<div class="page-wrapper">
			<div class="container-fluid">
				<div class="col-lg-8">
					<!--게시판 넓이 -->
 	
				</div>
				
				<!-- 게시판 -->
				
				<div class="container">
					<div class="row">
						<form id="detailForm" method="post">
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
										<td>글 제목 : <input type="text" name="title" value="<%= community.getTitle() %>" readonly>
										<input id="nbid" name="nbid" type="hidden" value="<%=community.getNbid()%>">
									</tr>
									
									<tr>
										<td><textarea readonly class="form-control"  name="content" 
												maxlength="2048" ><%=community.getbContent() %></textarea></td>
									</tr>
									
												
								</tbody>
							</table>
						</form>
							
							<div>
								<button class="btn btn-primary pull-right" id="before" 
									onclick="location.href='<%=request.getContextPath() %>/communitylist.ad'">이전</button>
							 <button class="btn btn-primary pull-right" id="update" 
									onclick="location.href='<%=request.getContextPath()%>/communitySelect.ad?nbid=<%=community.getNbid()%>'">수정</button>
								<button class="btn btn-primary pull-right" id="delete"
									onclick="deleteCommunity();">삭제</button>
								
									
							</div>
							
						
					</div>
				</div>
				
			
				<script>
				function deleteCommunity(){
					  
					var nbid = $("#nbid").val();
				
					console.log(nbid);
						
						 if(confirm("삭제 하시겠습니까?") == true){
							
							alert("삭제되었습니다.");
							
							<%-- $("#detailForm").attr("atcion", "<%=request.getContextPath()%>/communityDelete.ad"); --%>
							
							location.href = "<%=request.getContextPath()%>/communityDelete.ad?nbid=" + nbid;
							
						}else{
							return;
						} 
					}
				
				
				
				
				
				</script>
				
				
				
				
	
				
			</div>
		</div>
	</div>


</body>

</html>