package phonebook_package;


import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistrationHandler
 */
@WebServlet("/RegistrationHandler")
public class RegistrationHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static ArrayList<Contacts> list = new ArrayList<>(); 
	
	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#destroy()
	 */
	public void destroy() {
		try {
			MySqlConnectDAO.mysqlConnect().close();
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
		
		/** Generate current time, and convert it into simple format */
		java.util.Date date = new java.util.Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		
		/** Obtain user's input informations from the registration form */
		String userName = request.getParameter("userName");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String telNumber = request.getParameter("tel");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String birthDate = request.getParameter("birthDate");
		String gender = request.getParameter("radioGroup");
		String registrationDate = dateFormat.format(date);
		String password = request.getParameter("password");
		
		/** Instantiate registration object */
		RegistrationService registration = new RegistrationService();
	//	registration.setUsername(userName); // optional for now...
		
		/** Create Dispatcher for redirecting the user to the Contacts.jsp page after registering */
		RequestDispatcher dsp = request.getRequestDispatcher("Contacts.jsp");
		RequestDispatcher error = request.getRequestDispatcher("SignUp.jsp");
		/** Create session object */
		HttpSession session = request.getSession();
		
		/** Invoke isUsernameTaken() method to check if user name already exists */
		boolean validateUsername = registration.isUsernameTaken(userName, MySqlConnectDAO.mysqlConnect());
		
		/** Obtain contacts from the database */
		Contacts contacts = new Contacts();
		contacts.fetchContacts(MySqlConnectDAO.mysqlConnect());
		
		if(validateUsername == true) {
			/** If user name is already taken, redirect user to the error page */
			registration.getErrorMessage();
			request.setAttribute("usernameTaken", registration.getErrorMessage());
			error.forward(request, response);
		//	response.sendRedirect("error.jsp");
		} else {
			/** If user name is unique, insert data into database */
			registration.registerUser(userName, firstName, lastName, telNumber, email, address, birthDate, gender, registrationDate, password, MySqlConnectDAO.mysqlConnect());
			/** Set session for current user */
			session.setAttribute("getSession", userName);
			session.setAttribute("arraylist", list);
			dsp.forward(request, response);
		}
		
	}

}
