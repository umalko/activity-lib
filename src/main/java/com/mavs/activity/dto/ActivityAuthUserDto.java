package com.mavs.activity.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class ActivityAuthUserDto extends ActivityUserDto {

    private String password;

    public ActivityAuthUserDto(String email, String phone, String username, String password) {
        super(email, phone, username);
        this.password = password;
    }
}
