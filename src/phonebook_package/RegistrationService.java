package phonebook_package;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrationService {
	
	private String userName;
	private String errorMessage;
	
	public RegistrationService() {
		
	}
	
	public RegistrationService(String userName) {
		this.userName = userName;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setUsername(String userName) {
		this.userName = userName;
	}
	
	public String getUsername() {
		return userName;
	}

	//////////////////////////////////////////////////////////
	
	public void registerUser(String userName, String firstName, String lastName, String telNumber, String email, String address, String birthDate, String gender, String registrationDate, String password, Connection mysqlConnect) {
		
		String sql = " INSERT INTO `phonebook`("
				   + " `userName`, `firstName`, `lastName`, `telNumber`, `email`, `address`,"
				   + " `birthDate`, `gender`, `registrationDate`, `password`)"
				   + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		
		try(PreparedStatement prepStatement = mysqlConnect.prepareStatement(sql)) {
			
			prepStatement.setString(1, userName);
			prepStatement.setString(2, firstName);
			prepStatement.setString(3, lastName);
			prepStatement.setString(4, telNumber);
			prepStatement.setString(5, email);
			prepStatement.setString(6, address);
			prepStatement.setString(7, birthDate);
			prepStatement.setString(8, gender);
			prepStatement.setString(9, registrationDate);
			prepStatement.setString(10, password);
			prepStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	//////////////////////////////////////////////////////
	
	public boolean isUsernameTaken(String userName, Connection mysqlConnect) {
		
		String sql = " SELECT `userName` FROM `phonebook` ";
		
		ResultSet rs = null;
		
		try(PreparedStatement prepStatement = mysqlConnect.prepareStatement(sql)) {
			
			rs = prepStatement.executeQuery();
			
			String name = "";
			
			while(rs.next()) {
				name = rs.getString("userName");
				if(name.equals(userName)) {
					setErrorMessage("User name \"" + userName + "\" is already taken.");
					System.out.println(getErrorMessage());
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
