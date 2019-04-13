package web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/menu")
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
        String userRole = (String) session.getAttribute("userRole");
        
        out.println( "<link rel='stylesheet' type='text/css' href='/style.css' />" );
		out.println( "Wybierz co chcia³byœ sprawdziæ. <br/> <br/> <br/>" );
		
   
		switch(userRole) {
		case "user": 	out.println( buttonUserProfile() );
					 	out.println( buttonRebackToWebLogin() );
		break;
		
		case "premiumUser": out.println( buttonUserProfile() );
							out.println( buttonPremiumWebPage() );
							out.println( buttonRebackToWebLogin() );
		break;
		
		case "admin": 	out.println( buttonUserProfile() );
						out.println( buttonPremiumWebPage() );
						out.println( buttonAllUsers() );
						out.println( buttonChangeAccess() );
						out.println( buttonRebackToWebLogin() );
						
		break;

		}
	}
	
	
	private  String buttonUserProfile() {
		return " <br/> <br/><button onclick=\"location.href='/userProfile';\" type=\"button\"> Poka¿ profil</button> ";
	}
	
	private  String buttonAllUsers() {
		return " <br/> <br/><button onclick=\"location.href='/allUsers';\" type=\"button\"> Poka¿ wszystkich </button> ";
	}
	private  String buttonPremiumWebPage() {
		return " <br/> <br/><button onclick=\"location.href='/premium.jsp';\" type=\"button\"> Wejdz na stronê premium </button> ";
	}

	private  String buttonChangeAccess() {
		return " <br/> <br/><button onclick=\"location.href='/access.jsp';\" type=\"button\"> Zmienñ uprawnienia </button> ";
	}
	
	private  String buttonRebackToWebLogin() {
		return " <br/> <br/><button onclick=\"location.href='/login.jsp';\" type=\"button\"> Wróæ do strony logowania</button> ";
	}
	
}
