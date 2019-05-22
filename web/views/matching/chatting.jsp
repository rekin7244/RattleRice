<%@ page language="java" contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8"
	import="com.kh.rr.member.model.vo.*, java.net.*, java.util.*, javax.websocket.Session, java.text.*, com.kh.rr.matching.model.vo.*"%>
<%
	InetAddress Address = InetAddress.getLocalHost();
	Member m = (Member) (request.getSession().getAttribute("loginUser"));
	ChattingRoom reqCr = (ChattingRoom) (request.getSession().getAttribute("reqCr"));
	int rno = (int) session.getAttribute("rno");
	/* int rno = (int) request.getAttribute("rno"); */
	/* ArrayList<HashMap<String, Object>> list = (ArrayList<HashMap<String, Object>>) request.getAttribute("list");

	HashMap<String, Object> hmap = null;
	for (int i = 0; i < list.size(); i++) {
		hmap = list.get(i);
	} */
	//현재시간
	long now = System.currentTimeMillis();
			
	Date d = new Date(now);
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	String getTime = sdf.format(d);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<!-- 메뉴바 스타일 -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
//창크기 조절용 함수
$(function() {
   $(window).resize(function() {
      window.resizeTo(410, 600);
   });

   $("#chatP").click(function(){
	   var rno = $("input[name=rno]").val();
	   console.log("chatp 선택");
	   
		$.ajax({
			url:"<%=request.getContextPath()%>/chatPerson.cr",
			data:{rno:rno},
			type:"get",
			success:function(data){
				console.log(data);
				var myId = "<%=m.getUserId()%>";
				
				$chatPersonDiv = $(".chatPerson");
				
				for (var key in data) {
					console.log(data[key].type);
					//alert(typeof(data[key].type)); // ->String
					
					/* if( === data[key].userId){
						
					} */
					
					//-> 잘못된 알고리즘2
					var $div = $("<div class='divArea' style='margin-bottom: 13px;'>");
					var $imgDiv = $("<div class='profileImg' data-toggle='modal' data-target='#userProfile'>");
					var $nameDiv = $("<div class='profileName'>");
					var $kickDiv = $("<div style='float: right; margin-top: 8px;'>");
					var deadLineTime = data[key].dTime;
					//alert(typeof(data[key].dTime)); // ->String
					
					$imgDiv.append("<img src='/rr/profileImg_upload/"+ data[key].changeName +"' style='width:100%; border-radius:6em;'>");
					//$kickDiv.append("<button type='button' class='btn btn-danger kickBtn' style='visibility:hidden;' >강퇴</button>");
					
					if(myId === data[key].userId){
						$nameDiv.append("<p>" + data[key].nickName + "(나)</p>");
						
						if(data[key].type === "MASTER"){
							//내가 방장일 경우
							$("#deadLineI").append("<i class='fas fa-stopwatch' id='dl' style='font-size: 22px; color: #1abc9ccc;' data-toggle='modal' data-target='#deadLine'></i>");
						}
						
					}else{
						var userId = data[key].userId;
						$nameDiv.append("<p>" + data[key].nickName + "</p>");
						
						//$(".kickBtn").css({visibility:"visible"});
						if(data[key].type === "USER"){
							/* $("#deadLineI").append("<i class='fas fa-credit-card' id='dl' style='font-size: 22px; color: #1abc9ccc;' data-toggle='modal' data-target='#deadLine'></i>"); */
							$kickDiv.append("<button type='button' class='btn btn-danger kickBtn'>강퇴</button><input type='hidden' value='<%= rno%>' name='rno'>");
						}
						
					}
					
					$div.append($imgDiv);
					$div.append($nameDiv);
					$div.append($kickDiv);
					
					$chatPersonDiv.append($div);
					
					if(now < deadLineTime){
						$("#dTime").text(deadLineTime);
					}<%-- else{
						$("input[name=dTime]").val("25");
						location.href = "<%= request.getContextPath()%>/deadLine.cr";
					}
					
					if(deadLineTime === "25"){
						$("#dTime").text("마감시간을 설정하세요.");	
					} --%>
						
					} 

					//-> 잘못된 알고리즘
					/* if(data[key].type == "USER"){
						console.log(data[key].type);
						var $div = $("<div class='divArea' style='margin-bottom: 13px;'>");
						var $imgDiv = $("<div class='profileImg' data-toggle='modal' data-target='#userProfile'>");
						var $nameDiv = $("<div class='profileName'>");
						
						$imgDiv.append("<img src='/rr/profileImg_upload/"+ data[key].changeName +"' style='width:100%; border-radius:6em;'>");
						
						if(myId === data[key].userId){
							$nameDiv.append("<p>" + data[key].nickName + "(나)</p>");						
						}else{
							$nameDiv.append("<p>" + data[key].nickName + "</p>");	
						}

						$div.append($imgDiv);
						$div.append($nameDiv);

						$chatPersonDiv.append($div);
					
						
					}else{
						var $div = $("<div class='divArea' style='margin-bottom: 13px;'>");
						var $imgDiv = $("<div class='profileImg' data-toggle='modal' data-target='#userProfile'>");
						var $nameDiv = $("<div class='profileName'>");
						var $kickDiv = $("<div style='float: right; margin-top: 8px;'>");
						
						$imgDiv.append("<img src='/rr/profileImg_upload/"+ data[key].changeName +"' style='width:100%; border-radius:6em;'>");
						
						if(myId === data[key].userId){
							$nameDiv.append("<p>" + data[key].nickName + "(나)</p>");						
						}else{
							$nameDiv.append("<p>" + data[key].nickName + "</p>");	
							$kickDiv.append("<button type='button' class='btn btn-danger kickBtn' >강퇴</button>");
						}
											
						$div.append($imgDiv);
						$div.append($nameDiv);
						$div.append($kickDiv);
						
						$chatPersonDiv.append($div);

						$("#deadLineI").append("<i class='fas fa-stopwatch' id='dl' style='font-size: 22px; color: #1abc9ccc;' data-toggle='modal' data-target='#deadLine'></i>");
						
					} */
								
				
				$(".close").click(function(){
					$(".divArea").remove();
					$(".fa-stopwatch").remove();
					console.log("지운다.")
				});
				
			}
				
		});
	});
   
   $("#dt").click(function(){
	   
	   var dTime = $("input[name=dTime]").val();
	   var dtRno = $("input[name=dtRno]").val();
	   
	   $.ajax({
			url:"<%=request.getContextPath()%>/deadLine.cr",
			data:{dTime:dTime, dtRno:dtRno},
			type:"get",
			success:function(data){
				console.log(data);
				/* $("#dTime").text(data); */
			}
			
			
	   });
   });
   
});
</script>
<style>
#menu i {
	font-size: 1.7em;
	color: white;
}

