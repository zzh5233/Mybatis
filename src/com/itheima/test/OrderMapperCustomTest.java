package com.itheima.test;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.domain.Order;
import com.itheima.domain.OrderCustom;
import com.itheima.domain.OrderQueryVo;
import com.itheima.domain.User;
import com.itheima.mapper.OrderMapperCustom;

public class OrderMapperCustomTest {
	
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
	
	/**
	 * 查询订单关联查询用户信息 
	 * @throws Exception 
	 */
	@Test
	public void testFindOrderUser() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		OrderMapperCustom orderMapperCustom = sqlSession.getMapper(OrderMapperCustom.class);
		
		List<OrderCustom> list = orderMapperCustom.findOrderUser();
		
		for(OrderCustom oc: list) {
			System.out.println(oc);
		}
		
		sqlSession.close();
		
	}
	/**
	 * 查询订单关联查询用户信息  用resultMap来接受
	 * @throws Exception 
	 */
	@Test
	public void testFindOrderUserResultMap() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		OrderMapperCustom orderMapperCustom = sqlSession.getMapper(OrderMapperCustom.class);
		
		List<Order> list = orderMapperCustom.findOrderUserResultMap();
		
		for(Order o: list) {
			System.out.println(o);
		}
		
		sqlSession.close();
	}
	/**
	 *  -- 查询订单关联查询用户及订单明细 使用resultMap -->
	 * @throws Exception 
	 */
	@Test
	public void testFindOrderAndOrderDetailResultMap() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		OrderMapperCustom orderMapperCustom = sqlSession.getMapper(OrderMapperCustom.class);
		
		List<Order> list = orderMapperCustom.findOrderAndOrderDetailResultMap();
		
		for(Order o: list) {
			System.out.println(o);
		}
		
		sqlSession.close();
	}
	/**
	 *  -- 查询用户及购买商品的信息，使用resultMap 多对多 -->
	 * @throws Exception 
	 */
	@Test
	public void testFindUserAndItemResultMap() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		OrderMapperCustom orderMapperCustom = sqlSession.getMapper(OrderMapperCustom.class);
		
		List<User> list = orderMapperCustom.findUserAndItemResultMap();
		
		for(User u: list) {
			System.out.println(u);
		}
		
		sqlSession.close();
	}

}
