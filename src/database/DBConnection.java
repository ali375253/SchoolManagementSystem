package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if(con==null) {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(url,username,password);
			return con;
		}
		return con;
	}
	public static void close() throws SQLException {
		if(con!=null)
			con.close();
	}
	private static Connection con=null;
	private static String url="jdbc:postgresql://localhost/SMS";
	private static String username="postgres";
	private static String password="aliasgar";
}
