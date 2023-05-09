package com.xinyi.flashsale.db.dao;

import com.xinyi.flashsale.db.model.Activity;


import java.util.List;

public interface ActivityDao {

    public boolean save(Activity activity);
    public Activity getById(long activityId);

    public List<Activity> getAll();

    public boolean delete(long activityId);

    public void updateActivity(Activity activity);

    public boolean lockStock(Long id);
    public boolean deductStock(Long id);

    public boolean revertStock(Long id);
}
