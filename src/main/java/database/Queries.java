package database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.servlet.http.HttpServletResponse;

import domain.User;

public class Queries {

	    private Connection connection;
	    private Statement statement;

	    
	    
	    public Queries() throws SQLException, ClassNotFoundException {
	        
	    	try {
				Class.forName("org.hsqldb.jdbc.JDBCDriver");
				
				Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/", "sa", "");
				Statement statement = connection.createStatement();
				
				this.connection =connection;
				this.statement= statement;
							
	    	} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	    
	    
	    public void closeConnecttion () throws SQLException {
	    	this.statement.close();
	         this.connection.close();
	    }
	
	    
	    
	    public void insertUser(User newUser) throws  SQLException {
	      
	        this.statement.executeUpdate("INSERT INTO user (id_user, username, password, email, userrole) "
	        		+ "VALUES (NULL, '"+ newUser.getUsername()+"', '"+ newUser.getPassword()+"','"+ newUser.getEmail()+"', 'user')");
	       
	    }
	    
	    public boolean checkLogin (String username, String password) throws SQLException {
	    	
	    	boolean checkData= false;
	   
	    	ResultSet resultSet = this.statement.executeQuery("SELECT username, password FROM user WHERE username ='"
	    	+ username + "'and password ='"+ password + "'");
	    	
	    	while(resultSet.next()) {
	    		if( username.equals(resultSet.getString("username")) & password.equals(resultSet.getString("password")) ){
	    			checkData= true;
	    		}
	    	}
	    	return checkData;
	    }
	    
	    public String checkUserRole(String username,String password) throws SQLException{
	    	
	    	String userRole = null;
	      	ResultSet resultSet = this.statement.executeQuery("SELECT username, password, userRole FROM user WHERE username ='"
	    	    	+ username + "'and password ='"+ password + "'");
	    	    	
	    	    	while(resultSet.next()) {
	    	    		if( username.equals(resultSet.getString("username")) & password.equals(resultSet.getString("password")) ){
	    	    			userRole = resultSet.getString("userRole");
	    	    		}else {
	    	    			userRole="something go wrong";
	    	    		}
	    	    	}
	    	return userRole;
	    }
	    
	    public String checkUserEmail(String username,String password) throws SQLException{
	    	
	    	String userEmail = null;
	      	ResultSet resultSet = this.statement.executeQuery("SELECT* FROM user WHERE username ='"
	    	    	+ username + "'AND password ='"+ password + "'");
	    	    	
	    	    	while(resultSet.next()) {
	    	    		if( username.equals(resultSet.getString("username")) & password.equals(resultSet.getString("password")) ){
	    	    			userEmail = resultSet.getString("email");
	    	    		}else {
	    	    			userEmail ="something go wrong";
	    	    		}
	    	    	}
	    	return userEmail;
	    }
	    
	    public boolean checkIsTheUserAlreadyInDatabase(String user) throws SQLException {
	    	boolean checkUser=false;
	    	int i =0;
	    	
	    	Statement statement = this.connection.createStatement();
	    	ResultSet result = statement.executeQuery("SELECT username FROM user WHERE username ='" + user + "'"  );
	   		
	   		while(result.next()) i++;	
	   		if (i==0) checkUser = false;
	   		else checkUser= true;
	    			
	   		return checkUser;
	    }
	    
   
	    public void showAllData( HttpServletResponse response) throws SQLException, IOException {
	    		
	    	PrintWriter out = response.getWriter();
	    	
	        Statement statement = this.connection.createStatement();
	        ResultSet result = statement.executeQuery("SELECT * FROM user");
	        out.println("<table>");
	        while (result.next()) {
	        	out.println( "<tr> <td> " + result.getString("username") + " </td><td> " + result.getString("password") + 
	        			" </td><td> " + result.getString("email") + " </td><td> "  + result.getString("userrole") + "</td></tr>"  ); 
	        }
	        out.println("</table>");
	    }
	    
	    public void updateUserAccess(String username, String userRole ) throws SQLException {
	        Statement statement = this.connection.createStatement();
	        statement.executeUpdate("UPDATE user SET userRole = '"+ userRole +
	        		"' WHERE username =  '"+ username +"'");
	    }
	    
}



