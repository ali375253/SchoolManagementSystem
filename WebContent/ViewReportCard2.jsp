<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="parent.ViewReportCardDAO, parent.ReportCard, java.sql.*, database.DBConnection, java.util.*, admin.Subject" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Report Card</title>
</head>
<body>
	<%
		if(session.getAttribute("studid")!=null){
			int studentid=Integer.parseInt((String)session.getAttribute("studid"));
			int standard=Integer.parseInt(request.getParameter("standard"));
			int reportcardid=Integer.parseInt(studentid+""+standard);
			try {
				ViewReportCardDAO vrd=new ViewReportCardDAO();
				ReportCard rc=vrd.viewReportCard(reportcardid);
				Connection con=DBConnection.getConnection();
				String stand=request.getParameter("standard");
				session.setAttribute("standard",standard);
				String query="select subjectid,subjectname,subjectno from sms.subject where standard=? ORDER BY subjectno";
				PreparedStatement st=con.prepareStatement(query);
				st.setString(1,stand);
				ResultSet rs=st.executeQuery();
				ArrayList<Subject> subs=new ArrayList<>();
				Subject sub;
				int cnt=1;
				while(rs.next()){
		%>
					<h3><%= rs.getString(2) %></h3><br>
		<%
				}
				out.println(rc.getReportCardID()+" "+rc.getStudentID()+" "+rc.getStandard()+" "+rc.getSubject1()+" "+rc.getSubject2()+" "+rc.getSubject3()+" "+rc.getSubject4()+" "+rc.getSubject5()+" "+rc.getTotal()+" "+rc.getPercentage()+" "+rc.getResult());
				
			} 
			catch (ClassNotFoundException | SQLException e) {
				out.println(e.getMessage());
			}
		}
		else
			response.sendRedirect("ParentLogin.jsp");
			
			
	%>
</body>
</html>