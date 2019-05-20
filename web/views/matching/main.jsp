<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.kh.rr.matching.model.vo.*"%>
<%
	ArrayList<ChattingRoom> list = 
		(ArrayList<ChattingRoom>) request.getAttribute("list"); 
	/* String location = (String)request.getAttribute("location"); */
%>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 모바일 크기 -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<!-- 메뉴바 스타일 -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
<title>딸랑밥!</title>
<script>
	//창크기 조절용 함수
	$(function() {
		$(window).resize(function() {
			window.resizeTo(410, 600);
		});
		
		//프리미엄 채팅방 색깔 바꿔주는 함수
		$(".cr-content-inner").each(function(){
			if($(this).children(".roomKind").val() == '프리미엄'){
				$(this).css("background","yellowgreen");
			};
			
		})
		
		//조건 검색 날짜 기본 값 설정 함수
		$("#searchTime").val('0001-01-01T17:56');
	
	});
	
	//프리미엄 채팅방을 만들지 안 만들지 선택하는 함수
	function choice(){
		var choice = window.confirm("프리미엄으로 하시겠습니까?");
	
		if(!choice){
			console.log("거절");
			location.href='<%=request.getContextPath()%>/selectAll.cr';
		}
	}
	
	//프리미엄 채팅방 모달 창 변경될 때 값을 저장해주는 함수
	function premiumCondition(){
		$location = $("#pLocation").val();
		$time = $("#pTime").val().split('T');
		$mPerson = $("#pMperson").val();
		$rName = $("#pRname").val();
		$pCategory = $("select[name=pCategory]").val();
		
		$("#allVal").val($location + "," + $time[0] + "," + $time[1] + "," +
				$mPerson + "," + $rName + "," + $pCategory);
		
		console.log($location + "," + $time[0] + "," + $time[1] + "," +
				$mPerson + "," + $rName + "," + $pCategory);
	}
	
	//지도 api띄우는 함수 - 일반
	var openWin;
	function openChild(){
		
		window.name = "main";
		
		openWin = window.open('/rr/views/matching/map.jsp','childForm',
					'top=50px, left=800px, height=500, width=400');
		timer = setInterval(function(){
			$("#location").val(openWin.$("#locationInfo").val());
			$("#pLocation").val(openWin.$("#locationInfo").val());
		}, 1000);
	}
	
	//지도 api띄우는 함수 - 프리미엄
	var openWin2;
	function openChild2(){
		
		window.name = "main";
		
		openWin2 = window.open('/rr/views/matching/map.jsp','childForm',
					'top=50px, left=800px, height=500, width=400');
		timer = setInterval(function(){
			$("#pLocation").val(openWin.$("#locationInfo").val());
		}, 1000);
	}
	
</script>
<style>
	body::-webkit-scrollbar {
		display: none;
	}
	.sexRatio {
		display: inline-block;
	}
	.mainContent {
		margin-top: 12.9%;
		margin-bottom: 14.6%;
	}
	.cr-content-inner {
		padding: 10px 0;
		border-bottom: 1px solid black;
	}
	.chatImg img {
		width: 80px; 
		height:80px; 
		border-radius:4em;
	}
	.cr-contents {
		display: table-cell;
		vertical-align: middle;
	}
	.chatImg {
		width:24%;	
	}
	.chatInfo {
		width: 43%;
	}
	.chatInfo #title {
		font-size: 15px;
		font-weight: bold;		
	}
	.cr-content-inner .btn {
	}
