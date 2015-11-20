package phonebook_package;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Contacts {
	
	private String userName;
	private String firstName;
	private String lastName;
	private String telNumber;
	private String email;
	private String address;
	private String birthDate;
	private String gender;
	private String regDate;
	
	public ArrayList<Contacts> list = new ArrayList<>();
	
	public Contacts() {
		
	}
	
	public Contacts(String userName, String firstName, String lastName, String telNumber, String email, String address, String birthDate, String gender, String regDate) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telNumber = telNumber;
		this.email = email;
		this.address = address;
		this.birthDate = birthDate;
		this.gender = gender;
		this.regDate = regDate;
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
	
////////////////////////////////////////////////////////////////////////////	
	
	public void fetchContacts(Connection mysqlConnect) {
		
		ResultSet rs = null;
		
		String query = " SELECT * FROM `phonebook` ";
		
		try(PreparedStatement prepStat = mysqlConnect.prepareStatement(query)) {
			
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
				Contacts fetchContacts = new Contacts(userName, firstName, lastName, telNumber, email, address, birthDate, gender, regDate);
				list.add(fetchContacts);
				LoginHandler.list.add(fetchContacts);
				ContactsHandler.list.add(fetchContacts);
				RegistrationHandler.list.add(fetchContacts);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
////////////////////////////////////////////////////////////////////////////////////////////
	
	public void searchResults(String query, Connection mysqlConnect) {
		
		ArrayList<Contacts> listResults = new ArrayList<>();
		
		ResultSet rs = null;
		
		String sql = " SELECT * FROM `phonebook` ";
		
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
				
				Contacts getResult = new Contacts(userName, firstName, lastName, telNumber, email, address, birthDate, gender, regDate);
				listResults.add(getResult);
			}
			
			for(Contacts l : listResults) {
				/** Search user by username, first name, last name or tel. number */
				if((l.getUserName().equals(query)) || (l.getFirstName().equalsIgnoreCase(query)) || (l.getLastName().equalsIgnoreCase(query)) || (l.getTelNumber().equals(query))) {
					Contacts queryFound = new Contacts(l.getUserName(), l.getFirstName(), l.getLastName(), l.getTelNumber(), l.getEmail(), l.getAddress(), l.getBirthDate(),l.getGender(), l.getRegDate());
					SearchHandler.list.add(queryFound);
				} else {
				//	System.out.println("Searched query doesn't exist in the database. ");
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

}
