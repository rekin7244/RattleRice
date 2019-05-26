<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>SMS 관리</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<style>
/* ---------------------------------------------------
    CONTENT STYLE
----------------------------------------------------- */
#content {
	width: calc(100% - 250px);
	padding: 40px;
	min-height: 100vh;
	transition: all 0.3s;
	position: absolute;
	top: 10;
	right: 0;
}

#content.active {
	width: 100%;
}

#mainbar {
	background-color: lightgreen;
	font-size: 1.5em;
	padding: 5px;
	border-radius: 10px;
}

/*  .sms {
	display: inline-block;
} */

#smsinput>#to>label {
	background: lightgray;
	width: 100px;
	text-align: center;
}
/
#phone {
	margin-top: -100px;
}

.smsform .sms-text {
	margin-top: -500px;
	margin-left: 30px;
}

 #smsinput {

	margin-left: 100px;
	
} 


/* 
.smsform #btn button {
	padding: 30px;
} */

#btn {
	margin-top: -30px;
	margin-left:40px;
	padding: 40px;
	
} 

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 15% auto; /* 15% from the top and centered */
	padding: 20px;
	border: 1px solid #888;
	width: 50%; /* Could be more or less, depending on screen size */
}
/* The Close Button */
.close {
	color: #aaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: black;
	text-decoration: none;
	cursor: pointer;
}

#to{
	margin-left:30px;
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
					<a>SMS 발송</a>
				</div>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="nav navbar-nav ml-auto">
						<li class="nav-item active"><a class="nav-link"
							href="<%=request.getContextPath() %>/memberlist.ad">회원관리</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath()%>/communitylist.ad">커뮤니티</a></li>
						<li class="nav-item"><a class="nav-link" href="calculate.jsp">정산</a></li>
						<li class="nav-item"><a class="nav-link"
							href="views/admin/sms.jsp">SMS</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath() %>/logout.me">로그아웃</a></li>
					</ul>
				</div>
			</div>
		</nav>

		<br> <br>

	 <form action="<%=request.getContextPath() %>/smslistInsert.ad"
			method="post">
		<h3>
			<b>문자 보내기</b>
		</h3>
		<br>

		<div class="smsform" id="smsinput">
			
			<!-- 	
			<label>제목</label> <input type="text" placeholder="필수 입력 값이 아닙니다.">
				<br> -->
			
			<img id="phone" src="../../images/smartphone.png" width="320px"
				height="600px">

			<div class="sms-text">
				<textarea autofocus cols="30" rows="10" name="content"></textarea>
			</div>
			
			
			<div id = "to">
				<label>제목</label>  <br>
				<input type="text" placeholder="필수 입력 값이 아닙니다.">
				<br>
				<label>받는사람</label> <br>
				<input name="to" type="text" placeholder="전화번호('-'제외)">			
				<br>
			</div>
			

			<div id="btn">
				<button type="reset" class="btn btn-primary">재작성</button>

				&nbsp;&nbsp;&nbsp;
				<!-- Trigger/Open The Modal -->
				<button id="myBtn" type="submit" class="btn btn-primary">보내기</button>

				<!-- The Modal -->
				<div id="myModal" class="modal">

					<!-- Modal content -->
					<div class="modal-content">
						<span class="close">&times;</span>
						<p>전송 중 입니다. 잠시만 기다려 주세요...</p>
					</div>

				</div>




			</div>

		

		</div>
	</div>
		</form>
</body>



<script>

//Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];                                          

// When the user clicks on the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}




</script>

</html>