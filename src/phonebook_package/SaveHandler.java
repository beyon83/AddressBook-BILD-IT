package phonebook_package;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
 * Servlet implementation class SaveAccount
 */
@WebServlet("/SaveHandler")
public class SaveHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Connection mysqlConnect = null;
	public static ArrayList<EditService> list = new ArrayList<>();
	
	public void init(ServletConfig config) {
		mysqlConnect = MySqlConnectDAO.mysqlConnect();
		System.out.println("init() from SaveHandler has been invoked.");
	}

	public void destroy() {
		try {
			mysqlConnect.close();
			System.out.println("destroy() from SaveHandler has been invoked.");
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
	//	String userName = request.getParameter("userName");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String telNumber = request.getParameter("tel");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String birthDate = request.getParameter("birthDate");
		String gender = request.getParameter("radioGroup");
		String registrationDate = dateFormat.format(date);
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		RequestDispatcher dsp = request.getRequestDispatcher("Account.jsp");
		
		String userName = (String)session.getAttribute("getSession");
		session.setAttribute("getSession", userName);
		session.setAttribute("arraylist", list);
		
		/** Instantiate registration object */
		EditService edit = new EditService();
		edit.editUser(userName, firstName, lastName, telNumber, email, address, birthDate, gender, registrationDate, password, mysqlConnect);
		
		dsp.forward(request, response);
	}

}
