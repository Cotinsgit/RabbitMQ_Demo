package com.chow.hello;

import com.chow.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

/**
 * 接收方
 */
public class Recver {
    private final static String QUEUE = "hello";//队列的名字

    public static void main(String[] args) throws Exception{
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE,false,false,false,null);

        QueueingConsumer consumer =new QueueingConsumer(channel);//定义一个消费者,QueueingConsumer已经过时,建议使用DefaultConsumer子类
        //接收消息 ,参数2 是自动确认
        channel.basicConsume(QUEUE, true, consumer);

        while (true) {
            //获取消息
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();//如果没有消息会等待,有的话就获取执行然后销毁,是一次性的
            String message = new String(delivery.getBody());
            System.out.println(message);

        }
    }
}
