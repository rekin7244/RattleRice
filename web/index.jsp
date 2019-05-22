<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.rr.member.model.vo.Member"%>
	
<%
	Member loginUser = (Member) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>딸랑밥</title>
<style>
th {
	text-align:center;
}
</style>
<script>
	function fnMove(seq) {
		var offset = $("#div" + seq).offset();
		$('html, body').animate({
			scrollTop : offset.top
		}, 800);
	}
</script>
<style>

img {
	width: 100% !important;
}

#bg-img {
	height: 650px;
	background-image: url('images/main.jpg');
	background-repeat: no-repeat;
	background-size: cover;
	background-position: 50% 50%;
	background-attachment: fixed;
}

#bgtext {
	transition-duration: 1s;
}

#bgtext:hover {
	color: orangered;
	text-shadow: 3px 3px orange;
	font-weight: bold;
	font-size: 100px;
}

#bgtext {
	padding: 100px;
	padding-left: 70px;
	text-align: center;
	color: white;
	font-size: 53px;
	font-family: 'Megrim', cursive;
	text-shadow: 0px 0px 10px #000, 0px 0px 10px #000, 0px 0px 10px #000,
		0px 0px 10px #000, 0px 0px 10px #000;
}

#siteIntroDiv {
	margin:0 auto;
}

.navbar-inverse .navbar-nav>li>a:hover {
	cursor: pointer;
}

.navbar-inverse {
	opacity: 0.9;
	background: #F4AC8A;
	border: none;
	font-weight: bold;
}

.navbar-inverse .navbar-nav>li>a {
	color: black;
}

.content > .content-inner {
	display: table-cell;
	vertical-align: middle;
}

.contact-form {
	margin: 0 auto;
	padding: 10px;
	text-align: center;
	background: yellowgreen;
}

/*contact 페이지 스타일*/
.contact-inner {
	background: lightblue;
	border-radius: 2em;
	padding: 30px 0;
}
/* 우측하단 채팅방 아이콘 고정 */
.fixed {
	position: fixed;
	top: 90%;
	right: 3%;
}

.fixed .far {
	font-size: 3em;
}

