<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="header" class="clearfix">

	<h1>
		<a href="${pageContext.request.contextPath}/main">Mysite6</a>
	</h1>


	<c:if test="${sessionScope.authUser != null}">
		<!-- 로그인 했을 때 -->
		<ul>
			<li>${authUser.name}님안녕하세요*^^*</li>
			<li><a href="${pageContext.request.contextPath}/user/logout"
				class="btn_s">로그아웃</a></li>
			<li><a href="${pageContext.request.contextPath}/user/modifyform"
				class="btn_s">회원정보수정</a></li>
		</ul>
	</c:if>

	<c:if test="${sessionScope.authUser == null}">
		<ul>
			<li><a href="${pageContext.request.contextPath}/user/loginform"
				class="btn_s">로그인</a></li>
			<li><a href="${pageContext.request.contextPath}/user/joinform"
				class="btn_s">회원가입</a></li>
		</ul>
	</c:if>
</div>
<!-- //header -->

<div id="nav">
	<ul class="clearfix">
		<li><a href="">입사지원서</a></li>
		<li><a href="${pageContext.request.contextPath}/board">게시판</a></li>
		<li><a href="${pageContext.request.contextPath}/gallery">갤러리</a></li>
		<li><a href="${pageContext.request.contextPath}/guest">방명록</a></li>
	</ul>
</div>
<!-- //nav -->