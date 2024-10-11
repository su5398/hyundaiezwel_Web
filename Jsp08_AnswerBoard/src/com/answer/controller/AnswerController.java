package com.answer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.answer.dao.AnswerDao;
import com.answer.dto.AnswerDto;

@WebServlet("/answer.do")
public class AnswerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("{"+command+"}");
		
		AnswerDao dao = new AnswerDao();
		
		if(command.equals("list")) {
			List<AnswerDto> list = dao.selectAll();
			request.setAttribute("list", list);
			RequestDispatcher dis = request.getRequestDispatcher("boardlist.jsp");
			dis.forward(request, response);
			
		}else if(command.equals("writeform")) {
			response.sendRedirect("boardwrite.jsp");
		}else if(command.equals("boardwrite")) {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");
			
			AnswerDto dto = new AnswerDto();
			dto.setTitle(title);
			dto.setContent(content);
			dto.setWriter(writer);
			
			int res = dao.insert(dto);
			
			if(res>0) {
				request.setAttribute("msg", "글 작성 성공");
				request.setAttribute("url", "answer.do?command=list");
			}else {
				request.setAttribute("msg", "글 작성 실패");
				request.setAttribute("url", "answer.do?command=writeform");
			}
			
			RequestDispatcher dis = request.getRequestDispatcher("result.jsp");
			dis.forward(request, response);
			
		}else if(command.equals("detail")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			
			AnswerDto dto = dao.selectOne(boardno);
			
			request.setAttribute("dto", dto);
			RequestDispatcher dis = request.getRequestDispatcher("boarddetail.jsp");
			dis.forward(request, response);
		}else if(command.equals("updateform")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			
			AnswerDto dto = dao.selectOne(boardno);
			request.setAttribute("dto", dto);
			RequestDispatcher dis = request.getRequestDispatcher("boardupdate.jsp");
			dis.forward(request, response);
			
		}else if(command.equals("boardupdate")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			AnswerDto dto = new AnswerDto();
			dto.setBoardno(boardno);
			dto.setTitle(title);
			dto.setContent(content);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
