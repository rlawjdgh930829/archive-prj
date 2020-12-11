<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1>${ DETAIL.boardTitle }</h1>      
			분류: ${ DETAIL.categoryName }<br/>
			작성자: ${ DETAIL.memberId }<br/>
			조회수: <fmt:formatNumber value="${ DETAIL.boardViewCount }"/><br/>
			작성일: ${ DETAIL.boardDate }<br/>
			<c:if test="${ DETAIL.memberNo == USER.memberNo }">
				<a href="boardDelete?no=${ DETAIL.boardNo }" class="btn btn-danger">삭제</a>
				<a href="boardModify?no=${ DETAIL.boardNo }" class="btn btn-info">수정</a>
			</c:if>
			</div>
	</div>
	<div class="container">
		   ${ DETAIL.boardContent }
	</div>
	<hr>
	<jsp:include page="comment.jsp"/>
</body>
</html>