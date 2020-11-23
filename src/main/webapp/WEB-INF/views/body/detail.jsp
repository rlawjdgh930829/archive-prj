<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1>${ DETAIL.board_title }</h1>      
			분류: ${ DETAIL.category_name }<br/>
			작성자: ${ DETAIL.member_id }<br/>
			조회수: ${ DETAIL.board_cnt }<br/>
			작성일: ${ DETAIL.board_date }<br/>
			<c:if test="${ DETAIL.member_no == USER.member_no }">
				<a href="boardDelete?no=${ DETAIL.board_no }" class="btn btn-danger">삭제</a>
				<a href="boardModify?no=${ DETAIL.board_no }" class="btn btn-info">수정</a>
			</c:if>
			</div>
	</div>

	<div class="container">
		   ${ DETAIL.board_content }
	</div>
</body>
</html>