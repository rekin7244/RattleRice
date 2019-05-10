<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>500 Error Page</title>
<style>
.outer {
	height:800px;
	color: black;
}
#noticeKo {
	align:left;
	margin-left:0 auto;
}
#noticeEn {
	color:grey;
}
</style>
</head>
<body>
	<div class="outer" align="center">
		<img src="<%=request.getContextPath() %>/images/errorImage.png" alt="" />
		<h1 align="center">오류<p>Error Code : 500</p></h1>
		
		<p id="noticeKo">요청하신 페이지를 처리 중에 오류가 발생했습니다. 서비스 이용에 불편을 드려 죄송합니다. <br />
		요청하신 정보가 정확한지 확인 후 다시 시도해 주시기 바랍니다.<p>
		
		<p id="noticeEn">We have encountered a system error while processing your request. <br />
		We apologize for the inconvenience. Please check request and try again.</p>
	</div>
</body>
</html>