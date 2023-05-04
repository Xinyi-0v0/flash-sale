package com.xinyi.flashsale.service.impl;

import com.xinyi.flashsale.db.dao.ActivityDao;

import com.xinyi.flashsale.db.model.Activity;

import com.xinyi.flashsale.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityDao activityDao;
    @Override
    public void addNewActivity(Activity activity) {
        activityDao.save(activity);
    }

    @Override
    public Activity getActivityById(long activityId) {

        return activityDao.getById(activityId);
    }

    @Override
    public List<Activity> getAllActivities() {

        return activityDao.getAll();
    }

    @Override
    public void deleteActivityById(long activityId) {
        activityDao.delete(activityId);
    }

    @Override
    public void updateActicity(Activity activity) {
        activityDao.updateActivity(activity);
    }
}
