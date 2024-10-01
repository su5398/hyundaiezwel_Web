<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
   
<%@ page import="com.login.dao.MyMemberDao" %>
<%@ page import="com.login.dto.MyMemberDto" %>
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String command = request.getParameter("command");
	System.out.println("[command: "+command+"]");
	
	MyMemberDao dao = new MyMemberDao();
	
	if(command.equals("login")){
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MyMemberDto dto = dao.login(id,pw);
		
		if(dto.getMyid() != null){
			//session
			session.setAttribute("dto",dto);
			//default:30분
			session.setMaxInactiveInterval(60*60);
			/*
			page 영역 : 하나의 jsp 페이지 내에서만 객체를 공유하는 영역.
						pageContext객체 -> 해당 jsp페이지 내에서만 유효.
						
			request 영역 : 응답하는 페이지까지 유효한 영역.
							setAttribute로 저장하고 getAttribute로 받고.
							forward
			session 영역 : 하나의 브라우저당 1개의 session 객체.
							같은 브라우저 내에서 요청되는 페이즈들은 같은 객체를 공유.
							
			application 영역 : 어플리케이션 당 1개의 application 객체가 생성.
			*/
			
			if(dto.getMyrole().equals("ADMIN")){
				response.sendRedirect("adminmain.jsp");
			}else if(dto.getMyrole().equals("USER")){
				response.sendRedirect("usermain.jsp");
			}
		}else{
			//로그인 실패시
			response.sendRedirect("logRes.jsp");	
		}
	}else if(command.equals("logout")){
		//로그아웃
		//session에 담아둔 정보 삭제
		session.invalidate();
		response.sendRedirect("index.jsp");
	}else if(command.equals("userlistall")){
		//전체 유저 정보 조회
		List<MyMemberDto> list = dao.selectAll();
	}
		
%>
</body>
</html>