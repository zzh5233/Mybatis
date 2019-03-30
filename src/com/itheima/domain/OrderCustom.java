package com.itheima.domain;

import java.util.Date;

/**
 * Order的扩赞类
 * @author zzh
 *
 */
public class OrderCustom extends Order {

	private String username;
	private String password;
	private Date birthday;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "OrderCustom [username=" + username + ", password=" + password + ", birthday=" + birthday + "]";
	}
	
}
