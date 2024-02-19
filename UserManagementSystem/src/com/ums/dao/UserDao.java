package com.ums.dao;

import java.util.List;


import com.ums.model.User;

public interface UserDao {
  public  List<User> getAllUser();
  public void insertUser(User user);
  public void deleteUser(int id);
  public User editUser(int id);
  public void updateUser(User user);
}
