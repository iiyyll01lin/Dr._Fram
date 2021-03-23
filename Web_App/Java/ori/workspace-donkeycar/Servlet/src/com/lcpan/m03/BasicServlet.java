package com.lcpan.m03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BasicServlet")
public class BasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//    public BasicServlet() {
//        super();
//    }  ¥i§R°£

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		out.print("Served at: ");
		out.print(request.getContextPath());
		out.print("<br>Hello Mabelle");
//		response.getWriter().append("Served at: ")
//		.append(request.getContextPath())
//		.append("<br>Hello World");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
