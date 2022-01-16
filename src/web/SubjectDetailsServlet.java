package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SubjectDetails;
import dao.SubjectDetailsDao;

public class SubjectDetailsServlet extends HttpServlet{
    
	private static final long serialVersionUID = 1L;
	private SubjectDetailsDao SubjectDao;

    public void init() {
        SubjectDao = new SubjectDetailsDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	HttpSession session= request.getSession();
		int newsid=(int) session.getAttribute("pass_sid");
		
    	int n = Integer.parseInt(request.getParameter("subjectno"));
    	for(int i=1;i<=n;i++) {

    		String subject = request.getParameter("s"+i);
            int module = Integer.parseInt(request.getParameter("m"+i));
            int no_of_hours = Integer.parseInt(request.getParameter("h"+i));
            
            SubjectDetails subjectmodule = new SubjectDetails();
            subjectmodule.setSID(newsid);
            subjectmodule.setSubject(subject);
            subjectmodule.setModule(module);
            subjectmodule.setHours(no_of_hours);
            try {
				if(SubjectDao.getDetails(subjectmodule)!=0) {
					continue;
				}else {
					break;
				}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
        response.sendRedirect("difficulty.jsp");
    }
}
