<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="database.DBConnection, java.util.*, java.sql.*,admin.Subject" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/subject.css">
<link rel="stylesheet" type="text/css" href="css/upload_assignment.css">
<title>Term Result</title>


</head>
<body>

<div>
	<form method="post" action="UploadTermResultServlet">
	<h3 align="center">ENTER MARKS</h3>
		<h3>Student ID</h3><input type="text" name="studentid" />
		<h3>Term Type</h3>
		<select name="termtype">
			<option>First</option>
			<option>Second</option>
			<option>Final</option>
		</select>
		<%
			Connection con=DBConnection.getConnection();
			String standard=request.getParameter("standard");
			session.setAttribute("standard",standard);
			String query="select subjectid,subjectname,subjectno from sms.subject where standard=? ORDER BY subjectno";
			PreparedStatement st=con.prepareStatement(query);
			st.setString(1,standard);
			ResultSet rs=st.executeQuery();
			ArrayList<Subject> subs=new ArrayList<>();
			Subject sub;
			int cnt=1;
			while(rs.next()){
				//sub=new Subject();
				//sub.setSubjectID(rs.getInt(1));
				//sub.setSubjectName(rs.getString(2));
				//sub.setSubjectno(rs.getInt(3));
				//subs.add(sub);
		%>
				<h3><%= rs.getString(2) %></h3><input type="text" name="<%=cnt++%>" /><br>
		<%
			}
		%>
		<input type="submit" value="Upload" />
		
		</div>
	</form>
</body>
</html>