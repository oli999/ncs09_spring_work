<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/error/forbidden.jsp</title>
<jsp:include page="../include/resource.jsp"></jsp:include>
</head>
<body>
<div class="container">
	<h1>금지된 요청 입니다.</h1>
	<p class="alert alert-danger">
		${msg }
		<a class="alert-link" href="${pageContext.request.contextPath }/home.do">확인</a>
	</p>
</div>
</body>
</html>






