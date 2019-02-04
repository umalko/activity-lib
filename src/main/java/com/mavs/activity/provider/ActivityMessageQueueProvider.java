package com.mavs.activity.provider;


import com.mavs.activity.model.Activity;

public interface ActivityMessageQueueProvider {

    void produceActivity(Activity activity);
}
