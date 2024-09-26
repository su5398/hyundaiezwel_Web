<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.my.model.dao.MyBoardDao" %>
<%@ page import="com.my.model.dto.MyBoard" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	MyBoardDao dao = new MyBoardDao();
	List<MyBoard> list = dao.selectAll();
%>
<h1>LIST PAGE</h1>

</body>
</html>