package com.market.service;

import java.util.Map;

import com.market.beans.User;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public interface UserService {
	/**
	 * 根据用户名和密码登陆
	 * @param userName
	 * @param password
	 * @return返回结果集合
	 */
	public Map<String, Object> login(String userName, String password);
	/**
	 * 根据传入一个用户来注册用户
	 * 
	 * @return返回结果集合
	 */
	public Map<String, Object> register(User user);
	/**
	 * 根据用户名删除用户
	 * @param userName
	 * @param password
	 * @return返回结果集合
	 */
	public Map<String, Object> deleteUserByUserName(String userName);
	/**
	 * 更新用户的信息
	 * @param userName
	 * @param password
	 * @return返回结果集合
	 */
	public Map<String, Object> updateUserInformation(User user);
	/**
	 * 获取所有的用户
	 * @param userName
	 * @param password
	 * @return返回结果集合
	 */
	public java.util.List<User> getAllUsers();
	/**
	 * 授权管理
	 * @param userName
	 * @param password
	 * @return返回结果集合
	 */
	public boolean updateManager(User user);
}
