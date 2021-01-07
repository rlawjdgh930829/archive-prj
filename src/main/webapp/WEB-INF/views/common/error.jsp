<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1><font color="red"><c:out value="${error.STATUS_CODE }"></c:out></font></h1>
			<h3>${error.MESSAGE }</h3>
			<p><a href="<c:url value='/'/>"> [HOME] </a>을 클릭하시면, 홈으로 돌아갑니다.</p>
		</div>
	</div>
</body>
</html>