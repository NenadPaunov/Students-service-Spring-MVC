<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	type="text/css" rel="stylesheet">
<meta charset="UTF-8">
<title>Home</title>
<base href="${pageContext.request.contextPath}/static/images/"
	target="_blank">
<link href="https://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
</head>
<body>
	<section id="wrapper">
		<header id="header">

			<div id="titlePage">
				<h2>Students service</h2>
			</div>
		</header>
		<div id="nav">
			<div class="dropdown">
				<button class="dropbtn">Home</button>
				<div class="dropdown-content">
					<a href="${pageContext.request.contextPath }/" target="_self">Home</a>
					<a href="${pageContext.request.contextPath }/test" target="_self">Home</a>
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
						target="_self">Create exam</a>
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

			<img src="service.jpg" alt="hero" title="hero">

		</div>
		<footer id="footer">
			<p id="parag">Copyright @ NenadPaunov</p>
		</footer>

	</section>
</body>
</html>