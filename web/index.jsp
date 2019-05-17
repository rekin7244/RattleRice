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
	width: 100%;
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

.navbar-inverse {
	background: #F4AC8A;
	border: none;
}

.navbar-inverse .navbar-nav>li>a {
	color: black;
}

.contact-form {
	margin: 0 auto;
	padding: 10px;
	text-align: center;
	background: yellowgreen;
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
	<div class="container" id="div1">
		<h1
			style="font-weight: bold; font-family: 'Megrim', cursive; text-align: center">About
			Us</h1>
		<p style="text-align: center">딸랑밥을 소개합니다.</p>


		<div class="row content">

			<img src="images/section1.jpg" /> <br /> <br /> <br />
			<hr>
			<h4>딸랑밥 소개</h4>
			<div class="col-md-4">
				<img src="images/section1-face.jpg" height="300px"/>
			</div>
			<div id="siteIntroDiv" class="col-md-8">
				<p id="siteIntroduction">아니더면, 만물은 충분히 꽃이 인간은 황금시대의 이것이다. 이상은 눈이 충분히 끓는다. 무엇이 때까지 대고,
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
	<div class="container">

		<h1
			style="font-weight: bold; font-family: 'Megrim', cursive; text-align: center">Service</h1>
		<p id="serviceIntroduction" style="text-align: center">위치기반 최신 지도 서비스 및 게시판 기능을 제공합니다.</p>
		<div class="row content">


			<div class="col-md-6">
				<img src="images/section2-map.jpg" />
			</div>
			<div class="col-md-6">
				<img src="images/section2-board.png" />
			</div>
		</div>



	</div>


	<!--    제이쿼리 스크롤 이벤트를 위한 다이브 -->
	<div id="div3"></div>

	<br>
	<br>
	<!-- section3 : contact -->
	<div class="container">
		<h1
			style="font-weight: bold; font-family: 'Megrim', cursive; text-align: center">Contact</h1>
		<p style="text-align: center">지.금.제.휴.해</p>
		<br />
		<div class="row content">

			<div class="contact-form">

				<form action="" method="post">
				
					<table>
						<colgroup>
							<col width="100px" />
							<col width="*" />
							<col width="100px" />
							<col width="320px" />
						</colgroup>
						<tr>
							<td colspan="4" style="font-size: 12px;">*는 필수 입력 사항 입니다.</td>
						</tr>
						<tr>
							<td>이름 *</td>
							<td><input type="text" class="input_type01"
								style="width: 170px" id="uname" value="" name="uname" /></td>
							<td>희망지역 *</td>
							<td><select class="selectbox_custom news" name="area1"
								style="width: 110px;">
									<option>시/도</option>
									<option value="서울">서울</option>
									<option value="경기">경기</option>
									<option value="인천">인천</option>
									<option value="강원">강원</option>
									<option value="충남">충남</option>
									<option value="대전">대전</option>
									<option value="충북">충북</option>
									<option value="부산">부산</option>
									<option value="울산">울산</option>
									<option value="대구">대구</option>
									<option value="강북">강북</option>
									<option value="경남">경남</option>
									<option value="전남">전남</option>
									<option value="광주">광주</option>
									<option value="전북">전북</option>
									<option value="제주">제주</option>
							</select> <span id="asdfc1"> <select class="selectbox_custom news"
									name="area2" style="width: 150px;">
										<option>시/군/구</option>
								</select>
							</span></td>

						</tr>
						<tr>
							<td>핸드폰번호 *</td>
							<td><input type="text" class="input_type02" id="tel1"
								value="" maxlength="4" name="tel1" /> <input type="text"
								class="input_type02" id="tel2" value="" maxlength="4"
								name="tel2" /> <input type="text" class="input_type02"
								id="tel3" value="" maxlength="4" name="tel3" /></td>
							<td>문의내용</td>
							<td><input type="text" class="input_type01" id="title"
								style="width: 260px;" value="" name="title" /></td>
						</tr>
						<tr>

						</tr>
						<tr>
							<td colspan="4">
								<div class="termsWrap">
									<h3>
										<strong>개인정보 수집약관 동의</strong>
									</h3>
									<ul id="termsInfo" class="terms" type="none"></ul>
									<p>
										<label><input type="checkbox" id="cb9" name="check"
											value="Y"
											onclick="setCheckBoxAsRadio(PageForm.check_yn,this)" />&nbsp;동의</label>
										<label><input type="checkbox" id="cb9" name="check"
											value="N"
											onclick="setCheckBoxAsRadio(PageForm.check_yn,this)" checked />&nbsp;비동의</label>
									</p>
								</div>
							</td>
						</tr>

					</table>

					<p class="MainConsult_Btn">
						<span>창업상담 신청하기</span>
					</p>


				</form>
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
		<p align="center">공지사항을 읽어주세요</p>
		<br>

		<div class="container-fluid">
			<div class="row content">
					<div class="form-group">
						<label for="keyword" class="col-sm-2 control-label">제목 검색</label>
						<div class="col-sm-9">
							<input type="text" name="keyword" id="noticeKeyword"
								placeholder="키워드를 입력하세요" class="form-control">
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
		<p align="center">자주 물어보시는 질문입니다</p>
		<br>

		<div class="container-fluid">
			<div class="row content">
					<div class="form-group">
						<label for="keyword" class="col-sm-2 control-label">제목 검색</label>
						<div class="col-sm-9">
							<input type="text" id="faqKeyword"
								placeholder="키워드를 입력하세요" class="form-control">
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
		<p align="center">후기글들입니다</p>
		<br>

		<div class="container-fluid">
			<div class="row content">
					<div class="form-group">
						<label for="keyword" class="col-sm-2 control-label">가게명 검색</label>
						<div class="col-sm-9">
							<input type="text" id="reviewKeyword"
								placeholder="가게명을 입력하세요" class="form-control">
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
	
	/* //공지사항 검색 ajax
	function searchNotice(){
		var keyword = $("#noticekeyword").val();
		var condition = $("#noticeCondition").val();
		$.ajax({
			url:"searchNoticeBoard.bo",
			type:"get",
			data:{currentPage:1,keyword:keyword,condition:condition},
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
	} */
	</script>

</body>
</html>