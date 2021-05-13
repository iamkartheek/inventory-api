package com.upgrad.course.demo.exception.dto;

import java.util.List;

public class ErrorResponse {

    public String message;
    public List<String> errorDetails;

    public ErrorResponse(String message, List<String> errorDetails) {
        this.message = message;
        this.errorDetails = errorDetails;
    }
}
