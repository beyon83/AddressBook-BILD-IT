<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="phonebook_package.LoginService" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/login-styles.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link href='http://fonts.googleapis.com/css?family=Oswald:300&subset=latin-ext' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Slabo+27px' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
<title>Login Page</title>
</head>
<body>

	<!-- Bootstrap navigation bar  -->
	<nav class="navbar navbar-inverse" style="border-radius: 0px;">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" style="color: #e3e3e3;" href="#">Phonebook Application</a>
	    </div>
	    <div>
	      <ul class="nav navbar-nav">
	        <!-- inside li: class="active" -->
	        <li><a href="http://localhost:27900/PhonebookApp/Contacts.jsp">Contacts</a></li>
<%-- 	        <% if(session.getAttribute("getSession") == null) { %> --%>
	        <c:choose>
	        	<c:when test="${getSession == null}">
	        		<li><a href="http://localhost:27900/PhonebookApp/SignUp.jsp">Sign up</a></li>
	        		<li><a href="#">Log in</a></li>
	        	</c:when>
<%-- 	        <% } else { %> --%>
	        	<c:otherwise>
	        		<li><a href="#">Log Out</a></li>
<%-- 	        <% } %> --%>
	        	</c:otherwise>
	        </c:choose>
	      </ul>
	      <ul class="nav navbar-nav">
	      <c:if test="${getSession != null}">
<%-- 	      	<% if(session.getAttribute("getSession") != null) { %> --%>
<%-- 	        	<% String sessionName = (String)session.getAttribute("getSession"); %> --%>
			<c:out value="${getSession}" />			
<%-- 	        <li><a id="logged-in-user" href="#"><img src="img/user_avatar.png" /><% out.println(sessionName); %></a></li> --%>
			<li><a id="logged-in-user" href="#"><img src="img/user_avatar.png" /><c:out value="${getSession}" /></a></li>
	      </c:if>  
<%-- 	        <% } %> --%>
	      </ul>
	    </div>
	  </div>
	</nav>

	<div class="form-container clearfix">
		<form action="LoginHandler" method="post">
			<h4>Enter Your User Name and Your Password</h4>
		    <div class="form-group">
		<!--    <label for="userName">User name: </label> -->
				<input type="text" name="userName" id="userName" class="form-control" placeholder="User name:" />
			</div>
			<div id="separation-line"></div>
			<div class="form-group">
		<!--  	<label for="pass">Password: </label> -->
				<input type="password" name="password" id="pass" class="form-control" placeholder="Password:" />
			</div>
			<div class="error-message" style="color: #FF4747; margin-bottom: 10px; margin-left: 10px;">
				${ LoginService.getError().equals("Wrong username/password") ? "" : errorMessage } 
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-info btn-block" class="form-control"> Login </button>
			</div>
		</form>
	</div>

</body>
</html>