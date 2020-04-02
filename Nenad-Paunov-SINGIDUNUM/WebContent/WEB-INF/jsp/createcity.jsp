<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create city</title>
</head>
<body>
<body>
	<form action="${pageContext.request.contextPath}/docreatecity"
		method="post">
		<table class="formtable">
			<tr>
				<td class="label">City name:</td>
				<td class="control"><input name="cityName" type="text"></td>
			</tr>
			<tr>
				<td class="label">Zip code:</td>
				<td class="control"><input name="zipCode" type="text"></td>
			</tr>
			<tr>
				<td><select name="countryId">
						<c:forEach var="tempCountry" items="${countries}">

							<option value="${tempCountry.countryId} ">${tempCountry.name}</option>

						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td class="control"><input type="submit"
					value="Create new city"></td>
			</tr>
		</table>

	</form>
</body>


</html>