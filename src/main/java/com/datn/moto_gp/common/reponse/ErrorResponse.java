package com.datn.moto_gp.common.reponse;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorResponse {
    int status; // HTTP status (400, 404, 500, ...)
    String errorCode;  // Mã lỗi nghiệp vụ, ví dụ: "E-USER-001"
    String message; // Mô tả lỗi
    String path; //API path gay loi
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime timestamp;
}
