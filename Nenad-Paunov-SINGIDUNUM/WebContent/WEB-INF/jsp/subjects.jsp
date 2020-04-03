<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All subjects</title>
</head>
<body>
<h3>Subjects:</h3>
	<c:forEach var="subject" items="${subjects}">
		<p>
			<c:out value="${subject}"></c:out>
		</p>

	</c:forEach>
</body>
</html>