package com.itheima.mapper;

import com.itheima.domain.Orders;
import com.itheima.domain.OrdersCustom;
import com.itheima.domain.User;

import java.util.List;

/**
 * @author 陈涛
 * @version 1.0, 2017/11/26 18:12
 */
public interface OrdersMapper {

    // 一对一查询，查询订单关联查询客户
    public List<OrdersCustom> findOrdersAndUserByResultType() throws Exception;

    public List<Orders> findOrdersAndUserByResultMap() throws Exception;

    // 一对多查询，查询订单关联查询明细
    public List<Orders> findOrdersAndOrderDetail() throws Exception;

    // 多对多，查询客户关联查询商品
    public List<User> findUserAndItems() throws Exception;

    // 查询订单延迟查询客户
    public List<Orders> findOrdersLazyLoadingUser() throws Exception;
}
