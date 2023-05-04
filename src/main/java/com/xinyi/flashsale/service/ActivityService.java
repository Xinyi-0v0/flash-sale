package com.xinyi.flashsale.service;

import com.xinyi.flashsale.db.model.Activity;
import com.xinyi.flashsale.db.model.Product;

import java.util.List;

public interface ActivityService {

    public void addNewActivity(Activity activity);
    public Activity getActivityById(long activityId);

    public List<Activity> getAllActivities();

    public void deleteActivityById(long activityId);

    public void updateActicity(Activity activity);
}
