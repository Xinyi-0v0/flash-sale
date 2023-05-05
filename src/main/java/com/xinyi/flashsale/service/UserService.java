package com.xinyi.flashsale.service;

import com.xinyi.flashsale.db.model.User;

import java.util.List;

public interface UserService {

    public void createUser(String userName, String address,String phone);

    public User getUser(Long userId);

    public List<User> getAllUsers();
    public void deleteUser(Long userId);
}
