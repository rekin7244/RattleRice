<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.kh.rr.transaction.model.vo.*"%>
<%
	ArrayList<Transaction> list = (ArrayList<Transaction>) request.getAttribute("list");
	ArrayList<HashMap<String, Object>> list2 =(ArrayList<HashMap<String, Object>>)request.getAttribute("list2");
	HashMap<String, Object> hmap = null;
	for (int i = 0; i < list2.size(); i++) {
		hmap = list2.get(i);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 부트스트랩 -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<!-- 메뉴바 스타일 -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
<title>Insert title here</title>
<style>
.nav-tabs>li {
	width:50%;
}

.bar {
	margin: 17% 0 0 0;
}

.paybtn {
	float: right; 
	margin-top: 6px;
	border: none;
}

.tab-content .payTab {
	position: fixed;
    top: 81.5%;
    width: 100%;
    background: #FFE8EE;
    height: 44px;
}

.tab-content label {
	margin-top : 12px;
}
.transactionList {
	margin-bottom: 24%;
}
.transactionList-inner{
	border-bottom: 1px solid skyblue;
	padding: 10px 15px; 
}

/* 벨 사용 내역 테이블 스타일 */
#bellList-inner {
	margin: 0 auto;
	width: 95%;
	padding: 10px 15px; 
}

#bellList-inner>tbody>.dateTr{
    color: gray;
    font-size: 12px;
    margin-bottom: 10px;
	height: 30px;
}

#bellList-inner>tbody>.priceTr {
	font-weight: bold;
	font-size: 16px;
	height: 37px;
	border-bottom: 1px solid lightblue;
}

#bellList-inner>tbody>.priceTr>td:last-child {
	color: skyblue;
	font-weight: normal;
	text-align: right;
}


.date {
	color: gray;
	font-size: 12px;
	margin-bottom: 10px;
}

.context > div {
	display: inline-block;
}
.title {
	font-weight: normal;
	font-size: 16px;
}
.price {
    font-size: 16px;
	color: skyblue;
	float: right;
}

</style>
<script>
	$(function() {
		$(window).resize(function() {
			window.resizeTo(410, 600);
		});
	});
	
	//벨 충전 시, 디비에 데이터 삽입하는 ajax
	function bellCharge() {
		var bell = $("#bell").val();
		var point = $("#point").text();
		
		var confirm = window.confirm("정말 " +bell +"벨 만큼 충전하시겠습니까?");	
		
		if(confirm && (Number(bell) <= (Number(point) / 500))){
			$.ajax({
				url:"<%= request.getContextPath()%>/insert.tr",
				data:{bell:bell},
				success:function(data){
					console.log("데이터 삽입 성공!");
				},
				error:function(){
					console.log("실패!");
				}
			})
			
		}else{
			alert("보유 포인트가 부족합니다!");
				window.reload();
		}
	}
	
	//벨 탭 클릭시 벨 관련 트랜잭션 불러오는 ajax
	function selectBellTransaction(){
		
			
			$.ajax({
				url:'selectbell.tr',
				success:function(data){
						//넣어줄 최종 테이블 선언
						$tableBody = $("#bellList-inner tbody");
						//에이잭스 동작 할때 마다 초기화 하고 새로 다시 뿌려준다
						$tableBody.html('');
						
						for(var key in data){
							//날짜 값 넣어 줄 tr
							var $dateTr = $("<tr class='dateTr'>");
							var $dateTd = $("<td>").text(data[key].tDate);
							
							//충전인지 사용인지, 금액이 얼마나 되는지 넣어줄 tr
							var $priceTr = $("<tr class='priceTr'>")
							var $chOrPayTd = $("<td>");
							var $priceTd = $("<td>").text(data[key].tPrice + "벨");
							
							//충전일 경우
							if(data[key].type == 'CH'){
								$chOrPayTd.text("딸랑벨 충전");
							//소비일 경우
							}else{
								$chOrPayTd.text("방생성");
							}
							//날짜값 넣기
							$dateTr.append($dateTd);
							//충전/소비, 단위 넣기
							$priceTr.append($chOrPayTd);
							$priceTr.append($priceTd);
							$tableBody.append($dateTr);
							$tableBody.append($priceTr);
						}
				},
				error:function(){
					console.log("실패!");	
				}
		})
	}
