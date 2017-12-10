package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
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

/**
 * mapper代理开发测试
 *
 * @author 陈涛
 * @version 1.0, 2017/11/24 16:40
 */
public class MapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws IOException {
        // 根据mybatis的全局配置文件构造一个流
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建sqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test1(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 生成代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 调用useMapper
        User user = userMapper.findUserById(26);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 生成代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 调用useMapper
        List<User> list = userMapper.findUserByUserName("%张%");
        System.out.println(list);

        sqlSession.close();
    }

    @Test
    public void test3(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 生成代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("冬冬");
        user.setBirthday(new Date());
        user.setSex(2);
        user.setAddress("西安");
        // 调用useMapper
        userMapper.insertUser(user);

        sqlSession.commit();
        sqlSession.close();
    }
}
