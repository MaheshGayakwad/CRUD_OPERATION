package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.SignUpBO;
import dao.SignDao;


/**
 * Servlet implementation class ShowController
 */
@WebServlet("/ShowController")
public class ShowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		
		ArrayList<SignUpBO> al = SignDao.showUsers();
		
		
		pw.print("<link rel='stylesheet' href='style.css' />");
		
		pw.print("<table border = '1px solid black' width = '100%'>");
		
		pw.print("<tr class = 'one'><th>ID</th><th>Name</th><th>Email</th><th>Phone</th><th>city</th><th>Country</th></tr>");
		
		for(SignUpBO i : al) {
			
			pw.print("<tr><th>"+i.getId()+"</th><th>" +i.getName()+"</th><th>"+i.getEmail()+"</th><th>"+i.getPhone()+"</th><th>"+i.getCity()+"</th><th>"+i.getCountry()+"</th><th><a href = 'UpdateController?id= "+i.getId()+"'>Edit</a></th><th><a href = 'DeleteController?id= "+i.getId()+"'>Delete</a></th></tr>");
			
			
		}
		
		
		pw.print("</table>");
		
		
		
	}

}
