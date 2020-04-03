<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create new subject</title>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<form action="${pageContext.request.contextPath}/docreatesubject"
		method="post">
		<table class="formtable">
			<tr>
				<td class="label">Subject name:</td>
				<td class="control"><input name="name" type="text"></td>
			</tr>
			<tr>
				<td class="label">Description:</td>
				<td class="control"><input name="description" type="text"></td>
			</tr>
			<tr>
				<td class="label">Year of study:</td>
				<td class="control"><input name="yearOfStudy" type="number"></td>
			</tr>
			<tr>
				<td><select name="semester">
						<option value="WINTER">WINTER</option>
						<option value="SUMMER">SUMMER</option>

				</select></td>

			</tr>
			<tr>
				<td><select name="id">
						<c:forEach var="tempProfessor" items="${professors}">

							<option value="${tempProfessor.id} ">${tempProfessor.firstName} ${tempProfessor.lastName}</option>

						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td class="label"></td>
				<td class="control"><input type="submit"
					value="Create new subject"></td>
			</tr>

		</table>

	</form>
</body>
</html>