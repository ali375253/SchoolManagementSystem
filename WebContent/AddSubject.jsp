<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Add Subject</title>
<link rel="stylesheet" type="text/css" href="css/subject.css">
</head>
<body>
	<form method="post" action="AddSubjectServlet">
	
		<div>
		<h3 align="center">Add Subjects</h3>
			
			Subject ID
				<input type="text" name="subjectid"  />
				
			Subject Name
				<input type="text" name="subjectname" />
				
			Standard	
				<input type="text" name="standard" />
			Subject Number
				<input type="text" name="subjectno" />
	
				<input type="submit" value="Add" />
			
		</div>
	</form>
</body>
</html>