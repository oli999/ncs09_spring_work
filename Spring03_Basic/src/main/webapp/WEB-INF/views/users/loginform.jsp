<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/loginform.jsp</title>
</head>
<body>
<h1>로그인 폼 입니다. 1</h1>
<form action="login.do" method="post">
	<label for="id">아이디</label>
	<input type="text" name="id" id="id"/>
	<label for="pwd">비밀번호</label>
	<input type="password" name="pwd" id="pwd"/>
	<button type="submit">로그인</button>
</form>
<h1>로그인 폼 입니다. 2</h1>
<form action="${pageContext.request.contextPath }/users/login2.do" method="post">
	<label for="id">아이디</label>
	<input type="text" name="id" id="id"/>
	<label for="pwd">비밀번호</label>
	<input type="password" name="pwd" id="pwd"/>
	<button type="submit">로그인</button>
</form>

<h1>로그인 폼 입니다. 3</h1>
<form action="${pageContext.request.contextPath }/users/login3.do" method="post">
	<label for="id">아이디</label>
	<input type="text" name="id" id="id"/>
	<label for="pwd">비밀번호</label>
	<input type="password" name="pwd" id="pwd"/>
	<button type="submit">로그인</button>
</form>
</body>
</html>




