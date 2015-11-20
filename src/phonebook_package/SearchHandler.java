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
 * Servlet implementation class SearchHandler
 */
@WebServlet("/SearchHandler")
public class SearchHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Connection mysqlConnect = null;
	
	public void init(ServletConfig config) throws ServletException {
		mysqlConnect = MySqlConnectDAO.mysqlConnect();
		System.out.println("init() from SearchHandler has been invoked.");
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#destroy()
	 */
	public void destroy() {
		try {
			mysqlConnect.close();
			System.out.println("destroy() from SearchHandler has been invoked.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Contacts> list = new ArrayList<>();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		list.clear();
		
		String query = request.getParameter("query");
		
		HttpSession sessionList = request.getSession();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("SearchResults.jsp");
		
		Contacts search = new Contacts();
		search.searchResults(query, MySqlConnectDAO.mysqlConnect());
		
		sessionList.setAttribute("arraylist", list);
		sessionList.setAttribute("query", query);
		
		dispatcher.forward(request, response);
	
	}

}
