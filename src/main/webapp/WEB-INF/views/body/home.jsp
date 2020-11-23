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
		<h2>글목록</h2>
		<table class="table table-hover">
			<thead><tr>
					<th>글번호</th>
					<th>분류</th>
					<th>작성자</th>
					<th>글제목</th>
					<th>작성일</th>
					<th>조회수</th>
			</tr></thead>
	    	<tbody>
	    		<c:if test="${ BOARD == null }">
	    			<td colspan="5">등록된 글이 없습니다.</td>
	    		</c:if>
	    		<c:if test="${ BOARD != null }">
	    			<c:forEach items="${ BOARD }" var="board">
		    			<tr>
							<td>${ board.board_no }</td>
							<td>${ board.category_name }</td>
							<td>${ board.member_id }</td>
							<td><a href="detail?no=${ board.board_no }">${ board.board_title }</a></td>
							<td>${ board.board_date }</td>
							<td>${ board.board_cnt }</td>
						</tr>
	    			</c:forEach>
				</c:if>
			</tbody>
		</table>
		
		<div>
			<c:if test="${ PAGE.startPage != 1 }">
				<a href="/?nowPage=${ PAGE.startPage - 1 }&cntPerPage=${ PAGE.cntPerPage }">&lt;</a>
			</c:if>
			<c:forEach begin="${PAGE.startPage }" end="${PAGE.endPage }" var="page">
				<c:choose>
					<c:when test="${ page == PAGE.nowPage }">
						<b>${ page }</b>
					</c:when>
					<c:when test="${ page != PAGE.nowPage }">
						<a href="/?nowPage=${ page }&cntPerPage=${ PAGE.cntPerPage }">${ page }</a>
					</c:when>
				</c:choose>
			</c:forEach>
			<c:if test="${ PAGE.endPage != PAGE.lastPage }">
				<a href="/?nowPage=${ PAGE.endPage+1 }&cntPerPage=${ PAGE.cntPerPage }">&gt;</a>
			</c:if>
		</div>
	</div>
</body>
</html>