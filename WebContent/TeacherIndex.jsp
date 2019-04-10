<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/index.css">

</head>
<body>
	<%
		//response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		String tchrid=(String)session.getAttribute("tchrid");
		if(tchrid==null){
			response.sendRedirect("AdminLogin.jsp");
		}
	%>
	
	<div class="wrapper">
	<header>
		<div class="logo">
			<h1>School Management System</h1>
		</div>
		<div class="navigation">
			<ul>
				<li>Home</li>
				<li>Add Assignments</li>
        		<li>Add Results</li>
        
       			 <li><a  href="/nirmalaniketan/TeacherLogout">Logout</a></li>
			</ul>
		</div>
	</header>
</div>
	
</body>
</html>