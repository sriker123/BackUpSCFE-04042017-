<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="CategoryMenu1.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddProduct</title>
</head>
<body>
	<jsp:include page="AdminHome.jsp"></jsp:include>
	<c:url value="manage_product_create" var="url"></c:url>

	<form:form method="post" action="${url}" commandName="createProductObj"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td><form:label path="id">Product Id</form:label></td>
				<td><form:input path="id" disabled="true" /> <form:hidden
						path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="name">Product Name</form:label></td>
				<td><form:input path="name"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="price">Product Price</form:label></td>
				<td><form:input path="price"></form:input></td>
			</tr>

			<tr>
				<td><form:label path="description">Product Description</form:label></td>
				<td><form:input path="description"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="supplier">
						<spring:message text="Supplier" />Supplier Name
					</form:label></td>
				<td><form:select path="supplier.name" items="${supplierList}"
						itemValue="name" itemLabel="name" class="form-control" /></td>
			</tr>
			<tr>
				<td><form:label path="category">
						<spring:message text="Category" />Category Name
					</form:label></td>
				<td><form:select path="category.name" items="${categoryList}"
						itemValue="name" itemLabel="name" class="form-control" /></td>
			</tr>

			<tr>
				<td><form:label path="image">
						<spring:message text="image" />Upload Image
					</form:label></td>
				<td><form:input path="image" type="file" /></td>

			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Add Product" class="btn-btn-default"></td>
			</tr>
		</table>
	</form:form>

	<jsp:include page="AboutUs.jsp"></jsp:include>

</body>
</html>