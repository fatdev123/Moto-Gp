package com.datn.moto_gp.modules.enumsdata.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StatusTypeUpdateRequest {
    String name;
    String description;
}
