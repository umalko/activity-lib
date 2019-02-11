package com.mavs.activity.model;

import java.io.Serializable;

public enum ActivityType implements Serializable {

    NEW_USER_NOTIFICATION,
    NEW_USER_AUTH, // can be old/remove_user activity
    NEW_RELATIONSHIP,
    END_RELATIONSHIP
}
