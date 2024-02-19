package com.ums.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/ums";
	static final String USER = "root";
	static final String PASS = "root";
	static final String GETLOGININFO = "Select * from signup_credentials where email= ? and password= ? ;";
	
	public Connection getCon()  {
		Connection con=null;
		  try {
			  Class.forName(JDBC_DRIVER);
			  con=DriverManager.getConnection(DB_URL, USER, PASS);
		  }catch(SQLException | ClassNotFoundException e) {}
		
		return con;
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();
		try(Connection con=getCon();
				PreparedStatement ps=con.prepareStatement(GETLOGININFO)){
		      ps.setString(1, email);
		      ps.setString(2,password);
		  ResultSet rs=    ps.executeQuery();
		  RequestDispatcher rd =null;
		  if(rs.next()) {
			  session.setAttribute("name", rs.getString("name"));
			rd=  req.getRequestDispatcher("/list");  
		  }else {
			  req.setAttribute("status", "failed");
			  rd=  req.getRequestDispatcher("login.jsp");  
		  }
		  rd.forward(req, resp);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
