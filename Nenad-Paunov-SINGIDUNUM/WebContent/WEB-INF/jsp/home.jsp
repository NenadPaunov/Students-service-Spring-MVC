<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Home page</p>
	<a href="${pageContext.request.contextPath }/students">Show all Students</a><br> <br> 
	<a href="${pageContext.request.contextPath }/createstudent">Create student</a> <br> <br> 
	<a href="${pageContext.request.contextPath }/cities">Show all Cities</a> <br> <br> 
</body>
</html>