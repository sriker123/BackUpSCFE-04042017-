<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>


	<form:form action="register" method="post" commandName="userObject">

		<table>
			<tr>
				<td><form:label path="id">User Id</form:label></td>
				<td><form:input path="id" disabled="false" /> <form:hidden
						path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="name">User  Name</form:label></td>
				<td><form:input path="name"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="password">password</form:label></td>
				<td><form:input path="password" type="post"></form:input></td>
			</tr>

			<tr>
				<td><form:label path="mail">email</form:label></td>
				<td><form:input path="mail"></form:input></td>
			</tr>

			<tr>
				<td><form:label path="contact"> contact</form:label></td>
				<td><form:input path="contact"></form:input></td>
			</tr>

			<tr>
				<td><form:label path="role"> role</form:label></td>
				<td><form:input path="role"></form:input></td>
			</tr>


			<tr>
				<td colspan="2"><input type="submit" class="btn btn-primary"
					value="register"></td>
			</tr>
		</table>


	</form:form>

</body>
</html>