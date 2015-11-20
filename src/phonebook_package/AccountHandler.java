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
 * Servlet implementation class AccountHandler
 */
@WebServlet("/AccountHandler")
public class AccountHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Connection mysqlConnect = null;

	/** Create an static ArrayList filled with data from AccountService's class constructor */
	static ArrayList<AccountService> list1 = new ArrayList<>();
	
	public void init(ServletConfig config) throws ServletException {
		mysqlConnect = MySqlConnectDAO.mysqlConnect();
		System.out.println("init() from AccountHandler has been invoked.");
	}
	
	public void destroy() {
		try {
			mysqlConnect.close();
			System.out.println("destroy() from AccountHandler has been invoked.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		/** Create sessions object for user and for ArrayList */
		HttpSession sessionUser = request.getSession();
		HttpSession sessionList = request.getSession();
		
		/** Create an Dispatcher object to redirect user */
		RequestDispatcher dispatcher = request.getRequestDispatcher("Account.jsp");
		
		/** Instantiate AccountService constructor */
		AccountService accountService = new AccountService();
		
		/** Obtain session for current user, and cast it into String */
		String userName = (String)sessionUser.getAttribute("getSession");
		/** Call getAccountInfo() method and pass session user to its argument */
		accountService.getAccountInfo(userName, mysqlConnect);
		
		/** Set a new session for array list, for further use in Account.jsp file using the ${arraylist} expression */
		sessionList.setAttribute("arraylist", list1);
		
		/** Redirect to the Account.jsp file */
		dispatcher.forward(request, response);
		list1.clear();
		
	}

}
