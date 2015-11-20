package phonebook_package;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletHandler
 */
@WebServlet("/LoginHandler")
public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
	
	/** Create ArrayList for users */
	public static ArrayList<Contacts> list = new ArrayList<>();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/** Clear list to prevent duplicate items */
		list.clear();
		
		/** Get username and password from "login.jsp" page */
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		/** Create session objects */
		HttpSession session = request.getSession();
		HttpSession sessionList = request.getSession();
		
		/** Create Dispatcher objects for redirect */
		RequestDispatcher contacts  = request.getRequestDispatcher("Contacts.jsp");
		RequestDispatcher loginIndex = request.getRequestDispatcher("login.jsp");
		
		/** Instantiate LoginService object */
		LoginService login = new LoginService();
		/** Instantiate Contacts object */
		Contacts contactsObject = new Contacts();
		/** Invoke fetchContacts() method to obtain users from database */
		contactsObject.fetchContacts(MySqlConnectDAO.mysqlConnect());
		
		/** Check if username and password matches to the user's input */
		boolean checkLogin = login.authenticateUser(userName, password, MySqlConnectDAO.mysqlConnect());
		
		if(checkLogin == true) {
			/** Set session attribute for username */
			session.setAttribute("getSession", userName);
			/** Set session attribute for ArrayList */
			sessionList.setAttribute("arraylist", list);
			contacts.forward(request, response); // redirect to the "Contacts.jsp" page
			list.clear(); // clear the list
		} else {
			/** Set session attribute for wrong input */
			request.setAttribute("errorMessage", LoginService.getError());
			loginIndex.forward(request, response); // redirect to the "login.jsp" page
		}
	}

}