</style>
</head>
<body>
	<%@ include file="header.jsp"%>
	<!--채팅방목록 -->
	<script>
		$(function(){
			$("#ks").on("keyup", function(){
				var value= $(this).val().toLowerCase();
				$(".cr-content").filter(function(){
					$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)					
				});
			});
		})
	</script>
	<div class="mainContent" align="center">
			<div class="cr-content text" style="width: 100%;">
				<%if(list != null) {
					for(ChattingRoom cr : list){ %>
						<form action="<%= request.getContextPath()%>/selectOne.cr?rno=<%=cr.getRno() %>" method="post">
							<div class="cr-content-inner">
								<input type="hidden" value="<%= cr.getrKind()%>" class="roomKind"> 
								<div class="cr-contents chatImg">
									<%if(cr.getCategory().equals("중식")){ %>
										<img src="<%= request.getContextPath()%>/images/chineesefood.png">
									<%}else if(cr.getCategory().equals("한식")){ %>
										<img src="<%= request.getContextPath()%>/images/koreanfood.png">
									<%}else if(cr.getCategory().equals("일식")){ %>
										<img src="<%= request.getContextPath()%>/images/japanesefood2.jpg">
									<%}else{ %>
										<img src="<%= request.getContextPath()%>/images/pasta.jpg">
									<%} %>
								</div>
								<div class="cr-contents chatInfo">
									<p id="title"><%=cr.getrTitle() %></p>
									<p id="person">모집인원 <%=cr.getpPerson() %>/<%=cr.getmPerson() %></p>
									
								</div>
								<div class="cr-contents btn">
									<button class="btn btn-warning" type="submit" onclick="window.confirm('입장하시겠습니까?')">입장하기</button>
								</div>
							</div>
						</form>
					<%} 
					
					}%>
			</div>
	</div>
	<%@ include file="menubar.jsp"%>

	<!-- 방 생성 (선택) -->
	<div class="container">
		<!-- Modal -->
		<div class="modal fade" id="createChat" role="dialog"
			data-backdrop="static">
			<div class="modal-dialog modal-sm" data-backdrop="static">
				<!-- Modal content-->
				<div class="modal-content" data-backdrop="static">
					<div class="modal-header" data-backdrop="static">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">채팅방 생성</h4>
					</div>
					<div class="modal-body" data-backdrop="static">
						<p style="font-size: 0.8em; text-align: center;">채팅방을
							생성하시겠습니까?</p>
						<div align="center" data-backdrop="static">
							<button type="button" class="btn btn-default" style="color: red" data-dismiss="modal"
							data-toggle="modal" data-target="#createChatp"
							onclick="choice();">프리미엄</button>
							&nbsp;
							<button type="button" class="btn btn-default" style="color: #4abeca" data-dismiss="modal"
							data-toggle="modal" data-target="#createChatp1">일반</button>
						</div>
						<br>
						<p style="color: #3498db; text-align: center;">※프리미엄 방 생성시
							1코인이 소비됩니다.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 일반 방 생성  -->
	<div class="container">
		<!-- Modal -->
		<div class="modal fade" id="createChatp1" role="dialog"
			data-backdrop="static">
			<div class="modal-dialog modal-sm" data-backdrop="static">
				<div class="modal-content" data-backdrop="static">
					<div class="modal-header" data-backdrop="static">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">방 생성</h4>
					</div>
					<div class="modal-body" data-backdrop="static">
						<button onclick="openChild();">위치선택</button>
						<form action="<%=request.getContextPath()%>/insert.cr" method="get">
							<div class="form-group">
								<label for="location">위치</label> <input type="text"
									class="form-control" id="location" name="location">
							</div>
							<div class="form-group">
								<label for="pTime">시간</label> <input type="datetime-local"
									class="form-control" id="time" name="pTime">
							</div>
							<div class="form-group">
								<label for="mPerson">인원수</label> <input type="text"
									class="form-control" id="memberCount" name="mPerson">
							</div>
							<div class="form-group">
								<label for="rTitle">방 제목</label> <input type="text"
									class="form-control" id="rName"
									placeholder="ex) 역삼역 9시에 간장새우 드실분~" name="rTitle">
							</div>
							<div class="form-group">
								<label for="fcategory">메뉴</label> <select class="form-control"
									id="fcategory" name="category">
									<option value="10">한식</option>
									<option value="20">중식</option>
									<option value="30">일식</option>
									<option value="40">양식</option>
								</select>
							</div>
							<button type="button" class="btn btn-default" data-dismiss="modal"
								aria-label="Close" style="float:right">취소</button>
							<button type="submit" class="btn btn-default" style="float:right">생성</button>
						</form>
					</div>
					<div class="modal-footer" data-backdrop="static">
					</div>
				</div>

			</div>
		</div>
	</div>

	<!-- 프리미엄 방 생성 (조건1) -->
	<div class="container">
		<!-- Modal -->
		<div class="modal fade" id="createChatp" role="dialog"
			data-backdrop="static">
			<div class="modal-dialog modal-sm" data-backdrop="static">
				<div class="modal-content" data-backdrop="static">
					<div class="modal-header" data-backdrop="static">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">프리미엄방 생성</h4>
					</div>
					<div class="modal-body" data-backdrop="static">
					<button onclick="openChild();">위치선택</button>
						<form>
							<div class="form-group">
								<label for="pLocation">위치</label> <input type="text"
									class="form-control" id="pLocation">
							</div>
							<div class="form-group">
								<label for="pTime">시간</label> <input type="datetime-local"
									class="form-control" id="pTime">
							</div>
							<div class="form-group">
								<label for="pMperson">인원수</label> <input type="text"
									class="form-control" id="pMperson">
							</div>
							<div class="form-group">
								<label for="pRname">방 제목</label> <input type="text"
									class="form-control" id="pRname"
									placeholder="ex) 역삼역 9시에 간장새우 드실분~">
							</div>
								<div class="form-group">
								<label for="pCategory">메뉴</label> <select class="form-control"
									id="pCategory" name="pCategory">
									<option value="10">한식</option>
									<option value="20">중식</option>
									<option value="30">일식</option>
									<option value="40">양식</option>
								</select>
							</div>
							<button type="button" class="btn btn-default" data-dismiss="modal" style="float:right"
								aria-label="Close">취소</button>
							<button type="button" class="btn btn-default" data-dismiss="modal" style="float:right"
								data-toggle="modal" data-target="#createChatp2" onclick="premiumCondition();">다음</button>
						</form>
					</div>
					<div class="modal-footer" data-backdrop="static">
					</div>
				</div>

			</div>
		</div>
	</div>

	<!-- 프리미엄 방 생성 (조건2) -->
	<div class="container">
		<!-- Modal -->
		<div class="modal fade" id="createChatp2" role="dialog"
			data-backdrop="static">
			<div class="modal-dialog modal-sm" data-backdrop="static">

				<div class="modal-content" data-backdrop="static">
					<div class="modal-header" data-backdrop="static">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">프리미엄방 생성</h4>
					</div>
					<div class="modal-body" data-backdrop="static">
						<form action="<%= request.getContextPath()%>/insert.pcr" method="get">
							<input type="hidden" value="" id="allVal" name="allVal"> 
							<div class="form-group">
								<label>성비</label>
								<div>
									<label>남<i class="mars icon" style="color: blue"></i></label> <input
										type="text" class="form-control sexRatio" id="male" name="male"
										style="width: 60px;"> &nbsp; &nbsp; &nbsp;
									&nbsp; &nbsp; &nbsp; <label>여<i class="venus icon"
										style="color: red"></i></label> <input type="text"
										class="form-control sexRatio" id="female" name="female"
										style="width: 60px;">
								</div>
							</div>
							<div class="form-group">
								<label for="age">나이</label> <select class="form-control"
									id="age" name="age">
									<option value="20">20대</option>
									<option value="30">30대</option>
									<option value="40">40대</option>
									<option value="50">50대</option>
								</select>
							</div>
							<div class="form-group">
								<label for="job">직업</label> <input type="text"
									class="form-control" id="job" name="job">
							</div>
							<br>
							<p style="font-size: 0.8em; color: #3498db; text-align: center;">※
								생성버튼을 누를 시 1코인이 소비됩니다.</p>
							<button type="button" class="btn btn-default" data-dismiss="modal"
								data-toggle="modal" data-target="#createChatp">이전</button>
							<input type="submit" class="btn btn-default" value="생성">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 키워드 검색 -->
	<div class="container">
		<!-- Modal -->
		<div class="modal fade" id="ksearch" role="dialog"
			data-backdrop="static">
			<div class="modal-dialog modal-sm" data-backdrop="static">
				<div class="modal-content" data-backdrop="static">
					<div class="modal-header" data-backdrop="static">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Search</h4>
					</div>
					<div class="modal-body" data-backdrop="static">
						<p style="color: #4abeca; font-size: 0.8em;">키워드를 입력하세요.</p>
						<input type="search" class="form-control" id="ks"
							placeholder="Input Text Here.">
					</div>
					<div class="modal-footer" data-backdrop="static">
						<button type="button" class="btn btn-default" data-dismiss="modal"
							aria-label="Close" onclick="location.reload();">취소</button>
						<button type="button" class="btn btn-default" data-dismiss="modal" >검색</button>
					</div>
				</div>

			</div>
		</div>
	</div>

