<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
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
	<h1>Register</h1>
   <form action="/register/persons" method="post" class="form-vertical">
		<table class="table">
			<tr>
				<td><label>First Name:</label></td>
				<td><input type="text"  name="firstName"  class="form-control" /></td>
			</tr>
			<tr>
				<td><label>Last Name:</label></td>
				<td><input type="text" name="lastName"  class="form-control"/></td>
			</tr>
			<tr>
				<td><label>Email:</label></td>
				<td><input type="email" name="email"  class="form-control"/></td>
			</tr>
			<tr>
				<td><label>Password:</label></td>
				<td><input type="password" name="password"  class="form-control"/></td>
			</tr>
			<tr>
				<td><label>Phone:</label></td>
				<td><input type="text" name="phone"  class="form-control"/></td>
			</tr>
			<tr>
				<td><label>City:</label></td>
				<td><input type="text"  name="address.city"  class="form-control"/></td>
			</tr>
			<tr>
				<td><label>Country:</label></td>
				<td><input type="text" name="address.country"  class="form-control"/></td>
			</tr>
			<tr>
				<td><label>State:</label></td>
				<td><input type="text" name="address.state"  class="form-control"/></td>
			</tr>
			<tr>
				<td><label>Zipcode:</label></td>
				<td><input type="text"  name="address.zipcode"  class="form-control"/></td>
			</tr>
		</table>
		<input type="hidden" name="enable" value="1"/>
		<input type="submit"  class="btn btn-primary"/>
	</form>
 </div>
 </div>
</body>
</html>