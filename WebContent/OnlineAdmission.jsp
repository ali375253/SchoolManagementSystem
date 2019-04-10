<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/student_registration.css">
</head>
<body>
	<form method="post" action="OnlineAdmissionServlet" >
	<div class="box">
		<h1>Student Registration</h1>
			
				<input type="text" name="firstname" placeholder="First Name" class="email"/>
				
				<input type="text" name="middlename" placeholder="Middle Name" class="email"/>
			
				<input type="text" name="lastname" placeholder="Last Name" class="email"/>
				
				<input type="text" name="dob" placeholder="Date of Birth" class="email"/>
				
				<input type="text" name="gender"  placeholder="Gender" class="email"/>
				
				<input type="text" name="mobileno" placeholder="Mobile Number" class="email" />
				
				<input type="text" name="socialcategory" placeholder="Social Category" class="email"/>
				
				<input type="text" name="houseno" placeholder="House Number" class="email"/>
				
				<input type="text" name="streetname" placeholder="Street Name"class="email"/>
				
				<input type="text" name="addressline1" placeholder="Address Line1" class="email"/>
				
				<input type="text" name="addressline2" placeholder="Address Line2" class="email"/>
				
				<input type="text" name="city" placeholder="City" class="email"/>
			
				<input type="text" name="pincode" placeholder="Pinode" class="email"/>
					
				<input type="text" name="state" placeholder="State" class="email"/>
			
				<input type="password" name="password" placeholder="Password" class="email" />
			
				
				<a href="/nirmalaniketan/OnlineAdmissionServlet" class="btn">Register</a>
			</div>
		
	</form>
</body>
</html>