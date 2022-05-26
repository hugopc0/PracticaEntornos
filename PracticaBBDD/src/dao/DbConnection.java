package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	Connection conn;
	private static String bd = "biblioteca";
	private static String parametros = "?useSSL=false&serverTimezone=UTC";
	private static String user = "root";
	private static String password = "trebujena";
	private static String url = "jdbc:mysql://localhost:3306/" + bd + parametros;
	
	public DbConnection() {
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		return conn;
	}

	public void disconnect() throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}
	
}
