<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Sematic UI -->
<script src="/rr/js/semantic.min.js"></script>
<link rel="stylesheet" href="/rr/css/semantic.min.css">
<!-- 부트스트랩 -->
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
<link rel="stylesheet" type="text/css" href="../../css/matching/bar.css">
<!-- 거래내역 스타일 -->
<link rel="stylesheet" type="text/css"
	href="../../css/matching/payment.css">
<title>Insert title here</title>
<script>
	$(function() {
		$(window).resize(function() {
			window.resizeTo(410, 600);
		});
	});
</script>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container bar">
		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#bellTab">벨</a></li>
			<li style="color: #4abeca;"><a data-toggle="tab" href="#billTab">빌</a></li>
		</ul>
		<br>

	</div>

	<div class="tab-content">
		<div id="bellTab" class="tab-pane fade in active">
			<div class="container-fluid">
				<label><i class="bell icon" style="color: gold"></i>보유 bell
				</label> <label><span style="color: #4abeca;">10</span>벨</label>
			</div>
		</div>

		<div id="billTab" class="tab-pane fade">
			<div class="container-fluid">
				<label><i class="money bill alternate icon"
					style="color: gold"></i>보유 bill </label> <label><span
					style="color: #4abeca;">10000</span>빌</label>
				<button type="button" class="btn btn-default paybtn"
					data-toggle="modal" data-target="#refund">환급신청</button>
			</div>
		</div>
	</div>

	<!-- 환급신청 -->
	<div class="container">
		<!-- Modal -->
		<div class="modal fade" id="refund" role="dialog"
			data-backdrop="static">
			<div class="modal-dialog modal-sm" data-backdrop="static">

				Modal content
				<div class="modal-content" data-backdrop="static">
					<div class="modal-header" data-backdrop="static">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Refund</h4>
					</div>
					<div class="modal-body" data-backdrop="static">
						<p>환급 금액을 입력해주세요.</p>
						<input type="text" class="form-control" id="ks"
							placeholder="3000빌 이상부터 환급가능합니다."> <br> <label><i
							class="money bill alternate icon" style="color: gold"></i>보유 bill
						</label> <label><span style="color: #4abeca;">10000</span>빌</label>
					</div>
					<div class="modal-footer" data-backdrop="static">
						<button type="button" class="btn btn-default" data-dismiss="modal"
							aria-label="Close">취소</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">환급</button>
					</div>
				</div>

			</div>
		</div>
	</div>

	<%@ include file="menubar.jsp"%>
</body>
</html>