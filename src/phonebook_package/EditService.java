package phonebook_package;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditService {
	
	private String userName;
	private String firstName;
	private String lastName;
	private String telNumber;
	private String email;
	private String address;
	private String birthDate;
	private String gender;
	private String regDate;
	private String password;
	
	public EditService() {
		
	}
	
	public EditService(String userName) {
		this.userName = userName;
	}
	
	public EditService(String userName, String firstName, String lastName, String telNumber, String email, String address, String birthDate, String gender, String regDate, String password) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telNumber = telNumber;
		this.email = email;
		this.address = address;
		this.birthDate = birthDate;
		this.gender = gender;
		this.regDate = regDate;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}
	
	public String getUsername() {
		return userName;
	}

	//////////////////////////////////////////////////////////
	
	public void editUser(String userName, String firstName, String lastName, String telNumber, String email, String address, String birthDate, String gender, String registrationDate, String password, Connection mysqlConnect) {
		
		EditService edit = new EditService(userName, firstName, lastName, telNumber, email, address, birthDate, gender, registrationDate, password);
		SaveHandler.list.add(edit);
		
		String sql = " UPDATE `phonebook` SET `firstName` = ?, "
				   + " `lastName` = ?, `telNumber` = ?, `email` = ?,"
				   + " `address` = ?, `birthDate` = ?, `gender` = ?,"
				   + " `registrationDate` = ?, `password` = ?"
				   + "  WHERE `userName` = '" + userName + "' ";
		
		try(PreparedStatement prepStatement = mysqlConnect.prepareStatement(sql)) {
			
		//	prepStatement.setString(1, userName);
			prepStatement.setString(1, firstName);
			prepStatement.setString(2, lastName);
			prepStatement.setString(3, telNumber);
			prepStatement.setString(4, email);
			prepStatement.setString(5, address);
			prepStatement.setString(6, birthDate);
			prepStatement.setString(7, gender);
			prepStatement.setString(8, registrationDate);
			prepStatement.setString(9, password);
			prepStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
