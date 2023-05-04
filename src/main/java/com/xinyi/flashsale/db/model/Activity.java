package com.xinyi.flashsale.db.model;

import java.util.Date;

public class Activity {
    private Long id;

    private String name;

    private Long productId;

    private Long oldPrice;

    private Long seckillPrice;

    private Integer activityStatus;

    private Date startTime;

    private Date endTime;

    private Long totalStock;

    private Long avaiableStock;

    private Long lockStock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Long oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Long getSeckillPrice() {
        return seckillPrice;
    }

    public void setSeckillPrice(Long seckillPrice) {
        this.seckillPrice = seckillPrice;
    }

    public Integer getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(Integer activityStatus) {
        this.activityStatus = activityStatus;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(Long totalStock) {
        this.totalStock = totalStock;
    }

    public Long getAvaiableStock() {
        return avaiableStock;
    }

    public void setAvaiableStock(Long avaiableStock) {
        this.avaiableStock = avaiableStock;
    }

    public Long getLockStock() {
        return lockStock;
    }

    public void setLockStock(Long lockStock) {
        this.lockStock = lockStock;
    }
}