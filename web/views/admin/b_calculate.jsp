<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>정산 관리</title>

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

/* .wrapper {
	display: flex;
	width: 100%;
} */
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

/* page표시 */
#sidebar .sidebar-header {
	text-align: right;
	padding: 20px;
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

a.article, a.article:hover {
	background: #6d7fcc !important;
	color: #fff !important;
}

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
</style>
</head>

<body>
	<%@ include file="menubar_admin.jsp"%>
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
					<a>사업자 정산</a>
				</div>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="nav navbar-nav ml-auto">
						<li class="nav-item active"><a class="nav-link" href="adminForm.jsp">회원관리</a></li>
						<li class="nav-item"><a class="nav-link" href="community.jsp">커뮤니티</a></li>
						<li class="nav-item"><a class="nav-link" href="calculate.jsp">정산</a></li>
						<li class="nav-item"><a class="nav-link" href="sms.jsp">SMS</a></li>
						<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath() %>/logout.me">로그아웃</a></li>
					</ul>
				</div>
			</div>

		</nav>
	
	
	<br><br> 
		<input type="text" id="searchBrand" placeholder="상호명">
		<button onclick='search()'>검색</button>
		<table class="table table-bordered" id="tableId">

			<thead>
				<tr style="background: lightgray" align="center">
					<th><input type="checkbox" id="selectAll"></th>
					<th>사업자번호</th>
					<th>상호명</th>
					<th>은행</th>
					<th>계좌번호</th>
					<th>카드 매출</th>
					<th>관리</th>
				</tr>
			</thead>

			<tbody align="center"></tbody>
		</table>
		<div id="pagingArea" align="left">
		<button onclick="reserveSettleChecked()" class="btn pull-left">정산</button>
			<ul id="paging" class="pagination"></ul>
		</div>
	</div>
	<script>
		$(function(){
			$.ajax({
				url:"<%=request.getContextPath()%>/reserveSettleList.ad",
				type:"post",
				success:function(data){
					setList(data);
				}
			});
		});
	
		function setList(data){
			var list = data["list"];
			var pi = data["pi"];
			
			$tableBody = $("#tableId tbody");
			$tableBody.html('');
			$.each(list, function(index, value){
				var status = value.status;
				var $tr = $("<tr>");
				if(status=='Y'){
					var $hiddenRid = $("<input type='hidden' value='"+value.rid+"'>");
					var $checkInput = $("<input type='checkbox' class='checkMember'>");
					$checkInput.append($hiddenRid);
				}else{
					var $checkInput = $("<input type='checkbox' disabled>");
				}
				var $checkTd = $("<td>");
				var $idTd = $("<td>").text(value.bcode);
				var $brandTd = $("<td>").text(value.brand);
				var bankcode = value.bankcode;
				var bankname = '';
				switch(bankcode){
				case '002':bankname='산업은행'; break; case '003':bankname='기업은행'; break; case '004':bankname='국민은행'; break;
				case '005':bankname='외환은행'; break; case '007':bankname='수협은행'; break; case '011':bankname='농협은행'; break;
				case '012':bankname='단위농협은행'; break; case '020':bankname='우리은행'; break; case '023':bankname='SC제일은행'; break;
				case '027':bankname='씨티은행'; break; case '031':bankname='대구은행'; break; case '032':bankname='부산은행'; break;
				case '034':bankname='광주은행'; break; case '035':bankname='제주은행'; break; case '037':bankname='전북은행'; break;
				case '039':bankname='경남은행'; break; case '045':bankname='새마을금고'; break; case '048':bankname='신협은행'; break;
				case '048':bankname='신협은행'; break; case '050':bankname='상호저축은행'; break; case '055':bankname='도이치은행'; break;
				case '071':bankname='우체국은행'; break; case '081':bankname='하나은행'; break; case '088':bankname='신한은행'; break;
				case '090':bankname='카카오은행'; break; default : bankname='KH은행'
				}
				var $bankTd = $("<td>").text(bankname);
				var $accountTd = $("<td>").text(value.account);
				var $sumTd = $("<td>").text(value.price+'원');
				if(status == 'Y'){
					var $button = $("<button onclick='settlement("+value.rid+")'>").text('수동정산');
					var $adminTd = $("<td>");
				}else{
					var $button = '정산완료';
					var $adminTd = $("<td>").css("background","lightgrey");
				}
				
				$checkTd.append($checkInput);
				$tr.append($checkTd);
				$tr.append($idTd);
				$tr.append($brandTd);
				$tr.append($bankTd);
				$tr.append($accountTd);
				$tr.append($sumTd);
				$adminTd.append($button);
				$tr.append($adminTd);
				$tableBody.append($tr);
			});
			$paging = $("#paging");
			$paging.html('');
			var $firstLi = $('<li><button onclick="paging(1)">&laquo;</button></li>');
			$paging.append($firstLi);
			for (var i = 0; i < pi.maxPage; i++) {
				$paging.append('<li><button onclick="paging('+(i+1)+');">'+(i+1)+'</button></li>');
			}
			var $endLi = $('<li><button onclick="paging('+pi.maxPage+');">&raquo;</button></li>');
			$paging.append($endLi);
		}
		
		function search(){
			var brand = $("#searchBrand").val();
			$.ajax({
				url:"<%=request.getContextPath()%>/reserveSettleSearch.ad",
				type:"post",
				data:{brand:brand},
				success:function(data){
					console.log(data);
					setList(data);
				}
			});
		}
		
		function paging(nextPage){
			var brand = $("#searchBrand").val();
			$.ajax({
				url:"<%=request.getContextPath()%>/reserveSettleSearch.ad",
				type:"post",
				data:{currentPage:nextPage,brand:brand},
				success:function(data){
					console.log(data);
					setList(data);
				}
			})
		}
		
		function settlement(index){
			console.log(index);
			location.href="<%=request.getContextPath()%>/reserveSettle.ad?num="+index;
		}
		
		function reserveSettleChecked(){
			var str = "";
			
			$('.checkMember:checked').each(function(){
				console.log($(this).children().eq(0).val());
				if(str == ""){
					str+=$(this).children().eq(0).val();					
				}else{
					str+=","+$(this).children().eq(0).val();
				}
			});
			console.log(str);
			
			location.href="<%=request.getContextPath()%>/reserveSettleChecked.ad?arr="+str;
		}
		
		$("#selectAll").change(function(){
			if($(this).is(":checked")){
				$('.checkMember').each(function(){
					$(this).attr("checked", true);
				});
			}else{
				$('.checkMember').each(function(){
					$(this).attr("checked", false);
				});
			}
		});
		
		
	</script>
	
	
</body>

</html>