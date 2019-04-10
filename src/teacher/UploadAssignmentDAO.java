package teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import database.DBConnection;
class UploadAssignmentDAO{

	public UploadAssignmentDAO() throws ClassNotFoundException, SQLException {
		con=DBConnection.getConnection();
	}
	public int uploadDocument(int assignmentid, int teacherid, int subjectid, byte[] doc, String duedate, int standard) throws SQLException {
		String query="insert into sms.assignment values(?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, assignmentid);
		st.setInt(2, teacherid);
		st.setInt(3, subjectid);
		st.setBytes(4,doc);    //Storing binary data in blob field.
		st.setString(5, duedate);
		st.setInt(6, standard);
		int ans = st.executeUpdate();
		con.close();
		return ans;
	}
	private final Connection con;
}
