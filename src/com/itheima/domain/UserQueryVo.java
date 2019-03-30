package com.itheima.domain;

import java.util.List;

/**
 * 作为查询传递的pojo包装类
 * @author zzh
 *
 */
public class UserQueryVo {

	//封装了一个user的扩展
	private UserCustom userCustom;
	
	private List<Integer> ids;

	
	//还可以封装其他属性，其他类
	
	//---
	public UserCustom getUserCustom() {
		return userCustom;
	}
	
	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
}
