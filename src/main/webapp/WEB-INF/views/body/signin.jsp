<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>로그인</h2>
		<form:form action="/signin" method="post" modelAttribute="loginUserDTO">
			<div class="form-group">
				<label for="id">ID:</label>
				<form:input type="text" class="form-control" id="id" placeholder="Enter id" name="memberId" path="memberId"/>
				<font color="red"><form:errors path="memberId"></form:errors></font>
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label>
				<form:input type="password" class="form-control" id="pwd" placeholder="Enter password" name="memberPwd" path="memberPwd"/>
				<font color="red"><form:errors path="memberPwd"></form:errors></font>				
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>
</html>