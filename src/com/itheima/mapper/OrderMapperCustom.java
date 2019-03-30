package com.itheima.mapper;

import java.util.List;

import com.itheima.domain.Order;
import com.itheima.domain.OrderCustom;
import com.itheima.domain.User;

public interface OrderMapperCustom {
	
	//查询订单关联查询用户信息---一对一查询
	public List<OrderCustom> findOrderUser() throws Exception;
	
	//查询订单关联查询用户信息---一对一查询 用resultMap来接受
	public List<Order> findOrderUserResultMap() throws Exception;
	
	// -- 查询订单关联查询用户及订单明细 使用resultMap -->
	public List<Order> findOrderAndOrderDetailResultMap() throws Exception;
	
	// -- 查询用户及购买商品的信息，使用resultMap 多对多 -->
	public List<User> findUserAndItemResultMap() throws Exception;
}
