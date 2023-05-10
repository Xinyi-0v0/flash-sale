package com.xinyi.flashsale.db.dao.impl;


import com.xinyi.flashsale.db.dao.OrderDao;
import com.xinyi.flashsale.db.mappers.OrderMapper;
import com.xinyi.flashsale.db.model.Order;
import com.xinyi.flashsale.db.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public boolean save(Order order) {
        int res = orderMapper.insert(order);
        if(res == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Order getById(long orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public boolean updateOrder( Order Order) {
        int res = orderMapper.updateByPrimaryKeySelective(Order);
        if(res == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(long orderId) {
        int res =  orderMapper.deleteByPrimaryKey(orderId);
        if(res == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Order getByOrderId(String orderId) {
        return orderMapper.selectByOrderId(orderId);
    }
}