package com.itheima.domain;

import java.util.List;

/**
 * 定义一个包装对象
 */
public class QueryUserVo {
	
	//定义了很多的查询条件，可以将条件的pojo包装进来组成一个包装对象
	
	//用户信息查询条件
	private User user;
	
	//用户id列表，用于向mybatis传多个id
	private List<Integer> ids;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}


}
