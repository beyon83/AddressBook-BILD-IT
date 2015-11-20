<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/signup-styles.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
<script src="jquery/validation.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link href='http://fonts.googleapis.com/css?family=Oswald:300&subset=latin-ext' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Slabo+27px' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
<title>Sign Up</title>
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
	        <li><a href="#">Sign up</a></li>
	        <li><a href="http://localhost:27900/PhonebookApp/login.jsp">Log in</a></li>
	      </ul>
	    </div>
	  </div>
	</nav>
	
	<!-- Form  -->
	<div class="form-container clearfix">
	<h4 id="h4-title"> Sign Up: </h4>
		<form method="post" action="RegistrationHandler" class="form-validation">
		<div class="form-wrapper">
			<div class="form-group" style="margin-bottom: 0px; position: relative; top: 10px;">
				<input type="text" name="userName" class="form-control" placeholder="User name" required /><br />
			</div>
			<div class="error-message" style="color: #FF4747; font-style: italic; font-size: 14px; margin-bottom: 10px; margin-left: 10px;">
<!-- 			<img src="img/x.png" style="margin-bottom: 2px;" /> -->
				${ RegistrationService.getErrorMessage().equals('t') ? '' : usernameTaken }
			</div>	
			<div id="separation-line"></div>
			<div class="form-group" style="margin-bottom: 0px; position: relative; top: 10px;">
				<input type="text" name="firstName" class="form-control" placeholder="First name" required /><br />
			</div>
			<div id="separation-line"></div>
			<div class="form-group" style="margin-bottom: 0px; position: relative; top: 10px;">
				<input type="text" name="lastName" class="form-control" placeholder="Last name" required /><br />
			</div>
			<div id="separation-line"></div>
			<div class="form-group" style="margin-bottom: 0px; position: relative; top: 10px;">
				<input type="password" name="password" class="form-control" placeholder="Password" required /><br />
			</div>
			<div id="separation-line"></div>
			<div class="form-group" style="margin-bottom: 0px; position: relative; top: 10px;">
				<input type="text" name="birthDate" class="form-control" placeholder="Birth date" required /><br />
			</div>	
			<div id="separation-line"></div>
			<div class="form-group" style="margin-bottom: 0px; position: relative; top: 10px;">
				<input type="number" name="tel" class="form-control" placeholder="Tel. number" required /><br />
			</div>
			<div id="separation-line"></div>
			<div class="form-group" style="margin-bottom: 0px; position: relative; top: 10px;">	
				<input type="email" name="email" class="form-control" placeholder="Email" required /><br />
			</div>
			<div id="separation-line"></div>
			<div class="form-group" style="margin-bottom: 0px; position: relative; top: 10px;">	
				<input type="text" name="address" class="form-control" placeholder="Address" required /><br />
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
				<button type="submit" class="btn btn-info btn-block" class="form-control"> Submit </button>
			</div>
		</div>		
		</form>
	</div>
	
</body>
</html>