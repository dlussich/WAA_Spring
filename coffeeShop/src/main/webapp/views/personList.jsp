<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Persons List</title>
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
	<h1>Persons List</h1>
	<table class="table table-striped">
	<thead>
	 <tr>
		<th><b>  First Name </b></th>
		<th><b>  Last Name  </b></th>
		<th><b>  Email  </b></th>
		<th><b>  Phone  </b></th>
	 </tr>
	 </thead>
	<c:forEach var="person" items="${persons}">
	<tbody>
	<tr>
		<td>${person.firstName}</td>
		<td>${person.lastName}</td>
		<td>${person.email}</td>
		<td>${person.phone}</td>
	</tr>
	</tbody>
	</c:forEach>
	</table>	
    </div>
 </div>
</body>
</html>