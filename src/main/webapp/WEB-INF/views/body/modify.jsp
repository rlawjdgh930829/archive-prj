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
		<h2>글수정</h2>
		<form action="/boardModify" method="post">
			<input type="hidden" value="${ DETAIL.boardNo }" name="boardNo">
			<div class="form-group">
				<label for="title">Title:</label>
				<input type="text" class="form-control" value="${ DETAIL.boardTitle }" id="title" maxlength="50" placeholder="Enter title" name="boardTitle">
				<div id="titleCheckMessage"></div>
			</div>
			<label for=category>Select list:</label>
			<select class="form-control" id="category" name="categoryNo">
				<c:forEach items="${ CATEGORY }" var="category">
					<c:if test="${ category.categoryName == DETAIL.categoryName }">
						<option value="${ category.categoryNo }" selected>${ category.categoryName }</option>
					</c:if>
					<c:if test="${ category.categoryName != DETAIL.categoryName }">
						<option value="${ category.categoryNo }">${ category.categoryName }</option>
					</c:if>
				</c:forEach>
			</select>
			<div class="form-group">
				<label for="content">Contents:</label>
				<textarea id="summernote" name="boardContent">${ DETAIL.boardContent }</textarea>
			</div>
			<button id="button" type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	
	<script>
		$("#title").blur(function() {
			if($('#title').val().length <= 0) {
				$('#titleCheckMessage').text('제목을 입력해주세요.');
				$('#titleCheckMessage').css('color', 'red');
				$("#titleCheck").val("false");
				$("#button").prop("disabled", true);
			} else {
				$("#button").prop("disabled", false);
			}
		});
		
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