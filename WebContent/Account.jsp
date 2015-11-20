<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="phonebook_package.AccountService" %>
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
<title>Account info</title>
</head>
<body>
	
	<% 
 //	String strSession = (String)session.getAttribute("getSession");
	%>

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
<%-- 	        <% if(strSession == null) { %> --%>
	        <c:choose>
	        	<c:when test="${getSession == null}">
		        	<li><a href="http://localhost:27900/PhonebookApp/SignUp.jsp">Sign up</a></li>
		        	<li><a href="http://localhost:27900/PhonebookApp/login.jsp">Log in</a></li>
		        </c:when>
		        <c:otherwise>
<%-- 		        <% } else { %> --%>
		        	<li><a href="#">Account Info</a></li>
	 	        	<li><a href="LogOut">Log Out</a></li>
	 	        	<li>
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
<%-- 	        <% } %> --%>
	        </c:choose>
	      </ul>
	      <ul class="nav">
	      	<c:if test="${getSession != null}">
	      		<li><a id="logged-in-user" href="#"><img id="img-icon" src="img/user_avatar.png" /><c:out value="${getSession}" /></a></li>
	        </c:if>
<%-- 	      	<% if(strSession != null) { %> --%>
<%-- 	        <li><a id="logged-in-user" href="#"><img id="img-icon" src="img/user_avatar.png" /><% out.println(strSession); %></a></li> --%>
<%-- 	        <% } %> --%>
	      </ul>
	    </div>
	  </div>
	</nav>

	<!-- c:forEach tag = Same as: for each arraylist as list or: for(Object arraylist : list) -->
	<c:forEach items="${arraylist}" var="list">
 	<div class="account-container"> 
 		<h3>Account Details: </h3> 
		<div class="account-info"> 
 			<div id="sep-line"></div> 
			<p>User name: <span><c:out value="${list.userName}" /></span></p> 
 			<div id="sep-line"></div> 
 			<p>First name: <span><c:out value="${list.firstName}" /></span></p> 
			<div id="sep-line"></div> 
 			<p>Last name: <span><c:out value="${list.lastName}" /></span></p> 
			<div id="sep-line"></div> 
			<p>Tel. number: <span><c:out value="${list.telNumber}" /></span></p> 
			<div id="sep-line"></div> 
			<p>Email: <span><c:out value="${list.email}" /></span></p> 
			<div id="sep-line"></div> 
			<p>Address: <span><c:out value="${list.address}" /></span></p>
			<div id="sep-line"></div> 
			<p>Birth date: <span><c:out value="${list.birthDate}" /></span></p>
 			<div id="sep-line"></div> 
			<p>Gender: <span><c:out value="${list.gender}" /></span></p>
			<div id="sep-line"></div> 
			<p>Registration date: <span><c:out value="${list.regDate}" /></span></p>
			<div id="sep-line"></div> 
			<c:if test="${getSession == list.userName}">
				 <div id="edit-info"> 
					<form action="EditHandler" method="post"> 
						<input type="submit" class="btn btn-primary" value="Edit Account">
					</form> 
					<form action="DeleteHandler" method="post">
						<input type="submit" class="btn btn-primary" value="Delete Account">
					</form> 
				</div>
			</c:if>
		</div> 
 	</div> 
 	</c:forEach>
	
<%-- 	<%  --%>
<!-- 	AccountService accountService = new AccountService();  -->
<!-- 	accountService.getAccountInfo(strSession); -->
<!-- 	for(AccountService accList : accountService.accountList) { -->
<!-- 	%> -->
<!-- 	<div class="account-container"> -->
<!-- 		<h3>Account Details: </h3> -->
<!-- 		<div class="account-info"> -->
<!-- 			<div id="sep-line"></div> -->
<%-- 			<p>User name: <span><% out.println(accList.getUserName()); %></span></p> --%>
<!-- 			<div id="sep-line"></div> -->
<%-- 			<p>First name: <span><% out.println(accList.getFirstName()); %></span></p> --%>
<!-- 			<div id="sep-line"></div> -->
<%-- 			<p>Last name: <span><% out.println(accList.getLastName()); %></span></p> --%>
<!-- 			<div id="sep-line"></div> -->
<%-- 			<p>Tel. number: <span><% out.println(accList.getTelNumber()); %></span></p> --%>
<!-- 			<div id="sep-line"></div> -->
<%-- 			<p>Email: <span><% out.println(accList.getEmail()); %></span></p> --%>
<!-- 			<div id="sep-line"></div> -->
<%-- 			<p>Address: <span><% out.println(accList.getAddress()); %></span></p> --%>
<!-- 			<div id="sep-line"></div> -->
<%-- 			<p>Birth date: <span><% out.println(accList.getBirthDate()); %></span></p> --%>
<!-- 			<div id="sep-line"></div> -->
<%-- 			<p>Gender: <span><% out.println(accList.getGender()); %></span></p> --%>
<!-- 			<div id="sep-line"></div> -->
<%-- 			<p>Registration date: <span><% out.println(accList.getRegDate()); %></span></p> --%>
<!-- 			<div id="sep-line"></div> -->
<!-- 			<div id="edit-info"> -->
<!-- 				<form action="http://localhost:27900/PhonebookApp/EditAccount.jsp" method="post"> -->
<!-- 					<input type="submit" class="btn btn-primary" value="Edit Account"> -->
<!-- 				</form> -->
<!-- 				<form action="DeleteHandler" method="post"> -->
<!-- 					<input type="submit" class="btn btn-primary" value="Delete Account"> -->
<!-- 				</form> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
<%--  <% } %> --%>
	
</body>
</html>