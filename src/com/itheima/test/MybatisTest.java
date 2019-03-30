package com.itheima.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionManager;
import org.junit.Test;

import com.itheima.domain.User;

/**
 * 测试mybatis的CRUD
 * @author zzh
 */
public class MybatisTest {
	
	/**
	 * 通过Id查询用户信息
	 * @throws IOException
	 */
	@Test
	public void findUserByIdTest() throws IOException {
		
		//mybatis的配置文件
		String resource = "config/SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//通过sqlSession来操作数据库
		
		User user = sqlSession.selectOne("test.findUserById",1);
		
		System.out.println(user);
		
		//释放资源
		sqlSession.close();
	}
	/**
	 * 通过姓名模糊查询用户
	 * @throws IOException
	 */
	@Test
	public void findUserByNameTest() throws IOException {
		
		//mybatis的配置文件
		String resource = "config/SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//通过sqlSession来操作数据库
		
		List<User> users = sqlSession.selectList("test.findUserByName","zz");
		for(User u : users) {
			System.out.println(u);
		}
		
		//释放资源
		sqlSession.close();
	}
	/**
	 * 添加用户
	 * @throws IOException
	 */
	@Test
	public void addUserTest() throws IOException {
			
		String resource = "config/SqlMapConfig.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = new User();
		user.setUsername("yyhhnn");
		user.setPassword("qweqwe");
		user.setBirthday(new Date());
		
		sqlSession.insert("addUser",user);
		System.out.println(user.getId());
		
		//需要手动提交
		sqlSession.commit();
		sqlSession.close();
	}
	/**
	 * 删除用户
	 * @throws IOException
	 */
	@Test
	public void deleteUserTest() throws IOException {
		
		String resource = "config/SqlMapConfig.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession.insert("deleteUser",6);
		
		//需要手动提交
		sqlSession.commit();
		sqlSession.close();
	}
	/**
	 * 修改用户
	 * @throws IOException
	 */
	@Test
	public void updateUserTest() throws IOException {
			
		String resource = "config/SqlMapConfig.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		

		User user = sqlSession.selectOne("findUserById",4);
		user.setUsername("yyhhnn03");
		user.setPassword("qweqwe03");
		
		sqlSession.insert("updateUser",user);
		
		//需要手动提交
		sqlSession.commit();
		sqlSession.close();
	}	
	
	
	
}
