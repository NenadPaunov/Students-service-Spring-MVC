<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create country</title>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body>
<form action="${pageContext.request.contextPath}/docreatecountry"
		method="post">
		<table class="formtable">
			<tr>
				<td class="label">Country name:</td>
				<td class="control"><input name="name" type="text"></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td class="control"><input type="submit"
					value="Create new country"></td>
			</tr>
		</table>

	</form>
</body>
</html>