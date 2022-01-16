package web;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import dao.LoginDao;


public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Login login=new Login();
        login.setEmail(email);
        login.setPassword(password);

        try {
            if (loginDao.validate(login)) {
                int sid=loginDao.getSID(login);
                if(sid!=0) {
                	HttpSession session = request.getSession();
                	session.setAttribute("sid", sid);
                    response.sendRedirect("Timetable.jsp");
                }
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("user", email);
                response.sendRedirect("login.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}