package com.datn.moto_gp.exception;

import com.datn.moto_gp.common.reponse.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
@RestControllerAdvice // Đánh dấu đây là nơi xử lý lỗi toàn cục cho tất cả RestController
public class GlobalExceptionHandler {

    /**
     * Xử lý lỗi AppException tùy chỉnh do người dùng định nghĩa
     * Luồng xử lý:
     * 1. Trong service, controller ném ra AppException với ErrorCode cụ thể.
     *    Ví dụ: throw new AppException(ErrorCode.STATUS_ALREADY_EXISTS);
     * 2. Exception này sẽ được method dưới đây bắt lại.
     * 3. Trả về response chuẩn hóa gồm: status, mã lỗi, thông điệp, path, thời gian.
     */
    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorResponse> handleAppException(AppException ex, HttpServletRequest request) {
        return ResponseEntity
                // Trả về mã HTTP status, nên dùng từ ErrorCode để linh hoạt (ex.getErrorCode().getHttpStatus())
                .status(ex.getErrorCode().getHttpStatus())
                .body(
                        ErrorResponse.builder()
                                // Mã HTTP status gửi về client (ví dụ: 409, 400, 404,...)
                                .status(ex.getErrorCode().getHttpStatus())
                                // Mã lỗi nghiệp vụ - do dev định nghĩa, ví dụ: "E-STATUS-0003"
                                .errorCode(ex.getErrorCode().getCode())
                                // Mô tả lỗi - giúp dev và người dùng hiểu vấn đề
                                .message(ex.getErrorCode().getMessage())
                                // Đường dẫn endpoint xảy ra lỗi (ví dụ: "/api/status-type")
                                .path(request.getRequestURI())
                                // Thời điểm lỗi xảy ra
                                .timestamp(LocalDateTime.now())
                                .build()
                );
    }

    // TODO: Có thể thêm nhiều @ExceptionHandler khác nếu muốn xử lý lỗi như NullPointerException, Validation, Unauthorized,...
}