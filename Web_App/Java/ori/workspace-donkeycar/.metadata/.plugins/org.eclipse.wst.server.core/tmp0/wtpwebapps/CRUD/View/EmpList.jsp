<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.peijie.bean.EmpBean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有員工資料</title>
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
				<li><a href="<%=request.getContextPath()%>/index" 
				class="nav-link">回首頁</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
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
					<c:if test="${showFlag==true}">
						<c:forEach var="emp" items="${listEmp}">
							<tr>
							<td><c:out value="${emp.empno}" /></td>
							<td><c:out value="${emp.ename}" /></td>
							<td><c:out value="${emp.hiredate}" /></td>
							<td><c:out value="${emp.salary}" /></td>
							<td><c:out value="${emp.deptno}" /></td>
							<td><c:out value="${emp.title}" /></td>
							<td><a href="edit?empno=<c:out value='${emp.empno}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="delete?empno=<c:out value='${emp.empno}' />">Delete</a></td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${searchFlag==true}">
						<c:forEach var="empE" items="${existingEmps}">
							<tr>
							<td><c:out value="${empE.empno}" /></td>
							<td><c:out value="${empE.ename}" /></td>
							<td><c:out value="${empE.hiredate}" /></td>
							<td><c:out value="${empE.salary}" /></td>
							<td><c:out value="${empE.deptno}" /></td>
							<td><c:out value="${empE.title}" /></td>
							<td><a href="edit?empno=<c:out value='${empE.empno}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="delete?empno=<c:out value='${empE.empno}' />">Delete</a></td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>