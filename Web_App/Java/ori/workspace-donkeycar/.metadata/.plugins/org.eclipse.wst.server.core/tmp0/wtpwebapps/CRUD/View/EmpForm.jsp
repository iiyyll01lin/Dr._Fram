<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<fieldset class="form-group">
						<input type="hidden" name="empno"
						value="<c:out value='${empno}' />" class="form-control" />
					</fieldset>
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
						value="<c:out value='${emp.ename}' />" <c:if test="${editFlag!=true}">disabled</c:if> class="form-control"
						name="ename" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Employee Hiredate</label> <input type="text"
						value="<c:out value='${emp.hiredate}' />" <c:if test="${editFlag!=true}">disabled</c:if> class="form-control"
						name="hiredate">
				</fieldset>

				<fieldset class="form-group">
					<label>Employee Salary</label> <input type="text" 
					<c:if test="${editFlag!=true}">disabled</c:if> 
					<c:if test="${emp.salary!=0}">value="<c:out value='${emp.salary}' />"</c:if>
					<c:if test="${emp.salary==0}">value="<c:out value='${salary}' />"</c:if>
					 class="form-control"
						name="salary">
				</fieldset>

				<fieldset class="form-group">
					<label>Employee Department</label> <input type="text"
						<c:if test="${emp.deptno!=0}">value="<c:out value='${emp.deptno}' />"</c:if>
						<c:if test="${emp.deptno==0}">value="<c:out value='${deptno}' />"</c:if>
						<c:if test="${editFlag!=true}">disabled</c:if> 
						class="form-control"
						name="deptno">
				</fieldset>

				<fieldset class="form-group">
					<label>Employee Title</label> <input type="text"
						value="<c:out value='${emp.title}' />"
						<c:if test="${editFlag!=true}">disabled</c:if> class="form-control"
						name="title">
				</fieldset>
				
				<c:if test="${emp != null && editFlag!=true}">
					<fieldset class="form-group">
					<label>Employee Update Result</label> <input type="text"
						value="<c:out value='${uResult}' />" class="form-control"
						name="uResult" disabled style="background-color:	#FFB5B5">
					</fieldset>
				</c:if>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>