package com.xinyi.flashsale.kafka;

import com.xinyi.flashsale.db.dao.ActivityDao;
import com.xinyi.flashsale.db.dao.OrderDao;
import com.xinyi.flashsale.db.model.Activity;
import com.xinyi.flashsale.db.model.Order;
import com.xinyi.flashsale.util.RediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class KafkaListeners {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ActivityDao activityDao;
    @Autowired
    private RediService redisService;

    @Transactional
    @KafkaListener(topics = "create_order", groupId = "my_group_xinyi")
    void createOrderListener(Message<Order> message){
        System.out.println("******* create_order Message Received ********");
        // get order
        Order order = message.getPayload();
        order.setCreateTime(new Date());
        // update stock info in DB （Redis is updated when validate stock）
        boolean lockStockResult  = activityDao.lockStock(order.getActivityId());
        if (lockStockResult) {
            //order status 0:no available stock 1:wait for payment
            order.setOrderStatus(1);
        } else {
            order.setOrderStatus(0);
        }
        // create order
        boolean res = orderDao.save(order);
        System.out.println( order.getOrderNo() +"order created: " + res);
        System.out.println("***************");
    }

    @Transactional
    @KafkaListener(topics = "pay_check", groupId = "my_group_xinyi")
    void checkOrderStatus(Message<Order> message){
        System.out.println("***************");
        System.out.println(message.getPayload());
        System.out.println("***************");

    }

    @Transactional
    @KafkaListener(topics = "pay_done", groupId = "my_group_xinyi")
    void afterPayment(Message<Order> message){
        System.out.println("******* pay_done Message Received ********");
        Order order = message.getPayload();
        // update stock info
        activityDao.deductStock(order.getActivityId());
        System.out.println("***************");

    }

}
