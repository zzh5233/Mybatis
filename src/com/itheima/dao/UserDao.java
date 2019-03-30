package com.itheima.dao;

import java.util.List;

import com.itheima.domain.User;

/**
 * User的持久化接口
 * @author zzh
 *
 */
public interface UserDao {

	public void addUser(User user) throws Exception;
	
	public void deleteUser(int id) throws Exception;
	
	public void updateUser(User user) throws Exception;
	
	public User findUserById(int id) throws Exception;
	
	public List<User> findUserByName(String name) throws Exception;
	
}
