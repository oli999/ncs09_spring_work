<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/home.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>
<div class="container">
	<h1>인덱스 페이지 입니다</h1>
	<c:if test="${not empty id }">
		<p> 
			<strong>${id }</strong> 님 로그인중 ...
			<a href="users/logout.do">로그아웃</a>
		</p>
	</c:if>
	<ul>
		<li><a href="todo/list.do">할일 목록 보기</a></li>
		<li><a href="todo/list2.do">할일 목록 보기2</a></li>
		<li><a href="todo/list3.do">할일 목록 보기3</a></li>
		<li><a href="users/loginform.do">로그인 하러가기</a></li>
		<li><a href="play.do">회원 전용 공간으로 가기</a></li>
	</ul>
	<h2>공지사항</h2>
	<ul>
		<c:forEach var="tmp" items="${notice }">
			<li>${tmp }</li>
		</c:forEach>
	</ul>
</div>
</body>
</html>





