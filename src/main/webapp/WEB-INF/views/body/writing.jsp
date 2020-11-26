<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>글등록</h2>
		<form:form action="/writing" method="post" modelAttribute="boardDTO">
			<form:input type="hidden" value="${ USER.member_no }" name="member_no" path="member_no"/>
			<div class="form-group">
				<label for="title">Title:</label>
				<form:input type="text" class="form-control" id="title" placeholder="Enter title" name="board_title" path="board_title"/>
				<font color="red"><form:errors path="board_title"></form:errors></font>
			</div>
			<label for=category>Select list:</label>
			<form:select class="form-control" id="category" name="category_no" path="category_no">
				<c:forEach items="${ CATEGORY }" var="category">
					<form:option value="${ category.category_no }">${ category.category_name }</form:option>
				</c:forEach>
			</form:select>
			<div class="form-group">
				<label for="content">Contents:</label>
				<form:textarea id="summernote" name="board_content" path="board_content"></form:textarea>
				<font color="red"><form:errors path="board_content"></form:errors></font>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>
	
	<script>
		function sendFile(file, el) {
			var form_data = new FormData();
			form_data.append('file', file);
			$.ajax({
				data: form_data,
				type : "post",
				url: 'summer_image',
				cache :false,
				contentType : false,
				enctype : 'multipart/form-data',
				processData : false,
				success : function(img_name) {
						$(el).summernote('editor.insertImage', img_name);
				}
			});
		}
		
		$(function() {
			$('#summernote').summernote({
				 	placeholder: 'Enter Contents',
			        height: 300,
			        lang: 'ko-KR',
			        callbacks: {
			        	onImageUpload: function(files, editor, welEditable) {
			        		for(var i = files.length -1; i>=0; i--) {
			        			sendFile(files[i], this);
			        		}
			        	}
			        }
			 });
		});
	</script>
</body>
</html>