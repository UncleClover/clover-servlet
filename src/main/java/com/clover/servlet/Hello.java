package com.clover.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String message;

	public void init() throws ServletException {
		message = "Fuck the world!";
		System.out.println("初始化servlet……");
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置刷新自动加载时间为 5 秒
		response.setIntHeader("Refresh", 1);
		// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");

		// 实际的逻辑是在这里
		PrintWriter out = response.getWriter();
		out.println("<h1>" + message + "</h1>");

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		out.println("<h1>" + sdf.format(date) + "</h1>");

		destroy();
	}

	public void destroy() {
		System.out.println("销毁servlet……");
	}
}
