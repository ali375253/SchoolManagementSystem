package parent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;

public class ViewReportCardDAO {
	public ViewReportCardDAO() throws ClassNotFoundException, SQLException
	{
		con=DBConnection.getConnection();
	}
	public ReportCard viewReportCard(int reportcardid) throws SQLException
	{
		String query="select * from sms.reportcard where reportcardid=?";
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1, reportcardid);
		ResultSet rs=st.executeQuery();
		ReportCard rc=new ReportCard();
		while(rs.next()) {
			rc.setReportCardID(rs.getInt(1));
			rc.setStudentID(rs.getInt(2));
			rc.setSubject1(rs.getInt(3));
			rc.setSubject2(rs.getInt(4));
			rc.setSubject3(rs.getInt(5));
			rc.setSubject4(rs.getInt(6));
			rc.setSubject5(rs.getInt(7));
			rc.setTotal(rs.getInt(8));
			rc.setPercentage(rs.getDouble(9));
			rc.setResult(rs.getString(10));
			rc.setStandard(rs.getInt(11));
		}
		return rc;
	}
	private final Connection con;
}