#header i {
	font-size: 1.5em;
	color: white;
}

#header .search {
	float: right;
	position: absolute;
}

.navbar-nav {
	margin: 0;
}

.mainbar>li {
	display: inline-block;
	width: 24%;
	text-align: center;
}

.navbar {
	background: #1ABC9C;
}
/* 마이페이지 css */
ul, body {
	margin: 0 !important;
}

.cash>div>a {
	text-decoration: none;
	color: black;
}

.img i {
	font-size: 1.3em;
	margin-left: 0.3em;
}

.content {
	padding: 15px;
	margin-bottom: 14%;
	margin-top: 15%;
}

.content .line>div {
	display: inline-block;
	margin-top: 20px;
}

.line {
	margin: 0 5%;
}

.pay {
	margin: 0 5%;
}

.title {
	width: 30%;
	font-weight: bold;
}

.line .contents {
	border: none;
	width: 67%;
}

.img .icon {
	font-size: 1.5em;
	color: red;
}
body::-webkit-scrollbar {
	display: none;
}

#container {
   height: 410px;
}

#messageWindow::-webkit-scrollbar {

	display: none;
}

#messageWindow {
   height: 90%;
   overflow-y: scroll;
}

#chatForm {
	position: fixed;
	width: 100%;
	height: 15%;
	text-align: center;
	background: #4dd3b957;
}

#inputMessage {
	display: inline-block;
	margin-top: 9px;
	width: 77%;
	height: 40px;
}

#send {
	display: inline-block;
	width: 18%;
	height: 40px;
}

.msgLine {
   margin: 15px;
}

.smsgBox {

	background: #4dd3b96b /* #d8f0e3 */;
	padding: 0px 8px;
	border-radius: 8px;
	width: 45%;
	margin-left: auto;
	margin-right: 8px;
}

.rmsgBox {
	background: #ddddddc7;
	padding: 0px 8px;
	border-radius: 8px;
	width: 45%;
	margin-left: 8px;
	margin-right: auto;
}

#cs {
	padding: 4px;
	border: 5px dotted #fef5cbf2;
	text-align: center;
	text-shadow: 1px 0.8px #999;
	font-size: small;
	color: #9999993d;
}

