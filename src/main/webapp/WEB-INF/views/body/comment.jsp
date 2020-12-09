<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="container">
	<form:form action="/commentwriting" method="post" modelAttribute="commentDTO">
		<input type="hidden" value="${ DETAIL.boardNo }" name="boardNo">
		<input type="hidden" value="${ USER.memberNo }" name="memberNo"/>
		<div class="input-group mb-3">
			<form:input type="text" class="form-control" placeholder="Comment" path="commentContent"/>
			<div class="input-group-append">
				<button class="btn btn-success" type="submit">submit</button>
			</div>
		</div>
	</form:form>
	Comment <span class="badge badge-pill badge-primary">${ COUNT }</span>
	<div class="card">
		<c:if test="${fn:length(COMMENT) == 0}">
	    	<div class="card-body">
				<p class="card-text">등록된 댓글이 없습니다.</p>
			</div>
	   	</c:if>
	    <c:if test="${ COMMENT != null }">
	    	<c:forEach items="${ COMMENT }" var="comment">
			<div class="card-body">
				<h4 class="card-title">${ comment.memberNo }</h4>
				<p class="card-text">${ comment.commentContent }</p>
			</div>
			</c:forEach>
		</c:if>
	</div>
</div>