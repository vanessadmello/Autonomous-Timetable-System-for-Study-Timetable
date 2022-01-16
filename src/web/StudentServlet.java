package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Studentdao;
import model.Student;


public class StudentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private Studentdao Studentdao;

    public void init() {
    	Studentdao = new Studentdao();
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
    	
    	HttpSession session= request.getSession();
		int newsid=(int) session.getAttribute("pass_sid");
	    	
	   	String firstName = request.getParameter("firstName");
	   	String lastName = request.getParameter("lastName");
	   	String collegename = request.getParameter("collegeName");
	   	String contact = request.getParameter("contact");
	        
	   	Student student = new Student();
	   	student.setSID(newsid);
	   	student.setFirstName(firstName);
	   	student.setLastName(lastName);
	   	student.setCollegeName(collegename);
	   	student.setContact(contact);

	   	try {
	   		if(Studentdao.registerStudent(student)!=0) {
	   			response.sendRedirect("SubjectDetails.jsp");
	        }
	        else {
	        	response.sendRedirect("Register.jsp");
	        }
	            
	   	} catch (Exception e) {
	           
	   		e.printStackTrace();
	    }
	}
}