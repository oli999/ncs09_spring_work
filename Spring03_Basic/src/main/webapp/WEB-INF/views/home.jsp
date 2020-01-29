<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/home.jsp</title>
</head>
<body>
<h1>인덱스 페이지 입니다</h1>
<ul>
	<li><a href="todo/list.do">할일 목록 보기</a></li>
	<li><a href="todo/list2.do">할일 목록 보기2</a></li>
	<li><a href="todo/list3.do">할일 목록 보기3</a></li>
	<li><a href="users/loginform.do">로그인 하러가기</a></li>
</ul>
<h2>공지사항</h2>
<ul>
	<c:forEach var="tmp" items="${notice }">
		<li>${tmp }</li>
	</c:forEach>
</ul>
</body>
</html>





