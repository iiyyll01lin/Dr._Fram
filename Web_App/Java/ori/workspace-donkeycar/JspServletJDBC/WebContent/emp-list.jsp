<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.peijie.bean.EmpBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Info</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body style="background-color: #D2E9FF">
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #0072E3">
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list" 
				class="nav-link">Return to All Employees</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Employees</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Employee</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Employee No</th>
						<th>Name</th>
						<th>Hiredate</th>
						<th>Salary</th>
						<th>Department No</th>
						<th>Title</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<% List<EmpBean> emps = (ArrayList<EmpBean>)request.getAttribute("listEmp");
					for(EmpBean emp : emps){ //System.out.println("***"+emp.getEmpno()+"***");%>
						<tr>
							<td><%= emp.getEmpno() %></td>
							<td><%= emp.getEname() %></td>
							<td><%= emp.getHiredate() %></td>
							<td><%= emp.getSalary() %></td>
							<td><%= emp.getDeptno() %></td>
							<td><%= emp.getTitle() %></td>
							<td><a href="edit?empno=<%= emp.getEmpno() %>">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="delete?empno=<%= emp.getEmpno() %>">Delete</a></td>
						</tr>
					<% } %>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>