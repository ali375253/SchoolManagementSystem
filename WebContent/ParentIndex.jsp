<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/index.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		//response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		String studid=(String)session.getAttribute("studid");
		if(studid==null){
			response.sendRedirect("ParentLogin.jsp");
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
				<li><a href="/nirmalaniketan/OnlineAdmission.jsp" style="text-decoration:none">Registration</a></li>
        		<li><a href="/nirmalaniketan/ViewAssignmentServlet" style="text-decoration:none">View Assignments</a></li>
				<li><a href="/nirmalaniketan/ViewReportCard1.jsp" style="text-decoration:none">View Results</a></li>
				<li><a href="/nirmalaniketan/ParentLogout">Logout</a></li>
			</ul>
		</div>
	</header>
</div>
</body>
</html>