#cc {
	padding: 4px;
	border: 5px dotted #e4e4e4;
	text-align: center;
	text-shadow: 1px 0.8px #999;
	font-size: small;
	color: #9999993d;
}

.me {

	text-align: right;
	font-size: 10px;
	color: white;
	margin: 0px;
}

#stime {
	text-align: right;
	font-size: 9px;
	color: lightgray;
	margin-right: 9px;
}

#rtime {
	text-align: left;
	font-size: 9px;
	color: lightgray;
	margin-left: 9px;
}

.profileImg {
    width: 50px;
    margin-right: 13px;
    display: inline-block;
}

.profileName {
	display: inline-block;
}

.chatPerson {
	height: 250px;
	padding: 15px;
	overflow: auto;
}

.chatPerson::-webkit-scrollbar {
	display: none;
}

.deadLine, .evaluation {
    padding: 15px;
}

.blank {
	padding: 5px;
    background: #eee9;
}

.ev {
    width: 47%;
    background: #1abc9ccc;
    border: white;
    color: white;
}

.kickBtn {
    font-size: small;
    text-align: center;
    padding: 5px;
}

.fa-sign-out-alt {
	margin-top:9px;
}

#busImg {
	height: 200px;
    width: 250px;
    margin: auto;
    text-align: center;
}
</style>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top" style="padding: 3px 0">
	<div class="container">
		<div id="header">
		<!-- 채팅방에 입장했을때 : rno는 방번호 입니다 -->
			<%if(request.getParameter("rno") != null) { %>
				<ul class="nav navbar-nav mainbar">
					<li class="" style="left: -3%;"><div onclick="leaveRoom();">
					<a style="padding: 0;margin-top: 9px;">
					<i class="fas fa-sign-out-alt" style="font-size:1.8em;"></i></a>
					</div></li>
					<li id="chatP" data-toggle="modal" data-target="#chatSub" class="search"
						style="right: 0%;"><a href="#chatSub">
						<i class="fas fa-bars"></i></a></li>
				</ul>
			<%}else if(request.getParameter("info") != null){ %>
				<!-- 채팅방이 아닌 나머지 경우 -->
				<ul class="nav navbar-nav mainbar">
					<li class="" style="left: -3%;"><a href="<%= request.getContextPath()%>/selectAll.cr">
					<i class="fas fa-arrow-left"></i></a></li>
				</ul>
			<%}else{ %>
				<ul class="nav navbar-nav mainbar">
					<li data-toggle="modal" data-target="#msearch" class="search"
						style="right: 0%;"><a href="#msearch">
						<i class="fas fa-bars"></i></a></li>
					<li data-toggle="modal" data-target="#ksearch" class="search"
						style="right: 13%;"><a href="#ksearch">
						<i class="fas fa-search"></i></a></li>
				</ul>
			<%} %>
		</div>
	</div>
