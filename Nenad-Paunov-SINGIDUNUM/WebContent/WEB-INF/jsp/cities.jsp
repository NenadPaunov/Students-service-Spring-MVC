<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All cities</title>
</head>
<body>
	<h3>Cities:</h3>
	<c:forEach var="city" items="${cities}">
		<p>
			<c:out value="${city}"></c:out>
		</p>

	</c:forEach>
</body>
</html>