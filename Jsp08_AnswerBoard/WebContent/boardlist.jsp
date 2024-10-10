<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>글 목록</h1>
<table>
	<col width="50"><col width="300"><col width="100"><col width="100">
	<tr>
		<th>글번호</th>
		<th>제 목</th>
		<th>작성자</th>
		<th>작성일</th>
	</tr>
	<c:choose>
		<c:when test="${empty list }">
			<tr>
				<td colspan="4">=======작성된 글이 없습니다.=======</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${list }" var="dto">
				<tr>
					<td>${dto.boardno }</td>
					<td>
						<c:forEach begin="1" end="${dto.titletab }">
							&nbsp;
						</c:forEach>
						${dto.title }
					</td>
					<td>${dto.writer }</td>
					<td>${dto.date }</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	<tr>
		<td colspan="4">
			<input type="button" value="글쓰기" onclick="location.href='answer.do?command=writeform'">
		</td>
	</tr>
</table>
</body>
</html>