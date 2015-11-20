package phonebook_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountService {
	
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
	
	public ArrayList<AccountService> accountList = new ArrayList<>();
	
	public AccountService() {
		
	}
	
	public AccountService(String userName, String firstName, String lastName, String telNumber, String email, String address, String birthDate, String gender, String regDate, String password) {
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
	
	/** Getters and Setters */
	
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
	
//////////////////////////////////////////////////////////////	

	public void getAccountInfo(String userName, Connection mysqlConnect) {
		
		ResultSet rs = null;
		
		String sql = " SELECT * FROM `phonebook` WHERE `userName` = '" + userName + "' ";
		
		try(PreparedStatement prepStat = mysqlConnect.prepareStatement(sql)) {
			
			rs = prepStat.executeQuery();
			while(rs.next()) {
				this.userName = rs.getString("userName");
				this.firstName = rs.getString("firstName");
				this.lastName = rs.getString("lastName");
				this.telNumber = rs.getString("telNumber");
				this.email = rs.getString("email");
				this.address = rs.getString("address");
				this.birthDate = rs.getString("birthDate");
				this.gender = rs.getString("gender");
				this.regDate = rs.getString("registrationDate");
				this.password = rs.getString("password");
				AccountService accountInfo = new AccountService(userName, firstName, lastName, telNumber, email, address, birthDate, gender, regDate, password);
				accountList.add(accountInfo);
				AccountHandler.list1.add(accountInfo);
				EditHandler.list.add(accountInfo);
				UserProfile.list.add(accountInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
