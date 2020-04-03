<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create exam</title>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<form action="${pageContext.request.contextPath}/docreateexam"
		method="post">
		<table class="formtable">
			<tr>
				<td class="Label">Subjects: 
				<select name="id" onchange="showprofessors()">
						<option disabled selected value hidden></option>
						<c:forEach var="tempSubject" items="${subjects}">
							<option value="${tempSubject.subjectId} ">${tempSubject.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="Label">Professors: <select name="id">
						<c:forEach var="tempProfessor" items="${professors}">
							<option value="${tempProfessor.id} ">${tempProfessor.firstName}
								${tempProfessor.lastName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="label">Exams date:</td>
				<td class="control"><input name="name" type="date"></td>
			</tr>
			<tr>
			
	
			<tr>
				<td class="label"></td>
				<td class="control"><input type="submit"
					value="Create new exam"></td>
			</tr>

		</table>

	</form>
</body>

<script>

	function showprofessors(){
		
		console.log("test");
		
	}

</script>

</html>