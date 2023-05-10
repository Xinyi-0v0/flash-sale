package com.xinyi.flashsale.controller;


import com.xinyi.flashsale.db.model.Activity;
import com.xinyi.flashsale.db.model.Order;
import com.xinyi.flashsale.exception.BusinessException;
import com.xinyi.flashsale.service.ActivityService;
import com.xinyi.flashsale.service.OrderService;
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

    @Autowired
    private OrderService orderService;

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
        activity.setLockStock(0L);
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

    @GetMapping("/buy/{id}")
    public void sellProduct(@PathVariable Long id){
            try {
                boolean res = rediService.stockDeductValidator("stock:" + id);
                if (res) {
                    orderService.createOrder(id, 2L);
                    System.out.println("Congratulation! successfully add this product!");
                } else {
                    System.out.println("Sorry! This product is not available now! Fail to add this product to cart!");
                }
            }catch (Exception e) {
                 throw new RuntimeException(e.getMessage());
            }
    }

    @GetMapping("/pay/{orderId}")
    public void payForProduct(@PathVariable String orderId){
        orderService.payOrderProcess(orderId);
    }


}
