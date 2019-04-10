<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList, teacher.Assignment, database.DBConnection, java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet, javax.servlet.ServletOutputStream, java.io.*,java.util.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/view_assignment.css">
</head>
<body>
	<form action="ViewDoc.jsp" method="get">
	
	
	<div class="box">
	<h1><u>Assignment Details</u></h1>
	
		<%
			ArrayList<Assignment> al= (ArrayList<Assignment>) request.getAttribute("AssignmentList");
			for(int i=0;i<al.size();i++){
				Assignment as=al.get(i);
				
		        //response.setHeader("Content-disposition","inline; filename="+ as.getAssignmentID()+".pdf" );
				int teacherid=as.getTeacherID();
				Connection con=DBConnection.getConnection();
				String query="select firstname, lastname from sms.teacherdetails where teacherid=?";
				PreparedStatement st=con.prepareStatement(query);
				st.setInt(1, teacherid);
				ResultSet rs=st.executeQuery();
				if(rs.next()){
		%>
		<h2>Teacher Name:<%= rs.getString(1) + " " + rs.getString(2) %></h2>
		<%
				}
				st.close();
				int subjectid=as.getSubjectID();
				String query2="select subjectname from sms.subject where subjectid=?";
				PreparedStatement st2=con.prepareStatement(query2);
				st2.setInt(1, subjectid);
				ResultSet rs2=st2.executeQuery();
				if(rs2.next()){
		%>
				<h3>Subject:<%= rs2.getString(1) %></h3>
		<%
				}
				st2.close();
		%>
		<%
			session.setAttribute(i+"", as.getDoc());
			
		%>
			<h3><a href="\nirmalaniketan\ViewDoc?id=<%=i %>" />View Assignment</a></h3>
			<h3>Due Date:<%= as.getDueDate() %></h3>
		<%
			}
			session.setAttribute("aslist", al);
		%>
		</div>
		 	
	</form>
</body>
</html>