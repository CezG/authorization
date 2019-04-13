package web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import database.Queries;
import domain.User;

@WebServlet("/registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		User newUser = registerNewUser(request);
		PrintWriter out = response.getWriter();
		out.println("<link rel='stylesheet' type='text/css' href='/style.css' />");
		
		 try {
	            Queries query = new Queries();
	            
	            boolean checkUser = query.checkIsTheUserAlreadyInDatabase( newUser.getUsername() );
	            if(checkUser) {
	            
	            	out.println(" Nazwa u¿ytkownika jest zajêta <br/>" );
		            out.println( buttonRebackToWebRegistration());
		            
	            }else {
	            query.insertUser(newUser);
	            
	            query.closeConnecttion();
	            out.println("Dziêkuje za rejestracje: " + newUser.getUsername() + "<br/>" );
	            out.println( buttonRebackToWebLogin());
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {	
	            e.printStackTrace();
	        } 
	}
	
	private  String buttonRebackToWebLogin() {
		return "<br/> <br/><button onclick=\"location.href='/login.jsp';\" type=\"button\"> Wróæ do strony</button> ";
	}	
	
	private  String buttonRebackToWebRegistration() {
		return "<br/> <br/><button onclick=\"location.href='/index.jsp';\" type=\"button\"> Wróæ do strony</button> ";
	}	
	
	private User registerNewUser(HttpServletRequest request) {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String userRole = request.getParameter("userRole");
		
		User user = new User(username, password, email, userRole);
		
		return user;
	}

}
