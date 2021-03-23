<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>註冊帳號</title>
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
						<i class="fas fa-cat"></i>註冊帳號
					</h1>
					<form action="<%=request.getContextPath()%>/register" method="post" onsubmit="return validate()">
						<div class="form-group">
							<label for="account1">姓名</label> <input type="text"
								class="form-control" id="account1" placeholder="Username"
								name="name" required><br>
						</div>
						<div class="form-group">
							<label for="accountM">使用者帳號</label> <input type="text"
								id="accountM" class="form-control" placeholder="Useremail"
								name="account" required><br>
						</div>
						<div class="form-group">
							<label for="pwd1">密碼</label> <input type="password" id="pwd1"
								placeholder="Password" class="form-control" name="password"
								required><br>
						</div>
						<div class="form-group">
							<label for="adr1">地址</label> <input type="text" id="adr1"
								placeholder="Address" class="form-control" name="address"
								required><br>
						</div>
						<div class="form-group">
							<label for="tel1">聯絡方式</label> <input type="text" id="tel1"
								placeholder="Contact" class="form-control" name="contact"
								required><br>
						</div>
						<button type="submit" class="btn btn-primary btn-block"
							value="Register">註冊</button>
						<p class="lead mt-4">
							已經有帳號了? <a href="login.jsp">登入</a>
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
		crossorigin="anonymous"></script>
</body>
</html>