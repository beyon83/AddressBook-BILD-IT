package phonebook_package;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ContactsHandler
 */
@WebServlet("/ContactsHandler")
public class ContactsHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static ArrayList<Contacts> list = new ArrayList<>();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		list.clear();
		
		@SuppressWarnings("unused")
		HttpSession sessionUser = request.getSession();
		HttpSession sessionList = request.getSession();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Contacts.jsp");
		
		Contacts contacts = new Contacts();
		contacts.fetchContacts(MySqlConnectDAO.mysqlConnect());
		
		sessionList.setAttribute("arraylist", list);
		
		dispatcher.forward(request, response);
		list.clear();
		
	}

}
