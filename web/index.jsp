<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.rr.member.model.vo.Member"%>
	
<%
	Member loginUser = (Member) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<title>딸랑밥</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
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

.fixed .icon {
	font-size: 3em;
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
					<li><a onclick="fnMove('4')">FAQ</a></li>
					<!--                <li><a href="views/business/businessForm.jsp">사업자 로그인</a></li> -->
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li data-toggle="modal" data-target="#joinModla"><a
						style="font-family: 'Megrim', cursive; font-weight: bold;"><span
							class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li data-toggle="modal" data-target="#myModal"><a
						style="font-family: 'Megrim', cursive; font-weight: bold;"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</ul>
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
			<h4>개발자 소개</h4>
			<div class="col-md-4">
				<img src="images/section1-face.jpg" />
			</div>
			<div class="col-md-8">
				<p>아니더면, 만물은 충분히 꽃이 인간은 황금시대의 이것이다. 이상은 눈이 충분히 끓는다. 무엇이 때까지 대고,
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
		<p style="text-align: center">위치기반 최신 지도 서비스 및 게시판 기능을 제공합니다.</p>
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
					<!--                <input type="text" placeholder="아이디" name="userId" id="userId"><br> -->
					<!--                <input type="password" placeholder="패스워드" name="password" id="password"><br> -->
					<!--                <input type="password" placeholder="패스워드 확인" name="password2" id="password2"><br> -->
					<!--                <input type="text" placeholder="이름" name="userName" id="userName"><br> -->
					<!--                <input type="email" placeholder="이메일" name="email" id="email"><br> -->
					<!--                <input type="tel" placeholder="휴대폰" name="phone" id="phone"><br> -->
					<!--                <input type="text" placeholder="주소" name="address" id="address"><br> -->

					<!--                <label>성별 : </label> -->
					<!--                <input type="radio" name="gender" id="male" value="M"> -->
					<!--                <label for="male">남</label> -->
					<!--                <input type="radio" name="gender" id="female" value="F"> -->
					<!--                <label for="female">여</label> -->

					<!--                <br> -->

					<!--                <input type="text" placeholder="나이" name="age" id="age"><br> -->

					<!--                <label>취미 : </label> -->
					<!--                <input type="checkbox" name="hobby" id="hobby0" value="운동"> -->
					<!--                <label for="hobby0">운동</label> -->
					<!--                <input type="checkbox" name="hobby" id="hobby1" value="등산"> -->
					<!--                <label for="hobby1">등산</label> -->
					<!--                <input type="checkbox" name="hobby" id="hobby2" value="독서"> -->
					<!--                <label for="hobby2">독서</label> -->
					<!--                <input type="checkbox" name="hobby" id="hobby3" value="게임"> -->
					<!--                <label for="hobby3">게임</label> -->
					<!--                <input type="checkbox" name="hobby" id="hobby4" value="여행"> -->
					<!--                <label for="hobby4">여행</label> -->

					<!--                <br><br> -->

					<!--                <input type="submit" value="가입">&nbsp;&nbsp; -->
					<!--                <input type="reset" value="취소"> -->
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
									<ul class="terms">
										<li>1. 개인정보 수집 및 이용에 관한 사항 (필수) 회사는 고객서비스 제공을 위해 귀하의
											개인정보를 아래와 같이 수집하고자 합니다.</li>
										<li>2. 수집하는 개인정보의 항목<br> <span class="pdL12">(가)
												이름, 연락처, 희망개설지역 <br>
										</span> <span class="pdL12">(나) 서비스 이용과정이나 처리과정간 아래 정보들이 생성되어
												수집될 수 있습니다. <br>
										</span> <span class="pdL12">: 서비스 이용기록, 접속로그, 쿠키, 접속IP정보 </span>
										</li>
										<li>3. 수집 및 이용목적 – 상담진행을 위한 가맹지원 희망자의 개인정보 및 연락처 파악</li>
										<li>4. 개인정보의 보유 및 이용기간 –원칙적으로 개인정보의 수집목적 또는 제공받은 목적이 달성 시
											지체 없이 파기합니다.<br> <span class="pdL12">전자상거래 등에서의
												소비자보호에 관한 법률에 따라 고객의 불만 또는 분쟁처리에 관한 기록은 6개월 간 보관됩니다. 
										</li>
										<li>* 서비스 제공을 위해 필요한 최소한의 개인정보이므로 동의를 해주셔야 서비스를 이용하실 수
											있습니다. <br> * 개인정보의 수집 및 이용에 관한 사항에 동의하십니까?
										</li>
									</ul>
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

	<!-- section4 : FAQ  -->
	<div class="container">


		<h1
			style="font-weight: bold; font-family: 'Megrim', cursive; text-align: center">FAQ</h1>
		<p align="center">자주 물어보시는 질문입니다</p>
		<br>

		<div class="container-fluid">
			<div class="row content">
				<form action="" method="get" class="form-horizontal">
					<div class="form-group">
						<label for="keyword" class="col-sm-2 control-label">제목 검색</label>
						<div class="col-sm-9">
							<input type="text" name="keyword" id="keyword"
								placeholder="키워드를 입력하세요" class="form-control">
						</div>
					</div>

					<div class="form-group">
						<label for="keyword" class="col-sm-2 control-label">상담 유형</label>
						<div class="col-sm-9">
							<select class="form-control">
								<option>1</option>
								<option>2</option>
								<option>3</option>
							</select>
						</div>
					</div>
					<br>
					<div class="pull-right">
						<button type="submit" class="btn btn-primary" value="검색"
							onclick="" style="width: 100%;">검색</button>
					</div>
					<br>

				</form>
				<br> <br>
				<table style="width: 100%; text-align: center;"
					class="table table-striped table-bordered table-hover">
					<tr class="info">
						<th>번호</th>
						<th>상담유형</th>
						<th>질문</th>
						<th>조회수</th>
					</tr>
					<tr>
						<td>1</td>
						<td>2</td>
						<td>3</td>
						<td>4</td>
					</tr>
					<tr>
						<td>1</td>
						<td>2</td>
						<td>3</td>
						<td>4</td>
					</tr>
					<tr>
						<td>1</td>
						<td>2</td>
						<td>3</td>
						<td>4</td>
					</tr>
					<tr>
						<td>1</td>
						<td>2</td>
						<td>3</td>
						<td>4</td>
					</tr>
					<tr>
						<td>1</td>
						<td>2</td>
						<td>3</td>
						<td>4</td>
					</tr>
				</table>
				<nav style="text-align: center;">
					<ul class="pagination">
						<li><a href="#" aria-label="Previous"> <span
								aria-hidden="true">&laquo;</span>
						</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#" aria-label="Next"> <span
								aria-hidden="true">&raquo;</span>
						</a></li>
					</ul>
				</nav>
			</div>
		</div>


	</div>
	<br>
	<br>
	
	<%if(loginUser != null){ %>
		<div class="fixed">
			<a
				onclick="window.open('views/matching/main.jsp', '', 'top=50px, left=800px, height=500, width=400')"><i
				class="comment outline icon"></i></a>
		</div>
		
	<%}else{ %>
	
	<%} %>
	<div class="footer">
		<%@ include file="views/common/footer.jsp"%>
	</div>

</body>
</html>