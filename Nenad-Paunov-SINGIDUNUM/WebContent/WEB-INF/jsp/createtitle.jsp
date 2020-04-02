<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/docreatetitle"
		method="post">
		<table class="formtable">
			<tr>
				<td class="label">Title name:</td>
				<td class="control"><input name="titleName" type="text"></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td class="control"><input type="submit"
					value="Create new title"></td>
			</tr>
		</table>

	</form>
</body>
</html>