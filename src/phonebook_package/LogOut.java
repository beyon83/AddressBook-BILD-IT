package phonebook_package;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogOut
 */
@WebServlet("/LogOut")
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/** Create Dispatcher for including request from Contacts.jsp file */
		RequestDispatcher dispatcher = request.getRequestDispatcher("Contacts.jsp");
		dispatcher.include(request, response);
		
		/** Create a session object */
		HttpSession session = request.getSession();
		
		/** Create a Dispatcher for redirecting the user to the login.jsp page after logging out */
		RequestDispatcher dsp = request.getRequestDispatcher("login.jsp");
		session.invalidate(); // destroy session
		dsp.forward(request, response);
	}

}
