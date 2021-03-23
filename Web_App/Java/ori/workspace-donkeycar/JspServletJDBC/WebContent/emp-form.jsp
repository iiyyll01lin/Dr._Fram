<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Edit</title>
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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			<% if(request.getAttribute("emp") != null) {%>
					<form action="update" method="post">
				<% } %>
				<% if(request.getAttribute("emp") == null) {%>
					<form action="insert" method="post">
				<% } %>

				<caption>
					<h2>
						<% if(request.getAttribute("emp") != null) {%>
                                    Edit Employee
                        <% } %>
						<% if(request.getAttribute("emp") == null) {%>
                                    Add New Employee
                        <% } %>
					</h2>
				</caption>
				<% if(request.getAttribute("emp") != null) {%>
					<input type="hidden" name="empno"
						value="${emp.empno}" />
				<% } %>
				<% if(request.getAttribute("emp") == null) {%>
					<fieldset class="form-group">
						<label>Employee No</label> <input type="text"
							value="${emp.empno}" class="form-control"
							name="empno" required="required">
					</fieldset>
				<% } %>
				<fieldset class="form-group">
					<label>Employee Name</label> <input type="text"
						value="${emp.ename}" class="form-control"
						name="ename" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Employee Hiredate</label> <input type="text"
						value="${emp.hiredate}" class="form-control"
						name="hiredate">
				</fieldset>

				<fieldset class="form-group">
					<label>Employee Salary</label> <input type="text"
						value="${emp.salary}" class="form-control"
						name="salary">
				</fieldset>

				<fieldset class="form-group">
					<label>Employee Department</label> <input type="text"
						value="${emp.deptno}" class="form-control"
						name="deptno">
				</fieldset>

				<fieldset class="form-group">
					<label>Employee Title</label> <input type="text"
						value="${emp.title}" class="form-control"
						name="title">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>