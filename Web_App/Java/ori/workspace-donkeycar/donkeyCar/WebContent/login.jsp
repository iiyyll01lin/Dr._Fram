<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登入</title>
<link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://bootswatch.com/4/darkly/bootstrap.min.css">
<link href="css/all.css" rel="stylesheet">

</head>
<body class="homepage">
	<div class="container">
		<div class="row mt-5">
			<div class="col-md-6 m-auto">
				<div class="card card-body">
					<h1 class="text-center mb-3">
						<i class="fas fa-sign-in-alt"></i> 登入
					</h1>
					<form action="<%=request.getContextPath()%>/login" method="POST">
						<div class="form-group">
							<label for="email">使用者帳號</label> 
							<input type="email" id="email"
								name="email" class="form-control" placeholder="Enter Email Account" />
						</div>
						<div class="form-group">
							<label for="password">密碼</label> <input type="password"
								id="password" name="password" class="form-control"
								placeholder="Enter Password" />
						</div>
						<button type="submit" class="btn btn-primary btn-block">登入</button>
					</form>
					<p class="lead mt-4">
						還沒有帳號? <a href="registration.jsp">註冊</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>