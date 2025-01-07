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
	
	<form action="modifyOk">
	<input type=hidden name="bnum" value="${boardDto.bnum }"><br><br>
	<input type=text name="btitle" value="${boardDto.btitle }"><br><br>
	<textarea rows="5" cols="45" name='bcontent'>${boardDto.bcontent}</textarea> <br><br>
	
	${boardDto.bid}<br><br>
	${boardDto.bname }<br><br>
	${boardDto.bhit }<br><br>
	${boardDto.bdate}<br><br>
	
	<hr>
	<input type="submit" value="수정완료">
	<input type="button" value="수정취소" onclick="javascript:history.go(-1);">
	</form>
</body>
</html>