package com.peijie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.peijie.bean.EmpBean;

/*	This is a Data Access Layer (DAO) class that provides CRUD 
	(Create, Read, Update, Delete) operations for the table users 
	in a database.	也就是所謂存取DB*/
public class EmpDAO {
//	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//	private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
//	private static final String USER = "root";
//	private static final String PASSWORD = "j98619861";
	private static final String INSERT_EMP_SQL = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?);";
	private static final String SELECT_EMP_BYNO_SQL = "SELECT * FROM employee WHERE empno=?;";
	private static final String SELECT_ALLEMP_SQL = "SELECT * FROM employee;";
	private static final String DELETE_EMP_SQL = "DELETE FROM employee WHERE empno=?;";
	private static final String UPDATE_EMP_SQL = "UPDATE employee SET ename=?, hiredate=?, "
			+ "salary=?, deptno=?, title=? WHERE empno=?;";

	protected Connection getConnection() {
		Connection conn = null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			conn = ds.getConnection();
//			Class.forName(JDBC_DRIVER);
//			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	// Create Emp or Insert Emp
	public boolean insertEmp(EmpBean emp) throws SQLException {
//        System.out.println(INSERT_EMP_SQL);
		boolean rowInserted=false;
		// try-with-resource statement
		// will auto close the connection.
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(INSERT_EMP_SQL)) {
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getHiredate());
			pstmt.setInt(4, emp.getSalary());
			pstmt.setInt(5, emp.getDeptno());
			pstmt.setString(6, emp.getTitle());
//            System.out.println(pstmt);
			rowInserted = pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowInserted;
	}

	// Update Emp
	public boolean updateEmp(EmpBean emp) throws SQLException {
		boolean rowUpdated;
		try (Connection conn = getConnection(); 
				PreparedStatement pstmt = 
						conn.prepareStatement(UPDATE_EMP_SQL)) {
//			System.out.println("*******************");

			pstmt.setString(1, emp.getEname());
			pstmt.setString(2, emp.getHiredate());
			pstmt.setInt(3, emp.getSalary());
			pstmt.setInt(4, emp.getDeptno());
			pstmt.setString(5, emp.getTitle());
			pstmt.setInt(6, emp.getEmpno());
//			System.out.println(pstmt.executeUpdate());
			rowUpdated = pstmt.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	// Select Emp by empno
	public EmpBean selectEmp(int empno) {
		EmpBean emp = null;
		// Step 1: Establishing a Connection
		try (Connection conn = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement pstmt = conn.prepareStatement(SELECT_EMP_BYNO_SQL);) {
			pstmt.setInt(1, empno);
//            System.out.println(pstmt);
			// Step 3: Execute the query or update query
			ResultSet rs = pstmt.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("ename");
				String hiredate = rs.getString("hiredate");
				int salary = rs.getInt("salary");
				int deptno = rs.getInt("deptno");
				String title = rs.getString("title");
				emp = new EmpBean(empno, name, hiredate, salary, deptno, title);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	// Select Emps
	public List<EmpBean> selectAllEmps() {

		// using try-with-resources to avoid closing resources
		// (boiler plate code)
		List<EmpBean> emps = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection conn = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement pstmt = conn.prepareStatement(SELECT_ALLEMP_SQL);) {
//            System.out.println(pstmt);
			// Step 3: Execute the query or update query
			ResultSet rs = pstmt.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String name = rs.getString("ename");
				String hiredate = rs.getString("hiredate");
				int salary = rs.getInt("salary");
				int deptno = rs.getInt("deptno");
				String title = rs.getString("title");
				emps.add(new EmpBean(empno, name, hiredate, salary, deptno, title));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emps;
	}

	// Delete Emp
	public boolean deleteEmp(int empno) throws SQLException {
		boolean rowDeleted;
		try (Connection conn = getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(DELETE_EMP_SQL);) {
			pstmt.setInt(1, empno);
			rowDeleted = pstmt.executeUpdate() > 0;
		}
		return rowDeleted;
	}

}
