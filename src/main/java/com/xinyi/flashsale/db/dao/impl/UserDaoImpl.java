package com.xinyi.flashsale.db.dao.impl;

import com.xinyi.flashsale.db.dao.UserDao;
import com.xinyi.flashsale.db.mappers.UserMapper;
import com.xinyi.flashsale.db.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

@Autowired
private UserMapper userMapper;
    @Override
    public void save(User user) {
        userMapper.insert(user);
    }

    @Override
    public User getById(long userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        return user;
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAllUsers();
    }

    @Override
    public void delete(long userId) {
        userMapper.deleteByPrimaryKey(userId);
    }
}
