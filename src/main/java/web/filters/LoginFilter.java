package web.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import database.Queries;
import domain.User;


@WebFilter("/login")
public class LoginFilter implements Filter {


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<link rel='stylesheet' type='text/css' href='/style.css' />");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		try {
			Queries query = new Queries();
			
			if(query.checkLogin( username , password )) {
				
				HttpSession session = httpRequest.getSession();
					
				session.setAttribute( "username", username );
				session.setAttribute( "password", password );
				session.setAttribute( "email"   , query.checkUserEmail( username, password ));
				session.setAttribute( "userRole", query.checkUserRole( username, password ));
				setUserFromSession( ( HttpServletRequest ) request );
				
				chain.doFilter( request , response );
			}else {
				out.println( "Sprawdz czy poprawnie wprowadzi³eœ dane." );
				out.println( buttonRebackToWebLogin() );						
			}
		
			query.closeConnecttion();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	private  String buttonRebackToWebLogin() {
		return "<br/> <br/><button onclick=\"location.href='/login.jsp';\" type=\"button\"> Wróæ do strony</button> ";
	}
	
	private void  setUserFromSession(HttpServletRequest request) {
		

		HttpServletRequest httpRequest =  request;
		HttpSession session = httpRequest.getSession();
		
		String name 	= (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");
		String email 	= (String) session.getAttribute("email");
		String userRole = (String) session.getAttribute("userRole");
		
		User currentUser = new User( name, password, email, userRole );
	}


	public void destroy() {
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
