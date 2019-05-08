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
				<li><a href="#"><i class="far fa-comment-dots"></i></a></li>
				<li><a href="<%=request.getContextPath()%>/selectInfo.ui"><i class="fas fa-user"></i></a></li>
			</ul>
		</div>
	</div>
</nav>
