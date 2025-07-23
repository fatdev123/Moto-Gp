package com.datn.moto_gp.modules.enumsdata.dto.response;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class StatusTypeResponse {
    int statusId;
    String code;
    String name;
    String description;
}
