package com.peijie.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peijie.DAO.userDAO;
import com.peijie.bean.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private userDAO userDAO;   

	public void init() {
		userDAO = new userDAO();
    }   
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String userAccount = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println(userAccount);
        System.out.println(password);
      //make user object
        User userModel = new User(userAccount, password);
        System.out.println(userModel);
        try {
        	User listUser = userDAO.validate(userModel);
        	request.setAttribute("user", listUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = 
				request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
