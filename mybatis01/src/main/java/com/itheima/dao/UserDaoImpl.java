package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author 陈涛
 * @version 1.0, 2017/11/24 15:45
 */
public class UserDaoImpl implements UserDao {

    /** 注入sqlSessionFactory */
    private SqlSessionFactory sqlSessionFactory;

    /** 通过构造方法注入 */
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(int id) {
        // SqlSession定义为局部变量
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.findUserById",id);

        return user;
    }
}
