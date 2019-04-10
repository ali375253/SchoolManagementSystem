<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<div class="box">
	<form method="post" action="ParentLoginServlet">
		<h1>Login</h1>
				<input type="text" name="studentid" placeholder="Student ID" class="email"/>
				<input type="password" placeholder="Password" name="password" class="password"/>			
				<input type="submit" value="Login" class="btn"/>
			</div>
	</form>
</body>
</html>