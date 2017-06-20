<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> Product Detail </h1>
	<form action="/admin/products/${product.id}" method="post">
	<table>
		<tr>
			<td>Product Name:</td>
			<td><input type="text" name="productName" value="${product.productName}"/> </td>
		</tr>
		<tr>
			<td>Product Type:</td>
			<td><select name="productType">
					<option value="BREAKFAST" selected>Breakfast</option>
					<option value="LUNCH">Lunch</option>
					<option value="DINNER">Dinner</option>
				</select></td>
		</tr>
		<tr>
			<td>Description:</td>
			<td><input type="text" name="description" value="${product.description}"/> </td>
		</tr>
		<tr>
			<td>State:</td>
			<td><input type="text" name="price" value="${product.price}"/> </td>
		</tr>
		
	</table>
	
	<input type="submit"/>
	
	</form>
</body>
</html>