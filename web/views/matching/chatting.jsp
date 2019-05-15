<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.kh.rr.member.model.vo.*, java.net.*,java.util.*,javax.websocket.Session"%>
<% InetAddress Address = InetAddress.getLocalHost(); 
   Member m = (Member)(request.getSession().getAttribute("loginUser"));
   int rno = (int)session.getAttribute("rno"); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
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
	position:fixed;
	width: 100%;
	height: 15%;
	text-align: center;
	background: #4dd3b957;
}

#inputMessage {
	display:inline-block;
	margin-top:9px;
	width: 77%;
	height: 40px;
}

#send {
	display:inline-block;
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
	width:45%;
	margin-left:auto;
	margin-right:8px;
}

.rmsgBox {
	background: #ddddddc7;
	padding: 0px 8px;
	border-radius: 8px;
	width:45%;
	margin-left:8px;
	margin-right:auto;
}

#cp{
	text-align:center;
}
.me {
	text-align:right;
	font-size:10px;
	color:white;
	margin:0px;
}
#stime {
	text-align:right;
	font-size:9px;
	color:lightgray;
	margin-right:9px;
}

#rtime {
	text-align:left;
	font-size:9px;
	color:lightgray;
	margin-left:9px;
}
</style>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id="container" style="margin-top:50px;">
		<div id="messageWindow" style="height: 410px; background: white"></div>
		<div id="chatForm">
			<form>
			<input type="text" id="inputMessage" class="form-control" required>
			<input type="submit" id="send" class="btn btn-default" value="전송" onclick="send()">
			</form>
		</div>
	</div>
</body>

<script>
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
function onMessage(event) {
	var msg = event.data;
	var str2 = "-";
	
	if(msg.includes(str2) == true){
		var srr = msg.split("-");
		var userId = srr[1];
		var message = srr[2];
		$("#messageWindow").append("<div><div class='rmsgBox'>" + message + "<br><p class='me'>" + userId + "</p></div><p id='rtime'>2019.05.14 08:36</p></div>");
	}else{
		var srr = msg.split(":");
		var message = srr[1];
		$("#messageWindow").append("<br><p id='cp'>" + message + "</p>");
	}
}
function onOpen(event) {
   	var userId = "<%= m.getUserName() %>";
   	$("#messageWindow").append("<br><p id='cp'>" + userId + "님이 채팅방에 참여하셨습니다.</p>");
    var str = userId + "님이 채팅방에 참여하셨습니다.";
    send(str);
}
function onError(event) {
  alert(event.data);
}
function send(msg) {   
   var sendMsg = '';
   var userId = "<%= m.getUserName()%>";
   var rno = <%= rno %>;
   
   console.log(msg);
   
   if(msg == undefined){
      console.log("채팅");
      $("#messageWindow").append("<div><div class='smsgBox'>" + inputMessage.value + "<br><p class='me'>나</p></div><p id='stime'>2019.05.14 08:36</p></div>");
      sendMsg = rno + "-" + userId + "-" + inputMessage.value;
   }else{
      console.log("입장");
      sendMsg = rno + ":" + msg;
   }
      //webSocket.send(userId + ":" + inputMessage.value);
      webSocket.send(sendMsg);
      
      textarea.scrollTop = textarea.scrollHeight;
		$("#inputMessage").val('');
}
      </script>
</html>