package com.mavs.activity.provider;


import com.mavs.activity.dto.ActivityDto;

public interface ActivityMessageQueueProvider {

    void produceActivity(ActivityDto activityDto);
}
