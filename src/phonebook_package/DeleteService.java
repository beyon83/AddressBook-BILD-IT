package phonebook_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteService {
	
	public void deleteAccount(String userName, Connection mysqlConnect) {
		
		String sql = (" DELETE FROM `phonebook` WHERE `userName` = '" + userName + "' ");
		
		try(PreparedStatement prepStat = mysqlConnect.prepareStatement(sql)) {
			prepStat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
}
