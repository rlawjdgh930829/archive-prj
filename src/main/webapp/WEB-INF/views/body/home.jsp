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
		<ul class="breadcrumb">
			<c:if test="${ PAGE.categoryNo == 0 || PAGE.categoryNo == null }">
				<li class="breadcrumb-item active">전체글</li>
			</c:if>
			<c:if test="${ PAGE.categoryNo != 0 }">
				<li class="breadcrumb-item active"><a href="/">전체글</a></li>
			</c:if>
			<c:forEach items="${ CATEGORY }" var="category">
				<c:if test="${ PAGE.categoryNo == category.category_no }">
					<li class="breadcrumb-item active">${ category.category_name }</li>
				</c:if>
				<c:if test="${ PAGE.categoryNo != category.category_no }">
					<li class="breadcrumb-item"><a href="/?categoryNo=${ category.category_no }">${ category.category_name }</a></li>
				</c:if>
			</c:forEach>
		</ul>
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
		
		<ul class="pagination">
			<c:if test="${ PAGE.startPage != 1 }">
				<li class="page-item">
					<a href="/?nowPage=${ PAGE.startPage - 1 }&categoryNo=${ PAGE.categoryNo }" class="page-link">&lt;</a>
				</li>
			</c:if>
			<c:forEach begin="${ PAGE.startPage }" end="${ PAGE.endPage }" var="page">
				<c:choose>
					<c:when test="${ page == PAGE.nowPage }">
						<li class="page-item disabled">
							<a class="page-link">${ page }</a>
						</li>
					</c:when>
					<c:when test="${ page != PAGE.nowPage }">
						<li class="page-item">
							<a href="/?nowPage=${ page }&categoryNo=${ PAGE.categoryNo }" class="page-link">${ page }</a>
						</li>
					</c:when>
				</c:choose>
			</c:forEach>
			<c:if test="${ PAGE.endPage != PAGE.lastPage }">
				<li class="page-item">
					<a href="/?nowPage=${ PAGE.endPage+1 }&categoryNo=${ PAGE.categoryNo }" class="page-link">&gt;</a>
				</li>
			</c:if>
		</ul>
	</div>
</body>
</html>