<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="com.login.dto.MyMemberDto" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% MyMemberDto dto = (MyMemberDto)request.getAttribute("dto"); %>
<h1>내 정보 보기</h1>
<table>
	<tr>
		<th>I D</th>
		<td><%=dto.getMyid() %></td>
	</tr>
	<tr>
		<th>P W</th>
		<td><%=dto.getMypw() %></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><%=dto.getMyname() %></td>
	</tr>
	<tr>
		<th>주소</th>
		<td><%=dto.getMyaddr() %></td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td><%=dto.getMyphone() %></td>
	</tr>
	<tr>
		<th>이메일</th>
		<td><%=dto.getMyemail() %></td>
	</tr>
	<tr>
		<th>등급</th>
		<td><%=dto.getMyrole().equals("USER")?"일반회원":"매니저" %></td>
	</tr>
</table>
</body>
</html>