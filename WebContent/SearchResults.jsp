<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Contacts</title>
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
	        <li><a href="http://localhost:27900/PhonebookApp/ContactsHandler">Contacts</a></li>
	        <c:choose>
	        	<c:when test="${getSession == null}">
			        <li><a href="http://localhost:27900/PhonebookApp/SignUp.jsp">Sign up</a></li>
			        <li><a href="http://localhost:27900/PhonebookApp/login.jsp">Log in</a></li>
			    </c:when>
			    <c:otherwise>    
		 	        <li><a href="http://localhost:27900/PhonebookApp/AccountHandler">Account Info</a></li>
		 	    	<li><a href="LogOut">Log Out</a></li>
		 	    	<li>
						<!-- Bootstrap Search form -->
						<form action="SearchHandler" method="get">
							<div class="row" style="margin-left: 300px; margin-top: 7px;">
						    	<div class="col-lg-6">
						        	<div class="input-group" style="width: 300px;">
						      			<input style="background-color: #444444;" type="text" name="query" class="form-control" placeholder="Search for...">
						      			<span class="input-group-btn">
						        			<button class="btn btn-default" type="button"><img src="img/search-icon.png" /></button>
						      			</span>
						    		</div><!-- /input-group -->
						   		</div><!-- /.col-lg-6 -->
						    </div><!-- /.row -->
					    </form>
				    </li>
	        	</c:otherwise>
	        </c:choose>
	      </ul>
	      <ul class="nav">
	      	<c:if test="${getSession != null}">
				<li><a id="logged-in-user" href="#"><img id="img-icon" src="img/user_avatar.png" /><c:out value="${getSession}" /></a></li>
	        </c:if>
	      </ul>
	    </div>
	  </div>
	</nav>
	
	<div class="container">
		<h3>Results found: <c:out value="${arraylist.size()}" /></h3>
		<table class="table table-striped">
			<thead>
				<tr>
			        <th>User name</th>
			        <th>First name</th>
			        <th>Last name</th>
			        <th>Tel. number</th>
			        <th>Email</th>
			        <th>Address</th>
			        <th>Birth date</th>
			        <th>Gender</th>
			        <th>Registration date</th>
				</tr>
			</thead>
			<tbody>
		    	<c:choose>
			    	<c:when test="${arraylist.size() != 0}">
				    	<c:forEach items="${arraylist}" var="list">
							<tr>
								<td><c:out value="${list.userName}" /></td>
								<c:choose>
									<c:when test="${query.equalsIgnoreCase(list.firstName)}">
									<!-- Hightlight the first name of the matching query -->
									<td><p style="background-color: #fdff61; line-height: 13px; display: inline-block;"><c:out value="${list.firstName}" /></p></td>
								</c:when>
								<c:otherwise>
									<td><c:out value="${list.firstName}" /></td>
								</c:otherwise>
								</c:choose>  
								<td><c:out value="${list.lastName}" /></td>
								<td><c:out value="${list.telNumber}" /></td>
								<td><c:out value="${list.email}" /></td>
							    <td><c:out value="${list.address}" /></td>
								<td><c:out value="${list.birthDate}" /></td>
								<td><c:out value="${list.gender}" /></td>
								<td><c:out value="${list.regDate}" /></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
		    			<p>No results found...</p>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
    </div>
    
</body>
</html>