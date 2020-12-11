<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${ ERROR == 'yesLogin' }">
		<div class="alert alert-warning alert-dismissible">
    		<button type="button" class="close" data-dismiss="alert">&times;</button>
    		<strong>Warning!</strong> 잘못된 접근 방법입니다. 로그인 중이므로 해당 페이지로 이동할 수 없습니다.
  		</div>
	</c:if>
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
				<c:if test="${ PAGE.categoryNo == category.categoryNo }">
					<li class="breadcrumb-item active">${ category.categoryName }</li>
				</c:if>
				<c:if test="${ PAGE.categoryNo != category.categoryNo }">
					<li class="breadcrumb-item"><a href="/?categoryNo=${ category.categoryNo }">${ category.categoryName }</a></li>
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
	    		<c:if test="${fn:length(BOARD) == 0}">
	    			<td colspan="6">등록된 글이 없습니다.</td>
	    		</c:if>
	    		<c:if test="${ BOARD != null }">
	    			<c:forEach items="${ BOARD }" var="board">
		    			<tr>
							<td>${ board.boardNo }</td>
							<td>${ board.categoryName }</td>
							<td>${ board.memberId }</td>
							<td><a href="detail?no=${ board.boardNo }">${ board.boardTitle }</a></td>
							<td>${ board.boardDate }</td>
							<td><fmt:formatNumber value="${ board.boardViewCount }"/></td>
						</tr>
	    			</c:forEach>
				</c:if>
			</tbody>
		</table>
		
		<form class="form-inline" action="/" method="get">
			<input type="hidden" value="${ PAGE.nowPage }" name="nowPage">
			<input type="hidden" value="${ PAGE.categoryNo }" name="categoryNo">
			<input type="text" class="form-control" id="search" placeholder="Enter search" name="search"/>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		
		<ul class="pagination">
			<c:if test="${ PAGE.startPage != 1 }">
				<li class="page-item">
					<a href="/?nowPage=${ PAGE.startPage - 1 }&categoryNo=${ PAGE.categoryNo }&search=${ PAGE.search }" class="page-link">&lt;</a>
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
							<a href="/?nowPage=${ page }&categoryNo=${ PAGE.categoryNo }&search=${ PAGE.search }" class="page-link">${ page }</a>
						</li>
					</c:when>
				</c:choose>
			</c:forEach>
			<c:if test="${ PAGE.endPage != PAGE.lastPage }">
				<li class="page-item">
					<a href="/?nowPage=${ PAGE.endPage+1 }&categoryNo=${ PAGE.categoryNo }&search=${ PAGE.search }" class="page-link">&gt;</a>
				</li>
			</c:if>
		</ul>
	</div>
</body>
</html>