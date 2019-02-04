package com.mavs.activity.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mavs.activity.model.Activity;
import com.mavs.activity.model.ActivityType;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
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
                    .created(LocalDateTime.now())
                    .type(type)
                    .jsonObject(new ObjectMapper().writeValueAsString(o))
                    .build());
        } catch (JsonProcessingException e) {
            log.error("Activity wasn't built: {}", o.toString());
        }
        return Optional.empty();
    }
}
