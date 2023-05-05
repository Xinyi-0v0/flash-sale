package com.xinyi.flashsale.service;

import com.xinyi.flashsale.db.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void createUser(){
        userService.createUser("xinyi","1209 westlake","2065326799");
        System.out.println("All Users: " + userService.getAllUsers().size());
    }
    @Test
    public void  findUser(){
        User res = userService.getUser(2L);
        System.out.println("All Users: " + res.getUserName());
    }

    @Test
    public void deleteUser(){
        userService.deleteUser(1L);
        System.out.println("All Users: " + userService.getAllUsers().size());
    }


}
