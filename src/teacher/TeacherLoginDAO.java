package teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;

public class TeacherLoginDAO {
	public TeacherLoginDAO() throws ClassNotFoundException, SQLException
	{
		con=DBConnection.getConnection();
	}
	public boolean validate(int uname,String pwd) throws SQLException
	{
		String query="select teacherid,password from sms.teacherdetails where teacherid=? and password=?";
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1, uname);
		st.setString(2, pwd);
		ResultSet rs=st.executeQuery();
		if(rs.next())
			return true;
		else
			return false;
	}
	private final Connection con;
}
