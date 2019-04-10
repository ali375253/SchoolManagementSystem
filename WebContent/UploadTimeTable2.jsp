<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.Connection,java.sql.Statement,java.sql.SQLException,database.DBConnection,java.sql.ResultSet,java.util.ArrayList,java.sql.PreparedStatement"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Time Table</title>

<link rel="stylesheet" type="text/css" href="css/timetable.css">
</head>

<body>
	<form method="post" action="UploadTimeTableServlet" enctype='multipart/form-data'>
	<div class="box">
		
			<%
				session=request.getSession();
				if(session.getAttribute("uname")!=null){
					String standard=(String)request.getParameter("standard");
					session.setAttribute("standard", standard);
			%>
			
				<h2 align="center">Upload Document</h2>				
				<input type="file" name="timetable" />
			
				<input type="submit" value="Upload" class="btn1" />
			
			<%
				}
				else{
					response.sendRedirect("AdminLogin.jsp");
				}
			%>
		</table>
		</div>
	</form>
</body>
</html>