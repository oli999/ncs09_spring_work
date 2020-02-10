<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/shop/list.jsp</title>
<jsp:include page="../include/resource.jsp"/>
</head>
<body>
<jsp:include page="../include/navbar.jsp">
	<jsp:param value="shop" name="category"/>
</jsp:include>
<div class="container">
	<h3>상품 목록 입니다.</h3>
	<div class="row">
		<c:forEach var="tmp" items="${list }">
			<div class="col-xs-4">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4>${tmp.name }</h4>
					</div>
					<div class="panel-body">
						<img class="img-responsive img-thumbnail" src="${pageContext.request.contextPath }/resources/images/image1.png" alt="" />
						<p>가격 : <strong>${tmp.price }</strong></p>
						<p>남은 수량 : <strong>${tmp.remainCount }</strong></p>
					</div>
					<div class="panel-footer">
						<a class="btn btn-success" href="buy.do?num=${tmp.num }">구매하기</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
</body>
</html>






