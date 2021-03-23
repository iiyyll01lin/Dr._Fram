<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>員工資料處理</title>
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
					class="nav-link">查詢所有員工資料</a></li>
					<li><a href="<%=request.getContextPath()%>/new"
					class="nav-link">新增員工</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="row">
		<div class="container">
			<h3 class="text-center">員工資料處理</h3>
			<hr>
			<form method="post" action="nameSearch">
				<div class="container text-center">
					<label>輸入員工姓名 : </label>
					<input type="text" class="form-control" name="ename" /><p><br>
						<input type="submit" class="btn btn-success" value="確定" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>