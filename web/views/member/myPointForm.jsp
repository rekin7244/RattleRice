<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.kh.rr.member.model.vo.Member ,java.util.*"%>

<%
	Member loginUser = (Member) session.getAttribute("loginUser");
ArrayList<HashMap<String, Object>> list = (ArrayList<HashMap<String, Object>>) request.getAttribute("list");
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
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

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

.row {
	/* width: 1530px; */
	
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

.profile {
	
}

.form1, .form2 {
	margin-top: 30px;
}

.form1 {
	padding-left: 30px;
}

.form2 {
	padding-right: 30px;
}

.img {
	
}

.form-input {
	width: auto;
	display: inline-block;
}

#inProfileImg {
	object-fit: cover;
	border-radius: 50%;
}

.form-group {
	display: block;
}

#userUpdateBtn {
	
}

#userArea {
	margin-left: 120px;
	margin-right: 100px;
}

width
:
 
50%;
}
input, textarea {
	text-align: center;
}

.well {
	
}

.col-sm-5 {
	width: auto;
}

#profileImgUpdateBtn {
	background-color: lightgray;
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

tr>th, tr>td {
	width: 10%;
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
				<div>
					<div>
					<%HashMap<String, Object> pointHmap = list.get(0); %>
					
						<h2>보유 Point : <%=pointHmap.get("point")%>&nbsp;P</h2>
						<h2>보유 Bell : <%=pointHmap.get("bell")%>&nbsp;B</h2>
						<select id="pointSelect">
							<option value="2000">2,000p</option>
							<option value="5000">5,000p</option>
							<option value="10000">10,000p</option>
							<option value="15000">15,000p</option>
							<option value="20000">20,000p</option>
							<option value="25000">25,000p</option>
							<option value="30000">30,000p</option>
						</select>
						<button type="button" class="btn btn-warning"
							onclick="pointCharge()">포인트 충전</button>
					</div>


					<div class="container">
						<br>
						<table class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>날짜 <input class="form-control" id="myInput1"
										type="text" placeholder="날짜 검색"></th>
									<th>금액<input class="form-control" id="myInput2"
										type="text" placeholder="금액 검색"></th>
									<th>분류<input class="form-control" id="myInput3"
										type="text" placeholder="분류 검색"></th>
									<th>상태<input class="form-control" id="myInput4"
										type="text" placeholder="상태 검색"></th>

								</tr>
							</thead>
							<tbody id="myTable">
								<%
									for (int i = 0; i < list.size(); i++) {
										HashMap<String, Object> hmap = list.get(i);
								%>
								<tr>
									<td><%=hmap.get("date")%></td>
									<td><%=hmap.get("price")%>원</td>
									<%
										if (hmap.get("unit").equals("PO")) {
									%>
									<td>Point</td>
									<%
										} else if(hmap.get("unit").equals("BE")){
									%>
									<td>Bell</td>
									<%
										}
									%>
									<%
										if (hmap.get("type").equals("CH")) {
									%>
									<td>충전</td>
									<%
										} else if(hmap.get("type").equals("RE")){
									%>
									<td>환불</td>
									<%
										}else if (hmap.get("payment").equals("PAY")){
									%>
									<td>사용</td>
									<%
										}
									%>
								</tr>
								<%
									}
								%>

							</tbody>
						</table>
						<br>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="userInfo">
		<input value="<%=loginUser.getUserName()%>" id="pointUserName">
		<input value="<%=loginUser.getEmail()%>" id="pointUserEmail">
		<input value="<%=loginUser.getPhone()%>" id="pointUserPhone">
		<input value="<%=loginUser.getUserId()%>" id="pointUserId">
	</div>


	<script>
		
	$(function() {
		$(".userInfo").hide();
		$('#point').addClass('active');
	});
	
	
		$(document).ready(function(){
		  $("#myInput1").on("keyup", function() {
		    var value = $(this).val().toLowerCase();
		    
		    $("#myTable tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		  });
		});
	
		
		
		function pointCharge() {
			
			
			//var userId=loginUser.getUserName();
			var email =$("#pointUserEmail").val();
			var name =$("#pointUserName").val();
			var phone =$("#pointUserPhone").val();
			var userId = $("#pointUserId").val();
			var selectAmount =$("#pointSelect option:selected").val();
			
			/* IMP.init('imp06499175'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
			IMP.request_pay({
				pg : 'inicis', // version 1.1.0부터 지원.
				pay_method : 'card',
				merchant_uid : 'merchant_' + new Date().getTime(), //결제 방식
				name : '딸랑밥 Point 충전',//주문명 이름
				amount : selectAmount,//금액
				buyer_email : email,//결제자 email
				buyer_name : name,//결제자 이름
				buyer_tel : phone,//결제자 번호
				//buyer_addr : '서울특별시 강남구 삼성동',//결제자 주소
				//buyer_postcode : '123-456',//결제자 우편번호
				m_redirect_url : 'http://127.0.0.1:8001/rr/views/member/myPointForm.jsp'
			}, function(rsp) {
				if (rsp.success) {
					var msg = '결제가 완료되었습니다.';
					msg += '고유ID : ' + rsp.imp_uid;
					msg += '상점 거래ID : ' + rsp.merchant_uid;
					msg += '결제 금액 : ' + rsp.paid_amount;
					msg += '카드 승인번호 : ' + rsp.apply_num; */
					
					$.ajax({
						url:"<%=request.getContextPath()%>/pointCharge",
						data: {amount:selectAmount, userId:userId},
						type:"post",
						success:function(){
							console.log("ajax성공!");
							alert("테스트 결제 성공");
							window.location.reload();
						},
						error:function(data){
							console.log("ajax실패!");
							alert("테스트 결제 실패");
						}
					});
					
					
				/* } else {
					var msg = '결제에 실패하였습니다.';
					msg += '에러내용 : ' + rsp.error_msg;
				}
				alert(msg);
			}); */
		};
	</script>

</body>
</html>