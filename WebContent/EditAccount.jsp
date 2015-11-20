<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="phonebook_package.AccountService" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/signup-styles.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link href='http://fonts.googleapis.com/css?family=Oswald:300&subset=latin-ext' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Slabo+27px' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
<title>Edit Account</title>
</head>
<body>

<%-- 	<% --%>
<!--  	String strSession = (String)session.getAttribute("getSession"); -->
<!-- 	%> -->

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
	        <li><a href="http://localhost:27900/PhonebookApp/Account.jsp">Account Info</a></li>
	        <li><a href="LogOut">Log Out</a></li>
	      </ul>
	      <ul class="nav">
<%-- 	      	<% if(getSession != null) { %> --%>
<%-- 	        <li><a id="logged-in-user" href="#"><img id="img-icon" src="img/user_avatar.png" /><% out.println(strSession); %></a></li> --%>
<%-- 	        <% } %> --%>
				<li><a id="logged-in-user" href="#"><img id="img-icon" src="img/user_avatar.png" /><c:out value="${getSession}" /></a></li>
	      </ul>
	    </div>
	  </div>
	</nav>
	
<%-- 	<%  --%>
<!-- 	AccountService accountService = new AccountService();  -->
<!-- 	accountService.getAccountInfo(strSession); -->
	
<!-- 	String userName = strSession; -->
<!-- 	String firstName = null; -->
<!-- 	String lastName = null; -->
<!-- 	String telNumber = null; -->
<!-- 	String email = null; -->
<!-- 	String address = null; -->
<!-- 	String birthDate = null; -->
<!-- 	String gender = null; -->
<!-- 	String regDate = null; -->
<!-- 	String password = null; -->
	
<!-- 	for(AccountService l : accountService.accountList) { -->
<!-- 	//	userName = l.getUserName(); -->
<!-- 		firstName = l.getFirstName(); -->
<!-- 		lastName = l.getLastName(); -->
<!-- 		telNumber = l.getTelNumber(); -->
<!-- 		email = l.getEmail(); -->
<!-- 		address = l.getAddress(); -->
<!-- 		birthDate = l.getBirthDate(); -->
<!-- 		gender = l.getGender(); -->
<!-- 		regDate = l.getRegDate(); -->
<!-- 		password = l.getPassword(); -->
<!-- 	} -->
<!-- 	%> -->

	<c:forEach items="${arraylist}" var="list">
		<c:set var="firstname" value="${list.firstName}" />
		<c:set var="lastname" value="${list.lastName}" />
		<c:set var="password" value="${list.password}" />
		<c:set var="birthdate" value="${list.birthDate}" />
		<c:set var="telnumber" value="${list.telNumber}" />
		<c:set var="email" value="${list.email}" />
		<c:set var="address" value="${list.address}" />
		<c:set var="gender" value="${list.gender}" />
		<c:set var="regdate" value="${list.regDate}" />
	</c:forEach>
	
	<!-- Form  -->
	<div class="form-container clearfix">
	<h4 id="h4-title"> Edit Account: </h4>
		<form method="post" action="SaveHandler">
		<div class="form-wrapper">
			<div id="separation-line"></div>
			<div class="form-group" style="margin-bottom: 0px; position: relative; top: 10px;">
<%-- 				<input type="text" name="firstName" class="form-control" value="<%=firstName %>" /><br /> --%>
				<input type="text" name="firstName" class="form-control" placeholder="First name" value="<c:out value="${firstname}" />" /><br />
			</div>
			<div id="separation-line"></div>
			<div class="form-group" style="margin-bottom: 0px; position: relative; top: 10px;">
<%-- 				<input type="text" name="lastName" class="form-control" value="<%=lastName %>" /><br /> --%>
				<input type="text" name="lastName" class="form-control" placeholder="Last name" value="<c:out value="${lastname}" />" /><br />
			</div>
			<div id="separation-line"></div>
			<div class="form-group" style="margin-bottom: 0px; position: relative; top: 10px;">
<%-- 				<input type="password" name="password" class="form-control" value="<%=password %>" /><br /> --%>
				<input type="password" name="password" class="form-control" placeholder="Password" value="<c:out value="${password}" />" /><br />
			</div>
			<div id="separation-line"></div>
			<div class="form-group" style="margin-bottom: 0px; position: relative; top: 10px;">
<%-- 				<input type="text" name="birthDate" class="form-control" value="<%=birthDate %>" /><br /> --%>
				<input type="text" name="birthDate" class="form-control" placeholder="Birth date" value="<c:out value="${birthdate}" />" /><br />
			</div>	
			<div id="separation-line"></div>
			<div class="form-group" style="margin-bottom: 0px; position: relative; top: 10px;">
<%-- 				<input type="number" name="tel" class="form-control" value="<%=telNumber %>" /><br /> --%>
				<input type="number" name="tel" class="form-control" placeholder="Tel number" value="<c:out value="${telnumber}" />" /><br />
			</div>
			<div id="separation-line"></div>
			<div class="form-group" style="margin-bottom: 0px; position: relative; top: 10px;">	
<%-- 				<input type="email" name="email" class="form-control" value="<%=email %>" /><br /> --%>
				<input type="email" name="email" class="form-control" placeholder="Email" value="<c:out value="${email}" />" /><br />
			</div>
			<div id="separation-line"></div>
			<div class="form-group" style="margin-bottom: 0px; position: relative; top: 10px;">	
<%-- 				<input type="text" name="address" class="form-control" value="<%=address %>" /><br /> --%>
				<input type="text" name="address" class="form-control" placeholder="Address" value="<c:out value="${address}" />" /><br />
			</div>
			<div id="separation-line"></div>
			<div class="col-sm-9">
				<label>
					<input type="radio" checked="checked" name="radioGroup" value="Male" id="q128" />
					Male
				</label>
				<label>
					<input type="radio" name="radioGroup" value="Female" id="q129" />
					Female
				</label>
			</div>	
			<div class="form-group" style="margin-bottom: 10px;">
				<button type="submit" class="btn btn-info btn-block" class="form-control"> Save </button>
			</div>
		</div>		
		</form>
	</div>

</body>
</html>