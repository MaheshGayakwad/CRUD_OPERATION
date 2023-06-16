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
 * Servlet implementation class UpdateFinalController
 */
@WebServlet("/UpdateFinalController")
public class UpdateFinalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFinalController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
	String name =	request.getParameter("name");
	String email =	request.getParameter("email");
	String pass =	request.getParameter("pass");
	String phone =	request.getParameter("phone");
	String city =	request.getParameter("city");
	String country =request.getParameter("country");
	String sid = request.getParameter("id");	
	String tr = sid.trim();
	Integer id = Integer.parseInt(tr);
	
	
	
	SignUpBO si = new SignUpBO();	
	
	si.setId(id);
	si.setName(name);
	si.setEmail(email);
	si.setPassword(pass);
	si.setPhone(phone);
	si.setCity(city);
	si.setCountry(country);
	
	int status = SignDao.update(si);
	
	if (status > 0) {
		
		response.sendRedirect("ShowController");
		
	}else {
		pw.print("Sorry something went wrong");
	}
	
	
	}

}
