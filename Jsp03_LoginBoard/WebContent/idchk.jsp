<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String idnotused = request.getParameter("idnotused");
%>

<table>
	<tr>
		<td><input type="text" name="id"></td>
	</tr>
	<tr>
		<td><%=idnotused.equals("true")?"아이디 생성 가능":"아이디 중복" %></td>
	</tr>
	<tr>
		<td>
			<input type="button" value="확인" onclick="">
		</td>
	</tr>
</table>

</body>
</html>