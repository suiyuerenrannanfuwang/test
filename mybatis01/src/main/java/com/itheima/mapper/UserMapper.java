package com.itheima.mapper;

import com.itheima.domain.QueryUserVo;
import com.itheima.domain.User;
import com.sun.javafx.collections.MappingChange;

import java.util.List;
import java.util.Map;

/**
 * @author 陈涛
 * @version 1.0, 2017/11/24 15:43
 */
public interface UserMapper {

    public User findUserById(int id);

    public List<User> findUserByUserName(String username);

    public void insertUser(User user);

    // 综合查询客户信息
    public List<User> findUserList(QueryUserVo queryUserVo);

    // 综合查询客户总条数
    public int findUserCount(QueryUserVo queryUserVo);

    // 传递Hashmap传递
    public List<User> findUserByHashmap(Map map);

    // 传递一个list查询
    public List<User> findUserByList(List list);

    //传递单个数组查询
    public List<User> findUserByArray(Object[] arrayList);
}
