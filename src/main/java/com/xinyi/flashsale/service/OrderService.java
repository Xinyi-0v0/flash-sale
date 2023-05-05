package com.xinyi.flashsale.service;

import com.xinyi.flashsale.db.model.Activity;
import com.xinyi.flashsale.db.model.Order;
import org.springframework.stereotype.Service;



public interface OrderService {

    public void createOrder(Long activityId, Long userId);

    public void updateOrder(long orderId, int orderStatus);

    public void getOrder(Long orderId);


    public void deleteOrder(Long orderId);
}