body::-webkit-scrollbar { 
    display: none; 
}
</style>
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">
	<div id="div0" class="container-fluid"></div>

	<div id="bg-img">
		<div class="context" id="bgtext">
			<p>딸랑 밥</p>
			<h4>혼밥 매칭서비스</h4>
		</div>
	</div>
	<!-- 배경이미지 -->

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
					<li><a onclick="fnMove('0')">Home</a></li>
					<li><a onclick="fnMove('1')">About Us</a></li>
					<li><a onclick="fnMove('2')">Service</a></li>
					<li><a onclick="fnMove('3')">Contact</a></li>
					<li><a onclick="fnMove('4')">Board</a></li>
				</ul>
				<% if(loginUser != null) {%>
					<ul class="nav navbar-nav navbar-right">
					<li ><a style="font-family: 'Megrim', cursive; font-weight: bold; cursor: pointer;" onclick="goProfile()"><%=loginUser.getUserId()%>님</a></li>
					<li ><a style="font-family: 'Megrim', cursive; font-weight: bold;" 
						href="<%= request.getContextPath()%>/logout.me"><span
							class="glyphicon glyphicon-log-in"></span> Logout</a></li>
				</ul>
				<%}else{ %>
				<ul class="nav navbar-nav navbar-right">
					<li data-toggle="modal" data-target="#joinModla"><a
						style="font-family: 'Megrim', cursive; font-weight: bold;"><span
							class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li data-toggle="modal" data-target="#myModal"><a
						style="font-family: 'Megrim', cursive; font-weight: bold;"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</ul>
				<%} %>
			</div>
		</div>
	</nav>


	<!-- login 모달 -->
	<div class="container">
		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog modal-sm">
				<%@include file="views/member/memberLoginForm.jsp"%>
				<!-- Modal content-->
			</div>
		</div>
		<div class="modal fade" id="joinModla" role="dialog">
			<div class="modal-dialog">
				<%@include file="views/member/memberJoinSelectForm.jsp"%>
				<!-- Modal content-->
			</div>
		</div>
	</div>

	<!-- Sign up 모달 -->
	<div class="container">
		<!-- Modal -->
	</div>
	<br>
	<br>
	<div id="div1" class="container-fluid"></div>
	<br>
	<br>

	<!-- section1 : about us -->
	<div class="container-fluid" id="div1">
		<h1
			style="font-weight: bold; font-family: 'Megrim', cursive; text-align: center">About
			Us</h1>
		<p style="text-align: center">딸랑밥을 소개합니다.</p>


		<div class="row content">

			<img src="images/section1.jpg" style="width: 100%;"/> <br /> <br /> <br />
			<hr>
		</div>
		<br><br>
	</div>
	
	<div class="container">
	
		<div class="row content">
			<h4>딸랑밥 소개</h4>
			<div class="col-md-4 content-inner content-img">
				<img src="images/section1-face.jpg" height="300px"/>
			</div>
			<div id="siteIntroDiv" class="col-md-8 content-inner content-text">
				<p id="">아니더면, 만물은 충분히 꽃이 인간은 황금시대의 이것이다. 이상은 눈이 충분히 끓는다. 무엇이 때까지 대고,
					같이, 이상을 이것이다. 그것은 희망의 그러므로 따뜻한 가슴에 같이, 지혜는 봄바람이다. 사랑의 커다란 끝까지 그들의
					트고, 힘있다. 그들은 동산에는 뜨고, 속잎나고, 불어 무엇을 얼마나 봄바람이다. 굳세게 하는 관현악이며, 얼마나 이상
					대고, 들어 것이다. 인생을 모래뿐일 소금이라 이상은 힘있다. 못할 노래하며 청춘의 이 있는 안고, 것이다. 하였으며,
					하여도 이것을 뜨거운지라, 크고 일월과 우리 사막이다. 얼음에 별과 전인 운다.</p>
			</div>
		</div>
	
	</div>

	<br />
	<br />
	<br />

	<!--    제이쿼리 스크롤 이벤트를 위한 다이브 -->
	<div id="div2"></div>
	<br>
	<br>
	<!--    section2 : service -->
	<div class="container-fluid" style="background:#F4AC9C">
		<div class="row">
		<h1 style="font-weight: bold; font-family: 'Megrim', cursive; text-align: center">Service</h1>
		<p style="text-align: center">딸랑밥에서 제공하는 서비스 입니다.</p>
		<br />
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
		    <!-- Indicators -->
		    <ol class="carousel-indicators">
		      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		      <li data-target="#myCarousel" data-slide-to="1"></li>
		      <li data-target="#myCarousel" data-slide-to="2"></li>
		    </ol>
		
		    <!-- Wrapper for slides -->
		    <div class="carousel-inner" role="listbox">
		      <div class="item active">
		        <img src="images/section1-joker.jpg" alt="New York" width="1200" height="700">
		        <div class="carousel-caption">
		          <h3>New York</h3>
		          <p>The atmosphere in New York is lorem ipsum.</p>
		        </div>      
		      </div>
		
		      <div class="item">
		        <img src="images/section1-joker.jpg" alt="Chicago" width="1200" height="700">
		        <div class="carousel-caption">
		          <h3>Chicago</h3>
		          <p>Thank you, Chicago - A night we won't forget.</p>
		        </div>      
		      </div>
		    
		      <div class="item">
		        <img src="images/section1-joker.jpg" alt="Los Angeles" width="1200" height="700">
		        <div class="carousel-caption">
		          <h3>LA</h3>
		          <p>Even though the traffic was a mess, we had the best time playing at Venice Beach!</p>
		        </div>      
		      </div>
		    </div>
		  <!-- Left and right controls -->
		    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
		      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		      <span class="sr-only">Previous</span>
		    </a>
		    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
		      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		      <span class="sr-only">Next</span>
		    </a>
		
			</div>
			</div>
	</div>


	<!--    제이쿼리 스크롤 이벤트를 위한 다이브 -->
	<div id="div3"></div>
	<br>
	<br>
	<!-- section3 : contact -->
	<div class="container">
			
		<div id="contact" class="container" >
		  <div class="row">
		  <div class="col-md-8 col-md-offset-2 contact-inner" style="background:lightblue;">
			 <h1
				style="font-weight: bold; font-family: 'Megrim', cursive; text-align: center">Contact</h1>
			<p style="text-align: center">제휴를 맺읍시다.</p>
			<br />
		    <div class="col-md-2 col-md-offset-2">
		      <p>Fan? Drop a note.</p>
		      <p><span class="glyphicon glyphicon-map-marker"></span>Chicago, US</p>
		      <p><span class="glyphicon glyphicon-phone"></span>Phone: +00 1515151515</p>
		      <p><span class="glyphicon glyphicon-envelope"></span>Email: mail@mail.com</p>
		    </div>
		    <div class="col-md-6">
		      <div class="row">
		        <div class="col-sm-6 form-group">
		          <input class="form-control" id="name" name="name" placeholder="Name" type="text" required>
		        </div>
		        <div class="col-sm-6 form-group">
		          <input class="form-control" id="email" name="email" placeholder="Email" type="email" required>
		        </div>
		      </div>
		      <textarea class="form-control" id="comments" name="comments" placeholder="Comment" rows="5"></textarea>
		      <br>
		      <div class="row">
		        <div class="col-md-12 form-group">
		          <button class="btn pull-right" type="submit">Send</button>
		        </div>
		      </div>
		    </div>
		    
		    </div>
		    
		  </div>
		</div>
	</div>
	<!--    제이쿼리 스크롤 이벤트를 위한 다이브 -->
	<div id="div4"></div>

	<br>
	<br>
	
	<!-- section4 : Notice  -->
	<div class="container">
		<h1	style="font-weight: bold; font-family: 'Megrim', cursive; text-align: center">공지사항</h1>
		<p align="center">공지사항을 읽어주세요.</p>
		<br>

		<div class="container-fluid">
			<div class="row content">
					<div class="form-group">
						<label for="keyword" class="col-sm-2 control-label">제목 검색</label>
						<div class="col-sm-9">
							<input type="text" name="keyword" id="noticeKeyword"
								placeholder="키워드를 입력하세요." class="form-control">
						</div>
					</div>

					<div class="form-group">
						<label for="keyword" class="col-sm-2 control-label">공지 유형</label>
						<div class="col-sm-9">
							<select class="form-control" id="noticeCondition">
								<option value="">전체</option>
								<option value="공통">공통</option>
								<option value="일반 유저">일반 유저</option>
								<option value="사업자">사업자</option>
							</select>
						</div>
					</div>
					<br>
					<div class="pull-right">
						<button class="btn btn-primary" value="검색"
							onclick="noticePaging(1);" style="width: 100%;">검색</button>
					</div>
					<br>
				<br> <br>
				<table id="noticeTable" style="width: 100%; text-align: center;"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr class="info">
							<th>번호</th>
							<th>공지대상</th>
							<th>내용</th>
							<th>작성자</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
				<nav style="text-align: center;">
					<ul id="noticePaging" class="pagination"></ul>
				</nav>
			</div>
		</div>
	</div>
	<br>
	<br>
	
	<!-- section5 : FAQ  -->
	<div class="container">
		<h1	style="font-weight: bold; font-family: 'Megrim', cursive; text-align: center">FAQ</h1>
		<p align="center">자주 물어보시는 질문입니다.</p>
		<br>

		<div class="container-fluid">
			<div class="row content">
					<div class="form-group">
						<label for="keyword" class="col-sm-2 control-label">제목 검색</label>
						<div class="col-sm-9">
							<input type="text" id="faqKeyword"
								placeholder="키워드를 입력하세요." class="form-control">
						</div>
					</div>

					<div class="form-group">
						<label for="keyword" class="col-sm-2 control-label">상담 유형</label>
						<div class="col-sm-9">
							<select class="form-control" id="faqCondition">
								<option value="">전체</option>
								<option value="회원">회원</option>
								<option value="결제">결제</option>
								<option value="환불">환불</option>
								<option value="정책">정책</option>
								<option value="약관">약관</option>
								<option value="기타">기타</option>
							</select>
						</div>
					</div>
					<br>
					<div class="pull-right">
						<button type="submit" class="btn btn-primary" value="검색"
							onclick="faqPaging(1)" style="width: 100%;">검색</button>
					</div>
					<br>
				<br> <br>
				<table id="faqTable" style="width: 100%; text-align: center;"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr class="info">
							<th>번호</th>
							<th>상담유형</th>
							<th>질문</th>
							<th>작성자</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
				<nav style="text-align: center;">
					<ul id="faqPaging" class="pagination"></ul>
				</nav>
			</div>
		</div>
	</div>
	<br>
	<br>
	<!-- section6 : Review  -->
	<div class="container">
		<h1	style="font-weight: bold; font-family: 'Megrim', cursive; text-align: center">REVIEW</h1>
		<p align="center">후기글들입니다.</p>
		<br>
		<div class="container-fluid">
			<div class="row content">
					<div class="form-group">
						<label for="keyword" class="col-sm-2 control-label">가게명 검색</label>
						<div class="col-sm-9">
							<input type="text" id="reviewKeyword"
								placeholder="가게명을 입력하세요." class="form-control">
						</div>
					</div>
					<div class="pull-right">
						<button type="submit" class="btn btn-primary" value="검색"
							onclick="reviewPaging(1);" style="width: 100%;">검색</button>
					</div>
					<br>
				<br> <br>
				<table id="reviewTable" style="width: 100%; text-align: center;"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr class="info">
							<th>번호</th>
							<th>가게명</th>
							<th>후기내용</th>
							<th>작성자</th>
							<th>평점</th>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
				<nav style="text-align: center;">
					<ul id="reviewPaging" class="pagination"></ul>
				</nav>
			</div>
		</div>
	</div>
	<br>
	<br>
	
	<!-- section7 : Free Board  -->
	<div class="container">
		<h1	style="font-weight: bold; font-family: 'Megrim', cursive; text-align: center">자유게시판</h1>
		<p align="center">자유롭게 소통해요.</p>
		<br>

		<div class="container-fluid">
			<div class="row content fb">
					<div class="form-group">
						<label for="keyword" class="col-sm-2 control-label">제목 검색</label>
						<div class="col-sm-9">
							<input type="text" name="keyword" id="fbKeyword"
								placeholder="키워드를 입력하세요." class="form-control">
						</div>
					</div>
					<div class="pull-right">
						<button class="btn btn-primary" value="검색"
							onclick="fbPaging(1);" style="width: 100%;">검색</button>
					</div>
					
					<br>
					<br>
					<br>
				<table id="fbTable" style="width: 100%; text-align: center;"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr class="info">
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
				
				<% if(loginUser != null){ %>
				<button id="insertfb" class="btn btn-primary" style=" float: right; width: 15%; ">게시글 작성</button>
				<input type="hidden" value="<%=loginUser.getUserId()%>" name="fbUserId">
				<% } %>
				<nav style="text-align: center;">
					<ul id="fbPaging" class="pagination"></ul>
				</nav>
			</div>
		</div>
	</div>
	<br>
	<br>
	
	<%if(loginUser != null){ %>
		<div class="fixed">
			<a
				onclick="window.open('<%=request.getContextPath()%>/selectAll.cr', '', 'top=50px, left=800px, height=500, width=400')">
				<i class="far fa-comment"></i></a>
		</div>
	<%}else{ %>
	
	<%} %>
	<div class="footer">
		<%@ include file="views/common/footer.jsp"%>
	</div>
	
	<script>
	function goProfile(){
		location.href="/rr/selectPro";
	}
	$(function(){
		//메인페이지 정보 불러오기
		$.ajax({
			url:"indexInfo.if",
			data:{},
			type:"get",
			success:function(data){
				$("#siteIntroduction").text(data.sInfo);
				$("#serviceIntroduction").text(data.sService);
				$("#termsInfo").html(data.terms);
			},
			fail:function(data){
				console.log("실패!");
			}
		});
		//공지사항 조회 및 페이징
		$.ajax({
			url:"noticeBoard.bo",
			type:"get",
			data:{currentPage:1},
			success:function(data){
				var list = data["list"];
				var pi = data["pi"];
				//console.log(pi);
				
				$tableBody = $("#noticeTable tbody");
				$tableBody.html('');
				$.each(list, function(index, value){
					var $tr = $("<tr>");
					var $noTd = $("<td>").text(value.nbid);
					var $typeTd = $("<td>").text(value.target);
					var $contentTd = $("<td>").text(value.bContent);
					var $writerTd = $("<td>").text(value.writer);
					var $countTd = $("<td>").text(value.bCount);
					
					$tr.append($noTd);
					$tr.append($typeTd);
					$tr.append($contentTd);
					$tr.append($writerTd);
					$tr.append($countTd);
					$tableBody.append($tr);
				});
				
				$paging = $("#noticePaging");
				$paging.html('');
				var $firstTd = $('<li><a onclick="noticePaging(1);" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>');
				$paging.append($firstTd);
				for (var i = 0; i < pi.maxPage; i++) {
					$paging.append('<li><a onclick="noticePaging('+(i+1)+');">'+(i+1)+'</a></li>');
				}
				var $endTd = $('<li><a onclick="noticePaging('+pi.maxPage+');" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>');
				$paging.append($endTd);
			}
		});
		//FAQ게시판 조회 및 페이징
		$.ajax({
			url:"faqBoard.bo",
			type:"get",
			data:{currentPage:1},
			success:function(data){
				var list = data["list"];
				var pi = data["pi"];
				//console.log(pi);
				
				$tableBody = $("#faqTable tbody");
				$tableBody.html('');
				$.each(list, function(index, value){
					var $tr = $("<tr>");
					var $noTd = $("<td>").text(value.fbid);
					var $typeTd = $("<td>").text(value.fCategory);
					var $contentTd = $("<td>").text(value.bContent);
					var $writerTd = $("<td>").text(value.writer);
					var $countTd = $("<td>").text(value.bCount);
					
					$tr.append($noTd);
					$tr.append($typeTd);
					$tr.append($contentTd);
					$tr.append($writerTd);
					$tr.append($countTd);
					$tableBody.append($tr);
				});
				
				$paging = $("#faqPaging");
				$paging.html('');
				var $firstTd = $('<li><a onclick="faqPaging(1);" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>');
				$paging.append($firstTd);
				for (var i = 0; i < pi.maxPage; i++) {
					$paging.append('<li><a onclick="faqPaging('+(i+1)+');">'+(i+1)+'</a></li>');
				}
				var $endTd = $('<li><a onclick="faqPaging('+pi.maxPage+');" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>');
				$paging.append($endTd);
			},
			error:function(){
				console.log("실패!");
			}
		});
		//후기게시판 조회 및 페이징
		$.ajax({
			url:"reviewBoard.bo",
			type:"get",
			data:{currentPage:1},
			success:function(data){
				var list = data["list"];
				var pi = data["pi"];
				//console.log(pi);
				
				$tableBody = $("#reviewTable tbody");
				$tableBody.html('');
				$.each(list, function(index, value){
					var $tr = $("<tr>");
					var $noTd = $("<td>").text(value.rbid);
					var $brandTd = $("<td>").text(value.brand);
					var $contentTd = $("<td>").text(value.bContent);
					var $writerTd = $("<td>").text(value.writer);
					var $gradeTd = $("<td>").text(value.grade);
					
					$tr.append($noTd);
					$tr.append($brandTd);
					$tr.append($contentTd);
					$tr.append($writerTd);
					$tr.append($gradeTd);
					$tableBody.append($tr);
				});
				
				$paging = $("#reviewPaging");
				$paging.html('');
				var $firstTd = $('<li><a onclick="reviewPaging(1);" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>');
				$paging.append($firstTd);
				for (var i = 0; i < pi.maxPage; i++) {
					$paging.append('<li><a onclick="reviewPaging('+(i+1)+');">'+(i+1)+'</a></li>');
				}
				var $endTd = $('<li><a onclick="reviewPaging('+pi.maxPage+');" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>');
				$paging.append($endTd);
			},
			error:function(){
				console.log("실패!");
			}
		});
	});
	//자유게시판 조회 및 페이징
	$.ajax({
		url:"freeBoard.bo",
		type:"get",
		data:{currentPage:1},
		success:function(data){
			var list = data["list"];
			var pi = data["pi"];
			//console.log(pi);
			
			$tableBody = $("#fbTable tbody");
			$tableBody.html('');
			$.each(list, function(index, value){
				var $tr = $("<tr>");
				var $noTd = $("<td>").text(value.fbbid);
				var $titleTd = $("<td>").text(value.title);
				var $writerTd = $("<td>").text(value.writer);
				var $dateTd = $("<td>").text(value.bDate);
				var $countTd = $("<td>").text(value.bCount);
				
				$tr.append($noTd);
				$tr.append($titleTd);
				$tr.append($writerTd);
				$tr.append($dateTd);
				$tr.append($countTd);
				$tableBody.append($tr);
			});
			
			$paging = $("#fbPaging");
			$paging.html('');
			var $firstTd = $('<li><a onclick="fbPaging(1);" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>');
			$paging.append($firstTd);
			for (var i = 0; i < pi.maxPage; i++) {
				$paging.append('<li><a onclick="fbPaging('+(i+1)+');">'+(i+1)+'</a></li>');
			}
			var $endTd = $('<li><a onclick="fbPaging('+pi.maxPage+');" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>');
			$paging.append($endTd);
		}
	});
	//공지사항 페이징 및 검색 ajax
	function noticePaging(currentPage){
		var keyword = $("#noticeKeyword").val();
		var condition = $("#noticeCondition").val();
		$.ajax({
			url:"searchNoticeBoard.bo",
			type:"get",
			data:{currentPage:currentPage,keyword:keyword,condition:condition},
			success:function(data){
				var list = data["list"];
				var pi = data["pi"];
				
				$tableBody = $("#noticeTable tbody");
				$tableBody.html('');
				$.each(list, function(index, value){
					var $tr = $("<tr>");
					var $noTd = $("<td>").text(value.nbid);
					var $typeTd = $("<td>").text(value.target);
					var $contentTd = $("<td>").text(value.bContent);
					var $writerTd = $("<td>").text(value.writer);
					var $countTd = $("<td>").text(value.bCount);
					
					$tr.append($noTd);
					$tr.append($typeTd);
					$tr.append($contentTd);
					$tr.append($writerTd);
					$tr.append($countTd);
					$tableBody.append($tr);
				});
				
				$paging = $("#noticePaging");
				$paging.html('');
				var $firstTd = $('<li><a onclick="noticePaging(1);" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>');
				$paging.append($firstTd);
				for (var i = 0; i < pi.maxPage; i++) {
					$paging.append('<li><a onclick="noticePaging('+(i+1)+');">'+(i+1)+'</a></li>');
				}
				var $endTd = $('<li><a onclick="noticePaging('+pi.maxPage+');" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>');
				$paging.append($endTd);
			},
			error:function(){
				console.log("실패!");
			}
		});
	}
	//faq 페이징 ajax
	function faqPaging(currentPage){
		var keyword = $("#faqKeyword").val();
		var condition = $("#faqCondition").val();
		$.ajax({
			url:"searchFaqBoard.bo",
			type:"get",
			data:{currentPage:currentPage,keyword:keyword,condition:condition},
			success:function(data){
				var list = data["list"];
				var pi = data["pi"];
				
				$tableBody = $("#faqTable tbody");
				$tableBody.html('');
				$.each(list, function(index, value){
					var $tr = $("<tr>");
					var $noTd = $("<td>").text(value.fbid);
					var $typeTd = $("<td>").text(value.fCategory);
					var $contentTd = $("<td>").text(value.bContent);
					var $writerTd = $("<td>").text(value.writer);
					var $countTd = $("<td>").text(value.bCount);
					
					$tr.append($noTd);
					$tr.append($typeTd);
					$tr.append($contentTd);
					$tr.append($writerTd);
					$tr.append($countTd);
					$tableBody.append($tr);
				});
				
				$paging = $("#faqPaging");
				$paging.html('');
				var $firstTd = $('<li><a onclick="faqPaging(1);" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>');
				$paging.append($firstTd);
				for (var i = 0; i < pi.maxPage; i++) {
					$paging.append('<li><a onclick="faqPaging('+(i+1)+');">'+(i+1)+'</a></li>');
				}
				var $endTd = $('<li><a onclick="faqPaging('+pi.maxPage+');" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>');
				$paging.append($endTd);
			},
			error:function(){
				console.log("실패!");
			}
		});
	}
	//후기게시판 페이징 및 검색 ajax
	function reviewPaging(currentPage){
		var keyword = $("#reviewKeyword").val();
		$.ajax({
			url:"searchReviewBoard.bo",
			type:"get",
			data:{currentPage:currentPage,keyword:keyword},
			success:function(data){
				var list = data["list"];
				var pi = data["pi"];
				
				$tableBody = $("#reviewTable tbody");
				$tableBody.html('');
				$.each(list, function(index, value){
					var $tr = $("<tr>");
					var $noTd = $("<td>").text(value.rbid);
					var $brandTd = $("<td>").text(value.brand);
					var $contentTd = $("<td>").text(value.bContent);
					var $writerTd = $("<td>").text(value.writer);
					var $gradeTd = $("<td>").text(value.grade);
					
					$tr.append($noTd);
					$tr.append($brandTd);
					$tr.append($contentTd);
					$tr.append($writerTd);
					$tr.append($gradeTd);
					$tableBody.append($tr);
				});
				
				$paging = $("#reviewPaging");
				$paging.html('');
				var $firstTd = $('<li><a onclick="reviewPaging(1);" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>');
				$paging.append($firstTd);
				for (var i = 0; i < pi.maxPage; i++) {
					$paging.append('<li><a onclick="reviewPaging('+(i+1)+');">'+(i+1)+'</a></li>');
				}
				var $endTd = $('<li><a onclick="reviewPaging('+pi.maxPage+');" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>');
				$paging.append($endTd);
			},
			error:function(){
				console.log("실패!");
			}
		});
	}

	//자유게시판 페이징 및 검색 ajax
	function fbPaging(currentPage){
		var keyword = $("#fbKeyword").val();
		$.ajax({
			url:"searchFreeBoard.bo",
			type:"get",
			data:{currentPage:currentPage,keyword:keyword},
			success:function(data){
				var list = data["list"];
				var pi = data["pi"];
				
				$tableBody = $("#fbTable tbody");
				$tableBody.html('');
				$.each(list, function(index, value){
					var $tr = $("<tr>");
					var $noTd = $("<td>").text(value.fbbid);
					var $titleTd = $("<td>").text(value.title);
					var $writerTd = $("<td>").text(value.writer);
					var $dateTd = $("<td>").text(value.bDate);
					var $countTd = $("<td>").text(value.bCount);
					
					$tr.append($noTd);
					$tr.append($titleTd);
					$tr.append($writerTd);
					$tr.append($dateTd);
					$tr.append($countTd);
					$tableBody.append($tr);
				});
				
				$paging = $("#fbPaging");
				$paging.html('');
				var $firstTd = $('<li><a onclick="fbPaging(1);" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>');
				$paging.append($firstTd);
				for (var i = 0; i < pi.maxPage; i++) {
					$paging.append('<li><a onclick="fbPaging('+(i+1)+');">'+(i+1)+'</a></li>');
				}
				var $endTd = $('<li><a onclick="fbPaging('+pi.maxPage+');" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>');
				$paging.append($endTd);
			},
			error:function(){
				console.log("실패!");
			}
		});
	}
	
	$(function(){
		$("#insertfb").click(function(){
			var fbUserId = $("input[name=fbUserId]");
			
			$.ajax({
				url:"freeBoardInsert.bo",
				type:"get",
				data:{fbUserId:fbUserId},
				success:function(data){
					console.log(data);
				}
			});	
			
		});
		
		$("#fbTable td").click(function(){
			 var num = $(this).parent().children().eq(0).text();
			
			console.log(num);
			
			$.ajax({
				url:"selectOne.bo",
				type:"get",
				data:{num:num},
				success:function(data){
					console.log(data);
				}
			});
		});
	});
	</script>

</body>
</html>