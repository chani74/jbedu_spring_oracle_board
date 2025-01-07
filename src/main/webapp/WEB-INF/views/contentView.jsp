<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시글 보기	</h2>
	<hr>
	${boardDto.btitle }<br><br>
	${boardDto.bcontent}<br><br>
	${boardDto.bid}<br><br>
	${boardDto.bname }<br><br>
	${boardDto.bhit }<br><br>
	${boardDto.bdate}<br><br>
	<hr>
	<input type="button" value="수정">
	<input type="button" value="삭제">
	<input type="button" value="글 목록" onclick="javascript:location.href='list';">
	
</body>
</html>