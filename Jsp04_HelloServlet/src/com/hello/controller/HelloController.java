package com.hello.controller;

import java.io.IOException;

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
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post방식!");
	}
	
	@Override
	public void destroy() {
		System.out.println("servlet 종료!!!");
	}
	
}
