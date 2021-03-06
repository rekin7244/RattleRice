<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.kh.rr.admin.model.vo.Settlement,com.kh.rr.common.model.vo.PageInfo"%>
<%
	ArrayList<Settlement> list = (ArrayList<Settlement>) request.getAttribute("list");
	PageInfo pi = (PageInfo) request.getAttribute("pi");
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndpage();
%>
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
					<a>포인트 정산</a>
				</div>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="nav navbar-nav ml-auto">
						<li class="nav-item active"><a class="nav-link" href="adminForm.jsp">회원관리</a></li>
						<li class="nav-item"><a class="nav-link" href="community.jsp">커뮤니티</a></li>
						<li class="nav-item"><a class="nav-link" href="calculate.jsp">정산</a></li>
						<li class="nav-item"><a class="nav-link" href="sms.jsp">SMS</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath() %>/logout.me">로그아웃</a></li>
					</ul>
				</div>
			</div>

		</nav>
	
	
	<br><br> 
	
		<select id="searchCondition" name="searchCondition">
			<option value="">정렬</option>
			<option value="N">미정산</option>
			<option value="Y">정산완료</option>
		</select>
		<input type="text" id="searchKeyword" name="searchKeyword" placeholder="신청자 아이디">
		<button onclick="paging(1)">검색</button>

		<table class="table table-bordered">

			<thead>
				<tr style="background: lightgray" align="center">
					<th><input type="checkbox" id="selectAll" /></th>
					<th>신청 일자</th>
					<th>신청자 아이디</th>
					<th>신청 포인트</th>
					<th>발생 수수료</th>
					<th>정산 여부</th>
					<th>관리</th>
				</tr>
			</thead>
			<tbody id="tableTbody" align="center">
				<% for(Settlement s : list){ %>
				<tr>
					<td>
					<% if(s.getStatus().equals("N")){ %>
					<input type="checkbox" class="checkMember"/>
					<input type="hidden" id="rid" value="<%=s.getRid()%>"/>
					<% }else{ %>
					<input type="checkbox" id="" disabled />
					<% } %>
					</td>
					<td><%=s.gettDate() %></td>
					<td><%=s.getmId() %></td>
					<td><%=s.getrPrice() %></td>
					<td><%=s.getrFees() %></td>
					<td><% if(s.getStatus().equals("N")){ %>
						미정산
						<% } else { %>
						정산완료
						<% } %>
					</td>
					<td>
					<% if(s.getStatus().equals("N")){ %>
					<button onclick="settlement(<%=s.getRid()%>)">정산</button>
					<% }else{ %>
					<%=s.getrDate() %>
					<% } %>
					</td>	
				</tr>
				<% } %>
			</tbody>
		</table>
		
		<%-- 페이징 --%>
		<div class="pagingArea" align="center">
		<input type="hidden" id="currentPage" name="currentPage" value="<%=currentPage%>"/>
		<button onclick="paging(1)"><<</button>
		<% if(currentPage <= 1){ %>
		<button disabled><</button>
		<% } else { %>
		<button onclick="paging(<%=currentPage - 1%>)"><</button>
		<% } %>
		
		<% for(int i = 1; i <= maxPage; i++) { 
				if(currentPage != i){ %>
		<button onclick="paging(<%=i%>)"><%=i%></button> &nbsp;
			<% }else{ %>
		<button disabled><%=i%></button>&nbsp;
		<% 	   } %>
		<% } %>
		
		<% if(currentPage >= maxPage){ %>
		<button disabled>></button>
		<% } else { %>
		<button onclick="paging(<%=currentPage + 1%>)">></button>
		<% } %>
		<button onclick="paging(<%=maxPage%>)">>></button>
		</div>
		<div class="container-fluid full-width">
		<button onclick="pSettlementChecked()" class="btn pull-left">정산</button>
		</div>

	</div>
	
	<script>
		function settlement(rid){
			location.href="<%=request.getContextPath()%>/pSettlementOne.ad?num="+rid;
		}
		
		function pSettlementChecked(){
			var str = "";
			
			$('.checkMember:checked').each(function(){
				console.log($(this).siblings().val());
				if(str == ""){
					str+=$(this).siblings().val();					
				}else{
					str+=","+$(this).siblings().val();
				}
			});
			console.log(str);
			
			location.href="<%=request.getContextPath()%>/pSettleChecked.ad?arr="+str;
			
		}
		
		function paging(nextPage){
			$("#currentPage").val(nextPage);
			var condition = $("#searchCondition").val();
			var keyword = $("#searchKeyword").val();
			location.href="<%=request.getContextPath()%>/pSettlementSearch.ad?currentPage="+nextPage+"&searchCondition="+condition+"&searchKeyword="+keyword;
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