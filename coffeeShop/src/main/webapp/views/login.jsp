<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="${contextPath}/assets/styles.css"/>
</head>
<body>
	<div class="clearfix"></div>
 <div class="container-fluid">
 
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center login-title">Sign In</h1>
            <div class="account-wall">
                <c:url var="loginUrl" value="/login" />
                <form class="form-signin" action="${loginUrl}" method="post">
	                <input type="text" class="form-control" placeholder="Username" id="username" name="username" required autofocus>
	                <input type="password" class="form-control" placeholder="Password" id="password" name="password" required>
	                <button class="btn btn-lg btn-primary btn-block" type="submit">
	                    Sign in</button>
	                <label class="checkbox pull-left">
	                    <input type="checkbox" value="remember-me">
	                    Remember me
	                </label>
	                <a href="#" class="pull-right need-help">Need help? </a><span class="clearfix"></span>
	                <c:if test="${param.error != null}">
						<p class="alert alert-danger">
							Invalid user-name and password!
						</p>
					</c:if>
                </form>
            </div>
            <br/>
            <br/>
            <br/>
          <form action="/register" method="get" class="text-center"><input type="submit" value="Create an account" class="btn-lg btn-primary btn-block"/></form>
            
        </div>

	</div>
	</div>
  
</body>
</html>