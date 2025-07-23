package com.datn.moto_gp.modules.enumsdata.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SessionTypeResponse {
    int id;
    String code;
    String description;
}
