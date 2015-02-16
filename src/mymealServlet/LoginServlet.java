package mymealServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mymealDAO.CustomerDAO;
import mymealDTO.Customer;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("SignIn") != null){
		String username = (String)request.getParameter("userName");
		String password = (String)request.getParameter("password");
		CustomerDAO cd = new CustomerDAO();
		Customer c = cd.findByUsernameAndPassword(username, password);
		HttpSession session = request.getSession(false);
		if(c!=null){
			System.out.println("Customer found" + c.getFirst_name());
			String target = "";
			if(null != session){
				session.setAttribute("loggedUser", c);
				target = (String) request.getParameter("target");
			}
			switch(target){
			case "Book Table" : request.getRequestDispatcher("Booking.jsp").forward(request, response);
								break;
			case "Add Feedback" : request.getRequestDispatcher("Feedback.jsp").forward(request, response);
								break;
		}
		} else {
			System.out.println("Customer not found");
			String error_message = "Wrong User Name or Password";
			session.setAttribute("error_msg",error_message );
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		} else if(request.getParameter("SignUp") != null){
			request.getRequestDispatcher("SignUP.jsp").forward(request, response);
		}
	}

}
