<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> User
					Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Employees</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${emp != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${emp == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${emp != null}">
                                    Edit Employee
                                </c:if>
						<c:if test="${emp == null}">
                                    Add New Employee
                                </c:if>
					</h2>
				</caption>
				<c:if test="${emp != null}">
					<input type="hidden" name="empno"
						value="<c:out value='${emp.empno}' />" />
				</c:if>
				<c:if test="${emp == null}">
					<fieldset class="form-group">
						<label>Employee No</label> <input type="text"
							value="<c:out value='${emp.empno}' />" class="form-control"
							name="empno" required="required">
					</fieldset>
				</c:if>
				<fieldset class="form-group">
					<label>Employee Name</label> <input type="text"
						value="<c:out value='${emp.ename}' />" class="form-control"
						name="ename" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Employee Hiredate</label> <input type="text"
						value="<c:out value='${emp.hiredate}' />" class="form-control"
						name="hiredate">
				</fieldset>

				<fieldset class="form-group">
					<label>Employee Salary</label> <input type="text"
						value="<c:out value='${emp.salary}' />" class="form-control"
						name="salary">
				</fieldset>

				<fieldset class="form-group">
					<label>Employee Department</label> <input type="text"
						value="<c:out value='${emp.deptno}' />" class="form-control"
						name="deptno">
				</fieldset>

				<fieldset class="form-group">
					<label>Employee Title</label> <input type="text"
						value="<c:out value='${emp.title}' />" class="form-control"
						name="title">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>