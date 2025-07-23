package com.datn.moto_gp.constants;

public enum ErrorCode {

// Đặt mã theo pattern: E-TYPE-XXXY, trong đó:
    //XXX: nhóm nghiệp vụ (001–099).
    //Y: 0 = invalid, 1 = not found, 2 = already exists.

//Error code cho cac table _type
// ───── STATUS TYPE ERRORS (001) ─────

    INVALID_STATUS_TYPE(400, "E-TYPE-0010", "Invalid status type"),
    STATUS_TYPE_NOT_FOUND(404, "E-TYPE-0011", "Status type not found"),
    STATUS_TYPE_ALREADY_EXISTS(409, "E-TYPE-0012", "Status type already exists"),

    // ───── ROLE TYPE ERRORS (002) ─────
    INVALID_ROLE_TYPE(400, "E-TYPE-0020", "Invalid role type"),
    ROLE_TYPE_NOT_FOUND(404, "E-TYPE-0021", "Role type not found"),
    ROLE_TYPE_ALREADY_EXISTS(409, "E-TYPE-0022", "Role type already exists"),

    // ───── SESSION TYPE ERRORS (003) ─────
    INVALID_SESSION_TYPE(400, "E-TYPE-0030", "Invalid session type"),
    SESSION_TYPE_NOT_FOUND(404, "E-TYPE-0031", "Session type not found"),
    SESSION_TYPE_ALREADY_EXISTS(409, "E-TYPE-0032", "Session type already exists"),

    // ───── PENALTY TYPE ERRORS (004) ─────
    INVALID_PENALTY_TYPE(400, "E-TYPE-0040", "Invalid penalty type"),
    PENALTY_TYPE_NOT_FOUND(404, "E-TYPE-0041", "Penalty type not found"),
    PENALTY_TYPE_ALREADY_EXISTS(409, "E-TYPE-0042", "Penalty type already exists"),

    // ───── NOTIFICATION TYPE ERRORS (005) ─────
    INVALID_NOTIFICATION_TYPE(400, "E-TYPE-0050", "Invalid notification type"),
    NOTIFICATION_TYPE_NOT_FOUND(404, "E-TYPE-0051", "Notification type not found"),
    NOTIFICATION_TYPE_ALREADY_EXISTS(409, "E-TYPE-0052", "Notification type already exists"),

    // ───── CATEGORY TYPE ERRORS (006) ─────
    INVALID_CATEGORY_TYPE(400, "E-TYPE-0060", "Invalid category type"),
    CATEGORY_TYPE_NOT_FOUND(404, "E-TYPE-0061", "Category type not found"),
    CATEGORY_TYPE_ALREADY_EXISTS(409, "E-TYPE-0062", "Category type already exists"),

    // ───── DEVICE TYPE ERRORS (007) ─────
    INVALID_DEVICE_TYPE(400, "E-TYPE-0070", "Invalid device type"),
    DEVICE_TYPE_NOT_FOUND(404, "E-TYPE-0071", "Device type not found"),
    DEVICE_TYPE_ALREADY_EXISTS(409, "E-TYPE-0072", "Device type already exists"),

    // ───── ACTION TYPE ERRORS (008) ─────
    INVALID_ACTION_TYPE(400, "E-TYPE-0080", "Invalid action type"),
    ACTION_TYPE_NOT_FOUND(404, "E-TYPE-0081", "Action type not found"),
    ACTION_TYPE_ALREADY_EXISTS(409, "E-TYPE-0082", "Action type already exists");

    // ─────────────────────────────────────


    ;
    private final int httpStatus;
    private final String code;
    private final String message;

    ErrorCode(int httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
