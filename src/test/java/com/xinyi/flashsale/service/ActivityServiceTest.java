package com.xinyi.flashsale.service;

import com.xinyi.flashsale.db.model.Activity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivityServiceTest {

    @Autowired
    ActivityService activityService;

    @Test
    public void addNewActivity(){
        Activity activity = new Activity();
        activity.setName("test");
        activity.setAvaiableStock(5l);
        activity.setProductId(3l);
        activity.setTotalStock(5l);
        activity.setOldPrice(100l);
        activity.setSeckillPrice(10l);
        activityService.addNewActivity(activity);
    }

    @Test
    public void AddStock(){
        Activity activity = activityService.getActivityById(2l);
        activity.setAvaiableStock(5l);
        activityService.updateActicity(activity);
    }
}

