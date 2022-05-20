<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header id="header">
	<div class="container-fluid">
		<div id="logo" class="pull-left">
			<h1>
				<a href="#intro" class="scrollto">OhNoMyHouse</a>
			</h1>
			<!-- Uncomment below if you prefer to use an image logo -->
			<!-- <a href="#intro"><img src="img/logo.png" alt="" title="" /></a>-->
		</div>

		<nav id="nav-menu-container">
			<ul class="nav-menu">
				<li class="menu-active"><a href="#intro">Home</a></li>
				<li class="menu-active"><a href="#info">공지사항</a></li>
				<li class="menu-has-children"><a href="#">Search</a>
					<ul>
						<li><a href="#1">아파트 조회</a></li>
						<li><a href="#2">아파트별 실거래가 조회</a></li>
						<li><a href="#3">동별 실거래가 조회</a></li>
						<li><a href="#4">관심 지역 등록</a></li>
						<li><a href="#5">주변 상가 조회</a></li>
						<li><a href="#6">주변 환경</a></li>
						<li><a href="#7">사이트 맵</a></li>
					</ul></li>
				<c:choose>
					<c:when test="${sessionScope.userId eq null}">
						<li><a href="${root}/user/regist_form.do">회원 가입</a></li>
						<li><a href="${root}/user/login_form.do">로그인</a></li>
					</c:when>
					<c:otherwise>
						<!-- 로그인 한 경우 -->
						<li><a href="${root}/user/update_form.do?userid=${userId}">${userName}님
								회원수정</a></li>
						<li><a href="${root}/user/logout.do">로그아웃</a></li>
					</c:otherwise>
				</c:choose>
				<li data-wow-duration="0.7s" id="searchBox"><input type="text"
					id="searchBox-id" /></li>
				<li onclick="search()"><i class="ion-search"
					style="color: white"></i></li>
			</ul>
		</nav>
		<!-- #nav-menu-container -->
	</div>
</header>