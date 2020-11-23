<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1>${ DETAIL.board_title }</h1>      
			분류: ${ DETAIL.category_name }<br/>
			작성자: ${ DETAIL.member_id }<br/>
			조회수: ${ DETAIL.board_cnt }<br/>
			작성일: ${ DETAIL.board_date }<br/>
			<a href="boardDelete?no=${ DETAIL.board_no }" class="btn btn-danger">삭제</a>
			<a href="boardModify?no=${ DETAIL.board_no }" class="btn btn-info">수정</a>
		</div>
	</div>

	<div class="container">
		   ${ DETAIL.board_content }
	</div>
</body>
</html>