<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create new player</title>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<form action="${pageContext.request.contextPath}/docreatestudent"
		method="post">
		<table class="formtable">
			<tr>
				<td class="label">Index number:</td>
				<td class="control"><input name="indexNumber" type="text"></td>
			</tr>
			<tr>
				<td class="label">First name:</td>
				<td class="control"><input name="firstName" type="text"></td>
			</tr>
			<tr>
				<td class="label">Last name:</td>
				<td class="control"><input name="lastName" type="text"></td>
			</tr>
			<tr>
				<td class="label">Email:</td>
				<td class="control"><input name="email" type="email"></td>
			</tr>
			<tr>
				<td class="label">Address:</td>
				<td class="control"><input name="address" type="text"></td>
			</tr>
			<tr>
				<td class="label">Phone:</td>
				<td class="control"><input name="phone" type="text"></td>
			</tr>
			<tr>
				<td class="label">Current year of study:</td>
				<td class="control"><input name="currentYearOfStudy"
					type="number"></td>
			</tr>
			<tr>
				<form:select path="category">
					<form:option value="NONE"> --SELECT--</form:option>
					<form:options items="${cities}"></form:options>
				</form:select>
				<!-- 	<td><select name="cityName" size="4">
						<c:forEach var="tempCity" items="${cities}">

							<option value="${tempCity.cityName}">${tempCity.cityName}</option>

						</c:forEach>
				</select></td> -->
			</tr>
			<tr>
				<td class="label"></td>
				<td class="control"><input type="submit"
					value="Create new student"></td>
			</tr>
		</table>

	</form>

</body>
</html>