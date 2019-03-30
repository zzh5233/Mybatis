package com.itheima.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.domain.User;
import com.itheima.domain.UserCustom;
import com.itheima.domain.UserQueryVo;
import com.itheima.mapper.UserMapper;

public class UserMapperTest {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws Exception {
		//mybatis的配置文件
		String resource = "config/SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建会话工厂，传入mybatis的配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserList2() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//创建包装对象，设置查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
	
		//使用了动态sql，不设置某个值，条件就不会拼接到sql中
		userCustom.setUsername("zz");
		//传入多条id
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		
		userQueryVo.setUserCustom(userCustom);
		
		List<UserCustom> list = userMapper.findUserList2(userQueryVo);
		
		for(UserCustom uc: list) {
			System.out.println(uc);
		}
	}
	@Test
	public void testFindUserList() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//创建包装对象，设置查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		//使用了动态sql，不设置某个值，条件就不会拼接到sql中
		userCustom.setId(1);
		userCustom.setUsername("zz");
		userQueryVo.setUserCustom(userCustom);
		
		List<UserCustom> list = userMapper.findUserList(userQueryVo);
		
		for(UserCustom uc: list) {
			System.out.println(uc);
		}
	}
	@Test
	public void testFindUserCount() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//创建包装对象，设置查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		//userCustom.setId(1);
		userCustom.setUsername("zz");
		userQueryVo.setUserCustom(userCustom);
		
		int count = userMapper.findUserCount(userQueryVo);
		
		System.out.println(count);
	}
	
	@Test
	public void findUserByIdResultMap() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User user = userMapper.findUserByIdResultMap(1);
		
		System.out.println(user);
	}
	
	@Test
	public void testFindUserById() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User user = userMapper.findUserById(2);
		
		System.out.println(user);
	}
	@Test
	public void testFindUserByName() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		List<User> users = userMapper.findUserByName("zz");
		
		System.out.println(users);
	}

	@Test
	public void testQueryCountWithProcedure() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("sid",5);
		
		userMapper.queryCountWithProcedure(map);
		
		int count = (int) map.get("scount");
		
		System.out.println(count);
	}
	@Test
	public void testDeleteUserByIdWithProcedure() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("sid",8);
		
		userMapper.deleteUserByIdWithProcedure(map);
		//使用的事务是JDBC方式，增删改操作 需要手动的提交
		sqlSession.commit();
		
		System.out.println("删除成功");
	}
	
	
	
	
}
