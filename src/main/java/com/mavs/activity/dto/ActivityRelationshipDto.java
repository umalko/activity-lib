package com.mavs.activity.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityRelationshipDto extends BaseActivityDto {

    private String personEmail;
    private String personRelationshipEmail;
    private RelationshipType relationshipType;
}
