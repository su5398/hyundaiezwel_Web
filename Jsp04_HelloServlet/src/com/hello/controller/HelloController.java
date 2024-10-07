package com.hello.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController extends HttpServlet {
	
	public HelloController() {
		System.out.println("servlet 생성자!");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//서블릿 객체 생성시 초기화
		//config: 서블릿이 초기화 되는 동안 참조할 정보를 전달해주는 역할
		System.out.println("context param: " + config.getServletContext().getInitParameter("url"));
		
		System.out.println("init param: " + config.getInitParameter("driver"));
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get방식!");
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post방식!");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("parameter: " + command);
		
		PrintWriter out = response.getWriter();
		out.print("<h1 style='background-color:skyblue;'>helloServlet</h1>");
		out.print("<h2>servlet 라이프사이클, url mapping, command"+command+"</h2>");
		out.print("<a href='home.html'>돌아가기</a>");
	}
	
	@Override
	public void destroy() {
		System.out.println("servlet 종료!!!");
	}
	
}
