<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand" href="/">HOME</a>
  
		<!-- Links -->
		<ul class="navbar-nav ml-auto">
			<c:if test="${ USER == null }">
				<li class="nav-item">
					<a class="nav-link" href="signin">로그인</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="signup">회원가입</a>
				</li>
			</c:if>
			<c:if test="${ USER != null }">
				<li class="nav-item">
					<a class="nav-link" href="logout">로그아웃</a>
				</li>
			</c:if>
		</ul>
	</nav>
</body>
</html>