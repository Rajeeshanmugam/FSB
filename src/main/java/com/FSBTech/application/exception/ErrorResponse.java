package com.FSBTech.application.exception;

import lombok.Data;

@Data
public class ErrorResponse {
    private String errorCode;
    private String errorMsg;
}
