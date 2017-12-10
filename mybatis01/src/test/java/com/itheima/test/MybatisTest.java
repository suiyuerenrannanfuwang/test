package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.domain.UserUUID;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author 陈涛
 * @version 1.0, 2017/11/24 9:27
 */
public class MybatisTest {

    // 私有会话工厂
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 创建会话工厂
     */
    @Before
    public void createSqlSessionFactory(){
        try {
            // 加载配置文件
            String resource = "sqlMapConfig.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);

            // 使用SqlSessionFactoryBuilder从xml中创建SqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据id查询用户
     */
    @Test
    public void findUserById(){
        // 创建数据库会话实例对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 查询单个记录
        User user = sqlSession.selectOne("test.findUserById",10);

        System.out.println(user);

        // 关闭sqlSession
        sqlSession.close();
    }

    /**
     * 根据用户名模糊查询
     */
    @Test
    public void findUserByUserName(){
        // 创建数据库会话实例对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 查询多个记录
        //List<User> list = sqlSession.selectList("test.findUserByUserName","%张%");
        List<User> list = sqlSession.selectList("test.findUserByUserName2","张");
        System.out.println(list);

        // 关闭sqlSession
        sqlSession.close();
    }

    /**
     * 添加用户
     */
    @Test
    public void InsertUser(){
        // 创建数据库会话实例对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 添加用户信息
        /*User user = new User();
        user.setUsername("杨幂");
        user.setBirthday(new Date());
        user.setSex(2);
        user.setAddress("北京");*/

        UserUUID userUUID = new UserUUID();
        userUUID.setUuid(UUID.randomUUID().toString().replaceAll("-",""));
        userUUID.setUsername("宋茜");
        userUUID.setBirthday(new Date());
        userUUID.setSex(2);
        userUUID.setAddress("青岛");

        // 插入记录
        //sqlSession.insert("test.insertUser",user);
        sqlSession.insert("test.insertUser2",userUUID);
        // 提交事物
        sqlSession.commit();
        // 关闭sqlSession
        sqlSession.close();
    }

    /**
     * 修改用户
     */
    @Test
    public void updateUser(){
        // 创建数据库会话实例
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 修改已有用户信息
        User user = new User();
        user.setId(22);
        user.setUsername("智妍");
        user.setSex(2);
        user.setBirthday(new Date());
        user.setAddress("首尔");

        sqlSession.update("test.updateUser",user);
        // 提交事物
        sqlSession.commit();
        // 关闭sqlSession
        sqlSession.close();
    }

    /**
     * 删除用户
     */
    @Test
    public void deleteUser(){
        // 创建数据库会话实例
        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.update("test.deleteUser",25);
        // 提交事物
        sqlSession.commit();
        // 关闭sqlSession
        sqlSession.close();
    }

}
