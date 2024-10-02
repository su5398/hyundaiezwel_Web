<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="com.login.dto.MyMemberDto" %>
<%@ page import="java.util.List" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function updateRole(myno){
		location.href="membercontroller.jsp?command=updateroleform&myno="+myno;
	}
</script>
</head>
<body>
<%
	MyMemberDto logindto = (MyMemberDto)session.getAttribute("dto");

	if(logindto==null){
		pageContext.forward("index.jsp");
	}
%>
<% List<MyMemberDto> list = (List<MyMemberDto>)request.getAttribute("list");%>

<h1>회원정보조회</h1>
<div>
	<span><%=logindto.getMyname() %>님 환영합니다.(등급: <%=logindto.getMyrole() %> )</span>
	<button onclick="location.href='membercontroller.jsp?command=logout'">로그아웃</button>
</div>

<table border="1">
	<tr>
		<th>번호</th>
		<th>I D</th>
		<th>P W</th>
		<th>이름</th>
		<th>주소</th>
		<th>전화번호</th>
		<th>이메일</th>
		<th>가입여부</th>
		<th>등급</th>
		<th>등급변경</th>
	</tr>
	
<%
	for(MyMemberDto dto: list){
%>
	<tr>
		<td><%=dto.getMyno() %></td>
		<td><%=dto.getMyid() %></td>
		<td><%=dto.getMypw() %></td>
		<td><%=dto.getMyname() %></td>
		<td><%=dto.getMyaddr() %></td>
		<td><%=dto.getMyphone() %></td>
		<td><%=dto.getMyemail() %></td>
		<td><%=dto.getMyenabled().equals("Y")? "가입":"탈퇴" %></td>
		<td><%=dto.getMyrole() %></td>
		<td><button onclick="updateRole(<%=dto.getMyno()%>);">변경</button></td>
	</tr>
<%
	}
%>
	<tr>
		<td colspan="9" align="right">
			<button onclick="history.back()">뒤로가기</button>
		</td>
	</tr>
</table>
</body>
</html>