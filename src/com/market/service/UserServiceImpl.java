package com.market.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.market.beans.User;
import com.market.dao.UserDao;
import com.market.dao.UserDaoImp;
import com.market.utils.UserUtils;

public class UserServiceImpl implements UserService {
	private static UserDao userDao;

	static {
		userDao = new UserDaoImp();
	}

	@Override
	public Map<String, Object> login(String userName, String password) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		// ����
		User loginUser = haseTheUser(userName);
		if (loginUser.getId() > 0) {
			// ˵���и��û�
			if (loginUser.getPassword().equals(password) || loginUser.getPassword() == password) {
				// ˵��������ȷ�����û���BEAN������������
				System.out.println("ok");
				result.put(UserInf.LOGIN_USER_BEAN, loginUser);
				System.out.println("--------");
				result.put(UserInf.LOGIN_PASSWORD_RIGHT, true);
				result.put(UserInf.LOGIN_HASE_USER, true);
			} else {
				// ˵�����벻��
				result.put(UserInf.LOGIN_PASSWORD_RIGHT, false);
			}
		} else {
			// ˵��û�и��û�
			System.out.println("------");
		}

		return result;
	}

	/**
	 * 
	 * @param userName
	 * @return
	 */
	public User haseTheUser(String userName) {
		User user;
		user = userDao.getUserByName(userName);
		return user;
	}

	@Override
	public Map<String, Object> register(User user) {
		Map<String, Object> resut = new HashMap<>();
		User ishase = haseTheUser(user.getUserName());
		if (ishase.getId() <= 0) {
			// ˵��û�и��û�
			resut.put(UserInf.REGISTER_USER_NOTEXIT, true);
			// ִ���û����������ƣ�����С��6���ַ���Ҳ�����Դ���20���ַ�
			if (user.getUserName().length() >= 1 && user.getUserName().length() <= 20) {
				// ˵���û������Ⱥϸ�
				resut.put(UserInf.REGISTER_USERNAME_LENGTH, true);
				if (user.getPassword().length() >= 1) {// ˵�����볤�Ⱥϸ񣬿���ע��
					resut.put(UserInf.REGISTER_USERNAME_INF, userDao.addNewUser(user));
					resut.put(UserInf.REGISTER_PASSWORD_LENGTH, true);
				} else {
					// ���볤�Ȳ��ϸ�
					resut.put(UserInf.REGISTER_USERNAME_INF, false);
					resut.put(UserInf.REGISTER_PASSWORD_LENGTH, false);
				}

			} else {
				// ˵���û������Ȳ��ϸ�
				resut.put(UserInf.REGISTER_USERNAME_INF, false);
				resut.put(UserInf.REGISTER_USERNAME_LENGTH, false);
			}
		} else {
			// ˵�����û��Ѵ���
			resut.put(UserInf.REGISTER_USERNAME_INF, false);
			resut.put(UserInf.REGISTER_USER_NOTEXIT, false);
		}

		return resut;
	}

	@Override
	public Map<String, Object> deleteUserByUserName(String userName) {
		Map<String, Object> result = new HashMap<>();
		// ����
		User loginUser = haseTheUser(userName);
		if (loginUser.getId() > 0) {
			// ˵���и��û�,ִ��ɾ��
			result.put(UserInf.DELETE_HASE_USER, true);
			result.put(UserInf.DELETE_USER, userDao.deleteUserByName(userName));
		} else {
			// ˵��û�и��û�
			result.put(UserInf.DELETE_HASE_USER, false);
		}
		return result;
	}

	@Override
	public Map<String, Object> updateUserInformation(User user) {
		Map<String, Object> result = new HashMap<>();
		// ����
		 userDao.changeUserInf(user);

		return result;
	}

	@Test
	public void test() {
		User user = new User();
		user.setUserName("Wendy201314");
		user.setPassword("love201314");
		print(register(user));
	}

	public void print(Map<String, Object> result) {
		System.out.println(result.size());
		for (String key : result.keySet()) {
			System.out.println("key= " + key + " and value= " + result.get(key));
		}
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllUsers();
	}

	@Override
	public boolean updateManager(User user) {
		// TODO Auto-generated method stub
		
		userDao.updateManager(user);
		
		
		return true;
	}

}
