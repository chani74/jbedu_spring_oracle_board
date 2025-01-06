<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>게시판 글쓰기</h2>
	<hr>
	<form action="write">
		아이디: <input type="text" name="bid" value="${loginId}" }><br><br>
		작성자 : <input type="text" name="bname" ><br><br>
		글제목 : <input type="text" name="btitle" ><br><br>
		글내용 : <textarea rows=5 cols="50" name="bcontent"></textarea><br><br>
		<input type="submit" value="글입력">
		<input type="button" value="취소">
		
	
	</form>
	
</body>
</html>