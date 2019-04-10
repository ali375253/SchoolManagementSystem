package visitor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DBConnection;

public class OnlineAdmissionDAO {
	public int register(int studentID,String firstname,String middlename,String lastname,String dob,String gender,String mobileno,String socialcatagory,String houseno,String streetname,String addressline1,String addressline2,String city,int pincode,String state,String password) throws ClassNotFoundException, SQLException {
		Connection con=DBConnection.getConnection();
		String query="insert into sms.studentdetails values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1, studentID);
		st.setString(2, firstname);
		st.setString(3, middlename);
		st.setString(4, lastname);
		st.setString(5, dob);
		st.setString(6, gender);
		st.setString(7, mobileno);
		st.setString(8, socialcatagory);
		st.setString(9, houseno);
		st.setString(10, streetname);
		st.setString(11, addressline1);
		st.setString(12, addressline2);
		st.setString(13, city);
		st.setInt(14, pincode);
		st.setString(15, state);
		st.setString(16, password);
		int ans=st.executeUpdate();
		DBConnection.close();
		return ans;	
	}
}
