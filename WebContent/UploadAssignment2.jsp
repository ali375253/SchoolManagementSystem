<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.Connection,java.sql.Statement,java.sql.SQLException,database.DBConnection,java.sql.ResultSet,java.util.ArrayList,java.sql.PreparedStatement"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Assignment</title>
<link rel="stylesheet" type="text/css" href="css/upload_assignment.css">
<script type="text/javascript src="date.js"></script>
</head>
<body>
	<form method="post" action="UploadAssignmentServlet" enctype='multipart/form-data'>
		<table>
			<%
				session=request.getSession();
				String standard=(String)request.getParameter("standard");
				session.setAttribute("standard", standard);
				if(session.getAttribute("tchrid")!=null){
					Connection con=DBConnection.getConnection();
					String query="select subjectid from sms.subject where standard=? ORDER BY subjectid";
					PreparedStatement st=con.prepareStatement(query);
					st.setString(1, standard);
					ResultSet rs=st.executeQuery();
			%>
			
				<div class="main">
				<div class="box">
				<h3>Select Subject</h3>
					 <select name="subject">
					 	<% while(rs.next()){  %>
							<option><%= rs.getInt("subjectid") %></option>
				<% 			} 
				}
				else{
					response.sendRedirect("TeacherLogin.jsp");
				}%>
					</select>
					<h3>Upload Assignment</h3>
						<input type="file" name="assignment" />
						
					<h3>Due Date</h3>
					<br>
					<input type="date" name="duedate" />
					
					<input type="submit" value="Upload" class="btn1" />
					
					</div>
					</div>
		</table>
	</form>
</body>
</html>