<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>회원가입</h2>
		<form:form action="/signup" method="post" modelAttribute="memberDTO">
			<div class="form-group">
				<label for="id">ID:</label>
				<form:input type="text" class="form-control" id="id" placeholder="Enter id" name="member_id" path="member_id"/>
				<font color="red"><form:errors path="member_id"></form:errors></font>
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label>
				<form:input type="password" class="form-control" id="pwd" placeholder="Enter password" name="member_pwd" path="member_pwd"/>
				<font color="red"><form:errors path="member_pwd"></form:errors></font>
			</div>
			<div class="form-group">
				<label for="email">Email:</label>
				<form:input type="email" class="form-control" id="email" placeholder="Enter email" name="member_email" path="member_email"/>
				<font color="red"><form:errors path="member_email"></form:errors></font>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>
</html>