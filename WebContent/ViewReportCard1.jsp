<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Report Card</title>
</head>
<body>
	<form method="post" action="ViewReportCard2.jsp">
		<%
			if(session.getAttribute("studid")!=null){
		%>
		<h3>Select Standard</h3>
		<select name="standard">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>	
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10</option>
		</select>
		<input type="submit" value="select" />
		<%
			}
			else
				response.sendRedirect("ParentLogin.jsp");
		%>
	</form>
</body>
</html>