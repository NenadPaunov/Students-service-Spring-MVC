<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="${pageContext.request.contextPath}/static/css/create.css"
	type="text/css" rel="stylesheet">
<!--<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/script.js"></script>-->
<title>Creating Simple jQuery Validation in Registration Form</title>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	
</script>
<meta name="robots" content="noindex,nofollow" />
</head>

<body>
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
						placeholder="Index number(Required)" /> <span
						class="val_indexNumber"></span>
				</p>
				<p>
					<label for="fname">First name</label> <input name="firstName"
						type="text" placeholder="First name(Required)" /> <span
						class="val_fname"></span>
				</p>
				<p>
					<label for="lname">Last Name</label> <input name="lastName"
						type="text" placeholder="Last name(Required)" /> <span
						class="val_lname"></span>
				</p>
				<p>
					<label for="email">Email</label> <input name="email" type="text"
						placeholder="email@gmail.com(Required)" /> <span
						class="val_email"></span>
				</p>
				<p>
					<label for="address">Address</label> <input name="address"
						type="text" placeholder="Address(Required)" /> <span
						class="val_pass"></span>
				</p>
				<p>
					<label for="phone">Phone number</label> <input name="phone"
						type="text" placeholder="(XXX)XXX-XXXX(Required)" /> <span
						class="val_phone"></span>
				</p>
				<p>
					<label for="year">Current year of study</label> <input
						name=currentYearOfStudy type="text"
						placeholder="Current year of study(Required)" /> <span
						class="val_year"></span>
				</p>
				<p>
					<select name="cityId">
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
	<!--wrap start-->
</body>
<script type="text/javascript">
	jQuery(function($) {
		var validation_holder;

		$("form#register_form input[name='submit']")
				.click(
						function() {

							var validation_holder = 0;

							var indexNumber = $(
									"form#register_form input[name='indexNumber']")
									.val();
							var fname = $(
									"form#register_form input[name='firstName']")
									.val();
							var lname = $(
									"form#register_form input[name='lastName']")
									.val();
							var email = $(
									"form#register_form input[name='email']")
									.val();
							var email_regex = /^[\w%_\-.\d]+@[\w.\-]+.[A-Za-z]{2,6}$/; // reg ex email check	
							var phone = $(
									"form#register_form input[name='phone']")
									.val();
							var phone_regex = /^[0-9]{4,20}$/; // reg ex phone check	
							var year = $(
									"form#register_form input[name='currentYearOfStudy']")
									.val();

							/* validation start */
							if (indexNumber == "") {
								$("span.val_indexNumber").html(
										"This field is required.").addClass(
										'validate');
								validation_holder = 1;
							} else {
								$("span.val_indexNumber").html("");
							}
							if (fname == "") {
								$("span.val_fname").html(
										"This field is required.").addClass(
										'validate');
								validation_holder = 1;
							} else {
								$("span.val_fname").html("");
							}
							if (lname == "") {
								$("span.val_lname").html(
										"This field is required.").addClass(
										'validate');
								validation_holder = 1;
							} else {
								$("span.val_lname").html("");
							}
							if (!email_regex.test(email)) { // if invalid email
								$("span.val_email").html("Invalid Email!")
										.addClass('validate');
								validation_holder = 1;
							} else {
								$("span.val_email").html("");
							}
							if (!phone_regex.test(phone)) { // if invalid phone
								$("span.val_phone").html(
										"Invalid Phone Number!").addClass(
										'validate');
								validation_holder = 1;

							} else {
								$("span.val_phone").html("");
							}
							if (year == "") {
								$("span.val_year").html(
										"This field is required.").addClass(
										'validate');
								validation_holder = 1;
							} else {
								$("span.val_year").html("");
							}
							if (validation_holder == 1) { // if have a field is blank, return false
								$("p.validate_msg").slideDown("fast");
								return false;
							}
							validation_holder = 0; // else return true
							/* validation end */
						}); // click end 

	});
</script>
</html>