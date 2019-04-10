package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DBConnection;

public class AddSubjectDAO {
	public AddSubjectDAO() throws ClassNotFoundException, SQLException {
		con=DBConnection.getConnection();
	}
	public int addSubject(int subjectid,String subjectname,String standard,int subjectno) throws ClassNotFoundException, SQLException {
		String query="insert into sms.subject values(?,?,?,?)";
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1, subjectid);
		st.setString(2, subjectname);
		st.setString(3, standard);
		st.setInt(4, subjectno);
		int ans=st.executeUpdate();
		return ans;
	}
	private final Connection con;
}
