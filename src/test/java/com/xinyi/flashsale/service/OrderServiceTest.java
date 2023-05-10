package com.xinyi.flashsale.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void createOrder(){
        orderService.createOrder(2L,2L);
    }

    @Test
    public void updateOrder(){
        orderService.updateOrder(3L, 0);
    }

    @Test
    public void getOrder(){
        orderService.getOrder(1L);

    }
    @Test
    public void getOrderByOrderId(){
        orderService.payOrderProcess("853320829256208384");
    }


    @Test void deleteOrder(){
        orderService.deleteOrder(2L);
    }
}
