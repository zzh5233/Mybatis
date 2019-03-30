package com.itheima.mapper;

import java.util.HashMap;
import java.util.List;

import com.itheima.domain.User;
import com.itheima.domain.UserCustom;
import com.itheima.domain.UserQueryVo;

public interface UserMapper {

	//调用存储过程查询id < sid（参数） 的用户数量
	public void queryCountWithProcedure(HashMap<String, Object> map);
	//调用存储过程，根据学号删除学生
	public void deleteUserByIdWithProcedure(HashMap<String, Object> map);
	
	//用户信息综合查询
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	//用户信息综合查询，增加了foreach循环带入的条件
	public List<UserCustom> findUserList2(UserQueryVo userQueryVo) throws Exception;
	
	//用户信息综合查询总数
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;
	
	//结果映射，查询的表名和属性名不一致时指定映射
	public User findUserByIdResultMap(int id) throws Exception;
	
	
	public void addUser(User user) throws Exception;
	
	public void deleteUser(int id) throws Exception;
	
	public void updateUser(User user) throws Exception;
	
	public User findUserById(int id) throws Exception;
	
	public List<User> findUserByName(String name) throws Exception;
}
