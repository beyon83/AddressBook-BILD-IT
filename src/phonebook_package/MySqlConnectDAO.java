package phonebook_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnectDAO {
	
	final static String DRIVER = "com.mysql.jdbc.Driver";
	final static String LOCAL_HOST = "jdbc:mysql://localhost/phonebook_app";
	final static String ROOT = "root";
	final static String PASSWORD = "";

	public static Connection mysqlConnect() {
		
		Connection mysqlConnect = null;
		
		try {
			Class.forName(DRIVER);
			mysqlConnect = DriverManager.getConnection(LOCAL_HOST, ROOT, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return mysqlConnect;
	}
	
	

}