</nav>
   <div id="container" style="margin-top:50px;">
      <div id="messageWindow" style="height: 410px; background: white"></div>
      <div id="chatForm">
         <input type="text" id="inputMessage" class="form-control" >
   		 <input type="hidden" value="<%= rno%>" name="rno">
         <input type="submit" id="send" class="btn btn-default" value="전송" onclick="send()">
      </div>
   </div>
      
   <!-- 채팅방 내 기능을 담당하는 모달 컨텐츠 -->
   <div class="container">
		<!-- Modal -->
		<div class="modal fade" id="chatSub" role="dialog"
			data-backdrop="static">
			<div class="modal-dialog modal-sm" data-backdrop="static" style="margin:0;">
				<!-- Modal content-->
				<div class="modal-content" data-backdrop="static" style="height: 513px;width: 202px;margin-left: auto;">
					<div class="modal-header" data-backdrop="static">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">대화 상대</h4>
					</div>
					<div class="modal-body" data-backdrop="static" style="padding: 0;">
						<%-- 대화상대 띄우기 --%>
						<div class="chatPerson">
						
						</div>
						
						<div class="blank"></div>
						
						<%-- 마감시간 설정 --%>
						<div class="deadLine">
							<div id="deadLineT" style=" display: inline-block; ">
								<h4>마감시간</h4>
							</div>
							<div id="deadLineI" style=" display: inline-block; margin-left: 10%; ">
								<p id="dTime" style="float: right; margin-left: 14px; font-size: 16px; "></p>
							</div>
						</div>
						
						<div class="blank"></div>
						
						<%-- 사용자/식당 평가하기 --%>
						<div class="evaluation">
							<h4>평가</h4>
							<button type="button" class="btn btn-default ev" data-toggle="modal" data-target="#userEv">사용자</button>
							<button type="button" class="btn btn-default ev" data-toggle="modal" data-target="#BusEv">식당</button>
						</div>
						
					</div>
				</div>
			</div>

		</div>
	</div>
	
	<!-- 사용자 프로필 확인하는 모달 컨텐츠 -->
   <div class="container">
		<!-- Modal -->
		<div class="modal fade" id="userProfile" role="dialog"
			data-backdrop="static">
			<div class="modal-dialog modal-sm" data-backdrop="static">
				<!-- Modal content-->
				<div class="modal-content" data-backdrop="static" style=' height: 500px; '>
					<div class="modal-header" data-backdrop="static">
						<h4 class="modal-title" style=' text-align:center '>프로필</h4>
					</div>
					<div class="modal-body" data-backdrop="static" style="padding: 0; height: 375px;">
															
					</div>
					<div class="modal-footer" data-backdrop="static">
						<button type="button" class="btn btn-default" data-dismiss="modal" >확인</button>
					</div>
				</div>
			</div>

		</div>
	</div>
	
   
   <!-- 마감시간 설정하는 모달 컨텐츠 -->
   <div class="container">
		<!-- Modal -->
		<div class="modal fade" id="deadLine" role="dialog"
			data-backdrop="static">
			<div class="modal-dialog modal-sm" data-backdrop="static">
				<!-- Modal content-->
				<div class="modal-content" data-backdrop="static" style=' width: 80%; margin: 10% 10%; '>
					<div class="modal-header" data-backdrop="static">
						<h4 class="modal-title" style=' text-align:center '>마감시간 설정</h4>
					</div>
					<div class="modal-body" data-backdrop="static" style="padding: 0;">
						<input type="time" class="form-control" name="dTime" style="width: 80%; margin: 30px; text-align: center;">
						<input type="hidden" value="<%= rno%>" name="dtRno">						
					</div>
					<div class="modal-footer" data-backdrop="static">
						<button type="button" class="btn btn-default" data-dismiss="modal"
							aria-label="Close">취소</button>
						<button type="button" id="dt" class="btn btn-default" data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>

		</div>
	</div>
	<script>
	$("input[name=dTime]").val('<%=getTime%>');
	</script>
	
	<!-- 사용자 평가 모달 컨텐츠 -->
   <div class="container">
		<!-- Modal -->
		<div class="modal fade" id="userEv" role="dialog"
			data-backdrop="static">
			<div class="modal-dialog modal-sm" data-backdrop="static">
				<!-- Modal content-->
				<div class="modal-content" data-backdrop="static" style=' width: 80%; margin: 10% 10%; '>
					<div class="modal-header" data-backdrop="static">
						<h4 class="modal-title" style=' text-align:center '>사용자 평가</h4>
					</div>
					<div class="modal-body" data-backdrop="static" style="padding: 0;">
						<%-- 대화상대 --%>
						<div id="chatPersonEv">
						
						</div>									
					</div>
					<div class="modal-footer" data-backdrop="static">
						<button type="button" class="btn btn-default" data-dismiss="modal"
							aria-label="Close">취소</button>
						<button type="button" class="btn btn-default" data-dismiss="modal" >평가</button>
					</div>
				</div>
			</div>

		</div>
	</div>
	
	<!-- 식당 평가 모달 컨텐츠 -->
   <div class="container">
		<!-- Modal -->
		<div class="modal fade" id="BusEv" role="dialog"
			data-backdrop="static">
			<div class="modal-dialog modal-sm" data-backdrop="static">
				<!-- Modal content-->
				<div class="modal-content" data-backdrop="static" style=' width: 80%; margin: 10% 10%; '>
					<div class="modal-header" data-backdrop="static">
						<h4 class="modal-title" style=' text-align:center '>식당 평가</h4>
					</div>
					<div class="modal-body" data-backdrop="static" style="padding: 0;">
						<h4 style="text-align:center;">식당이름</h4>
						<p style="color:lightgray; margin-left: 15px;">오늘 방문하신 식당은 어떠셨나요?</p>
						<div id="busImg">
							<img src="/rr/images/picture.png" style=" width: 250px; height: 200px; ">
						</div>
						<div id="">
						</div>					
					</div>
					<div class="modal-footer" data-backdrop="static">
						<button type="button" class="btn btn-default" data-dismiss="modal"
							aria-label="Close">취소</button>
						<button type="button" class="btn btn-default" data-dismiss="modal" >평가</button>
					</div>
				</div>
			</div>

		</div>
	</div>
   
</body>

