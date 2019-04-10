package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;

public class ReportCardDAO {
	public ReportCardDAO() throws ClassNotFoundException, SQLException {
		con=DBConnection.getConnection();
	}
	public int generateReportCard(int reportcardid, int studentid, int subject1, int subject2, int subject3, int subject4, int subject5, int total, double percentage, String result, int standard) throws SQLException
	{
		String query="insert into sms.reportcard values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1, reportcardid);
		st.setInt(2, studentid);
		st.setInt(3, subject1);
		st.setInt(4, subject2);
		st.setInt(5, subject3);
		st.setInt(6, subject4);
		st.setInt(7, subject5);
		st.setInt(8, total);
		st.setDouble(9, percentage);
		st.setString(10, result);
		st.setInt(11, standard);
		int ans=st.executeUpdate();
		return ans;
	}
	private final Connection con;
}
