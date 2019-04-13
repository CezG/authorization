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



@WebServlet("/userAccess")
public class UserAcces extends HttpServlet {
	private static final long serialVersionUID = 1L;
       



	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<link rel='stylesheet' type='text/css' href='/style.css' />");
		
		try {
			changeUserAccess(request, response);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
private void changeUserAccess ( HttpServletRequest request, HttpServletResponse response ) throws ClassNotFoundException, SQLException, IOException {
		
		PrintWriter out = response.getWriter();	
	
		String username = request.getParameter( "username" );
		String userRole = request.getParameter( "userRole" );
		
		Queries query = new Queries();
		boolean checkUser = query.checkIsTheUserAlreadyInDatabase(username);
		
		if (checkUser) {
			query.updateUserAccess(username, userRole);
			out.println("Zmieniono uprawnienia u¿ytkownika \"" + username + "\" na " + userRole);
			out.println( buttonRebackToWebAcces() );
			out.println( buttonRebackToWebMenu() );
		}else {
			out.println("Niepoprawna nazwa u¿ytkownika. ");
			out.println( buttonRebackToWebAcces() );
		}	
	}

private  String buttonRebackToWebMenu() {
	return " <br/> <br/><button onclick=\"location.href='/menu';\" type=\"button\"> Wróæ do Menu</button> ";
}

private  String buttonRebackToWebAcces() {
	return " <br/> <br/><button onclick=\"location.href='access.jsp';\" type=\"button\"> Wróæ do poprzedniej strony </button> ";
}


}
