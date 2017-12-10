package com.itheima.dao;

import com.itheima.domain.User;

/**
 * @author 陈涛
 * @version 1.0, 2017/11/24 15:43
 */
public interface UserDao {

    public User findUserById(int id);

}
