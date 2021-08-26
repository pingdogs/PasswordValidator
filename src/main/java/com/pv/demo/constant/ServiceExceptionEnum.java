package com.pv.demo.constant;

public enum ServiceExceptionEnum {

    SUCCESS(0, "Success"),
    SYS_ERROR(1, "Server Error"),
    VALIDATION_ERROR(2, "Valitation Error");
    private final int code;
    private final String message;

    ServiceExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
