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
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		 String sid = request.getParameter("id");
		
		 String trimmed = sid.trim();
		 
		 Integer id = Integer.parseInt(trimmed);
		 
		 
		 SignUpBO si = SignDao.getEmployeebyId(id);
		 
		 
		 
		 
		 pw.print("<link rel='stylesheet' href='update.css' />");
			
		 pw.print("<h1>Update Details</h1>");
		 
		 
		pw.print("<form action = 'UpdateFinalController'>");
		
		
		pw.print("<input type = 'hidden' value = "+si.getId()+" name = 'id'>");
		
		pw.print("<input type = 'text' value = "+si.getName()+" name = 'name'>");
		
		pw.print("<input type = 'text' value = "+si.getEmail()+" name = 'email'>");
		
		pw.print("<input type = 'password' value = "+si.getPassword()+" name = 'pass'>");
		
		pw.print("<input type = 'text' value = "+si.getPhone()+" name = 'phone'>");
		
		pw.print("<input type = 'text' value = "+si.getCity()+" name = 'city'>");
		
		
		
		pw.print("<input type = 'text' value = "+si.getCountry()+" name = 'country'>");
		
		
		pw.print("<input type = 'submit' value = 'Edit and save'>");
		
		
		pw.print("</form>");
		 
	
		 
		 
		
	}

	
	

}
