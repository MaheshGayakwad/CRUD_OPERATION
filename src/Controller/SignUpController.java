package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.SignUpBO;
import dao.SignDao;

/**
 * Servlet implementation class SignUpController
 */
@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SignUpController() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String pass = request.getParameter("pass");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		
		SignUpBO bo = new SignUpBO(name, email, phone, pass, city, country);
		
		int status = SignDao.registerUser(bo);
		
		if (status > 0) {
			
			response.sendRedirect("index.html");
			
		}else {
			pw.print("Galat");
		}
		
		
		
	}

}