<script>
//date format 함수  : Date 내장 객체에 format함수 추가
Date.prototype.format = function(f) {    
    if (!this.valueOf()) return " ";     
    
    var weekName = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];    
    var d = this;         
    
    return f.replace(/(yyyy|yy|MM|dd|E|hh|mm|ss|a\/p)/gi, function($1) {        
        switch ($1) {            
           case "yyyy": return d.getFullYear();            
           case "yy": return (d.getFullYear() % 1000).zf(2);            
           case "MM": return (d.getMonth() + 1).zf(2);            
           case "dd": return d.getDate().zf(2);            
           case "E": return weekName[d.getDay()];            
           case "HH": return d.getHours().zf(2);            
           case "hh": return ((h = d.getHours() % 12) ? h : 12).zf(2);            
           case "mm": return d.getMinutes().zf(2);            
           case "ss": return d.getSeconds().zf(2);            
           case "a/p": return d.getHours() < 12 ? "오전" : "오후";            
           default: return $1;        
         }    
    });
}; 

//한자리일경우 앞에 0을 붙여준다.
String.prototype.string = function(len){
    var s = '', i = 0; 
    while (i++ < len) { s += this; } 
    return s;
}; 
String.prototype.zf = function(len){return "0".string(len - this.length) + this;};
Number.prototype.zf = function(len){return this.toString().zf(len);};
//->여기까지 Date Format함수!

var textarea = document.getElementById("messageWindow");
var webSocket = new WebSocket("ws://<%=Address.getHostAddress()%>:8001" + '<%=request.getContextPath()%>/serverStart<%-- ?rno=<%=rno%> --%>');
var inputMessage = document.getElementById('inputMessage');
    
webSocket.onerror = function(event) {
  onError(event)
};
webSocket.onopen = function(event) {
  onOpen(event)
};
webSocket.onmessage = function(event) {
  onMessage(event)
};
webSocket.onclose = function(event) {  
	onClose(event)
};
	
function onMessage(event) {
	var msg = event.data;
	var str2 = "-";
	var str3 = ":";
	
	if(msg.includes(str2) == true){
		var rtime = new Date().format('yyyy.MM.dd a/p hh:mm');
		var srr = msg.split("-");
		var rno = srr[0];
		console.log("rno : "+rno);
		var userId = srr[1];
		var message = srr[2];
		if(rno == <%=rno%>)
		$("#messageWindow").append("<div><div class='rmsgBox'>" + message + "<br><p class='me'>" + userId + "</p></div><p class='ct' id='rtime'>" + rtime + "</p></div>");
	}else if(msg.includes(str3) == true){
		var srr = msg.split(":");
		var rno = srr[0];
		var userId = srr[1]
		var message = srr[2];
		if(rno == <%=rno%>){
			$("#messageWindow").append("<p id='cs'>" + userId + message + "</p>");
			
			<%-- 방 나가지는 기능 --%>
			if(message.includes("나가셨습니다.")){
				location.href = "<%= request.getContextPath()%>/leave.cr";
			}
		}
	}
	
	textarea.scrollTop = textarea.scrollHeight;
}
function onOpen(event) {
   	var userId = "<%=m.getUserName()%>";
   	$("#messageWindow").append("<br><p id='cs'>" + userId + "님이 채팅방에 참여하셨습니다.</p>");

    var str = userId + ":님이 채팅방에 참여하셨습니다.";
    send(str);
}

function onError(event) {
  alert(event.data);
}

function onClose(event){
}

function send(msg) {   

	var sendMsg = '';
	var userId = "<%=m.getUserName()%>";
	var rno =<%=rno%>;
	var stime = new Date().format('yyyy.MM.dd a/p hh:mm');

		console.log(msg);

		if (msg == undefined) {
			//console.log("채팅");
			$("#messageWindow")
					.append(
							"<div><div class='smsgBox'>"
									+ inputMessage.value
									+ "<br><p class='me'>나</p></div><p class='ct' id='stime'>"
									+ stime + "</p></div>");
			sendMsg = rno + "-" + userId + "-" + inputMessage.value;
		} else {
			console.log("입장/퇴장test");
			sendMsg = rno + ":" + msg;
		}
		//webSocket.send(userId + ":" + inputMessage.value);
		webSocket.send(sendMsg);

		textarea.scrollTop = textarea.scrollHeight;
		$("#inputMessage").val(' ');
	}
function leaveRoom(){
	var userId = "<%=m.getUserName()%>";
	send(userId + ":님이 채팅방을 나가셨습니다.");
	location.href = "<%= request.getContextPath()%>/leave.cr";
}
</script>
</html>