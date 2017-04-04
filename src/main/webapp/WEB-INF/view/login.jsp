<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
.button {
	background-color: #668080; /* Green */
	border: none;
	color: white;
	padding: 10px 42px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 20px;
	margin: 4px 2px;
	cursor: pointer;
	font-family: monotype corsiva;
}

.buuton2 {
	background-color: #FFFFFF
} /* Orange*/
</style>

</head>
<body>
<%-- 	<form:form action="validate" method="post" commandName="loginObject">
		<table>
			<tr class="input-group margin-bottom-sm">
				<td><form:label path="name">User Name</form:label></td>
				<td><span class="input-group-addon"><i
						class="fa fa-envelope-o fa-fw" aria-hidden="true"></i></span> <form:input
						path="name" class="form-control"></form:input></td>
			</tr>
			<tr class="input-group">
				<td><form:label path="password">password</form:label></td>
				<td><span class="input-group-addon"><i
						class="fa fa-key fa-fw" aria-hidden="true"></i></span> <form:input
						path="password" class="form-control"></form:input></td>
			</tr>

			<tr>

				<input type="submit" class="button button2" value="login">
				<input type="reset" class="button button2" value="reset">

			</tr>

		</table>
	</form:form> --%>
	<form action="validate" method="post">
		<div class="input-group margin-bottom-sm">
			<span class="input-group-addon"><i
				class="fa fa-envelope-o fa-fw" aria-hidden="true"></i></span> <input
				name="userName" class="form-control" type="text"
				placeholder="UserName">
		</div>
		<div class="input-group">
			<span class="input-group-addon"><i class="fa fa-key fa-fw"
				aria-hidden="true"></i></span> <input name="password" class="form-control"
				type="password" placeholder="Password">
		</div>

		<input type="submit" class="button button2" value="login"> <input
			type="reset" class="button button2" value="reset">

	</form> 

</body>
</html>