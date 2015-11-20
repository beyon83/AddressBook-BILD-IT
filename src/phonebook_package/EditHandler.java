package phonebook_package;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EditHandler
 */
@WebServlet("/EditHandler")
public class EditHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Connection mysqlConnect = null;
	
	public static ArrayList<AccountService> list = new ArrayList<>();
	
	public void init(ServletConfig config) throws ServletException {
		mysqlConnect = MySqlConnectDAO.mysqlConnect();
		System.out.println("init() has been invoked.");
	}
	
	public void destroy() {
		try {
			mysqlConnect.close();
			System.out.println("destroy() has been invoked.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		list.clear();
		
		HttpSession session = request.getSession();
		RequestDispatcher dsp = request.getRequestDispatcher("EditAccount.jsp");
		
		String userName = (String)session.getAttribute("getSession");
		session.setAttribute("getSession", userName);
		
		AccountService accountService = new AccountService();
		accountService.getAccountInfo(userName, mysqlConnect);
		session.setAttribute("arraylist", list);
		
		System.out.println("Size of the list: " + list.size());
		for(AccountService l : list) {
			System.out.println("List username: " + l.getUserName());
			System.out.println("List firstName " + l.getFirstName());
		}
		
		/**
		for(AccountService accList : accountService.accountList) {
			if(firstName.equals("") || firstName.equals(null)) {
				firstName = accList.getFirstName();
			}	
			if(lastName.equals("") || lastName.equals(null)) {
				lastName = accList.getLastName();
			}	
			if(telNumber.equals("") || telNumber.equals(null)) {
				telNumber = accList.getTelNumber();
			}
			if(email.equals("") || email.equals(null)) {
				email = accList.getEmail();
			}
			if(address.equals("") || address.equals(null)) {
				address = accList.getAddress();
			}
			if(birthDate.equals("") || birthDate.equals(null)) {
				birthDate = accList.getBirthDate();
			}
			if(gender.equals("") || gender.equals(null)) {
				gender = accList.getGender();
			}
			if(registrationDate.equals("") || registrationDate.equals(null)) {
				registrationDate = accList.getRegDate();
			}
			if(password.equals("") || password.equals(null)) {
				password = accList.getPassword();
			}
		}
		*/
		
		dsp.forward(request, response);
		
	}

}
