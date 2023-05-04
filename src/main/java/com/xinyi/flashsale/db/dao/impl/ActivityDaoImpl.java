package com.xinyi.flashsale.db.dao.impl;

import com.xinyi.flashsale.db.dao.ActivityDao;
import com.xinyi.flashsale.db.mappers.ActivityMapper;
import com.xinyi.flashsale.db.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class  ActivityDaoImpl implements ActivityDao {

    @Autowired
    private ActivityMapper activityMapper;
    @Override
    public boolean save(Activity activity) {
        try {
            activityMapper.insert(activity);
            return true;
        } catch (ArithmeticException e) {
            return false;
        }
    }

    @Override
    public Activity getById(long activityId) {
        return activityMapper.selectByPrimaryKey(activityId);
    }

    @Override
    public List<Activity> getAll() {
        return activityMapper.getAllActivities();
    }

    @Override
    public boolean delete(long activityId) {
        try {
            activityMapper.deleteByPrimaryKey(activityId);
            return true;
        } catch (ArithmeticException e) {
            return false;
        }
    }

    @Override
    public void updateActivity(Activity activity) {
        try {
            activityMapper.updateByPrimaryKeySelective(activity);
        } catch (ArithmeticException e) {
            throw new RuntimeException("Fail to update: " + e.getMessage());
        }
    }
}
