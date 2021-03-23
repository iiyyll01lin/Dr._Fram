package com.peijie.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peijie.bean.EmpBean;
import com.peijie.dao.EmpDAO;
//@WebServlet("/")
@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpDAO empDAO;

	public void init() {
		empDAO = new EmpDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.getServletPath()獲取 Servlet 路徑（Servlet path）
		// request.getContextPath()獲取專案名稱
//		System.out.println(request.getContextPath());
		String action = request.getServletPath(); 
		try {
			switch (action) {
			case "/new":
				//insert form
				showNewForm(request, response);
				break;
			case "/insert":
				//insert action
				insertEmp(request, response);
				break;
			case "/delete":
				deleteEmp(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateEmp(request, response);
				break;
			default:
				// handle list
				listEmp(request, response);
				break;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("emp-form.jsp");
		dispatcher.forward(request, response);
	}

	private void insertEmp(HttpServletRequest request, 
			HttpServletResponse response) 
					throws SQLException, IOException, ServletException {
		boolean updateResult;
		String uResult="Insert成功";
		try {
			int empno =	Integer.parseInt(request.getParameter("empno"));
			String name = request.getParameter("ename");
			String hiredate = request.getParameter("hiredate");
			int salary = Integer.parseInt(request.getParameter("salary"));
			int deptno = Integer.parseInt(request.getParameter("deptno"));
			String title = request.getParameter("title");
			EmpBean newEmp = new EmpBean(empno, name, hiredate, salary, deptno, title);
			updateResult=empDAO.insertEmp(newEmp);
		}catch(Exception e) {
			uResult="Insert失敗";
		}finally {
			request.setAttribute("uResult", uResult);
			request.getRequestDispatcher("EmpInsertUpdateDelete.jsp").forward(request, response);;
		}
//		response.sendRedirect("list");
	}

	private void deleteEmp(HttpServletRequest request, 
			HttpServletResponse response) 
					throws SQLException, IOException, ServletException {
		boolean deleteResult;
		String uResult="Delete成功";
		try {
			int empno = Integer.parseInt(request.getParameter("empno"));
			deleteResult=empDAO.deleteEmp(empno);
		}catch(Exception e) {
			uResult="Delete失敗";
		}finally {
			request.setAttribute("uResult", uResult);
			request.getRequestDispatcher("EmpInsertUpdateDelete.jsp").forward(request, response);;
		}
//		response.sendRedirect("list");
	}

	private void showEditForm(HttpServletRequest request, 
			HttpServletResponse response)
			throws SQLException, ServletException, IOException {
//		System.out.println(request.getParameter("empno"));
		int empno = Integer.parseInt(request.getParameter("empno"));
		
		EmpBean existingEmp = empDAO.selectEmp(empno);
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("emp-form.jsp");
		request.setAttribute("emp", existingEmp);
		dispatcher.forward(request, response);

	}

	private void updateEmp(HttpServletRequest request, 
			HttpServletResponse response) 
					throws SQLException, IOException, ServletException {
		boolean updateResult;
		String uResult="Update成功";
		try {
			int empno = Integer.parseInt(request.getParameter("empno"));
			String name = request.getParameter("ename");
			String hiredate = request.getParameter("hiredate");
			int salary = Integer.parseInt(request.getParameter("salary"));
			int deptno = Integer.parseInt(request.getParameter("deptno"));
			String title = request.getParameter("title");
			EmpBean emp = new EmpBean(empno, name, hiredate, 
				salary, deptno, title);
			updateResult=empDAO.updateEmp(emp);
//		System.out.println(updateResult);
		}catch(Exception e) {
			uResult="Update失敗";
		}finally {
			request.setAttribute("uResult", uResult);
			request.getRequestDispatcher("EmpInsertUpdateDelete.jsp").forward(request, response);;
		}
		
		
//		
	}

	private void listEmp(HttpServletRequest request, 
			HttpServletResponse response)
			throws SQLException, IOException, ServletException {
//		System.out.println(request.getContextPath());
		List<EmpBean> listEmp = empDAO.selectAllEmps();
		request.setAttribute("listEmp", listEmp); // 保留Data給下面調派code emp-list.jsp用
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("emp-list.jsp");
		dispatcher.forward(request, response);
	}
}
