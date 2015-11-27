package com.market.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.market.beans.User;
import com.market.utils.UserUtils;

public class UserDaoImp implements UserDao {

	@Override
	public boolean addNewUser(User user) {
		// TODO Auto-generated method stub
		QueryRunner runner = UserUtils.getUtils().getQueryRunner();
		boolean result = false;
		try {
			runner.insert("insert into users values(null,?,?,?,?,?,?,?)", new BeanHandler<>(User.class), user.getUserName(),
					user.getPassword(), user.getManager(),user.getAddress(),user.getPhone(),user.getEmail(),user.getNickName());
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result = false;
		}
		runner = null;

		return result;
	}

	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		QueryRunner runner = UserUtils.getUtils().getQueryRunner();
		User user = new User();
		try {
			user = runner.query("select * from users where userName=?", new BeanHandler<>(User.class), name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (user == null) {
			user = new User();
		}
		runner = null;
		return user;
	}

	@Override
	public boolean changeUserInf(User user) {
		// TODO Auto-generated method stub
		QueryRunner runner = UserUtils.getUtils().getQueryRunner();
		System.out.println(user.toString());
		int result = 0;
		try {
			result = runner.update("update users set password=?,address=?,phone=?,email=?,nickname=? where id=? ",
	user.getPassword(),user.getAddress(),user.getPhone(),user.getEmail(),user.getNickName(),user.getId());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		runner = null;
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteUserByName(String name) {
		// TODO Auto-generated method stub
		QueryRunner runner = UserUtils.getUtils().getQueryRunner();
		int result = 0;
		try {
			result = runner.update("delete from users where username=?", name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		runner = null;
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Test
	public void test() {
		User user = new User();
		user.setUserName("wendy13144");
		user.setPassword("love201314");
		System.out.println(addNewUser(user));
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		QueryRunner runner = UserUtils.getUtils().getQueryRunner();
		List<User> users = new ArrayList<>();
		try {
			users = runner.query("select * from users", new BeanListHandler<>(User.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		runner = null;
		return users;
	}

	public void updateManager(User user) {
		// TODO Auto-generated method stub
		QueryRunner runner = UserUtils.getUtils().getQueryRunner();
		try {
			runner.update("update users set manager=? where username=?", user.getManager(), user.getUserName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testName() throws Exception {
		List<User> allUsers = getAllUsers();
		for (User user : allUsers) {
			System.out.println(user.toString());
		}
	}

}
