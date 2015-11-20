package phonebook_package;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteHandler
 */
@WebServlet("/DeleteHandler")
public class DeleteHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Connection mysqlConnect = null;
	
	public void init(ServletConfig config) throws ServletException {
		mysqlConnect = MySqlConnectDAO.mysqlConnect();
		System.out.println("init() from DeleteHandler has been invoked.");
	}
	
	public void destroy() {
		try {
			mysqlConnect.close();
			System.out.println("destroy() from DeleteHandler has been invoked.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dsp = request.getRequestDispatcher("Contacts.jsp");
		
		HttpSession session = request.getSession();
		
		String userName = (String)session.getAttribute("getSession");
		
		DeleteService deleteAccount = new DeleteService();
		deleteAccount.deleteAccount(userName, mysqlConnect);
		
		session.invalidate();
		dsp.forward(request, response);
		
	}

}
