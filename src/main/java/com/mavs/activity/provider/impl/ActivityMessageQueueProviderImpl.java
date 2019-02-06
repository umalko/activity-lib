package com.mavs.activity.provider.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mavs.activity.dto.ActivityDto;
import com.mavs.activity.provider.ActivityMessageQueueProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ActivityMessageQueueProviderImpl implements ActivityMessageQueueProvider {

    private static final String QUEUE = "_QUEUE";

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ActivityMessageQueueProviderImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Async
    @Override
    public void produceActivity(ActivityDto activityDto) {
        try {
            String json = new ObjectMapper().writeValueAsString(activityDto);
            rabbitTemplate.convertAndSend(activityDto.getType().name() + QUEUE, json);
        } catch (Exception e) {
            log.error("Something wrong!", e);
        }
    }
}
