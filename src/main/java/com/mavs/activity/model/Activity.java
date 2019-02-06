package com.mavs.activity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * Activity object provided for sending to message broker to further process.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Activity implements Serializable {

    public Activity(Activity activity) {
        this.id = activity.getId();
        this.guid = activity.getGuid();
        this.type = activity.getType();
        this.processType = activity.getProcessType();
        this.created = activity.getCreated();
        this.jsonObject = activity.getJsonObject();
    }

    @Id
    private String id;
    private String guid;
    private ActivityType type;
    private ActivityProcessType processType;
    private Date created;
    private String jsonObject;
}
