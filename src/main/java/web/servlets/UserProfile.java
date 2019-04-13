package web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/userProfile")
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		response.setContentType("text/html");		
		PrintWriter out = response.getWriter();
        out.println("<link rel='stylesheet' type='text/css' href='/style.css' />");
        
		HttpSession session = request.getSession();
			
		String username = 	(String) session.getAttribute("username");
	 	String password = 	(String) session.getAttribute("password");
	 	String email 	= 	(String) session.getAttribute("email");	        
	 	String userRole = 	(String) session.getAttribute("userRole");
	 	
	 	out.println("<table>");
	 	out.println("<tr><td> User name </td> <td>" + username 	+ "</td></tr>");
	 	out.println("<tr><td> Password 	</td> <td>" + password 	+ "</td></tr>");
	 	out.println("<tr><td> Email 	</td> <td>" + email 	+ "</td></tr>");
	 	out.println("<tr><td> User role </td> <td>" + userRole 	+ "</td></tr>");	 	
	 	out.println("</table>");

	 	out.print( buttonRebackToWeb() );
	}

	private  String buttonRebackToWeb() {
		return " <br/> <br/><button onclick=\"location.href='/menu';\" type=\"button\"> Wróæ do poprzedniej strony</button> ";
	}
}
