<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="com.my.model.dto.MyBoard" %>
<%@ page import="com.my.model.dao.MyBoardDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int myno = Integer.parseInt(request.getParameter("myno"));

	MyBoardDao dao = new MyBoardDao();
	int res = dao.delete(myno);
	
%>
</body>
</html>