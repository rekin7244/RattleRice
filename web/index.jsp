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

/*네비바 스타일*/
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


/*메인 배경 스타일*/
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

/*섹션별 제목 관련 스타일*/
.content > .content-inner {
	display: table-cell;
	vertical-align: middle;
}

/*contact 페이지 스타일*/
.contact-inner {
	background: lightblue;
	border-radius: 2em;
	padding: 30px 0;
}

.contact-form {
	margin: 0 auto;
	padding: 10px;
	text-align: center;
	background: yellowgreen;
}

/*게시판 관련 스타일*/
.nav-tabs>li{
	text-align: center;
	width: 20%;
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

/*스크롤 바 삭제*/
body::-webkit-scrollbar { 
    display: none; 
}
</style>
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">
	<div id="div0" class="container-fluid"></div>

	<div id="bg-img">
		<div class="context" id="bgtext">
			<p>Rattle Rice</p>
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
			 <h1
				style="font-weight: bold; font-family: 'Megrim', cursive; text-align: center">Contact</h1>
			<p style="text-align: center">제휴를 맺읍시다.</p>
			<br />
		  <div class="col-md-8 col-md-offset-2 contact-inner" style="background:lightblue;">
		    <div class="col-md-2 col-md-offset-2">
		      <p>제휴 인풋</p>
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
		      <textarea class="form-control" id="comments" name="comments" placeholder="Comment" rows="5" style="resize:none;"></textarea>
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
	
	<!-- section4 : Board  -->
	<div class="container">
		<div class="title">
			<h1	style="font-weight: bold; font-family: 'Megrim', cursive; text-align: center">딸랑밥 게시판</h1>
		</div>
		<br><br>
		<!-- 게시판 선택해서 들어가는 nav -->
		<div class="bar">
		<ul class="nav nav-tabs">
			<li  class="active" style="color: #4abeca;"><a data-toggle="tab" href="#notice">공지사항</a></li>
			<li><a data-toggle="tab" href="#faq">FAQ</a></li>
			<li><a data-toggle="tab" href="#review">Review</a></li>
			<li><a data-toggle="tab" href="#free">자유게시판</a></li>
			<li><a data-toggle="tab" href="#job">직업게시판</a></li>
		</ul>

	</div>
	
	<!-- 전체 컨텐츠가 담기는 div -->
	<div class="tab-content">
	
	<!-- 공지사항 -->
	<div id="notice" class="tab-pane fade in active">
	
		<!-- <h1	style="font-weight: bold; font-family: 'Megrim', cursive; text-align: center">공지사항</h1> -->
		<br><br>
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
	
	<!-- 자주물어보는 질문 게시판 -->
	<div id="faq" class="tab-pane fade">
	
		<!-- <h1	style="font-weight: bold; font-family: 'Megrim', cursive; text-align: center">FAQ</h1> -->
		<br><br>
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
	
	<!-- 사용자 후기 -->
	<div id="review" class="tab-pane fade">
		<!-- <h1	style="font-weight: bold; font-family: 'Megrim', cursive; text-align: center">REVIEW</h1> -->
		<br><br>
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
	
	<!-- 자유 게시판 -->
	<div id="free" class="tab-pane fade">
		<!-- <h1	style="font-weight: bold; font-family: 'Megrim', cursive; text-align: center">자유게시판</h1> -->
		<br><br>
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
				<div class="pull-right">
					<button id="insertfb" class="btn btn-primary" style="width: 100%;" value="글 작성" onclick="insertfb();">글 작성</button>
				</div>
				<br><br>
				<% } %>
				
				<nav style="text-align: center;">
					<ul id="fbPaging" class="pagination"></ul>
				</nav>
			</div>
		</div>
	</div>
	
	<!-- 직업 게시판 -->
	<div id="job" class="tab-pane fade">
		<!-- <h1	style="font-weight: bold; font-family: 'Megrim', cursive; text-align: center">직업 게시판</h1> -->
		<br><br>
		<p align="center">직업별 게시판입니다</p>
		<br>

		<div class="container-fluid">
			<div class="row content jb">
					<div class="form-group">
						<label for="keyword" class="col-sm-2 control-label">직업 검색</label>
						<div class="col-sm-9">
							<select class="form-control" style="border-radius: 3px 3px 3px 3px; border: 1px solid lightgray;" id="jbCondition">
										<option value="">직업을 선택해주세요</option>
										<option value="무직">무직</option>
										<option value="학생">학생</option>
										<option value="IT">IT</option>
										<option value="언론">언론</option>
										<option value="공무원">공무원</option>
										<option value="군인">군인</option>
										<option value="서비스업">서비스업</option>
										<option value="교육">교육</option>
										<option value="금융/증권/보험업">금융/증권/보험업</option>
										<option value="유통업">유통업</option>
										<option value="예술">예술</option>
										<option value="의료">의료</option>
										<option value="법률">법률</option>
										<option value="건설업">건설업</option>
										<option value="제조업">제조업</option>
										<option value="부동산업">부동산업</option>
										<option value="운송업">운송업</option>
										<option value="농/수/임/광산업">농/수/임/광산업</option>
										<option value="가사">가사</option>
										<option value="기타">기타</option>
									</select>
						</div>
					</div>
					<div class="pull-right">
						<button class="btn btn-primary" value="검색"
							onclick="jbPaging(1);" style="width: 100%;">검색</button>
					</div>
					
					<br>
					<br>
					<br>
				<table id="jbTable" style="width: 100%; text-align: center;"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr class="info">
							<th>번호</th>
							<th>카테고리</th>
							<th>제목</th>
							<th>작성자</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
				
				<% if(loginUser != null){ %>
				<div class="pull-right">
					<button id="insertjb" class="btn btn-primary" style="width: 100%;" value="글 작성" onclick="insertjb();">글 작성</button>
				</div>
				<br><br>
				<% } %>
				
				<nav style="text-align: center;">
					<ul id="jbPaging" class="pagination"></ul>
				</nav>
			</div>
		</div>
	</div>
	
	<!-- tab-content -->
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
		
		fbLoad();		
		jbLoad();
		
	});
	
	//->onload function 끝
	
	//자유게시판 틀
	function fbContainer(){
		$fbDiv = $(".fb");
		$fbDiv.html("");
		
		$fbformgroup = $("<div class='form-group'><label for='keyword' class='col-sm-2 control-label'>제목 검색</label><div class='col-sm-9'><input type='text' name='keyword' id='fbKeyword' placeholder='키워드를 입력하세요.' class='form-control'></div></div>");
		$fbpullright = $("<div class='pull-right'><button class='btn btn-primary' value='검색' onclick='fbPaging(1);' style='width: 100%;'>검색</button></div><br><br><br>");
		$fbtable = $("<table id='fbTable' style='width: 100%; text-align: center;' class='table table-striped table-bordered table-hover'><thead><tr class='info'><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th></tr></thead><tbody></tbody></table>");
		$fbinsertDiv = $("<div class='pull-right'><button id='insertfb' class='btn btn-primary' style='width: 100%;' value='글 작성' onclick='insertfb();'>글 작성</button></div><br><br>");
		$fbnav = $("<nav style='text-align: center;'><ul id='fbPaging' class='pagination'></ul></nav>");
		
		$fbDiv.append($fbformgroup);
		$fbDiv.append($fbpullright);
		$fbDiv.append($fbtable);
		
		<% if(loginUser != null){ %>
		$fbDiv.append($fbinsertDiv);
		<% } %>
		
		$fbDiv.append($fbnav);
	}
	
	//자유게시판 조회 및 페이징
	function fbLoad(){
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
				var $tr = $("<tr onclick='selectOneFb(this)'>");
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
 	}
	
	//직군게시판 틀
	function jbContainer(){
		$jbDiv = $(".jb");
		$jbDiv.html("");
		
		$jbformgroup = $("<div class='form-group'><label for='keyword' class='col-sm-2 control-label'>직업 검색</label><div class='col-sm-9'><select class='form-control' style='border-radius: 3px 3px 3px 3px; border: 1px solid lightgray;' id='jbCondition'><option value=''>직업을 선택해주세요</option><option value='무직'>무직</option><option value='학생'>학생</option><option value='IT'>IT</option><option value='언론'>언론</option><option value='공무원'>공무원</option><option value='군인'>군인</option><option value='서비스업'>서비스업</option><option value='교육'>교육</option><option value='금융/증권/보험업'>금융/증권/보험업</option><option value='유통업'>유통업</option><option value='예술'>예술</option><option value='의료'>의료</option><option value='법률'>법률</option><option value='건설업'>건설업</option><option value='제조업'>제조업</option><option value='부동산업'>부동산업</option><option value='운송업'>운송업</option><option value='농/수/임/광산업'>농/수/임/광산업</option><option value='가사'>가사</option><option value='기타'>기타</option></select></div></div>");
		$jbpullright = $("<div class='pull-right'><button class='btn btn-primary' value='검색' onclick='jbPaging(1);' style='width: 100%;'>검색</button></div><br><br><br>");
		$jbtable = $("<table id='jbTable' style='width: 100%; text-align: center;' class='table table-striped table-bordered table-hover'><thead><tr class='info'><th>번호</th><th>카테고리</th><th>제목</th><th>작성자</th><th>조회수</th></tr></thead><tbody></tbody></table>");
		$jbinsertDiv = $("<div class='pull-right'><button id='insertjb' class='btn btn-primary' style='width: 100%;' value='글 작성' onclick='insertjb();'>글 작성</button></div><br><br>");
		$jbnav = $("<nav style='text-align: center;'><ul id='jbPaging' class='pagination'></ul></nav>");
		
		$jbDiv.append($jbformgroup);
		$jbDiv.append($jbpullright);
		$jbDiv.append($jbtable);
		
		<% if(loginUser != null){ %>
		$jbDiv.append($jbinsertDiv);
		<% } %>
		
		$jbDiv.append($jbnav);
	}
	
	//직군게시판 조회 및 페이징
	function jbLoad(){
	$.ajax({
		url:"jobBoard.bo",
		data:{currentPage:1},
		success:function(data){
			var list = data["list"];
			var pi = data["pi"];
			console.log(pi);
			
			$tableBody = $("#jbTable tbody");
			$tableBody.html('');
			$.each(list, function(index, value){
				var $tr = $("<tr onclick='selectOneJb(this)'>");
				var $noTd = $("<td>").text(value.jbbid);
				var $categoryTd = $("<td>").text(value.jCategory);
				var $titleTd = $("<td>").text(value.title);
				var $writerTd = $("<td>").text(value.writer);
				var $countTd = $("<td>").text(value.bCount);
				
				$tr.append($noTd);
				$tr.append($categoryTd);
				$tr.append($titleTd);
				$tr.append($writerTd);
				$tr.append($countTd);
				$tableBody.append($tr);
			});
			
			$paging = $("#jbPaging");
			$paging.html('');
			var $firstTd = $('<li><a onclick="jbPaging(1);" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>');
			$paging.append($firstTd);
			for (var i = 0; i < pi.maxPage; i++) {
				$paging.append('<li><a onclick="jbPaging('+(i+1)+');">'+(i+1)+'</a></li>');
			}
			var $endTd = $('<li><a onclick="jbPaging('+pi.maxPage+');" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>');
			$paging.append($endTd);
		},
		error:function(){
			console.log("실패!");
		}
	});
	}
	
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
					var $tr = $("<tr onclick='selectOneFb(this)'>");
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
	
	//자유게시판 글등록 및 조회

		//게시글 작성 버튼 눌렀을 때
		function insertfb(){
			var $fbDiv = $(".fb");
			
			$fbDiv.html("");
			
			var $insertfbTable = $("<table class='table table-striped table-bordered' id='insertfbT' style='width: 100%; text-align: center;'>");
			var $fbTh = $("<thead><tr><th colspan='2' style='background-color:#eeeeee; text-align:center;'>자유게시판 게시글 등록</th></tr></thead>");
			var $fbTb = $("<tbody><tr><td><input type='text' class='form-control' placeholder='제목' name='fbTitle' maxlength='50'></td></tr><tr><td><textarea class='form-control' placeholder='내용' name='fbContent' maxlength='2048' style='height:200px; resize: none;'></textarea></td></tr></tbody>");
			
			$insertfbTable.append($fbTh);
			$insertfbTable.append($fbTb);

			var $fbbtnDiv = $("<div style='text-align: right;'>");
			<% if(loginUser != null) { %>
			var $fbUser = $("<input type='hidden' value='<%=loginUser.getUserId()%>' name='fbUserId'>");
			$fbbtnDiv.append($fbUser);
			<% } %>
			var $fbbackBtn = $("<button class='btn btn-primary' value='이전' id='fbBackBtn' style='width: 9%;' onclick='fbBackBtn()'>이전</button>");
			var $fbinsertBtn = $("<button class='btn btn-primary' value='등록' id='fbInsertBtn' style=' margin-left: 7px; width: 9%;' onclick='fbInsertBtn()'>등록</button>");
			
			$fbbtnDiv.append($fbbackBtn);
			$fbbtnDiv.append($fbinsertBtn);
			
			$fbDiv.append($insertfbTable);
			$fbDiv.append($fbbtnDiv);
		
		}
		
		//게시글 등록버튼 눌렀을 때 
		function fbInsertBtn(){
				console.log("게시글 등록 버튼 눌렸어용!");
				var fbUserId = $("input[name=fbUserId]").val();
				var fbTitle = $("input[name=fbTitle]").val();
				var fbContent = $("textarea[name=fbContent]").val();
				console.log(fbTitle);
				console.log(fbContent);
				if(fbTitle != "" && fbContent != ""){
				$.ajax({
					url:"<%= request.getContextPath()%>/freeBoardInsert.bo",
					type:"get",
					data:{fbUserId:fbUserId, fbTitle:fbTitle, fbContent:fbContent},
					success:function(data){
						console.log("게시글 등록 성공!");
					}
				});	
					fbContainer();
					fbLoad();
			 	}else{
					alert("게시글 등록에 실패하셨습니다.");
					fbContainer();
					fbLoad();
				}
		}		
	
		//게시글 작성에서 이전 버튼 눌렀을 때
		function fbBackBtn(){
			console.log("게시글 등록에서 이전 버튼 눌렸어용!");
			fbContainer();
			fbLoad();
		}		
		
		//자유게시판 상세보기
		function selectOneFb(tr){
 			var num = tr.childNodes[0].innerHTML;
			console.log(tr.childNodes[0].innerHTML);
			//console.log(tr);
			
			console.log(num + "번째 게시글 보기!");
			
			var $fbDiv = $(".fb");
			
			$fbDiv.html("");
			
			var $selectfbTable = $("<table class='table table-striped table-bordered' id='selectfbT' style='width: 100%; text-align: center;'>");
			var $fbTh = $("<thead><tr><th colspan='3' style='background-color:#eeeeee; text-align:center;'>자유게시판 게시글</th></tr></thead>");
			var $fbTb = $("<tbody><tr><td colspan='3'><label style=' width: 10%; display: inline-block; '>제목</label><input type='text' class='form-control' name='fbT' maxlength='50' readonly style=' width: 90%; display: inline-block; '></td></tr><tr><td><label style=' width: 28%; display: inline-block; '>작성자</label><input type='text' class='form-control' name='fbW' readonly style=' width: 66%; display: inline-block; '></td><td><label style=' width: 28%; display: inline-block; '>작성일</label><input type='text' class='form-control' name='fbD' readonly style=' width: 66%; display: inline-block; '></td><td><label style=' width: 28%; display: inline-block; '>조회수</label><input type='text' class='form-control' name='fbCnt' readonly style=' width: 66%; display: inline-block; '></td></tr><tr><td colspan='3'><textarea class='form-control' name='fbCon' maxlength='2048' style='height:200px; resize: none;' readonly></textarea></td></tr></tbody>");
			
			$selectfbTable.append($fbTh);
			$selectfbTable.append($fbTb);

			var $fbbtnDiv = $("<div style='text-align: right;'>");
			
			var $fbNum = $("<input type='hidden' value='" + num + "' name='fbNum'>");
			var $fbbackBtn = $("<button class='btn btn-primary' value='이전' id='fbBackBtn' style='width: 9%;' onclick='fbBackBtn()'>이전</button>");
			var $fbUpdateBtn = $("<button class='btn btn-primary' value='수정' id='fbUpdateBtn' style=' margin-left: 7px; width: 9%;' onclick='fbUpdateBtn()'>수정</button>");
			var $fbDeleteBtn = $("<button class='btn btn-primary' value='삭제' id='fbDeleteBtn' style=' margin-left: 7px; width: 9%;' onclick='fbDeleteBtn()'>삭제</button>");
			
			var $fbReplyDiv = $("<div class='fbReplyArea'>");	
			
			var $fbSRDiv = $("<div id='showFbReply'>");
			var $fbSRT = $("<table class='table table-striped table-bordered' id='fbSRT' style='border: 0px; width: 100%; text-align: center;'>");
			//var $fbSRTb = $("<tbody id='fbSRTb'></tbody>");
			
			//$fbSRT.append($fbSRTb);
			$fbSRDiv.append($fbSRT);
			
			var $fbWriteRDiv = $("<div class='writeFbReply'>");
			var $fbWRT = $("<table class='table table-striped table-bordered' id='fbWRT' style='width: 100%; text-align: center;'>");
			var $fbWRTb = $("<tbody><tr><td><textarea rows='3' cols='80' class='form-control' name='fbWR' placeholder='댓글을 남겨주세요.' id='fbWR' style='resize: none;'></textarea></td><td><button class='btn btn-primary' value='등록' id='fbWRBtn' style='margin-top: 20px;width: 100%' onclick='fbWRBtn()' disabled>등록</button></td></tr></tbody>");
			
			$fbWRT.append($fbWRTb);
			$fbWriteRDiv.append($fbWRT);
			
			$fbReplyDiv.append($fbSRDiv);
			$fbReplyDiv.append($fbWriteRDiv);
			
			//-> 댓글 공간
		
			$fbbtnDiv.append($fbNum);
			$fbbtnDiv.append($fbbackBtn);
			
			$fbDiv.append($selectfbTable);
			$fbDiv.append($fbReplyDiv);
			$fbDiv.append($fbbtnDiv);
			
			<% if(loginUser != null) { %>
				$("#fbWRBtn").removeAttr("disabled");
			<% } %>

			$.ajax({
				url:"selectOneFb.bo",
				type:"get",
				data:{num:num},
				success:function(data){
					<% if(loginUser != null) { %>
						var me = '<%=loginUser.getUserId()%>';						
						console.log("지금 로그인한 사용자 : " + me);
					<% } %>
					
					console.log("글 작성자 : " + data.writer);
					console.log(data);
					$("input[name=fbT]").val(data.title);
					$("input[name=fbW]").val(data.writer);
					$("input[name=fbCnt]").val(data.bCount);
					$("textarea[name=fbCon]").text(data.bContent);
					$("input[name=fbD]").val(data.bDate);
					
					<% if(loginUser != null) { %>
					if(data.writer === me){
						$fbbtnDiv.append($fbUpdateBtn);
						$fbbtnDiv.append($fbDeleteBtn);
						$("input[name=fbT]").removeAttr("readonly");
						$("textarea[name=fbCon]").removeAttr("readonly");
					}										
					<% } %>
				}
			});
		}		

		function fbUpdateBtn(){
			var num = $("input[name=fbNum]").val();
			var fbT = $("input[name=fbT]").val();
			var fbCon = $("textarea[name=fbCon]").val();
			
			$.ajax({
				url:"freeBoardUpdate.bo",
				type:"get",
				data:{num:num, fbT:fbT, fbCon:fbCon},
				success:function(data){
					console.log("게시글 수정 완료!!");
					alert("게시글이 수정되었습니다!");
					selectOneFb(tr);
				}
			});
		}
		
		function fbDeleteBtn(){
			var num = $("input[name=fbNum]").val();
			
			$.ajax({
				url:"freeBoardDelete.bo",
				type:"get",
				data:{num:num},
				success:function(data){
					console.log("게시글 삭제 완료!!");
					alert("게시글이 삭제되었습니다!");
					fbContainer();
					fbLoad();
				}
			});
		}
		
		//자유게시판 댓글달기
		function fbWRBtn(){
			<% if(loginUser != null) { %>
			var writer = '<%=loginUser.getUserId()%>';
			<% } %>
			var num = $("input[name=fbNum]").val();
			var content = $("#fbWR").val();
			
			$.ajax({
				url:"insertFbReply.bo",
				data:{writer:writer,content:content,num:num},
				type:"get",
				success:function(data){
					console.log(data);
					var $replySelectTable = $("#fbSRT");
					
					for(var key in data){
						var $tr = $("<tr>");
						var $userImg = $("<td style='width: 10%;'><img src='/rr/images/profile.PNG' style='border-radius:6em;'></td>");
						var $writerTd = $("<td style='font-size: 16px; width: 20%;'>").text(data[key].rWriter);
						var $contentTd = $("<td style='width: 60%;text-align: left;background: #f9f9f9;border-radius: 1em;padding-left: 15px;'>").text(data[key].rContent);
						//var $dateTd = $("<td>").text(data[key].rDate).css("width", "25%");
						var $dateP = $("<p style=' font-size: 12px; color: lightgray; '>").text(data[key].rDate);
						
						$tr.append($userImg);
						$tr.append($writerTd);
						$writerTd.append($dateP);
						$tr.append($contentTd);
						//$tr.append($dateTd);
						$replySelectTable.append($tr);
					}
				},
				error:function(){
					console.log("실패");
				}
			});
		}
		//-> 자유게시판 끝
		
		//직군게시판 페이징 및 검색 ajax
		function jbPaging(currentPage){
			var condition = $("#jbCondition").val();
			
			$.ajax({
				url:"searchJobBoard.bo",
				type:"get",
				data:{currentPage:currentPage,condition:condition},
				success:function(data){
					var list = data["list"];
					var pi = data["pi"];
					
					$tableBody = $("#jbTable tbody");
					$tableBody.html('');
					$.each(list, function(index, value){
						var $tr = $("<tr onclick='selectOneJb(this)'>");
						var $noTd = $("<td>").text(value.jbbid);
						var $categoryTd = $("<td>").text(value.jCategory);
						var $titleTd = $("<td>").text(value.title);
						var $writerTd = $("<td>").text(value.writer);
						var $countTd = $("<td>").text(value.bCount);
						
						$tr.append($noTd);
						$tr.append($categoryTd);
						$tr.append($titleTd);
						$tr.append($writerTd);
						$tr.append($countTd);
						$tableBody.append($tr);
					});
					
					$paging = $("#jbPaging");
					$paging.html('');
					var $firstTd = $('<li><a onclick="jbPaging(1);" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>');
					$paging.append($firstTd);
					for (var i = 0; i < pi.maxPage; i++) {
						$paging.append('<li><a onclick="jbPaging('+(i+1)+');">'+(i+1)+'</a></li>');
					}
					var $endTd = $('<li><a onclick="jbPaging('+pi.maxPage+');" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>');
					$paging.append($endTd);
				},
				error:function(){
					console.log("실패!");
				}
			});
		}
		
		//직군게시판 글등록 및 조회

			//게시글 작성 버튼 눌렀을 때
			function insertjb(){
				var $jbDiv = $(".jb");
				
				$jbDiv.html("");
				
				var $insertjbTable = $("<table class='table table-striped table-bordered' id='insertjbT' style='width: 100%; text-align: center;'>");
				var $jbTh = $("<thead><tr><th colspan='2' style='background-color:#eeeeee; text-align:center;'>자유게시판 게시글 등록</th></tr></thead>");
				var $jbTb = $("<tbody><tr><td style=' width: 39%; '><label style=' width: 24%; margin-top: 7px; float: left; margin-right: 7px;'>카테고리</label><div><select class='form-control' style='width: 73%; border-radius: 3px 3px 3px 3px; border: 1px solid lightgray;' id='jbCondition'><option value=''>직업을 선택해주세요</option><option value='무직'>무직</option><option value='학생'>학생</option><option value='IT'>IT</option><option value='언론'>언론</option><option value='공무원'>공무원</option><option value='군인'>군인</option><option value='서비스업'>서비스업</option><option value='교육'>교육</option><option value='금융/증권/보험업'>금융/증권/보험업</option><option value='유통업'>유통업</option><option value='예술'>예술</option><option value='의료'>의료</option><option value='법률'>법률</option><option value='건설업'>건설업</option><option value='제조업'>제조업</option><option value='부동산업'>부동산업</option><option value='운송업'>운송업</option><option value='농/수/임/광산업'>농/수/임/광산업</option><option value='가사'>가사</option><option value='기타'>기타</option></select></div></td><td colspan='3'><input type='text' class='form-control' placeholder='제목' name='jbTitle' maxlength='50'></td></tr><tr><td colspan='5'><textarea class='form-control' placeholder='내용' name='jbContent' maxlength='2048' style='height:200px; resize: none;'></textarea></td></tr></tbody>");
				
				$insertjbTable.append($jbTh);
				$insertjbTable.append($jbTb);

				var $jbbtnDiv = $("<div style='text-align: right;'>");
				<% if(loginUser != null) { %>
				var $fbUser = $("<input type='hidden' value='<%=loginUser.getUserId()%>' name='jbUserId'>");
				$jbbtnDiv.append($fbUser);
				<% } %>
				var $jbbackBtn = $("<button class='btn btn-primary' value='이전' id='jbBackBtn' style='width: 9%;' onclick='jbBackBtn()'>이전</button>");
				var $jbinsertBtn = $("<button class='btn btn-primary' value='등록' id='jbInsertBtn' style=' margin-left: 7px; width: 9%;' onclick='jbInsertBtn()'>등록</button>");
				
				$jbbtnDiv.append($jbbackBtn);
				$jbbtnDiv.append($jbinsertBtn);
				
				$jbDiv.append($insertjbTable);
				$jbDiv.append($jbbtnDiv);
			
			}
			
			//게시글 등록버튼 눌렀을 때 
			function jbInsertBtn(){
					console.log("게시글 등록 버튼 눌렸어용!");
					var jbUserId = $("input[name=jbUserId]").val();
					var jbTitle = $("input[name=jbTitle]").val();
					var jbContent = $("textarea[name=jbContent]").val();
					var jbCategory = $("#jbCondition").val();
					console.log(jbTitle);
					console.log(jbContent);
					console.log(jbCategory);
					if(jbTitle != "" && jbContent != ""){
					$.ajax({
						url:"<%= request.getContextPath()%>/JobBoardInsert.bo",
						type:"get",
						data:{jbUserId:jbUserId, jbTitle:jbTitle, jbContent:jbContent, jbCategory:jbCategory},
						success:function(data){
							console.log("게시글 등록 성공!");
						}
					});	
						jbContainer();
						jbLoad();
				 	}else{
						alert("게시글 등록에 실패하셨습니다.");
						jbContainer();
						jbLoad();
					}
			}		
		
			//게시글 작성에서 이전 버튼 눌렀을 때
			function jbBackBtn(){
				console.log("게시글 등록에서 이전 버튼 눌렸어용!");
				jbContainer();
				jbLoad();
			}		
			
			//직군게시판 상세보기
			function selectOneJb(tr){
	 			var num = tr.childNodes[0].innerHTML;
				console.log(tr.childNodes[0].innerHTML);
				//console.log(tr);
				
				console.log(num + "번째 게시글 보기!");
				
				var $jbDiv = $(".jb");
				
				$jbDiv.html("");
				
				var $selectjbTable = $("<table class='table table-striped table-bordered' id='selectjbT' style='width: 100%; text-align: center;'>");
				var $jbTh = $("<thead><tr><th colspan='3' style='background-color:#eeeeee; text-align:center;'>직군게시판 게시글</th></tr></thead>");
				var $jbTb = $("<tbody><tr><td colspan='1'><label style=' width: 28%; display: inline-block; '>카테고리</label><input type='text' class='form-control' name='jbCat' readonly style=' width: 66%; display: inline-block; '></td><td colspan='2'><label style=' width: 14%; display: inline-block; '>제목</label><input type='text' class='form-control' name='jbT' maxlength='50' readonly style=' width: 83%; display: inline-block; '></td></tr><tr><td><label style=' width: 28%; display: inline-block; '>작성자</label><input type='text' class='form-control' name='jbW' readonly style=' width: 66%; display: inline-block; '></td><td><label style=' width: 28%; display: inline-block; '>작성일</label><input type='text' class='form-control' name='jbD' readonly style=' width: 66%; display: inline-block; '></td><td><label style=' width: 28%; display: inline-block; '>조회수</label><input type='text' class='form-control' name='jbCnt' readonly style=' width: 66%; display: inline-block; '></td></tr><tr><td colspan='3'><textarea class='form-control' name='jbCon' maxlength='2048' style='height:200px; resize: none;' readonly></textarea></td></tr></tbody>");
				
				$selectjbTable.append($jbTh);
				$selectjbTable.append($jbTb);

				var $jbbtnDiv = $("<div style='text-align: right;'>");
				
				var $jbNum = $("<input type='hidden' value='" + num + "' name='jbNum'>");
				var $jbbackBtn = $("<button class='btn btn-primary' value='이전' id='jbBackBtn' style='width: 9%;' onclick='jbBackBtn()'>이전</button>");
				var $jbUpdateBtn = $("<button class='btn btn-primary' value='수정' id='jbUpdateBtn' style=' margin-left: 7px; width: 9%;' onclick='jbUpdateBtn()'>수정</button>");
				var $jbDeleteBtn = $("<button class='btn btn-primary' value='삭제' id='jbDeleteBtn' style=' margin-left: 7px; width: 9%;' onclick='jbDeleteBtn()'>삭제</button>");
				
				$jbbtnDiv.append($jbNum);
				$jbbtnDiv.append($jbbackBtn);
				
				$jbDiv.append($selectjbTable);
				$jbDiv.append($jbbtnDiv);
				
				$.ajax({
					url:"selectOneJb.bo",
					type:"get",
					data:{num:num},
					success:function(data){
						<% if(loginUser != null) { %>
							var me = '<%=loginUser.getUserId()%>';						
							console.log("지금 로그인한 사용자 : " + me);
						<% } %>
						
						console.log("글 작성자 : " + data.writer);
						console.log(data);
						$("input[name=jbCat]").val(data.jCategory);
						$("input[name=jbT]").val(data.title);
						$("input[name=jbW]").val(data.writer);
						$("input[name=jbCnt]").val(data.bCount);
						$("textarea[name=jbCon]").text(data.bContent);
						$("input[name=jbD]").val(data.bDate);
						
						<% if(loginUser != null) { %>
						if(data.writer === me){
							$jbbtnDiv.append($jbUpdateBtn);
							$jbbtnDiv.append($jbDeleteBtn);
							$("input[name=jbT]").removeAttr("readonly");
							$("textarea[name=jbCon]").removeAttr("readonly");
						}										
						<% } %>
					}
				});
			}		

			function jbUpdateBtn(){
				var num = $("input[name=jbNum]").val();
				var jbT = $("input[name=jbT]").val();
				var jbCon = $("textarea[name=jbCon]").val();
				
				$.ajax({
					url:"jobBoardUpdate.bo",
					type:"get",
					data:{num:num, jbT:jbT, jbCon:jbCon},
					success:function(data){
						console.log("게시글 수정 완료!!");
						alert("게시글이 수정되었습니다!");
						selectOneJb(tr);
					}
				});
			}
			
			function jbDeleteBtn(){
				var num = $("input[name=jbNum]").val();
				
				$.ajax({
					url:"jobBoardDelete.bo",
					type:"get",
					data:{num:num},
					success:function(data){
						console.log("게시글 삭제 완료!!");
						alert("게시글이 삭제되었습니다!");
						jbContainer();
						jbLoad();
					}
				});
			}
	</script>

</body>
</html>