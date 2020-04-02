<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show all titles</title>
</head>
<body>
<h3>Titles:</h3>
	<c:forEach var="title" items="${titles}">
		<p>
			<c:out value="${title}"></c:out>
		</p>

	</c:forEach>
</body>
</html>