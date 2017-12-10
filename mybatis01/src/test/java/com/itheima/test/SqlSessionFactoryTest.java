package com.itheima.test;

import com.itheima.dao.UserDao;
import com.itheima.dao.UserDaoImpl;
import com.itheima.domain.QueryUserVo;
import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import com.itheima.utils.MyBatisSQLSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author 陈涛
 * @version 1.0, 2017/11/25 19:13
 */
public class SqlSessionFactoryTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before(){
        sqlSessionFactory = MyBatisSQLSessionFactoryUtils.getInstance();
    }

    @Test
    public void test(){
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = userDao.findUserById(22);
        System.out.println(user);
    }

    @Test
    public void testFindUserList(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        QueryUserVo queryUserVo = new QueryUserVo();
        User user = new User();
        user.setUsername("张");
        user.setSex(1);

        // 输入参数是多个id
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(16);
        ids.add(24);
        queryUserVo.setIds(ids);
        //queryUserVo.setUser(user);

        List<User> list = userMapper.findUserList(queryUserVo);
        System.out.println(list);

        sqlSession.close();
    }

    @Test
    public void findUserCount(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        QueryUserVo queryUserVo = new QueryUserVo();
        User user = new User();
        user.setUsername("张");
        user.setSex(1);
        queryUserVo.setUser(user);

        int count = mapper.findUserCount(queryUserVo);
        System.out.println(count);

        sqlSession.close();
    }

    @Test
    public void testFindUserByHashmap(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("id",28);
        map.put("username","冬冬");

        List<User> list = mapper.findUserByHashmap(map);
        System.out.println(list);

        sqlSession.close();
    }

    @Test
    public void testFindUserByList(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> list = new ArrayList<User>();
        User user = new User();
        user.setId(26);
        list.add(user);

        User user1 = new User();
        user1.setId(28);
        list.add(user1);
        List<User> userList = mapper.findUserByList(list);
        System.out.println(userList);

        sqlSession.close();
    }

    @Test
    public void testFindUserByArray(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 构造查询条件
        Object[] arrayList = new Object[2];
        User user = new User();
        user.setId(22);
        arrayList[0] = user;

        User user1 = new User();
        user1.setId(27);
        arrayList[1] = user1;

        List<User> list = mapper.findUserByArray(arrayList);
        System.out.println(list);

        sqlSession.close();
    }
}
