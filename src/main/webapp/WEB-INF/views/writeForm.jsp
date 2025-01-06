<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시판 글쓰기</h2>
	<hr>
	<form action="write">
		아이디: <input type="text" name="bid" value="${loginId}" readonly="readonly"><br><br>
		작성자 : <input type="text" name="bname" value="${memberName}" readonly="readonly" ><br><br>
		글제목 : <input type="text" name="btitle" ><br><br>
		글내용 : <textarea rows=5 cols="50" name="bcontent"></textarea><br><br>
		<input type="submit" value="글입력">
		<input type="button" value="취소">
		
	
	</form>
	
</body>
</html>