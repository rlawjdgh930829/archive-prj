<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${ MESSAGE != null }">
		<div class="alert alert-warning alert-dismissible">
    		<button type="button" class="close" data-dismiss="alert">&times;</button>
    		<c:if test="${ MESSAGE == 'noId' }">
    			<strong>존재하지 않는 아이디입니다.</strong>
    		</c:if>
    		<c:if test="${ MESSAGE == 'noPwd' }">
    			<strong>비밀번호가 틀렸습니다.</strong>
    		</c:if>
  		</div>
	</c:if>
	<c:if test="${ ERROR == 'noLogin' }">
		<div class="alert alert-warning alert-dismissible">
    		<button type="button" class="close" data-dismiss="alert">&times;</button>
    		<strong>Warning!</strong> 잘못된 접근 방법입니다. 로그인 후 다시 시도 해주세요.
  		</div>
	</c:if>
	<div class="container">
		<h2>로그인</h2>
		<form:form action="/signin" method="post" modelAttribute="loginUserDTO">
			<div class="form-group">
				<label for="id">ID:</label>
				<form:input type="text" class="form-control" id="id" placeholder="Enter id" name="memberId" maxlength="10" path="memberId"/>
				<font color="red"><form:errors path="memberId"></form:errors></font>
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label>
				<form:input type="password" class="form-control" id="pwd" placeholder="Enter password" name="memberPwd" maxlength="20" path="memberPwd"/>
				<font color="red"><form:errors path="memberPwd"></form:errors></font>				
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>
</html>