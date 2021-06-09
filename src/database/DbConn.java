package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConn {
	private static Connection conn;
	private DbConn() {
		// TODO Auto-generated constructor stub
		conn = connectDB();
	}
	private static class Singleton {
		private static final DbConn instance = new DbConn();
	}
	
	public static DbConn getInstance() {
		return Singleton.instance;
	}
	
	private static Connection connectDB() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			//e.printStackTrace();
			System.out.println("Driver error!");
		}
		try {
			String jdbcUrl = "jdbc:mariadb://localhost:3306/test";
			String userID = "root";
			String userPass = "dual1014";
			DriverManager.getConnection(jdbcUrl, userID, userPass);
			System.out.println("Success!");
		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
			System.out.println("Fail!");
		}
		return null;
	}
	
}
