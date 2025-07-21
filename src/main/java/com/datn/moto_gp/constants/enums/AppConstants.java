package com.datn.moto_gp.constants.enums;

public class AppConstants {

        // Pagination
        public static final int DEFAULT_PAGE_NUMBER = 0;
        public static final int DEFAULT_PAGE_SIZE = 10;
        public static final int MAX_PAGE_SIZE = 100;

        // Security
        public static final String TOKEN_PREFIX = "Bearer ";
        public static final String HEADER_STRING = "Authorization";

        // DateTime format
        public static final String DATE_FORMAT = "yyyy-MM-dd";
        public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

        // File upload
        public static final long MAX_FILE_SIZE = 5 * 1024 * 1024; // 5MB
        public static final String[] ALLOWED_IMAGE_TYPES = {"image/jpeg", "image/png"};

        // Default status
        public static final Long STATUS_ACTIVE = 1L;
        public static final Long STATUS_INACTIVE = 2L;

        // Other constants
        public static final String SYSTEM_ACCOUNT = "system";
}


