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
	<form method="post" action="TeacherLoginServlet">
	<div class="box">	
	<h1>Login</h1>
		
				<input type="text" placeholder="Teacher ID" name="teacherid" class="email"/>
		

				<input type="password" placeholder="Password" name="password" class="email"/>
			
			
				<input type="submit" value="Login" class="btn"/>
	</div>
	</form>
</body>
</html>