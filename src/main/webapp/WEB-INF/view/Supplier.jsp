<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<h2>
		<center>Manage Supplier</center>
	</h2>
	${message}
	<jsp:include page="CategoryMenu1.jsp"></jsp:include>
	
	<a href="manage_supplier_create" class="btn btn-primary" role="button">Add
		Supplier</a>
		
	
	
	
	



	<hr>

	<table border="2">

		<thead>
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Description</td>				
				<td>Address</td>	
				<td>Action</td>

			</tr>
		</thead>
		<c:forEach var="supplier" items="${supplierList}">
			<tr>
				<td>${supplier.id}</td>
				<td>${supplier.name}</td>
				<td>${supplier.description}</td>
				<td>${supplier.address}</td>

				<td><a
					href="<c:url value="manage_supplier_edit/${supplier.id}"/>">Edit
						<span class="glyphicon glyphicon-edit"></span>
				</a>| <a href="<c:url value="manage_supplier_delete/${supplier.id}"/>">
						<span class="glyphicon glyphicon-trash"></span>delete
				</a></td>

			</tr>
		</c:forEach>

	</table>

	<br>
	<br>
	<%-- ${category.id} &nbsp;&nbsp; ${category.name}&nbsp;&nbsp;
	${category.description}&nbsp;&nbsp; --%>


</body>
</html>