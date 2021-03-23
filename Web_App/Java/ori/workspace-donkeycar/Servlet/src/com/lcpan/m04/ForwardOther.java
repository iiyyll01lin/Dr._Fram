package com.lcpan.m04;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ForwardOther")
public class ForwardOther extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println(request.getServletPath());
		response.getWriter().append("Other task is done<br>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		 throws ServletException, IOException {
		 doGet(request, response);
	}
}
