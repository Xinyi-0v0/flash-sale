package com.xinyi.flashsale.controller;


import com.xinyi.flashsale.db.model.Activity;
import com.xinyi.flashsale.exception.BusinessException;
import com.xinyi.flashsale.service.ActivityService;
import com.xinyi.flashsale.util.ParaValidation;
import com.xinyi.flashsale.util.RediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class activityController {

    @Autowired
    private ActivityService activityService;
    @Autowired
    private RediService rediService;

// return html page: need to change @RestController to @Controller
//    @GetMapping("/new")
//    public String addSeckillActivity() {
//        return "add_activity";
//    }

    @GetMapping
    public List<Activity> getAllSeckillActivities() {
        return activityService.getAllActivities();
    }

    @PostMapping("/new")
    public Activity addSeckillActivityToDB(@RequestBody Activity activity) {
        if (!ParaValidation.isValidString(activity.getName()) || !ParaValidation.isValidLong(activity.getProductId())
                || !ParaValidation.isValidLong(activity.getSeckillPrice()) || !ParaValidation.isValidLong(activity.getTotalStock())
                || !ParaValidation.isValidLong(activity.getAvaiableStock())) {
            throw new BusinessException("wrong parameters", 0);
        }
        activityService.addNewActivity(activity);
        return activity;
    }

    @GetMapping ("/{id}")
    public Activity  getSeckillActivityById(@PathVariable Long id){
        return activityService.getActivityById(id);

    }
    @DeleteMapping("/{id}")
    public void  deleteSeckillActivity(@PathVariable Long id){
        activityService.deleteActivityById(id);

    }

//    // Simple deduction would cause oversell
//    @GetMapping("/{id}/buy")
//    public String sellProduct(@PathVariable Long id){
//        Activity activity = activityService.getActivityById(id);
//        Long availableStock = activity.getAvailableStock();
//        if (availableStock > 0) {
//            activity.setAvailableStock(availableStock - 1);
//            activityService.updateActivity(activity);
//            System.out.println("successfully placed the order");
//            return "successfully placed the order";
//        } else {
//            System.out.println("FAIL!!!");
//            return "FAIL!!!";
//        }
//    }

        @GetMapping("/{id}/buy")
    public String sellProduct(@PathVariable Long id){
        Boolean res = rediService.stockDeductValidator("stock:"+ id);
        if (res) {
            System.out.println("Congratulation! successfully add this product!");
            return "successfully!";
        } else {
            System.out.println("Sorry! This product is not available now! Fail to add this product to cart!");
            return "FAIL!!!";
        }
    }

}