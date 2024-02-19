package com.ums.daoimpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ums.dao.UserDao;
import com.ums.model.User;

public class UserDaoImpl implements UserDao{
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/ums";

	static final String USER = "root";
	static final String PASS = "root";

	static final String GETALLINFO = "Select * from user";
	static final String INSERTINFO = "insert into user(name,email,address) values(?,?,?)";
	static final String DELETEINFO = "delete from user where id=?;";
	static final String EDITBYID = "select * from user where id=?;";
	static final String UPDATEINFO = "update  user set name=?, email=?, address=? where id=?;";
    
	public Connection getCon()  {
		Connection con=null;
		  try {
			  Class.forName(JDBC_DRIVER);
			  con=DriverManager.getConnection(DB_URL, USER, PASS);
		  }catch(SQLException | ClassNotFoundException e) {}
		
		return con;
	}
	public List<User> getAllUser() {
		List<User> allUser= new ArrayList<>();
		    try(Connection con=getCon();
		    		PreparedStatement ps = con.prepareStatement(GETALLINFO)){
		    	  ResultSet rs= ps.executeQuery();
		    	  while(rs.next()) {
		    		  int id= rs.getInt("id");
		    		 String name=rs.getString("name");
		    		 String email=rs.getString("email");
		    		 String address=rs.getString("address");
		    		 allUser.add(new User(id,name,email,address));
		    	  }
		    } catch (SQLException e) {
				
				e.printStackTrace();
			}
		return allUser;
	}
	
	public void insertUser(User user) {
		try(Connection con=getCon();
				PreparedStatement  ps= con.prepareStatement(INSERTINFO);){
			
			String name=user.getName();
			String email=user.getEmail();
			String address= user.getAddress();
			
			ps.setString(1,name);
			ps.setString(2,email);
			ps.setString(3,address);
			ps.executeUpdate();
					
			
		} catch (SQLException e) {e.printStackTrace();}
		
		
	}
	@Override
	public void deleteUser(int id) {
		try(Connection con=getCon();
				PreparedStatement  ps= con.prepareStatement(DELETEINFO);){
			
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	@Override
	public User editUser(int id) {
		User user=null;
		try(Connection con = getCon();
				PreparedStatement ps= con.prepareStatement(EDITBYID)){
			
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				String name=rs.getString("name");
				String email=rs.getString("email");
				String address=rs.getString("address");
				user= new User(id, name, email, address);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public void updateUser(User user) {
		try(Connection con = getCon();
				PreparedStatement ps= con.prepareStatement(UPDATEINFO)){
			ps.setString(1,user.getName());
			ps.setString(2,user.getEmail());
			ps.setString(3,user.getAddress());
			ps.setInt(4,user.getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
