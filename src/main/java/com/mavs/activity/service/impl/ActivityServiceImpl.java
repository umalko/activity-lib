package com.mavs.activity.service.impl;

import com.google.common.collect.Lists;
import com.mavs.activity.model.Activity;
import com.mavs.activity.model.ActivityType;
import com.mavs.activity.repository.ActivityRepository;
import com.mavs.activity.service.ActivityService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public Optional<Activity> getById(String id) {
        return activityRepository.findById(id);
    }

    @Override
    public List<Activity> getAll() {
        return Lists.newArrayList(activityRepository.findAll());
    }

    @Override
    public List<Activity> getByType(ActivityType type) {
        return activityRepository.findByType(type.name());
    }

    @Override
    public Activity save(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public Activity update(Activity activity) {
        Optional<Activity> dbActivityOpt = activityRepository.findById(activity.getId());
        if (dbActivityOpt.isPresent()) {
            Activity dbActivity = dbActivityOpt.get();
            BeanUtils.copyProperties(activity, dbActivity);
            return activityRepository.save(dbActivity);
        } else {
            return activityRepository.save(activity);
        }
    }
}
