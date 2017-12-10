package com.itheima.domain;

import java.util.Date;

/**
 * 生成uuid
 *
 * @author 陈涛
 * @version 1.0，2017-11-24 08:51:18
 */
public class UserUUID {

	private String uuid	;
	private String username;
	private Date birthday	;
	private Integer sex	;
	private String address ;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
	
		this.uuid = uuid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
