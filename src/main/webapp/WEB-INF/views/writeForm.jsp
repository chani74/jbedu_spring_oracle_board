<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>�Խ��� �۾���</h2>
	<hr>
	<form action="write">
		���̵�: <input type="text" name="bid" value="${loginId}" }><br><br>
		�ۼ��� : <input type="text" name="bname" ><br><br>
		������ : <input type="text" name="btitle" ><br><br>
		�۳��� : <textarea rows=5 cols="50" name="bcontent"></textarea><br><br>
		<input type="submit" value="���Է�">
		<input type="button" value="���">
		
	
	</form>
	
</body>
</html>