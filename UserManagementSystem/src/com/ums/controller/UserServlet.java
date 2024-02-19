package com.ums.controller;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ums.daoimpl.UserDaoImpl;
import com.ums.model.User;

@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserDaoImpl udi;
       @Override
    public void init() throws ServletException {
    	udi=new UserDaoImpl();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		    String action = req.getServletPath();
		    switch(action) {
		    case "/list":
		    	getAllUser(req , resp);
				break;
		    case "/insert":
				insertUser(req, resp);
				break;
		    case "/delete":
				deleteUser(req, resp);
				break;
			case "/edit":
				editUser(req, resp);
				break;
			case "/update":
				updateUser(req, resp);
				break;
		    case "/register":
				registerUser(req, resp);
				break;
		    case "/loginForm":
				AdminLogin(req, resp);
				break;
		    case "/signupform":
				AdminSignup(req, resp);
				break;
		   
		    	
		    }
	}

	private void AdminLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.jsp").forward(req, resp);
		
	}
	private void AdminSignup(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("signup.jsp").forward(req, resp);
		
		
	}
	private void insertUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 String name= req.getParameter("name");
		  String email= req.getParameter("email");
		  String address= req.getParameter("address");
		  User insertUser= new User(name,email,address);
		  udi.insertUser(insertUser);
		  resp.sendRedirect("list");
		
	}
	private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 int id=Integer.parseInt(req.getParameter("id"));
		 String name= req.getParameter("name");
		  String email= req.getParameter("email");
		  String address= req.getParameter("address");
		  
		  User updateUser=new User(id,name,email,address);
		  udi.updateUser(updateUser);
		  resp.sendRedirect("list");
		
	}
	private void editUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		User editUser=udi.editUser(id);
		req.setAttribute("user1", editUser);
		req.getRequestDispatcher("updateForm.jsp").forward(req, resp);
		
	}
	private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		udi.deleteUser(id);
		resp.sendRedirect("list");
		
	}
	private void registerUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("userRegister.jsp").forward(req, resp);
		
	}
	private void getAllUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> user= udi.getAllUser();
		req.setAttribute("user", user);
		req.getRequestDispatcher("user.jsp").forward(req, resp);
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.doGet(req, resp);
	}

}
