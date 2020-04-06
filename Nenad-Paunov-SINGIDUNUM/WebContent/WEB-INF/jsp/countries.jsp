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
<title>Countries</title>
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
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<script type="text/javascript">
	function confirmDelete(x) {
	      var r = confirm("Are you sure about deleting this country?");
	      if (r == true) {
	          window.location.pathname = "${pageContext.request.contextPath}/dodeletecountry/"+x;
	      }	   
	    }
</script>
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
									<b> Countries details</b>
								</h2>
							</div>
							<div class="col-sm-4">
								<a href="${pageContext.request.contextPath }/create_country"
									target="_self"><button type="button"
										class="btn btn-info add-new">
										<i class="fa fa-plus"></i> Add New
									</button> </a>
							</div>
						</div>
					</div>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Name</th>
								<th>See all details</th>
								<th>Edit</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<c:forEach var="tempCountry" items="${countries}">
									<tr>
										<td>${tempCountry.name}</td>
										<td><a
											href="${pageContext.request.contextPath }/country_details/${tempCountry.countryId}"
											target="_self" class="fullscreen" title="See all details"
											data-toggle="tooltip"><i class="material-icons">&#xE03B;</i></a>
										</td>
										<td><a
											href="${pageContext.request.contextPath}/doupdatecountry/${tempCountry.countryId}"
											class="edit" title="Edit" data-toggle="tooltip"><i
												class="material-icons">&#xE254;</i></a></td>
										<td><a class="
									delete" title="Delete"
											data-toggle="tooltip"
											onclick="confirmDelete(${tempCountry.countryId})"><i
												class="material-icons">&#xE872;</i></a></td>
									</tr>
								</c:forEach>

							</tr>

						</tbody>
					</table>
					<form>
						<input class="form-control" type="text" id="num" value="${num}">
						<button style="background-color: red" class="btn btn-success"
							type="submit">submit</button>
					</form>
					<c:forEach var="i" begin="1" end="${pages }" step="1">
						<a href="${pageContext.request.contextPath}/countries/${i}/${num}">${i}</a>
					</c:forEach>
				</div>
			</div>

		</div>
		<footer id="footer">
			<p id="parag">Copyright @ NenadPaunov</p>
		</footer>

	</section>
	<script>
	   window
       .addEventListener(
               'load',
               function() {
                   document
                           .getElementById("num")
                           .addEventListener(
                                   "change",
                                   function(e) {
                                       window.location.href = "${pageContext.request.contextPath}/countries/1/"
                                               + document
                                                       .getElementById("num").value;
                                   });
               });</script>
</body>
</html>