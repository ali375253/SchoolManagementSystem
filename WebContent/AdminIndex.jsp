<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
	<%
		//response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		String uname=(String)session.getAttribute("uname");
		if(uname==null){
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
				<li>HOME</li>
				<li><a href="AddSubject.jsp" style="text-decoration:none">Add SUBJECTS</a></li>
        		<li><a href="UploadTermResult1.jsp" style="text-decoration:none">Add RESULTS</a></li>
        		<li><a href="UploadTimeTable1.jsp" style="text-decoration:none">Upload TIME-TABLE</a></li>
        		
        		
        	<li><a href="/nirmalaniketan/AdminLogout">LOGOUT</a></li>
			
			</ul>
		</div>
	</header>
</div>
	
	s
</body>
</html>