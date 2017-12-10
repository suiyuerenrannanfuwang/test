package com.itheima.domain;

/**
 * 自定义pojo
 *
 * @author 陈涛
 * @version 1.0, 2017/11/26 18:21
 */
public class OrdersCustom extends Orders {

    private String username;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "OrdersCustom{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
