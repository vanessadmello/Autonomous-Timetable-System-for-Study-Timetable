package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import scheduler.*;

public class TimetableServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private TimetableAction TB;
	
	public void init() {
       TB  = new TimetableAction();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException{
		
		//preference
		//database
		//input data
		
		
		Chromosome son = TB.fromFile();
		HttpSession session = request.getSession();
        session.setAttribute("son", son);
        response.sendRedirect("timetable.jsp");
	}

}
