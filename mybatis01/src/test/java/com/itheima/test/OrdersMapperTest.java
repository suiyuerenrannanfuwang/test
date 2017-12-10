package com.itheima.test;

import com.itheima.domain.Orders;
import com.itheima.domain.OrdersCustom;
import com.itheima.domain.User;
import com.itheima.mapper.OrdersMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 陈涛
 * @version 1.0, 2017/11/26 18:25
 */
public class OrdersMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void findOrdersAndUserByResultType() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);

        List<OrdersCustom> list = ordersMapper.findOrdersAndUserByResultType();
        System.out.println(list);

        sqlSession.close();
    }

    @Test
    public void findOrdersAndUserByResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);

        List<Orders> list = ordersMapper.findOrdersAndUserByResultMap();
        System.out.println(list);

        sqlSession.close();
    }

    @Test
    public void findOrdersAndOrderDetail() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);

        List<Orders> list = ordersMapper.findOrdersAndOrderDetail();
        System.out.println(list);

        sqlSession.close();
    }

    @Test
    public void findUserAndItems() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);

        List<User> list = ordersMapper.findUserAndItems();
        System.out.println(list);

        sqlSession.close();
    }

    @Test
    public void findOrdersLazyLoadingUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);

        List<Orders> list = ordersMapper.findOrdersLazyLoadingUser();
        // 取出一个订单信息
        Orders order = list.get(0);
        // 实现延迟加载
        User user = order.getUser();
        System.out.println(user);

        sqlSession.close();
    }
}
