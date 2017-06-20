<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Products</h1>
	<table>
	 <tr>
		<th><b>Product Name</b></th>
		<th><b>Type</b></th>
		<th><b>Description</b></th>
		<th><b>Price</b></th>
	</tr>
	<c:forEach var="prod" items="${products}">
	<tr>
		<td>${prod.productName}</td>
		<td>${prod.productType}</td>
		<td>${prod.description}</td>
		<td><a href="/admin/products/${prod.id}">Edit</a></td>
		<td><form action="/admin/products/delete/${prod.id}" method="post"><input type="submit" value="Delete"/></form></td>
	</tr>
	</c:forEach>
	</table>	

</body>
</html>