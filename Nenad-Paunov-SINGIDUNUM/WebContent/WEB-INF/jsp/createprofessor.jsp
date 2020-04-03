<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create new professor</title>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body>
<form action="${pageContext.request.contextPath}/docreateprofessor"
		method="post">
		<table class="formtable">
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
					<td><select name="cityId">
						<c:forEach var="tempCity" items="${cities}">

							<option value="${tempCity.cityId} ">${tempCity.cityName}</option>

						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="label">Phone:</td>
				<td class="control"><input name="phone" type="text"></td>
			</tr>
			<tr>
				<td class="label">Re-election date:</td>
				<td class="control"><input name="reelectionDate" type="date"></td>
			</tr>
			<tr>
				<td><select name="titleId">
						<c:forEach var="tempTitle" items="${titles}">

							<option value="${tempTitle.titleId} ">${tempTitle.titleName}</option>

						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td class="control"><input type="submit"
					value="Create new professor"></td>
			</tr>
			
		</table>

	</form>
</body>
</html>