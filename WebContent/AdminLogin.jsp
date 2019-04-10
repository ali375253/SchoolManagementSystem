<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login</title>
	<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
	<form method="post" action="AdminLoginServlet">
	
	<div class="box">
	<h1>Login</h1>
		<input type="text" name="username" placeholder="Username" class="email"/>
		<input type="password" name="password" placeholder="Password" class="email"/>
		<input type="submit" value="Login" class="btn"/>
	</div>
	</form>
</body>
</html>