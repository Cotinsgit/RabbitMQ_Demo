package com.chow.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 用于连接的工具类
 */
public class ConnectionUtil {
    public static Connection getConnection () throws  Exception{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.87.131");//设置 server 的地址
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("test");
        connectionFactory.setPassword("test");
        connectionFactory.setVirtualHost("/test");
        return connectionFactory.newConnection();//创建一个新的连接
    }
}
