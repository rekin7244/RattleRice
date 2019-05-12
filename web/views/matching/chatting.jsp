<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.rr.member.model.vo.*, java.net.*,java.util.*,javax.websocket.Session"%>
<% InetAddress Address = InetAddress.getLocalHost(); 
Set<Session> clients = (Set<Session>) session.getAttribute("client");
System.out.println(clients);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<!-- 메뉴바 스타일 -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

</style>
</head>
<body>
<%@ include file="header.jsp"%>
    <fieldset style="margin-top: 14%;">
        <textarea id="messageWindow" rows="10" cols="50" readonly="true"></textarea>
        <br/>
        <input id="inputMessage" type="text"/>
        <input type="submit" value="send" onclick="send()" />
    </fieldset>
</body>
	
	<script>
	var textarea = document.getElementById("messageWindow");
    var webSocket = new WebSocket("ws://<%=Address.getHostAddress()%>:8001" + '<%=request.getContextPath()%>/serverStart');
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
	var userId = "<%=((Member)(request.getSession().getAttribute("loginUser"))).getUserName()%>";
    textarea.value += userId + " : " + event.data + "\n";
}
function onOpen(event) {
	var userId = "<%=((Member)(request.getSession().getAttribute("loginUser"))).getUserName()%>";
    textarea.value += userId + "님이 채팅방에 참여하셨습니다.\n";
}
function onError(event) {
  alert(event.data);
}
function send() {
    textarea.value += "나 : " + inputMessage.value + "\n";
    webSocket.send(inputMessage.value);
    inputMessage.value = "";
}
		</script>
</html>