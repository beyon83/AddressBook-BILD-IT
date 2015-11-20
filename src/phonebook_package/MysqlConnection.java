package phonebook_package;

public interface MysqlConnection {

	final static String DRIVER = "com.mysql.jdbc.Driver";
	final static String LOCAL_HOST = "jdbc:mysql://localhost/phonebook_app";
	final static String ROOT = "root";
	final static String PASSWORD = "";
	
	public void mysqlConnect() ;
	
}
