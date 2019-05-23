<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.kh.rr.member.model.vo.Member, com.kh.rr.board.model.vo.Board, com.kh.rr.common.model.vo.PageInfo ,java.util.*"%>

<%
	Member loginUser = (Member) session.getAttribute("loginUser");
	ArrayList<Board> bList = (ArrayList<Board>) request.getAttribute("bList");
	PageInfo pi = (PageInfo) request.getAttribute("pi");
    int currentPage = pi.getCurrentPage();
    int maxPage = pi.getMaxPage();
    int startPage = pi.getStartPage();
    int endPage = pi.getEndpage();
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<title>딸랑밥</title>
<style>
body::-webkit-scrollbar { 
    display: none; 
}
.navbar-inverse {
	background: #F4AC8A;
	border: none;
}

.navbar-inverse .navbar-nav>li>a {
	color: black;
}

.contact-form {
	margin: 0 auto;
	padding-right: 10px;
	text-align: center;
	background: yellowgreen;
	text-align: center;
}

.fixed {
	position: fixed;
	top: 90%;
	right: 3%;
}

.fixed .far {
	font-size: 3em;
}

@import
	"https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700";

body {
	background: #fafafa;
	/* 	overflow: hidden */
}

/* 메뉴 */
p {
	text-align: center;
	font-family: 'Poppins', sans-serif;
	font-size: 1.1em;
	font-weight: 300;
	line-height: 1.7em;
}

/* sidebar menu*/
a, a:hover, a:focus {
	color: inherit;
	text-decoration: none;
	transition: all 0.3s;
}

#sidebar {
	top: 0;
	left: 0;
	z-index: 999;
	color: black;
	transition: all 0.3s;
}

a[data-toggle="collapse"] {
	position: relative;
}

#content {
	width: calc(100% - 250px);
	padding: 40px;
	transition: all 0.3s;
	position: absolute;
	top: 10;
	right: 0;
	padding: 0;
}

#jb-header {
	text-align: center;
}

#jb-header h1 {
	margin-top: 0;
	margin-bottom: 20px;
}

#jb-content {
	padding: 20px;
	border-left: 1px solid black;
	height: 700px;
}

.active {
	background: gray;
	color: white;
}

.content h3 {
	margin-top: 0;
	margin-bottom: 20px;
}

.in-content {
	width: 100%;
	margin: 0 auto;
	text-align: center;
	padding-bottom: 10px;
}

#div1 {
	width: 45%;
	height: 250px;
	display: inline-block;
}

#div2 {
	width: 45%;
	height: 250px;
	display: inline-block;
}

#div3 {
	width: 49%;
	display: inline-block;
}

#div4 {
	width: 49%;
	display: inline-block;
}

.container-fluid {
	padding: 0;
}


.form1{
	margin-top: 30px;
	padding-left: 30px;
}


.form-input {
	width: auto;
	display: inline-block;
}

.form-group {
	display: block;
}

.form-control {
	width: 50%;
}

input, textarea {
	text-align: center;
}


.col-sm-5 {
	width: auto;
}

/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 450px;
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}

/* .Small{
width: 6%
}
.middle{
width: 9%;
} */

tr>th:nth-child(1),tr>td:nth-child(1),tr>th:nth-child(6),tr>td:nth-child(6) {
   width: 6%
}
tr>th:nth-child(2),tr>td:nth-child(2),tr>th:nth-child(5),tr>td:nth-child(5) {
   width: 15%
}
tr>th:nth-child(4),tr>td:nth-child(4) {
   width: 10%
}

</style>

