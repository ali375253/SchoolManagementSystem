package parent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;

public class ParentLoginDAO {
	public ParentLoginDAO() throws ClassNotFoundException, SQLException
	{
		con=DBConnection.getConnection();
	}
	public boolean validate(int uname,String pwd) throws SQLException
	{
		String query="select studentid,password from sms.studentdetails where studentid=? and password=?";
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
