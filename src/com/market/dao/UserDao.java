package com.market.dao;

import java.util.List;

import com.market.beans.User;

public interface UserDao {
	public boolean addNewUser(User user);

	public User getUserByName(String name);

	public boolean changeUserInf(User user);

	public boolean deleteUserByName(String name);
	public List<User> getAllUsers();
	public void updateManager(User user);

}
