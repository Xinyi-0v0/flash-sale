package com.xinyi.flashsale.service.impl;

import com.xinyi.flashsale.db.dao.ActivityDao;
import com.xinyi.flashsale.db.dao.OrderDao;
import com.xinyi.flashsale.db.model.Activity;
import com.xinyi.flashsale.db.model.Order;
import com.xinyi.flashsale.exception.SystemException;
import com.xinyi.flashsale.kafka.KafkaProducer;
import com.xinyi.flashsale.service.OrderService;
import com.xinyi.flashsale.util.SnowFlakeId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ActivityDao activityDao;
    @Autowired
    private KafkaProducer kafkaProducer;

    private final SnowFlakeId snowFlakeID = new SnowFlakeId(1, 1);
    @Override
    // create a new order and then send it to mq
    public void createOrder(Long activityId, Long userId) {
        Activity activity = activityDao.getById(activityId);
        Order order = new Order();
        order.setUserId(userId);
        order.setActivityId(activityId);
        order.setOrderNo(String.valueOf(snowFlakeID.nextId()));
        order.setOrderAmount(activity.getSeckillPrice());
        kafkaProducer.sendMessage("create_order", order);
    }

    @Override
    public void updateOrder(long orderId, int orderStatus) {
        Order order = orderDao.getById(orderId);
        order.setOrderStatus(orderStatus);
        orderDao.updateOrder(order);
    }

    @Override
    public void getOrder(Long orderId) {
        orderDao.getById(orderId);
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderDao.delete(orderId);
    }

    @Override
    public void payOrderProcess(String orderId) {
        System.out.println("***********payOrderProcess service active***********");
        Order order = orderDao.getByOrderId(orderId);
        if(order == null){
            System.out.println("Order is not exist：" + orderId);
            return;
        } else if (order.getOrderStatus() != 1) {
            System.out.println("Order is invalid：" + orderId);
            return;
        }

        // 2: finish payment; 库存表压力大， 所以使用mq； 订单表压力没那么大， 可以直接操作数据库
        order.setOrderStatus(2);
        orderDao.updateOrder(order);
        kafkaProducer.sendMessage("pay_done", order);
    }
}
