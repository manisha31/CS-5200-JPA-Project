package mymealServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mymealDAO.CustomerDAO;
import mymealDTO.Customer;
import mymealDTO.Restaurant;

/**
 * Servlet implementation class Customer
 */
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CustomerDAO customerDAO = new CustomerDAO();
    List<CustomerServlet> allCustomers = new ArrayList<CustomerServlet>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		try {
//			allCustomers = customerDAO.getAllCustomer();
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("The no of customers recieved : "+ allCustomers.size());
		request.getRequestDispatcher("/login.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session1 = request.getSession(false);
		System.out.println("Getting a call");
		String target = "";
		if(null != session1){
			//session.setAttribute("loggedUser", c);
			target = (String) request.getParameter("target");
		}
		if(request.getParameter("SignUpSubmit") != null){
			System.out.println("Getting a call from button : SignUPSubmit");
			CustomerDAO customerDAO = new CustomerDAO();
			List<Customer> allCustomer = null;
			
			try {
				allCustomer = customerDAO.getAllCustomer();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String user_name = request.getParameter("user_name");
	    	  String pwd = request.getParameter("password");
	    	  String first_name = request.getParameter("first_name");
	    	  String last_name = request.getParameter("last_name");
	    	  String email = request.getParameter("email");
	    	  String address = request.getParameter("address");
	    	  String phone_no = request.getParameter("phone_no");
	    	  int entry_to_be_done = 0;
	    	  //if(allCustomer.size()!=0){
	    	  for(int i= 0; i< allCustomer.size();i++){
	    		  if(allCustomer.get(i).getUser_name().equals(user_name)){
	    			  entry_to_be_done=1;
	    			  session1.setAttribute("error_user", "User Name Already Exists");
	    			  request.getRequestDispatcher("SignUP.jsp").forward(request, response);
	    			  break;
	    		  }
	    	  }
	    	  //}
	    	  if(entry_to_be_done == 0){
	    		  Customer customerAdd = new Customer();
    			  customerAdd.setUser_name(user_name);
    			  customerAdd.setPassword(pwd);
    			  customerAdd.setFirst_name(first_name);
    			  customerAdd.setLast_name(last_name);
    			  customerAdd.setEmail(email);
    			  customerAdd.setAddress(address);
    			  customerAdd.setPhone_no(phone_no);
    			  customerDAO.insert(customerAdd);
    			  session1.setAttribute("error_msg", "User Added !");
    			  System.out.println("Adding a new customer");
    			  request.getRequestDispatcher("login.jsp").forward(request, response);
	    	  }
			
		}
		
	

		} 
		
	}


