package com.xinyi.flashsale.service;


import com.xinyi.flashsale.util.RediService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisServiceTest {

    @Autowired
    RediService redisService;

    @Test
    public void stockTest(){
        redisService.setValue("stock:1",5L);
    }

    @Test
    public void checkStock(){
        redisService.getValue("stock:1");
    }


    @Test
    public void deductStock(){
        Boolean res = redisService.stockDeductValidator("stock:1");
        System.out.println(res);
        System.out.println(redisService.getValue("stock:1"));
    }
}
