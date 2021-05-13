package com.upgrad.course.demo.exception.handler;

import com.upgrad.course.demo.exception.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

    @ControllerAdvice
    public class CustomHandlerException extends ResponseEntityExceptionHandler {

        private String NO_RECORDS_FOUND = "NO_RECORDS_FOUND";
        private String BAD_REQUEST = "BAD_REQUEST";

        @ExceptionHandler
        public final ResponseEntity<ErrorResponse> handleRecordNotFoundException(RuntimeException e, WebRequest req){
            List<String> errorDetails = new ArrayList<String>();
            errorDetails.add(e.getLocalizedMessage());
            ErrorResponse response = new ErrorResponse(NO_RECORDS_FOUND,errorDetails);

            return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
        }
    }

