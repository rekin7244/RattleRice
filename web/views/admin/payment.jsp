<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.kh.rr.transaction.model.vo.Transaction"%>
<%
	ArrayList<Transaction> list = (ArrayList<Transaction>) request.getAttribute("list");
	System.out.println(list);
%>
<!DOCTYPE html>
<html>

<head>
<title>회원 관리</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<style>
input[type="radio"] {
	display: none;
}

input[type="radio"]+label {
	font-weight: 400;
	font-size: 14px;
}

input[type="radio"]+label span {
	display: inline-block;
	width: 18px;
	height: 18px;
	margin: -2px 10px 0 0;
	vertical-align: middle;
	cursor: pointer;
	-moz-border-radius: 50%;
	border-radius: 50%;
	border: 3px solid #ffffff;
}

input[type="radio"]+label span {
	background-color: #fff;
}

input[type="radio"]:checked+label {
	color: #333;
	font-weight: 700;
}

input[type="radio"]:checked+label span {
	background-color: #ff8800;
	border: 2px solid #ffffff;
	box-shadow: 2px 2px 2px rgba(0, 0, 0, .1);
}

input[type="radio"]+label span, input[type="radio"]:checked+label span {
	-webkit-transition: background-color 0.24s linear;
	-o-transition: background-color 0.24s linear;
	-moz-transition: background-color 0.24s linear;
	transition: background-color 0.24s linear;
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

					<a>결제 내역 조회</a>
				</div>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="nav navbar-nav ml-auto">
						<li class="nav-item active"><a class="nav-link"
							href="<%=request.getContextPath()%>/memberlist.ad">회원관리</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath()%>/communitylist.ad">커뮤니티</a></li>
						<li class="nav-item"><a class="nav-link" href="calculate.jsp">정산</a></li>
						<li class="nav-item"><a class="nav-link"
							href="views/admin/sms.jsp">SMS</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath()%>/logout.me">로그아웃</a></li>
					</ul>
				</div>
			</div>

		</nav>
		<br> <br>

		<form action="<%=request.getContextPath()%>/paytypeSelect.ad">
			<div id="paytype">
				<input class="radiobox" id="option-one" name="radio" value="전체"
					type="radio"> <label for="option-one"> <span></span>
					전체
				</label> <input class="radiobox" id="option-two" name="radio" value="충전"
					type="radio"> <label for="option-two"> <span></span>
					충전
				</label> <input class="radiobox" id="option-three" name="radio" value="사용"
					type="radio"> <label for="option-three"> <span></span>
					사용
				</label> <input class="radiobox" id="option-four" name="radio" value="환불"
					type="radio"> <label for="option-four"> <span></span>
					환불
				</label>
			</div>
		</form>

		<form action="<%=request.getContextPath()%>/paymentlist.ad"
			method="post">

			<table class="table table-bordered" id="paylist">
				<thead>
					<tr style="background: lightgray" align="center">
						<th><input type="checkbox" id="checkmember"></th>
						<th>번호</th>
						<th>아이디</th>
						<th>거래일시</th>
						<th>거래금액</th>
						<th>상태</th>
						<th>구분</th>
					</tr>
				</thead>

				<%
					if (list != null) {
						for (int i = 0; i < list.size(); i++) {

							String type = "";
							if (list.get(i).getType().equals("CH")) {
								type = "충전";
							} else if (list.get(i).getType().equals("PAY")) {
								type = "사용";
							} else {
								type = "환불";
							}

							String unit = "";
							if (list.get(i).getUnit().equals("BE")) {
								unit = "bell";
							} else {
								unit = "point";
							} ;
				%>

				<tbody align="center" id="paylistFrom">
					<tr>
						<th><input type="checkbox"></th>
						<td><%=i + 1%></td>
						<td><%=list.get(i).getUserId()%></td>
						<td><%=list.get(i).gettDate()%></td>
						<td><%=list.get(i).gettPrice()%></td>
						<td><%=type%></td>
						<td><%=unit%></td>

					</tr>
					<%
						}
						} else {
					%>
					<tr>
						<td colspan="7" align="center">저장된 값이 없습니다.</td>
					</tr>
					<%
						}
					%>

				</tbody>
			</table>
		</form>
		

		 <script>
		
		
		 $(document).ready(function(){
			    $("#paytype").change(function(){
			        if($("#option-three").is(":checked")){
			            /* alert("사용 체크했음!"); */
			            
			        	var list = $("#paylist");
			         
			            $.ajax({
		         			 url : "paytypeSelect.ad",
		         			 success:function(data){
		         				$(list).children('#paylistFrom')
								.remove(); 
		         				
		         				for(var key in data){
		         					
								var ptype = data[key];
								var type="사용";
								var unit = "";
									
								if(ptype.unit == "BE"){
									unit="bell";
								}else{
									unit="point";
								}
								

		         				$(list).append('<tr>');
								$(list).append('<td><input type="checkbox" id="checkmember"></td>');
								$(list).append('<td style="TEXT-ALIGN: center">'+ key++ +'</td>');
								$(list).append('<td style="TEXT-ALIGN: center">' + ptype.userId + '</td>');
								$(list).append('<td style="TEXT-ALIGN: center">' + ptype.tDate + '</td>');
								$(list).append('<td style="TEXT-ALIGN: center">' + ptype.tPrice + '</td>');
								$(list).append('<td style="TEXT-ALIGN: center">' + type + '</td>');
								$(list).append('<td style="TEXT-ALIGN: center">' + unit + '</td>');
		         				
		         				}
		         			 },
		         			error : function() {
								colsole.log("실패");
							}
						}) 
			            
			            
			        }
			    });
			});
		 
		 
		 $(document).ready(function(){
			    $("#paytype").change(function(){
			        if($("#option-four").is(":checked")){
			           /*  alert("환불 체크했음!"); */
			            
			        	var list = $("#paylist");
			            $.ajax({
		         			 url : "refundtypeSelect.ad",
		         			 success:function(data){
		         				$(list).children('#paylistFrom')
								.remove(); 
		         				
		         				for(var key in data){
		         					
								var ptype = data[key];
								var type="환불";
								var unit = "";
								
								if(ptype.unit == "BE"){
									unit="bell";
								}else{
									unit="point";
								}
								
								
								

		         				$(list).append('<tr>');
								$(list).append('<td><input type="checkbox" id="checkmember"></td>');
								$(list).append('<td style="TEXT-ALIGN: center">'+ key++ +'</td>');
								$(list).append('<td style="TEXT-ALIGN: center">' + ptype.userId + '</td>');
								$(list).append('<td style="TEXT-ALIGN: center">' + ptype.tDate + '</td>');
								$(list).append('<td style="TEXT-ALIGN: center">' + ptype.tPrice + '</td>');
								$(list).append('<td style="TEXT-ALIGN: center">' + type + '</td>');
								$(list).append('<td style="TEXT-ALIGN: center">' + unit + '</td>');
		         				}
		         			 },
		         			error : function() {
								colsole.log("실패");
							}
						}) 
			            
			            
			        }
			    });
			});
		 
		 $(document).ready(function(){
			    $("#paytype").change(function(){
			        if($("#option-two").is(":checked")){
			            /* alert("충전 체크했음!"); */
			            
			        	var list = $("#paylist");
			            $.ajax({
		         			 url : "chargetypeSelect.ad",
		         			 success:function(data){
		         				$(list).children('#paylistFrom')
								.remove(); 
		         				
		         				for(var key in data){
		         					
								var ptype = data[key];
								var type="충전";
								
								var unit = "";
								
								if(ptype.unit == "BE"){
									unit="bell";
								}else{
									unit="point";
								}
								
								
							
		         				$(list).append('<tr>');
								$(list).append('<td><input type="checkbox" id="checkmember"></td>');
								$(list).append('<td style="TEXT-ALIGN: center">'+ key++ +'</td>');
								$(list).append('<td style="TEXT-ALIGN: center">' + ptype.userId + '</td>');
								$(list).append('<td style="TEXT-ALIGN: center">' + ptype.tDate + '</td>');
								$(list).append('<td style="TEXT-ALIGN: center">' + ptype.tPrice + '</td>');
								$(list).append('<td style="TEXT-ALIGN: center">' + type + '</td>');
								$(list).append('<td style="TEXT-ALIGN: center">' + unit + '</td>');
		         				
		         				}
		         			 },
		         			error : function() {
								colsole.log("실패");
							}
						}) 
			            
			            
			        }
			    });
			});
                 	 
		</script>
</body>

</html>