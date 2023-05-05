package com.xinyi.flashsale.db.dao;


import com.xinyi.flashsale.db.model.User;

import java.util.List;

public interface UserDao {
    public void save(User user);
    public User getById(long userId);

    public List<User> getAll();

    public void delete(long userId);

}
