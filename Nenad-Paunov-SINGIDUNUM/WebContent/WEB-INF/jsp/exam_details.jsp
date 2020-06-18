<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	type="text/css" rel="stylesheet">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Exam details</title>
<base href="${pageContext.request.contextPath}/static/images/"
	target="_blank">
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
					<input type="submit" value="Log out" />
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
			<div class="container">
				<div class="table-wrapper">
					<div class="table-title">
						<div class="row">
							<div class="col-sm-8">
								<h2>
									<b>Exam details</b>
								</h2>
							</div>

						</div>
					</div>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Exam`s subject</th>
								<th>Exam date</th>
								<th>ESPB</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${exam.examName}</td>
								<td>${exam.examDate}</td>
								<td>${exam.espb}</td>
							</tr>
						</tbody>
					</table>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Subject</th>
								<th>Description</th>
								<th>Year of study</th>
								<th>Semester</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${subject.name}</td>
								<td>${subject.description}</td>
								<td>${subject.yearOfStudy}</td>
								<td>${subject.semester}</td>
							</tr>
						</tbody>
					</table>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Title</th>
								<th>First name</th>
								<th>Last name</th>
								<th>Email</th>
								<th>City</th>
								<th>Phone</th>
								<th>Re-election date</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${professor.title.titleName}</td>
								<td>${professor.firstName}</td>
								<td>${professor.lastName}</td>
								<td>${professor.email}</td>
								<td>${professor.city.cityName}</td>
								<td>${professor.phone}</td>
								<td>${professor.reelectionDate}</td>
							</tr>

						</tbody>
					</table>

					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Index number</th>
								<th>First name</th>
								<th>Last name</th>
								<th>Email</th>
								<th>Address</th>
								<th>City</th>
								<th>Phone</th>
								<th>Current year of study</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<c:forEach var="student" items="${students}">
									<tr>
										<td>${student.indexNumber}</td>
										<td>${student.firstName}</td>
										<td>${student.lastName}</td>
										<td>${student.email}</td>
										<td>${student.address}</td>
										<td>${student.city.cityName}</td>
										<td>${student.phone}</td>
										<td>${student.currentYearOfStudy}</td>
									</tr>

								</c:forEach>
							</tr>

						</tbody>
					</table>
				</div>
			</div>

		</div>
		<footer id="footer">
			<p id="parag">Copyright @ NenadPaunov</p>
		</footer>

	</section>
</body>
</html>