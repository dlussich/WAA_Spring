<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Admin Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
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
        <div id="menu" class="collapse navbar-collapse" id="navbar-collapse-4">
        <ul class="nav navbar-nav navbar-left">
            <li><a href="/admin/products" class="active">Products</a></li>
            <li><a href="/admin/orders">Orders</a></li>
            <li><a href="/admin/persons">Users</a></li>
          </ul>
           <ul class="nav navbar-nav navbar-right">
            <li><a href='<c:url value="/logout"/>' class="active">Logout</a></li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container -->
    </nav><!-- /.navbar -->
    <div class="col-md-8 col-md-offset-2">
    	<h1>All Orders</h1>
		<table class="table table-striped">
		<c:forEach var="order" items="${orders}">
		<tr>
			<td>${order.orderDate}</td>
			<td>${order.person.firstName} ${order.person.lastName}</td>
			<td>${order.orderLines[0].product.productName}</td>
			<td>${order.orderLines[0].product.price}</td>
			<td>${order.orderLines[0].quantity}</td>
			<td>${order.totalAmount}</td>
		</tr>
		</c:forEach>
		</table>
		
    </div>
 </div>
 
</body>
</html>