</script>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container bar">
		<ul class="nav nav-tabs">
			<li><a data-toggle="tab" href="#bellTab" onclick="selectBellTransaction()">벨</a></li>
			<li class="active" style="color: #4abeca;"><a data-toggle="tab" href="#billTab">포인트</a></li>
		</ul>

	</div>

	<div class="tab-content">
	

		<div id="billTab" class="tab-pane fade in active">
			<div class="container-fluid transactionList">
				<%for(Transaction tr : list){ %>
					<%if(tr.getType().equals("RE")) {%>
					<div class="transactionList-inner blue">
						<div class="date">
							<%=tr.gettDate() %>
						</div>
						<div class="context">
							<div class="title">
								포인트 환불
							</div>
							<div class="price">
								<%=tr.gettPrice() %> Point
							</div>
						</div>
					</div>
					<%}else{ %>
					
					<%} %>
					
				<%} %>
			</div>
		
		
			<div class="container-fluid payTab">
				<label><i class="money bill alternate icon"
					style="color: gold"></i>보유 point </label> <label><span
					style="color: #4abeca;"><%=hmap.get("point") %></span></label>
				<button type="button" class="btn btn-default paybtn"
					data-toggle="modal" data-target="#refund" >환급신청</button>
			</div>
		</div>
		
		
			<div id="bellTab" class="tab-pane fade">
				<div class="container-fluid bellList">
					<table id="bellList-inner">
						<tbody></tbody>
					</table>
				</div>
			
			<div class="container-fluid payTab">
				<label><i class="bell icon" style="color: gold"></i>보유 bell
				</label> <label><span style="color: #4abeca;"><%=hmap.get("bell") %></span>벨</label>
				<button type="button" class="btn btn-default paybtn"
					data-toggle="modal" data-target="#bellCharge" >벨 충전</button>
			</div>
		</div>
	</div>
	<!-- 벨 충전 -->
	<div class="container">
		<!-- Modal -->
		<div class="modal fade" id="bellCharge" role="dialog"
			data-backdrop="static">
			<div class="modal-dialog modal-sm" data-backdrop="static">
				<div class="modal-content" data-backdrop="static">
					<div class="modal-header" data-backdrop="static">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">벨 충전</h4>
					</div>
					<form action="" method="get">
					<div class="modal-body" data-backdrop="static">
						<p>얼마나 충전해드릴까요?</p>
						<input type="text" class="form-control" id="bell"
							placeholder="1벨은 500포인트 입니다!" name="point"> <br> <label><i
							class="money bill alternate icon" style="color: gold"></i>보유 Point
						</label> <label><span id="point" style="color: #4abeca;"><%=hmap.get("point") %></span></label>
					</div>
					<div class="modal-footer" data-backdrop="static">
						<button type="button" class="btn btn-default" data-dismiss="modal"
							aria-label="Close">취소</button>
						<button type="submit" class="btn btn-default" onclick="bellCharge();">충전</button>
					</div>
					</form>
				</div>

			</div>
		</div>
	</div>
	<!-- 환급신청 -->
	<div class="container">
		<!-- Modal -->
		<div class="modal fade" id="refund" role="dialog"
			data-backdrop="static">
			<div class="modal-dialog modal-sm" data-backdrop="static">
				<div class="modal-content" data-backdrop="static">
					<div class="modal-header" data-backdrop="static">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Refund</h4>
					</div>
					<form action="<%= request.getContextPath()%>/insert.tr" method="post">
					<div class="modal-body" data-backdrop="static">
						<p>환급 금액을 입력해주세요.</p>
						<input type="text" class="form-control" id="ks"
							placeholder="3000포인트 이상부터 환급가능합니다." name="point"> <br> <label><i
							class="money bill alternate icon" style="color: gold"></i>보유 Point
						</label> <label><span style="color: #4abeca;" id="point"><%=hmap.get("point") %></span></label>
					</div>
					<div class="modal-footer" data-backdrop="static">
						<button type="button" class="btn btn-default" data-dismiss="modal"
							aria-label="Close">취소</button>
						<button type="submit" class="btn btn-default" id="refundBtn" disabled>환급</button>
					</div>
					</form>
				</div>

			</div>
		</div>
	</div>
	<script>
		$(function(){
			setInterval(function(){
				var $reqPoint = $("#ks").val();
				var $point = $("#point").text();
				
				if($reqPoint <= $point && $reqPoint != ''){
					console.log("가능");
					$("#refundBtn").removeAttr("disabled");
				}else{
					$("#refundBtn").attr('disabled', 'disabled');
				}
			}, 500);
		})
		
	</script>

	<%@ include file="menubar.jsp"%>
</body>
</html>