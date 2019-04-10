package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DBConnection;

public class TermResultDAO {
	public TermResultDAO() throws ClassNotFoundException, SQLException
	{
		con=DBConnection.getConnection();
	}
	public ArrayList<TermResult> getFirstTermResult() throws SQLException
	{
		String query="select * from sms.termresults where termtype=? ORDER BY studentid";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1,"First");
		ResultSet rs=st.executeQuery();
		ArrayList<TermResult> FirstTermList=new ArrayList<>();
		TermResult tr;
		while(rs.next()) {
			tr=new TermResult();
			tr.setStudentID(rs.getInt(1));
			tr.setSubject1(rs.getInt(2));
			tr.setSubject2(rs.getInt(3));
			tr.setSubject3(rs.getInt(4));
			tr.setSubject4(rs.getInt(5));
			tr.setSubject5(rs.getInt(6));
			tr.setTermType(rs.getString(7));
			tr.setTotal(rs.getInt(8));
			tr.setPercentage(rs.getDouble(9));
			tr.setStandard(rs.getInt(10));
			FirstTermList.add(tr);
		}
		return FirstTermList;
	}
	
	public ArrayList<TermResult> getSecondTermResult() throws SQLException
	{
		String query="select * from sms.termresults where termtype=? ORDER BY studentid";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1,"Second");
		ResultSet rs=st.executeQuery();
		ArrayList<TermResult> SecondTermList=new ArrayList<>();
		TermResult tr;
		while(rs.next()) {
			tr=new TermResult();
			tr.setStudentID(rs.getInt(1));
			tr.setSubject1(rs.getInt(2));
			tr.setSubject2(rs.getInt(3));
			tr.setSubject3(rs.getInt(4));
			tr.setSubject4(rs.getInt(5));
			tr.setSubject5(rs.getInt(6));
			tr.setTermType(rs.getString(7));
			tr.setTotal(rs.getInt(8));
			tr.setPercentage(rs.getDouble(9));
			tr.setStandard(rs.getInt(10));
			SecondTermList.add(tr);
		}
		return SecondTermList;
	}
	
	public ArrayList<TermResult> getFinalTermResult() throws SQLException
	{
		String query="select * from sms.termresults where termtype=? ORDER BY studentid";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1,"Final");
		ResultSet rs=st.executeQuery();
		ArrayList<TermResult> FinalTermList=new ArrayList<>();
		TermResult tr;
		while(rs.next()) {
			tr=new TermResult();
			tr.setStudentID(rs.getInt(1));
			tr.setSubject1(rs.getInt(2));
			tr.setSubject2(rs.getInt(3));
			tr.setSubject3(rs.getInt(4));
			tr.setSubject4(rs.getInt(5));
			tr.setSubject5(rs.getInt(6));
			tr.setTermType(rs.getString(7));
			tr.setTotal(rs.getInt(8));
			tr.setPercentage(rs.getDouble(9));
			tr.setStandard(rs.getInt(10));
			FinalTermList.add(tr);
		}
		return FinalTermList;
	}
	
	private final Connection con;
}
