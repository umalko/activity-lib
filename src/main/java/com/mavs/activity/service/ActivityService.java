package com.mavs.activity.service;


import com.mavs.activity.model.Activity;
import com.mavs.activity.model.ActivityType;

import java.util.List;
import java.util.Optional;

public interface ActivityService<T> {

    /**
     * Get activity by id
     *
     * @param id activity id
     * @return activity object
     */
    Optional<Activity> getById(String id);

    /**
     * Find all activities stored in the current service
     *
     * @return list of activities
     */
    List<Activity> getAll();

    /**
     * Get activities by specific type
     *
     * @param type activity type(User,...)
     * @return list of activities filtered by activity type
     */
    List<Activity> getByType(ActivityType type);

    /**
     * Save activity
     *
     * @param activity activity object
     * @return saved activity
     */
    Activity save(Activity activity);

    /**
     * Update existing activity
     *
     * @param activity activity object
     * @return modified activity
     */
    Activity update(Activity activity);

}
