package com.datn.moto_gp.modules.enumsdata.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SessionTypeCreationRequest {
    String code;
    String description;
}
