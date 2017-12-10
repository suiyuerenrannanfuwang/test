package com.itheima.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * 单例模式
 *
 * @author 陈涛
 * @version 1.0, 2017/11/25 18:41
 */
public class MyBatisSQLSessionFactoryUtils {
    // 静态的成员变量
    private static SqlSessionFactory sqlSessionFactory;

    // 恶汉模式，在类加载的时候，对成员变量初始化
    /*static {
        try {
            sqlSessionFactory =
                    new SqlSessionFactoryBuilder()
                            .build(Resources.getResourceAsStream("sqlMapConfig.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getInstance(){
        return sqlSessionFactory;
    }*/

    /**
     * 多线程同时调用getInstance()有没有线程安全问题？
     * 1.有没有多线程环境
     * 2.有没有访问同一个资源
     * 3.有没有对同一个资源进行修改
     */
    public static SqlSessionFactory getInstance(){

        if(sqlSessionFactory == null){

            synchronized (MyBatisSQLSessionFactoryUtils.class){

                if(sqlSessionFactory == null){
                    try {
                        sqlSessionFactory = new SqlSessionFactoryBuilder()
                                .build(Resources.getResourceAsStream("sqlMapConfig.xml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return sqlSessionFactory;
    }
}
