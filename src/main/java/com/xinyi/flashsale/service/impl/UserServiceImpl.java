package com.xinyi.flashsale.service.impl;

import com.xinyi.flashsale.db.dao.UserDao;
import com.xinyi.flashsale.db.model.User;
import com.xinyi.flashsale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Override
    public void createUser(String userName, String address, String phone) {
        User user = new User();
        user.setUserName(userName);
        user.setAddress(address);
        user.setPhone(phone);
        userDao.save(user);
    }


    @Override
    public User getUser(Long userId) {
        return userDao.getById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    @Override
    public void deleteUser(Long userId) {
        userDao.delete(userId);
    }
}
