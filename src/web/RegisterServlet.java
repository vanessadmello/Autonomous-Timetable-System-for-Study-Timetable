package web;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import dao.RegisterDao;


public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private RegisterDao registerdao;
	
	public void init() {
		registerdao = new RegisterDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Login login = new Login();
		login.setEmail(email);
		login.setPassword(password);
	        
		try {
			if (registerdao.register(login)!=0) {
				int sid=registerdao.getSID(login);
                if(sid!=0) {
                	HttpSession session= request.getSession();
                	session.setAttribute("pass_sid", sid);
                	response.sendRedirect("StudentDetails.jsp");
                /*	request.setAttribute("pass_sid",sid);
                	RequestDispatcher rd = request.getRequestDispatcher("/StudentDetails");
                	rd.forward(request,response);*/ 
                }
			} else {
	        	HttpSession session = request.getSession();
	        	session.setAttribute("user", email);
	        	response.sendRedirect("Register.jsp");
	        }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}    
	}
}