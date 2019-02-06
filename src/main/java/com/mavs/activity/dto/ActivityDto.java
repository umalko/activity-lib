package com.mavs.activity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mavs.activity.model.ActivityProcessType;
import com.mavs.activity.model.ActivityType;
import lombok.*;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDto<T extends BaseActivityDto> extends BaseActivityDto {

    private String guid;
    private ActivityType type;
    private ActivityProcessType processType;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date created;
    private T objectDto;
}
