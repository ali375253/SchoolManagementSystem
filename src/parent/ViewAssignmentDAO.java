package parent;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import database.DBConnection;
import teacher.Assignment;

public class ViewAssignmentDAO {
	public ViewAssignmentDAO() throws ClassNotFoundException, SQLException{
		con=DBConnection.getConnection();
	}
	public ArrayList<Assignment> viewAssignment(int parentid) throws SQLException {
		Calendar cal=Calendar.getInstance();
		int year=cal.get(Calendar.YEAR);
		int standard=(parentid/100)-year+1;
		String query="select * from sms.assignment where standard=?";
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1, standard);
		ResultSet rs=st.executeQuery();
		ArrayList<Assignment> al=new ArrayList<>();
		while(rs.next()) {
			Assignment as=new Assignment();
			as.setAssignmentID(rs.getInt(1));
			as.setTeacherID(rs.getInt(2));
			as.setSubjectID(rs.getInt(3));
			byte[] b = rs.getBytes(4);
			as.setDoc(b);
			as.setDueDate(rs.getString(5));
			as.setStandard(rs.getInt(6));
			al.add(as);
		}
		return al;
		
	}
	private final Connection con;
}
