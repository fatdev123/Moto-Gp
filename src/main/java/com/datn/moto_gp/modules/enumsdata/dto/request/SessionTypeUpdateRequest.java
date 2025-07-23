package com.datn.moto_gp.modules.enumsdata.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class SessionTypeUpdateRequest {
    String code;
    String description;
}
