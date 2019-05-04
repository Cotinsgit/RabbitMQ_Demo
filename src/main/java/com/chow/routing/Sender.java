package com.chow.routing;

import com.chow.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Sender {
    private final static String EXCHANGE_NAME = "testrouting";

    public static void main(String[] args) throws  Exception{
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");//定义路由格式的交换机
        channel.basicPublish(EXCHANGE_NAME, "key3", null, "路由消息".getBytes());
        channel.close();
        connection.close();
    }
}
