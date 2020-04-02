<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All countries</title>
</head>
<body>
	<h3>Countries:</h3>
	<c:forEach var="country" items="${countries}">
		<p>
			<c:out value="${country}"></c:out>
		</p>

	</c:forEach>
</body>
</html>