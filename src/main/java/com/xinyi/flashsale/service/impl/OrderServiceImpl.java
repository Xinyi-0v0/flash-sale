package com.xinyi.flashsale.service.impl;

import com.xinyi.flashsale.db.dao.ActivityDao;
import com.xinyi.flashsale.db.dao.OrderDao;
import com.xinyi.flashsale.db.model.Activity;
import com.xinyi.flashsale.db.model.Order;
import com.xinyi.flashsale.exception.SystemException;
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

    private final SnowFlakeId snowFlakeID = new SnowFlakeId(1, 1);
    @Override
    public void createOrder(Long activityId, Long userId) {
        Activity activity = activityDao.getById(activityId);
        Order order = new Order();
        order.setUserId(userId);
        order.setActivityId(activityId);
        order.setOrderNo(String.valueOf(snowFlakeID.nextId()));
        order.setCreateTime(new Date());
        order.setOrderAmount(activity.getSeckillPrice());
        if (orderDao.save(order) ){
        } else {
            throw new SystemException("Fail to create order",0);
        }
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
}
