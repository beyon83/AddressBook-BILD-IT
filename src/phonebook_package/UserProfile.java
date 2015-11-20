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
 * Servlet implementation class UserProfile
 */
@WebServlet("/UserProfile")
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Connection mysqlConnect = null;
	public static ArrayList<AccountService> list = new ArrayList<>();
	
	public void init(ServletConfig config) throws ServletException {
		mysqlConnect = MySqlConnectDAO.mysqlConnect();
		System.out.println("init() from UserProfile has been invoked.");
	}
	
	public void destroy() {
		try {
			mysqlConnect.close();
			System.out.println("destroy() from UserProfile has been invoked.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		list.clear();
		
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = request.getRequestDispatcher("Account.jsp");
		
		String userName = request.getParameter("userName");
		System.out.println("User account clicked: " + userName);
		
		/** Instantiate AccountService constructor */
		AccountService accountService = new AccountService();
		accountService.getAccountInfo(userName, mysqlConnect);
		
		session.setAttribute("arraylist", list);
		dispatcher.forward(request, response);
		
	}

}
