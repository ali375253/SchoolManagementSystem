package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DBConnection;

public class PayFeesDAO {
	
	public PayFeesDAO() throws ClassNotFoundException, SQLException{
		con=DBConnection.getConnection();
	}
	
	public int pay(int feesid,int studentid,String Date,String typeofpayement,int amount,int standard) throws ClassNotFoundException, SQLException{
		String query="insert into sms.fees values(?,?,?,?,?,?)";
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1, feesid);
		st.setInt(2, studentid);
		st.setString(3, Date);
		st.setString(4, typeofpayement);
		st.setInt(5, amount);
		st.setInt(6, standard);
		int ans=st.executeUpdate();
		return ans;
	}
	private final Connection con;
}
