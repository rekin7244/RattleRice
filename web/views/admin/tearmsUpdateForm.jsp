<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String terms = request.getParameter("terms");
	if(terms == null){
		terms = "test";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	$(function() {
		$(window).resize(function() {
			window.resizeTo(700, 500);
		});
	});
	function updateTerms() {
		location.href="updateTerms.terms"
	}
</script>
</head>
<body>
	<table class="table table-bordered">
		<tr>
			<td>
				<textarea name="terms" id="" cols="30" rows="10"><%=terms %></textarea>
			</td>
			<td align="center">
				<button onclick="updateTerms();">수정</button>
			</td>
		</tr>
	</table>
</body>
</html>