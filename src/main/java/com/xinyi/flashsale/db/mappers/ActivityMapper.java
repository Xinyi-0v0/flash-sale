package com.xinyi.flashsale.db.mappers;

import com.xinyi.flashsale.db.model.Activity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Long id);

    List<Activity> getAllActivities();
    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);
}