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
					<th>글제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
			</tr></thead>
	    	<tbody>
	    		<c:if test="${ BOARD == null }">
	    			<td colspan="5">등록된 글이 없습니다.</td>
	    		</c:if>
	    		<c:if test="${ BOARD != null }">
					<tr>
						<td>1</td>
						<td>test-title</td>
						<td>test-writer</td>
						<td>test-date</td>
						<td>1</td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</div>
</body>
</html>