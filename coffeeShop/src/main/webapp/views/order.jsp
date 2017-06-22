<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="${contextPath}/assets/styles.css"/>
</head>
<body>
  <div class="clearfix"></div>
 <div class="container-fluid">
 <!-- Second navbar for profile settings -->
    <nav id="menu" class="navbar navbar-inverse">
      <div class="container">    
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbar-collapse-4">
          <ul class="nav navbar-nav navbar-left">
          <sec:authorize access="hasRole('ROLE_ADMIN')">
            <li><a href="/admin/products" class="active">Products</a></li>
            <li><a href="/admin/orders">Orders</a></li>
            <li><a href="/admin/persons">Users</a></li>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_USER')">
          			<li><a href="/user/order">Order</a></li>
           </sec:authorize>
          </ul>
           <ul class="nav navbar-nav navbar-right">
            <li><a href='<c:url value="/logout"/>' class="active">Logout</a></li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container -->
    </nav><!-- /.navbar -->
    <div class="col-md-8 col-md-offset-2">
	<h1>Products</h1>
	<table class="table table-striped">
	 <tr>
		<th><b>Product Name</b></th>
		<th><b>Type</b></th>
		<th><b>Description</b></th>
		<th><b>Price</b></th>
		<th><b>Actions</b></th>
		<th></th>
	</tr>
	<c:forEach var="prod" items="${products}">
	<tr>
		<td>${prod.productName}</td>
		<td>${prod.productType}</td>
		<td>${prod.description}</td>
		<td>${prod.price}</td>
		<td><form action="/user/orderline" method="post"><input type="hidden" name="productId" value="${prod.id}"/>
		<label>Quantity:</label><input type="text" name="quantity" class="form-control"/>
		<input type="submit" value="Add to Order" class="btn btn-primary"/></form></td>
		
	</tr>
	</c:forEach>
	</table>	
    </div>
     <div class="col-md-8 col-md-offset-2">
    	<h1>Order Detail</h1>
	<table class="table table-striped">
	 <tr>
		<th><b>Product Name</b></th>
		<th><b>User</b></th>
		<th><b>Quantity</b></th>
	</tr>
	<c:forEach var="ol" items="${orderlines}">
	<tr>
		<td>${ol.product.productName}</td>
		<td>${user.firstName}  ${user.lastName}</td>
		<td>${ol.quantity}</td>
	</tr>
	</c:forEach>
	</table>
    </div>
    <div class="col-md-8 col-md-offset-2">
    <form action="/user/order" method="post" class="text-center"><input type="submit" value="Create Order" class="btn-lg btn-primary btn-block"/></form>
    </div>
 </div>
 
   
</body>
</html>