package com.ums.controller;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/ums";
	static final String USER = "root";
	static final String PASS = "root";

	static final String INSERTINFO = "insert into signup_credentials(name,email,password) values(?,?,?)";
	public Connection getCon()  {
		Connection con=null;
		  try {
			  Class.forName(JDBC_DRIVER);
			  con=DriverManager.getConnection(DB_URL, USER, PASS);
		  }catch(SQLException | ClassNotFoundException e) {}
		
		return con;
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String repeatPassword = req.getParameter("repeatPassword");
		
		 if(password != null && repeatPassword != null) {
	            if(!password.equals(repeatPassword)) {
	            	 req.setAttribute("status", "invalid");
	            	 req.getRequestDispatcher("signup.jsp").forward(req, resp);
	            }
	        }

	    		try (Connection con=getCon();
	    				PreparedStatement ps=con.prepareStatement(INSERTINFO)){
	    			
	    			ps.setString(1, name);
	    			ps.setString(2, email);
	    			ps.setString(3, password);
	    			
	    			ps.executeUpdate();
	    			req.getRequestDispatcher("login.jsp").forward(req, resp);
	    			

	    		} catch (SQLException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	        
		

	}

}
