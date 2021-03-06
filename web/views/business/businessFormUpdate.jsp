<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.rr.member.model.vo.*"%>
	
<% 
		ArrayList<HashMap<String, Object>> list = 
			(ArrayList<HashMap<String, Object>>) request.getAttribute("list");
		System.out.println("FormUpdate : " + list);
		
		/* StoreMenuInfo menuInfo = new StoreMenuInfo();
		System.out.println(menuInfo);*/
		
		/* ArrayList<Attachment> fileList = (ArrayList<Attachment>) request.getAttribute("fileList");
		System.out.println("fileList : " + fileList); */
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<title>사업자 페이지</title>

<!-- Bootstrap CSS CDN -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
<!-- Scrollbar Custom CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css">

<!-- Font Awesome JS -->
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"
	integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ"
	crossorigin="anonymous"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"
	integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY"
	crossorigin="anonymous"></script>

<style>
@import
	"https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700";

/* contents영역 */
body {
	font-family: 'Poppins', sans-serif;
	background: #fafafa;
}

/* 환영메세지 */
p {
	text-align: center;
	font-family: 'Poppins', sans-serif;
	font-size: 1.1em;
	font-weight: 300;
	line-height: 1.7em;
	color: #999;
}

/* sidebar menu*/
a, a:hover, a:focus {
	color: inherit;
	text-decoration: none;
	transition: all 0.3s;
}

/* ---------------------------------------------------
    SIDEBAR STYLE
----------------------------------------------------- */
.wrapper {
	display: flex;
	width: 100%;
}

#sidebar {
	width: 250px;
	position: fixed;
	top: 0;
	left: 0;
	height: 100vh;
	z-index: 999;
	background: #7386D5;
	color: #fff;
	transition: all 0.3s;
}

#sidebar.active {
	margin-left: -250px;
}

#sidebar .sidebar-header {
	text-align: right;
	padding: 10px;
	background: #aaaaaa;
}

#sidebar ul.components {
	padding: 20px 0;
	border-bottom: 1px solid #47748b;
}

#sidebar ul p {
	color: #fff;
	padding: 10px;
}

#sidebar ul li a {
	padding: 10px;
	font-size: 1.1em;
	display: block;
}

#sidebar ul li a:hover {
	color: black;
	background: #fff;
}

#sidebar ul li.active>a, a[aria-expanded="true"] {
	color: #fff;
	background: #6d7fcc;
}

a[data-toggle="collapse"] {
	position: relative;
}

.dropdown-toggle::after {
	display: block;
	position: absolute;
	top: 50%;
	right: 20px;
	transform: translateY(-50%);
}

ul ul a {
	font-size: 0.9em !important;
	padding-left: 30px !important;
	background: #739BE1;
}

ul.CTAs {
	padding: 20px;
}

ul.CTAs a {
	text-align: center;
	font-size: 0.9em !important;
	display: block;
	border-radius: 5px;
	margin-bottom: 5px;
}

a.download {
	background: #fff;
	color: #7386D5;
}

a.article, a.article:hover {
	background: #6d7fcc !important;
	color: #fff !important;
}

/* ---------------------------------------------------
    CONTENT STYLE
----------------------------------------------------- */
#content {
	width: calc(100% - 250px);
	padding: 0px;
	min-height: 100vh;
	transition: all 0.3s;
	position: absolute;
	top: 0;
	right: 0;
}

#content.active {
	width: 100%;
}

/* ---------------------------------------------------
    MEDIAQUERIES
----------------------------------------------------- */
@media ( max-width : 768px) {
	#sidebar {
		margin-left: -250px;
	}
	#sidebar.active {
		margin-left: 0;
	}
	#content {
		width: 100%;
	}
	#content.active {
		width: calc(100% - 250px);
	}
	#sidebarCollapse span {
		display: none;
	}
}

.container ul {
	list-style: none;
	padding: 0;
}

.li2 {
	float: right;
}
.buttonPadding{
padding-bottom: 30px;
}

#topMenu li {
	margin-right:20px;
}

.active {
	background: gray;
	color: white;
}
</style>
</head>

