<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>회원가입</h2>
		<input type="hidden" id="idCheck" value="false">
		<input type="hidden" id="emailCheck" value="false">
		<form:form action="/signup" method="post" modelAttribute="memberDTO">
			<div class="form-group">
				<label for="id">ID:</label>
				<form:input type="text" class="form-control" id="id" placeholder="Enter id" name="memberId" path="memberId"/>
				<div id="id_check"></div>
				<font color="red"><form:errors path="memberId"></form:errors></font>
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label>
				<form:input type="password" class="form-control" id="pwd" placeholder="Enter password" name="memberPwd" path="memberPwd"/>
				<font color="red"><form:errors path="memberPwd"></form:errors></font>
			</div>
			<div class="form-group">
				<label for="email">Email:</label>
				<form:input type="text" class="form-control" id="email" placeholder="Enter email" name="memberEmail" path="memberEmail"/>
				<div id="email_check"></div>
				<font color="red"><form:errors path="memberEmail"></form:errors></font>
			</div>
			<button id="button" type="submit" class="btn btn-primary" disabled>Submit</button>
		</form:form>
	</div>
	
	<script>
		$("#id").blur(function() {
			var idPatternCheck = /^[a-zA-Z0-9]{2,10}$/
			var userId = $('#id').val();
			if(userId == "") {
				$('#id_check').text('아이디를 입력해주세요.');
				$('#id_check').css('color', 'red');
				$("#idCheck").val("false");
				$("#button").prop("disabled", true);
			} else if(idPatternCheck.test(userId) == false) {
				$("#id_check").text("아이디는 영어와 숫자 2~10자리를 입력해주세요.");
				$("#id_check").css("color", "red");
				$("#idCheck").val("false");
				$("#button").prop("disabled", true);
			} else {
				$.ajax({
					url : '/idCheck?userId='+ userId,
					type : 'get',
					success : function(data) {
						if(data == true) {
							$("#id_check").text("사용중인 아이디입니다.");
							$("#id_check").css("color", "red");
							$("#idCheck").val("false");
							$("#button").prop("disabled", true);
						} else if(data == false) {
							$("#id_check").text("사용 가능한 아이디입니다.");
							$("#id_check").css("color", "blue");
							$("#idCheck").val("true");
							if($("#idCheck").val()=="true" && $("#emailCheck").val()=="true") {
								$("#button").prop("disabled", false);
							}
						}
					}
				});
			}
		});
		
		$("#email").blur(function() {
			var emailId = $('#email').val();
			var	emailPatternCheck = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
			if(emailId == ""){
				$('#email_check').text('이메일을 입력해주세요.');
				$('#email_check').css('color', 'red');
				$("#emailCheck").val("false");
				$("#button").prop("disabled", true);
			} else if(emailPatternCheck.test(emailId) == false) {
				$('#email_check').text('이메일 형식에 맞게 입력해주세요.');
				$('#email_check').css('color', 'red');
				$("#emailCheck").val("false");
				$("#button").prop("disabled", true);
			} else {
				$.ajax({
					url : '/emailCheck?emailId='+ emailId,
					type : 'get',
					success : function(data) {
						if(data == true) {
							$("#email_check").text("사용중인 이메일입니다.");
							$("#email_check").css("color", "red");
							$("#emailCheck").val("false");
							$("#button").prop("disabled", true);
						} else if(data == false){
							$("#email_check").text("사용 가능한 이메일입니다.");
							$("#email_check").css("color", "blue");
							$("#emailCheck").val("true");
							if($("#idCheck").val()=="true" && $("#emailCheck").val()=="true") {
								$("#button").prop("disabled", false);
							}
						}
					}
				});
			}
		});
	</script>
</body>
</html>