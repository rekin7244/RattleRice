<%@ page language="java" contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8"
	import="com.kh.rr.member.model.vo.*, java.net.*, java.util.*, javax.websocket.Session, java.text.*"%>
<%
	InetAddress Address = InetAddress.getLocalHost();
	Member m = (Member) (request.getSession().getAttribute("loginUser"));
	int rno = (int) session.getAttribute("rno");

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
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
//창크기 조절용 함수
$(function() {
   $(window).resize(function() {
      window.resizeTo(410, 600);
   });

});
</script>
<style>
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

#cp {
	padding: 4px;
	border: 5px dotted #fef5cbf2;
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
</style>
</head>
<body>

   <%@ include file="header.jsp"%>
   <div id="container" style="margin-top:50px;">
      <div id="messageWindow" style="height: 410px; background: white"></div>
      <div id="chatForm">
         <input type="text" id="inputMessage" class="form-control" >
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
    });}; 

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
	
	if(msg.includes(str2) == true){
		var rtime = new Date().format('yyyy.MM.dd a/p hh:mm');
		var srr = msg.split("-");
		var userId = srr[1];
		var message = srr[2];
		$("#messageWindow").append("<div><div class='rmsgBox'>" + message + "<br><p class='me'>" + userId + "</p></div><p class='ct' id='rtime'>" + rtime + "</p></div>");
	}else{
		var srr = msg.split(":");
		var message = srr[1];
		$("#messageWindow").append("<p id='cp'>" + message + "</p>");
	}
	
	textarea.scrollTop = textarea.scrollHeight;
}
function onOpen(event) {
   	var userId = "<%=m.getUserName()%>";
   	$("#messageWindow").append("<br><p id='cp'>" + userId + "님이 채팅방에 참여하셨습니다.</p>");

    var str = userId + "님이 채팅방에 참여하셨습니다.";
    send(str);
}

function onError(event) {
  alert(event.data);
}
function onClose(event){
	var msg = event.data;
	var userId = "<%=m.getUserName()%>";
	$("#messageWindow").append("<br><p id='cp'>" + userId + "님이 채팅방을 나가셨습니다.</p>");
}
function send(msg) {   

	var sendMsg = '';
	var userId = "<%=m.getUserName()%>";
	var rno =<%=rno%>;
	var stime = new Date().format('yyyy.MM.dd a/p hh:mm');

		console.log(msg);

		if (msg == undefined) {
			console.log("채팅");
			$("#messageWindow")
					.append(
							"<div><div class='smsgBox'>"
									+ inputMessage.value
									+ "<br><p class='me'>나</p></div><p class='ct' id='stime'>"
									+ stime + "</p></div>");
			sendMsg = rno + "-" + userId + "-" + inputMessage.value;
		} else {
			console.log("입장");
			sendMsg = rno + ":" + msg;
		}
		//webSocket.send(userId + ":" + inputMessage.value);
		webSocket.send(sendMsg);

		textarea.scrollTop = textarea.scrollHeight;
		$("#inputMessage").val(' ');
	}
</script>
</html>