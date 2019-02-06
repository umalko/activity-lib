package com.mavs.activity.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mavs.activity.dto.ActivityDto;
import com.mavs.activity.dto.BaseActivityDto;
import com.mavs.activity.model.Activity;
import com.mavs.activity.model.ActivityProcessType;
import com.mavs.activity.model.ActivityType;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Slf4j
public class ActivityUtil {

    private ActivityUtil() {
        // no-args constructor
    }

    public static Optional<Activity> buildActivity(Object o, ActivityType type) {
        try {
            return Optional.of(Activity.builder()
                    .guid(UUID.randomUUID().toString())
                    .created(new Date())
                    .type(type)
                    .processType(ActivityProcessType.CREATED)
                    .jsonObject(new ObjectMapper().writeValueAsString(o))
                    .build());
        } catch (JsonProcessingException e) {
            log.error("Activity wasn't built: {}", o);
        }
        return Optional.empty();
    }

    public static ActivityDto buildActivityDto(Activity activity, BaseActivityDto activityDto) {
        return ActivityDto.builder()
                .guid(activity.getGuid())
                .type(activity.getType())
                .processType(activity.getProcessType())
                .created(activity.getCreated())
                .objectDto(activityDto)
                .build();
    }

    public static <T extends BaseActivityDto> Optional<Activity> convertToActivity(ActivityDto<T> activityDto) {
        try {
            return Optional.of(Activity.builder()
                    .guid(activityDto.getGuid())
                    .created(activityDto.getCreated())
                    .type(activityDto.getType())
                    .processType(activityDto.getProcessType())
                    .jsonObject(new ObjectMapper().writeValueAsString(activityDto.getObjectDto()))
                    .build());
        } catch (JsonProcessingException e) {
            log.error("Activity wasn't built: {}", activityDto);
        }
        return Optional.empty();
    }

    public static <T extends BaseActivityDto> Optional<T> convertJsonToBaseActivityObject(String jsonObject, Class<T> type) {
        try {
            return Optional.of(new ObjectMapper().readValue(jsonObject, type));
        } catch (IOException e) {
            log.error("Json object wasn't parsed: {}", jsonObject);
        }
        return Optional.empty();
    }
}
