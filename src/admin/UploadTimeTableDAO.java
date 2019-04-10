package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DBConnection;

public class UploadTimeTableDAO {

	public UploadTimeTableDAO() throws ClassNotFoundException, SQLException {
		con=DBConnection.getConnection();
	}
	public int uploadDocument(int standard, byte[] doc) throws SQLException {
		String query="insert into sms.timetable values(?,?)";
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, standard);
		st.setBytes(2,doc);    //Storing binary data in blob field.
		int ans = st.executeUpdate();
		return ans;
	}
	private final Connection con;
}