<script>
//조건 검색 모달 변경 시 값들을 전달해주는 함수
function searchCondition(){

	$searchLocation = $("#searchLocation").val();
	$searchTime = $("#searchTime").val().split("T");
	$searchMember = $("#searchMember").val();
	$searchCategory = $("#searchCategory").val();
	
	$("#searchHidden").val($searchLocation + "," + $searchTime[0] + "," + $searchTime[1] + "," +
			$searchMember + "," + $searchCategory);
	console.log($("#searchHidden").val());
	
	
}
</script>
	<!-- 조건 검색1 -->
	<div class="container">
		<div class="modal fade" id="msearch" role="dialog"
			data-backdrop="static">
			<div class="modal-dialog modal-sm" data-backdrop="static">
				<div class="modal-content" data-backdrop="static">
					<div class="modal-header" data-backdrop="static">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Filtering</h4>
					</div>
					<div class="modal-body" data-backdrop="static">
						<form>
							<div class="form-group">
								<label for="area">지역</label> <select class="form-control"
									id="searchLocation">
									<option value="0">선택해주세요</option>
									<option value="서울">서울</option>
									<option value="경기">경기</option>
								</select>
							</div>
							<div class="form-group">
								<label for="time">시간</label> <input type="date"
									class="form-control" id="searchTime" required>
							</div>
							<div class="form-group">
								<label for="membercount">인원수</label> <input type="number"
									class="form-control" id="searchMember" value="0">
							</div>
							<div class="form-group">
								<label for="fcategory">메뉴</label> <select class="form-control"
									id="searchCategory">
									<option value="0">선택해주세요</option>
									<option value="한식">한식</option>
									<option value="중식">중식</option>
									<option value="일식">일식</option>
								</select>
							</div>
						</form>
						<div class="modal-footer" data-backdrop="static">
							<button type="button" class="btn btn-default"
								data-dismiss="modal" aria-label="Close">취소</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal" data-toggle="modal" data-target="#msearch2" onclick="searchCondition();">다음</button>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

	<!-- 조건 검색2 -->
	<div class="container">
		<!-- Modal -->
		<div class="modal fade" id="msearch2" role="dialog"
			data-backdrop="static">
			<div class="modal-dialog modal-sm" data-backdrop="static">
				<div class="modal-content" data-backdrop="static">
					<div class="modal-header" data-backdrop="static">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Filtering</h4>
					</div>
					<div class="modal-body" data-backdrop="static">
						<form action="<%=request.getContextPath()%>/search.cr" method="post">
							<label>성별</label>
							<div class="radio">
								<label><input type="radio" name="optradio" value="M">남<i
									class="mars icon" style="color: blue"></i></label> &nbsp; &nbsp; &nbsp;
								&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <label><input
									type="radio" name="optradio" value="F">여<i class="venus icon"
									style="color: red"></i></label>
							</div>
							<div class="form-group">
								<label for="age">나이</label> <select class="form-control"
									id="age" name="searchAge">
									<option value="0">선택해주세요</option>
									<option value="20">20대</option>
									<option value="30">30대</option>
									<option value="40">40대</option>
									<option value="50">50대</option>
								</select>
							</div>
							<div class="form-group">
								<label for="jobname">직업</label> 
								<select class="form-control" id="jobName" name="jobName">
										<option value="0">선택해주세요</option>
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
							<input type="hidden" id="searchHidden" name="searchHidden">
							<button type="button" class="btn btn-default" data-dismiss="modal"
								data-toggle="modal" data-target="#msearch">이전</button>
							<button type="submit" class="btn btn-default">검색</button>
						</form>
					</div>
					
				</div>

			</div>
		</div>
	</div>

</body>
</html>