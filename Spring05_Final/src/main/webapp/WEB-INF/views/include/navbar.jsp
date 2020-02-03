<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <div class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<!-- 홈페이지 링크와 버튼을 넣어둘 div -->
		<div class="navbar-header">
			<a class="navbar-brand" href="${pageContext.request.contextPath }/">Acorn</a>
			<button class="navbar-toggle" 
				data-toggle="collapse" 
				data-target="#one">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
		</div>
		<!-- xs 영역에서는 숨겨졌다가 버튼을 누르면 나오게 할 컨텐츠를 넣을 div -->
		<div class="collapse navbar-collapse" id="one">
			<ul class="nav navbar-nav">
				<li <c:if test="${param.category eq 'cafe' }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/cafe/list.do">Cafe</a></li>
				<li <c:if test="${param.category eq 'file' }">class="active"</c:if>><a href="${pageContext.request.contextPath }/file/list.do">자료실</a></li>
				<li><a href="#">Shop</a></li>		
			</ul>
			<c:choose>
				<c:when test="${empty sessionScope.id }">
					<div class="pull-right">
						<a class="btn btn-primary navbar-btn btn-xs" href="${pageContext.request.contextPath }/users/loginform.do">로그인</a>
						<a class="btn btn-warning navbar-btn btn-xs" href="${pageContext.request.contextPath }/users/signup_form.do">회원가입</a>
					</div>
				</c:when>
				<c:otherwise>
					<p class="navbar-text pull-right">
						<strong><a class="navbar-link" href="${pageContext.request.contextPath }/users/private/info.do">${id }</a></strong>
						<a class="navbar-link" href="${pageContext.request.contextPath }/users/logout.do">로그아웃</a> 
					</p>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>


