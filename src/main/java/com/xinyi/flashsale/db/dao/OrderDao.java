package com.xinyi.flashsale.db.dao;

import com.xinyi.flashsale.db.model.Order;
import com.xinyi.flashsale.db.model.Product;

public interface OrderDao {

    public boolean save(Order order);
    public Order getById(long orderId);

    public boolean updateOrder(Order Order);

    public boolean delete(long productId);

    Order getByOrderId(String orderId);
}