<body>
	<%@ include file="menubar_business.jsp" %>
		<!-- Page Content  -->
		<div id="content">

			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="container-fluid">

					<button type="button" id="sidebarCollapse" class="btn btn-info">
						<i class="fas fa-align-left"></i> <span>menu</span>
					</button>
					<button class="btn btn-dark d-inline-block d-lg-none ml-auto"
						type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<i class="fas fa-align-justify"></i>
					</button>

					<button class="btn btn-dark d-inline-block d-lg-none ml-auto"
						type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<i class="fas fa-align-justify"></i>
					</button>

					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="nav navbar-nav ml-auto">
							<li class="nav-item"><a class="nav-link"
								href="reservationForm.jsp">예약관리</a></li>
							<li class="nav-item active"><a class="nav-link"
								href="businessFormShop.jsp">매장관리</a></li>
							 <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath() %>/logout.me">로그아웃</a></li>
							
						</ul>
					</div>
				</div>
			</nav>


			<div class="container col-sm-9" style='text-align:center;'>
				<!-- div class="buttonPadding">
					<ul id="topMenu">
						<li class="li2"><button type="submit" style="float: right;">적용</button></li>
						<li class="li2"><button style="float: right;">미리보기</button>
					</ul>
				</div> -->
				<div class="row"
					style="border: 0.5px solid lightgray; padding:10px; 
					overflow-x: auto;">
					<h4>매장정보</h4>
					<form action="<%=request.getContextPath() %>/businessInfoUpdate.b" method="post" class="form-control">
					
					<br>
						<table align="center"
							style="min-width: 500px; border-collapse: separate; border-spacing: 0 10px;">
							<% if(list != null){
								HashMap<String, Object> hmap=null;
							for(int i = 0; i < list.size(); i++){ 
								hmap = list.get(0);
							}
							%>
							<tr>
								<td><label>매장명 : </label></td>
								<td><input type="text" name="brand" value='<%=hmap.get("brand") %>'></td>
							</tr>
							<tr>
								<td><label>hp : </label></td>
								<td><input type="tel" name="phone" value='<%=hmap.get("contact") %>'></td>
							</tr>
							<tr>
								<td><label>위치 : </label></td>
								<td><input type="text" name="address" value='<%=hmap.get("location") %>'></td>
							</tr>
							<tr>
								<td><label>영업시간 : </label></td>
								<td><input type="time" name="openTime1" value='<%=hmap.get("opening_hore") %>'>
								  <input type="time" id="closeTime" name="closeTime1" value='<%=hmap.get("close_hore") %>'></td>
							</tr>
							
							<tr>
								<td><label>간단한 소개 : </label></td>
								<td><input type="text" name="introducer" value='<%=hmap.get("intro") %>'
									style="height: 65px;"></td>
							</tr>
							<%  
							  }	else{					
							%>
							<tr>
								<td><label>hp : </label></td>
								<td><input type="tel" name="phone"></td>
							</tr>
							<tr>
								<td><label>위치 : </label></td>
								<td><input type="text" name="address"></td>
							</tr>
							<tr>
								<td><label>영업시간 : </label></td>
								<td><input type="time" name="openTime1"></td>
								<td><input type="time" name="closeTime1"></td>
							</tr>
							
							<tr>
								<td><label>간단한 소개 : </label></td>
								<td><input type="text" name="introducer"
									style="width: 175px; height: 80px;"></td>
							</tr>
							
							<%} %>
							
						</table>
						<button type="submit" id="submitBtn1" class="btn btn-primary" style='margin: 20px 0;'>적용하기</button>
					</form>
				</div>
				<div class="row"
					style="border: 0.5px solid lightgray; padding:10px; 
					overflow-x: auto; overflow-y:auto;">
					<h4 align="center">메뉴</h4>
					<br><br>
					
					<form action="menuInfoUpdate.b" method="post" class="form-control">
						<table class="table table-bordered" id="menuTable1" style="min-width: 500px;">
							<thead>
								<tr style="background: lightgray">
									<th align="center">메뉴명</th>
									<th align="center">가격</th>
									<th align="center">원산지</th>
								</tr>
							</thead>
							<tbody>
							<% 
							for(int i = 0; i < list.size(); i++){ 
								HashMap<String, Object> hmap = list.get(i);
							%> 
								<tr>
									<td><input type="text" name="menu" value='<%= hmap.get("menu")%>'></td>
									<td><input type="number" name="menuPrice" value='<%= hmap.get("price")%>'></td>
									<td><input type="text" name="origin" value='<%=hmap.get("origin") %>'></td>
									<input type="hidden" name="mid" value='<%=hmap.get("mId") %>'>
								</tr>
							<% } %>
							</tbody>
						</table>
						<button type="submit" class="btn btn-primary"  style='margin: 20px 0;'>수정하기</button>
					</form>
						<br>
						<div style="width: 100%; text-align: right;margin: 20px 0;">
						<button id="menuAdd">+</button>
						
						</div>
						<form action="menuInfoInsert.b" method="post" style="width: 100%;" class="form-control">
						<table class="table table-bordered" id="menuTable" style="min-width: 500px;">
							<thead>
								<tr style="background: lightgray">
									<th align="center">메뉴명</th>
									<th align="center">가격</th>
									<th align="center">원산지</th>
								</tr>
							</thead>
							<tbody>
							
								<!-- <tr>
									<td><input type="text" name="menu"></td>
									<td><input type="number" name="menuPrice" ></td>
									<td><input type="text" name="origin"></td>
									<input type="hidden" name="mid">
								</tr> -->
							</tbody>
							
						</table>
						<input type="hidden" value="0" id="lastCtn" name="lastCtn">
				<!-- <script>
					var ctn = 0;
					$("#menuAdd").click(function(){
						
						console.log("function동작");
						ctn++;
						$("#lastCtn").val(ctn);
						console.log(ctn);
						
						//var menuArray = new Array(ctn);
						
						$("#menuTable > tbody:last").append(
								"<tr><td>" + '<input type="text" class=menu' + ctn + '" name=menu">' + "</td>"
								+ "<td>" + '<input type="number" name="menuPrice' + ctn + '">' + "</td>"
								+ "<td>" + '<input type="text" name="origin' + ctn + '">' + "</td>" + 
								+ "<td>" + '<input type="hidden" name="count" value="'+ ctn + '" >' + "</td></tr>");
						
						
					});
					
					$("#submitBtn1").click(function(){
						alert("매장정보가 수정되었습니다");
					});
				</script> -->
							<button class ="submitBtn2 btn btn-primary" type="button" style='margin: 20px 0;'>추가하기</button>
						</form>
					
					<br>
					<hr>
					<br>
				
				</div>
				
				
				<div class="row"
					style="border: 0.5px solid lightgray; padding:10px;">
				
						<form action="<%= request.getContextPath() %>/updateImg" method="post"
							encType="multipart/form-data" class="form-control">
							
						<h4 align='left'>사진첨부</h4>
						
						
						<!-- 이미지첨부 -->
						<div id="contentImgArea"
							style="border: 0.5px solid lightgray;">
							
						
								<%
								 HashMap<String, Object> hamp = list.get(0);
								%>
								<img id="contentImg" src="/rr/profileImg_upload/<%=hamp.get("changeName")%>">
							<div id="fileArea">
								<input type="file" id="contentImg2" name="contentImg" 
									onchange="loadImg(this)" class='form-control'> 
						    </div>
								
						</div>
					
						<button type="submit" id="storeImgUpdate" class='btn btn-primary' style='margin: 20px 0;'>적용하기</button>
					</form>
					
				</div>

			</div>
		</div>
	</div>
	<script>

	$(function(){
			$(".submitBtn").click(function(){
				console.log($(".menuData"));
				
				console.log($(".price"));
				console.log($(".origin"));
				var menuArr = new Array();
				for(var i=0; i<$(".menuData").length; i++){
					menuArr[i] = $(".menuData")[i].value +"/"+ $(".price")[i].value +"/"+ $(".origin")[i].value;
				}
				console.log(menuArr);
				
				location.href = "menuInfoInsert.b?menuArr=" + menuArr.join(",");
				
			});
		
			$("#thumbnailImg").addClass("active");
			console.log("thumbnailImg");
			
		
		
	});
	//이미지 업로드
	function loadImg(value){
		if(value.files && value.files[0]){
			var reader = new FileReader();
			reader.onload = function(e){
				 $("#contentImg").removeAttr("src");
					$("#contentImg").attr("src", e.target.result);
					}
			
			reader.readAsDataURL(value.files[0]);
		}
	};
	var ctn = 0;
	$("#menuAdd").click(function(){
		
		console.log("function동작");
		ctn++;
		$("#lastCtn").val(ctn);
		console.log(ctn);
		
		//var menuArray = new Array(ctn);
		
		$("#menuTable > tbody:last").append(
				"<tr><td>" + '<input type="text" class=menuData ' + ctn + '" name=menu">' + "</td>"
				+ "<td>" + '<input type="number" class=price name="menuPrice' + ctn + '">' + "</td>"
				+ "<td>" + '<input type="text" class=origin name="origin' + ctn + '">' + "</td>" + 
				+ "<td>" + '<input type="hidden"  name="count" value="'+ ctn + '" >' + "</td></tr>");
		
		
	});
	
	$("#submitBtn1").click(function(){
		alert("매장정보가 수정되었습니다");
	});
	</script>


	<!-- jQuery CDN - Slim version (=without AJAX) -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<!-- Popper.JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
		integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
		crossorigin="anonymous"></script>
	<!-- Bootstrap JS -->
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
		integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
		crossorigin="anonymous"></script>
	<!-- jQuery Custom Scroller CDN -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.concat.min.js"></script>

	
</body>

</html>