</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">
	<div id="div0" class="container-fluid"></div>
	<!-- 상단바 -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav" id='selectmenu'>
					<li><a href="<%=request.getContextPath()%>/index.jsp">Home</a></li>

				</ul>
				<%
					if (loginUser != null) {
				%>
				<ul class="nav navbar-nav navbar-right">
					<li><a
						style="font-family: 'Megrim', cursive; font-weight: bold;"><%=loginUser.getUserName()%>님</a></li>
					<li><a
						style="font-family: 'Megrim', cursive; font-weight: bold;"
						href="<%=request.getContextPath()%>/logout.me"><span
							class="glyphicon glyphicon-log-in"></span> Logout</a></li>
				</ul>
				<%
					} else {
						request.setAttribute("msg", "잘못된 경로로 접근하셨습니다.");
						request.getRequestDispatcher("../common/errorPage.jsp").forward(request, response);
					}
				%>
			</div>
		</div>
	</nav>

	<!-- 내용 -->
	<br>
	<br>
	<br>
	<br>
	<div class="row">
		<%@ include file="myPageMenubar.jsp"%>
	</div>



	<div class="container-fluid text-center">
		<div class="row content" style="border-bottom: 0px;">
			<div class="col-sm-12 form1 well">
				<div class="">
					<h2>내가 작성한 글</h2><br>
					<div class="container">
						<input class="form-control" id="myInput" type="text"
							placeholder="키워드 검색"> <br>
						
							<%if(bList.size() !=0){%>
						<table class="table table-bordered table-striped" id="listArea">
							<thead>
								<tr>
									<th>글 번호</th>
									<th>타입</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일</th>
									<th>조회수</th>
								</tr>
							</thead>
							<tbody id="myTable">

								<%
									for (int i = 0; i < bList.size(); i++) {
											Board board = bList.get(i);
								%>
								<tr>
									<td><%=board.getBid()%></td>
									<%
										if (board.getbType().equals("JOB")) {
									%>
									<td>직업게시판</td>
									<%
										} else if (board.getbType().equals("FREE")) {
									%>
									<td>자유 게시판</td>
									<%
										} else if (board.getbType().equals("REVIEW")) {
									%>
									<td>Review</td>
									<%
										} else {
									%>
									<td>FAQ</td>
									<%
										}
									%>

									<td><%=board.getTitle()%></td>
									<td><%=board.getWriter()%></td>
									<td><%=board.getbDate()%></td>
									<td><%=board.getbCount()%></td>
								</tr>

								<%
									}
								%>
							</tbody>
						</table>
						<%
							} else {
						%>
						<table class="table table-bordered table-striped">
							<thead>
								<tr>
									<th class="Small">글 번호</th>
									<th class="middle">타입</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일</th>
									<th class="Small">조회수</th>
								</tr>
							</thead>
						</table>
						<h5>작성된 글이 없습니다.</h5>
						<%
							}
						%>
						<br>
						<div class="pagingArea" align="center">
			<button
				onclick="location.href='<%= request.getContextPath()%>/selectWrite?currentPage=1'"><<</button>
			<%if(currentPage <= 1){ %>
			<button disabled><</button>

			<%}else{ %>
			<button
				onclick="location.href='<%= request.getContextPath()%>/selectWrite?currentPage=<%= currentPage - 1%>'"><</button>
			<%} %>

			<% for(int p = startPage; p<=endPage; p++){
               if(p == currentPage){%>
			<button disabled><%=p %></button>
			<%      }else{%>
			<button
				onclick="location.href='<%=request.getContextPath()%>/selectWrite?currentPage=<%=p%>'"><%=p %></button>
			<%      } %>

			<%} %>

			<%if(currentPage >= maxPage){ %>
			<button disabled>></button>
			<%}else{ %>
			<button
				onclick="location.href='<%= request.getContextPath()%>/selectWrite?currentPage=<%=currentPage + 1%>'">></button>
			<%} %>
			<button
				onclick="location.href='<%= request.getContextPath()%>/selectWrite?currentPage=<%=maxPage%>'">>></button>
		</div>
					</div>
				</div>
			</div>
		</div>
</div>

<script>

$(function() {
	$('#write').addClass('active');
});


$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});


$(function(){
	$("#listArea td").mouseenter(function(){
		$(this).parent().css({"color":"darkgray", "cursor":"pointer"});
	}).mouseout(function(){
		$(this).parent().css({"color":"black"});
	});
});

</script>

</body>
</html>