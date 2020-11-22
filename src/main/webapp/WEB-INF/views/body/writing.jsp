<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<form action="/writing" method="post">
			<input type="hidden" value="${ USER.member_no }" name="member_no">
			<div class="form-group">
				<label for="title">Title:</label>
				<input type="text" class="form-control" id="title" placeholder="Enter title" name="board_title">
			</div>
			<label for=category>Select list:</label>
			<select class="form-control" id="category" name="category_no">
				<c:forEach items="${ CATEGORY }" var="category">
					<option value="${ category.category_no }">${ category.category_name }</option>
				</c:forEach>
			</select>
			<div class="form-group">
				<label for="content">Contents:</label>
				<textarea id="summernote" name="board_content"></textarea>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
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