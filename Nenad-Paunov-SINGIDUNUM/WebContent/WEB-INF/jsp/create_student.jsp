<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/css/create.css"
	type="text/css" rel="stylesheet">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Create student</title>
<base href="${pageContext.request.contextPath}/static/images/">
<link href="https://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/student.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	
</script>
<meta name="robots" content="noindex,nofollow" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
</head>
<body>
	<section id="wrapper">
		<header id="header">
			<div class="logoutLblPos" style="float: right">
				<c:url var="logoutUrl" value="/logout" />
				<form align="right" name="form1" action="${logoutUrl}" method="post">
					<label> <input type="submit" value="Log out" /></label>
				</form>
			</div>
			<div id="titlePage">
				<h2>Students service</h2>
			</div>
		</header>
		<div id="nav">
			<div class="dropdown">
				<button class="dropbtn">Home</button>
				<div class="dropdown-content">
					<a href="${pageContext.request.contextPath }/" target="_self">Home</a>
				</div>
			</div>
			<div class="dropdown">
				<button class="dropbtn">Students</button>
				<div class="dropdown-content">
					<a href="${pageContext.request.contextPath }/students"
						target="_self">Show all students</a> <a
						href="${pageContext.request.contextPath }/create_student"
						target="_self">Create student</a>
				</div>
			</div>
			<div class="dropdown">
				<button class="dropbtn">Professors</button>
				<div class="dropdown-content">
					<a href="${pageContext.request.contextPath }/professors"
						target="_self">Show all professors</a> <a
						href="${pageContext.request.contextPath }/create_professor"
						target="_self">Create professor</a>
				</div>
			</div>
			<div class="dropdown">
				<button class="dropbtn">Subjects</button>
				<div class="dropdown-content">
					<a href="${pageContext.request.contextPath }/subjects"
						target="_self">Show all subjects</a> <a
						href="${pageContext.request.contextPath }/create_subject"
						target="_self">Create subject</a>
				</div>
			</div>
			<div class="dropdown">
				<button class="dropbtn">Exams</button>
				<div class="dropdown-content">
					<a href="${pageContext.request.contextPath }/exams" target="_self">Show
						all exams</a> <a
						href="${pageContext.request.contextPath }/create_exam"
						target="_self">Create exam</a> <a
						href="${pageContext.request.contextPath }/exam_registration"
						target="_self">Exam registration</a>
				</div>
			</div>
			<div class="dropdown">
				<button class="dropbtn">Titles</button>
				<div class="dropdown-content">
					<a href="${pageContext.request.contextPath }/titles" target="_self">Show
						all titles</a> <a
						href="${pageContext.request.contextPath }/create_title"
						target="_self">Create title</a>
				</div>
			</div>
			<div class="dropdown">
				<button class="dropbtn">Cities</button>
				<div class="dropdown-content">
					<a href="${pageContext.request.contextPath }/cities" target="_self">Show
						all cities</a> <a
						href="${pageContext.request.contextPath }/create_city"
						target="_self">Create city</a>
				</div>
			</div>
			<div class="dropdown">
				<button class="dropbtn">Countries</button>
				<div class="dropdown-content">
					<a href="${pageContext.request.contextPath }/countries"
						target="_self">Show all countries</a> <a
						href="${pageContext.request.contextPath }/create_country"
						target="_self">Create country</a>
				</div>
			</div>

		</div>
		<div id="main">

			<div id="wrap">
				<!--wrap start-->
				<div id="wrap2">
					<!--wrap2 start-->

					<h2 class="free_account">Create student</h2>

					<form action="${pageContext.request.contextPath }/docreatestudent"
						method="post" id="register_form">

						<p class="validate_msg">Please fix the errors below!</p>

						<p>
							<label for="indexNumber">Index number</label> <input
								name="indexNumber" type="text"
								placeholder="Index number(Required)" minlength="10" maxlength="10" /> <span
								class="val_indexNumber"></span>
						</p>
						<p>
							<label for="fname">First name</label> <input name="firstName"
								type="text" placeholder="First name(Required)" minlength="3"
								maxlength="30" /> <span class="val_fname"></span>
						</p>
						<p>
							<label for="lname">Last Name</label> <input name="lastName"
								type="text" placeholder="Last name(Required)" minlength="3"
								maxlength="30" /> <span class="val_lname"></span>
						</p>
						<p>
							<label for="email">Email</label> <input name="email" type="text"
								placeholder="name@gmail.com(Required)" maxlength="30" /> <span
								class="val_email"></span>
						</p>
						<p>
							<label for="address">Address</label> <input name="address"
								type="text" placeholder="Address(Required)" minlength="3"
								maxlength="50" /> <span class="val_address"></span>
						</p>
						<p>
							<label for="phone">Phone number</label> <input name="phone"
								type="text" placeholder="(XXX)XXX-XXXX(Required)" minlength="6"
								maxlength="15" /> <span class="val_phone"></span>
						</p>
						<p>
							<label for="year">Current year of study</label> <input
								name=currentYearOfStudy type="number"
								placeholder="Current year of study(Required)" min="1" max="7" />
							<span class="val_year"></span>
						</p>
						<p>
							<label for="city">City</label> <select name="cityId">
								<c:forEach var="tempCity" items="${cities}">

									<option value="${tempCity.cityId} ">${tempCity.cityName}</option>

								</c:forEach>
							</select>
						</p>



						<input type="submit" name="submit" value="Create new student">
					</form>

				</div>
				<!--wrap2 end-->
			</div>
			<!--wrap1 end-->

		</div>
		<footer id="footer">
			<p id="parag">Copyright @ NenadPaunov</p>
		</footer>

	</section>
</body>

</html>