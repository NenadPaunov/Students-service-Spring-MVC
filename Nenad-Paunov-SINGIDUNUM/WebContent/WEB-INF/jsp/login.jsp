<!DOCTYPE html>
<html lang="en">
<head>
<title>Login page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/static/css/login.css"
	type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/css/util.css"
	type="text/css" rel="stylesheet">

</head>
<body onload='document.f.username.focus();'>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form p-l-55 p-r-55 p-t-178"
					name='f' action='${pageContext.request.contextPath}/login'
					method='POST'>
					<span class="login100-form-title"> Sign In </span>

					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter username">
						<input class="input100" type="text" name="username"
							placeholder="Username"> <span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Please enter password">
						<input class="input100" type="password" name="password"
							placeholder="Password"> <span class="focus-input100"></span>
					</div>

					<br> <br> <br>
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">Sign in</button>
					</div>
					<br> <br>

				</form>
			</div>
		</div>
	</div>

</body>
</html>