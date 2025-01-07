<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%-- Core Library --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시판 글 목록</h2>
	<hr></hr>
	<table border=1 cellspacing=0 cellpadding=0 width=800>
	<tr>
		<th>글번호</th>
		<th width=400>글제목</th>
		<th>작성자</th>
		<th>등록일</th>
		<th>조회수</th>
		<th>삭제</th>
	</tr>
	<c:forEach items="${boardList}" var="boardDto">
	<tr>
		<td>${boardDto.bnum }</td>
		<td><a href="content_view?bnum=${boardDto.bnum }" > ${boardDto.btitle }</a></td>
		<td>${boardDto.bname }</td>
		<td>${boardDto.bdate }</td>
		<td>${boardDto.bhit }</td>
		<td><input type="button" value="삭제" onClick="javascript:location.href='deleteOk?bnum=${boardDto.bnum }';"></td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan=6>
			<input type="button" value="글쓰기" onClick="javascript:location.href='write_form';">
		</td>
	</tr>
	</table>
</body>
</html>