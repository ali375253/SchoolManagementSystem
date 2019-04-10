package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;

public class AdminLoginDAO {
	public AdminLoginDAO() throws ClassNotFoundException, SQLException
	{
		con=DBConnection.getConnection();
	}
	public boolean validate(String uname,String pwd) throws SQLException
	{
		String query="select username,password from sms.admin where username=? and password=?";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, uname);
		st.setString(2, pwd);
		ResultSet rs=st.executeQuery();
		if(rs.next())
			return true;
		else
			return false;
	}
	private final Connection con;
}
