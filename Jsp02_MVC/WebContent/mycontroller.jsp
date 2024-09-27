<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>

<%@page import="com.mvc.dao.MVCBoardDao" %>
<%@page import="com.mvc.dto.MVCBoardDto" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//view에서 요청한 내용을 담은 파라미터
	String command = request.getParameter("command");

	System.out.println("[command: "+command+"]");
	MVCBoardDao dao = new MVCBoardDao();
	
	if(command.equals("boardlist")){
		List<MVCBoardDto> list = dao.selectAll();
		
		request.setAttribute("allList", list);
		
		pageContext.forward("boardlist.jsp");
		//페이지 이동
		/*
			1. forward()
			request에 담긴 값이 유효(유지)
			req,res객체가 유지.
			: pageContext.forward(), <jsp:forward>, requestDispatcher
			
			2. redirect
			새로운 페이지 요청한 것과 같은 방식으로 이동.
			req,res객체가 유지되지 않는다.
			: response.sendRedirect()
		
		*/
	}
%>
</body>
</html>