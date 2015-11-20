package phonebook_package;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {
	
	private static String error;
	
	public static void setError(String error) {
		LoginService.error = error;
	}
	
	public static String getError() {
		return error;
	}
	
	public boolean authenticateUser(String userName, String password, Connection mysqlConnect) {
		
	//	MySqlConnectDAO mysqlDao = new MySqlConnectDAO();
	//	mysqlDao.mysqlConnect();
		
		ResultSet rs = null;
		
		String sqlQuery = " SELECT `userName`, `password` FROM `phonebook` WHERE `userName` = '" + userName + "' AND `password` = '" + password + "' ";
		
		try(PreparedStatement prepStatement = mysqlConnect.prepareStatement(sqlQuery)) {
			
			rs = prepStatement.executeQuery();
			
			while(rs.next()) {
				String user = rs.getString("userName");
				String pass = rs.getString("password");
				if(userName.equals(user) && password.equals(pass)) {
					return true;
				} 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		setError("Wrong username or password! Try again.");
		return false;
	}
	
}
