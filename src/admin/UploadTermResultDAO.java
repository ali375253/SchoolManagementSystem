package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DBConnection;

public class UploadTermResultDAO {
	public int uploadResult(int studentid, int subject1, int subject2, int subject3, int subject4, int subject5, String termtype, int total, double percentage, int standard) throws ClassNotFoundException, SQLException {
		
		Connection con=DBConnection.getConnection();
		String query="insert into sms.termresults values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1, studentid);
		st.setInt(2, subject1);
		st.setInt(3, subject2);
		st.setInt(4, subject3);
		st.setInt(5, subject4);
		st.setInt(6, subject5);
		st.setString(7, termtype);
		st.setInt(8, total);
		st.setDouble(9, percentage);
		st.setInt(10, standard);
		int ans=st.executeUpdate();
		return ans;
	}
}
