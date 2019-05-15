<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-default navbar-fixed-bottom"
	style="padding: 5px 0">
	<div class="container-fluid">
		<div id="menu">
			<ul class="nav navbar-nav mainbar">
				<li><a href="<%=request.getContextPath()%>/selectAll.cr"><i class="fas fa-home"></i></a></li>
				<li data-toggle="modal" data-target="#createChat"><a
					href="#createChat"><i class="fas fa-user-plus"></i></a></li>
				<li><a href="#"><i class="fas fa-bell"></i></a></li>
				<!-- header 에서 분기를 주기 위해 쿼리스트링으로 쓰레기 값을 보내서 판단한다 -->
				<li><a href="<%=request.getContextPath()%>/selectInfo.ui?info=2"><i class="fas fa-user"></i></a></li>
			</ul>
		</div>
	</div>
</nav>
