package com.mavs.activity.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityUserDto extends BaseActivityDto {

    private String email;
    private String phone;
    private String username;
}
