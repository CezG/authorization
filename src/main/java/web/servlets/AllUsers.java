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


@WebServlet("/allUsers")
public class AllUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");		
		PrintWriter out = response.getWriter();
        out.println("<link rel='stylesheet' type='text/css' href='/style.css' />");
        
        Queries query;
		try {
			query = new Queries();
			query.showAllData(response);
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
     
	 	out.print( "<br/>" + buttonRebackToWeb() );
	}

	private  String buttonRebackToWeb() {
		return " <br/> <br/><button onclick=\"location.href='/menu';\" type=\"button\"> Wróæ do poprzedniej strony</button> ";
	}
	

}
