package visitor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OnlineAdmissionServlet")
public class OnlineAdmissionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out=res.getWriter();
		int studentID=Student.getStudentID();
		String firstName=req.getParameter("firstname");
		String middleName=req.getParameter("middlename");
		String lastName=req.getParameter("lastname");
		String dob=req.getParameter("dob");
		String gender=req.getParameter("gender");
		String mobileNo=req.getParameter("mobileno");
		String socialCategory=req.getParameter("socialcategory");
		String houseNo=req.getParameter("houseno");
		String streetName=req.getParameter("streetname");
		String addressLine1=req.getParameter("addressline1");
		String addressLine2=req.getParameter("addressline2");
		String city=req.getParameter("city");
		int pincode=Integer.parseInt(req.getParameter("pincode"));
		String state=req.getParameter("state");
		String password=req.getParameter("password");
		OnlineAdmissionDAO oad=new OnlineAdmissionDAO();
		try {
			int ans=oad.register(studentID, firstName, middleName, lastName, dob, gender, mobileNo, socialCategory, houseNo, streetName, addressLine1, addressLine2, city, pincode, state, password);
			if(ans > 1) {
				out.println("Registered Successfully");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}