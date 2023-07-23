package com.alibou.security.responses.exceptions;

import com.alibou.security.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
     ApiResponse apiResponse = new ApiResponse(
             e.getMessage(),
             e.getStatus(),
             ZonedDateTime.now(ZoneId.of("Z")),
             e.getDetails(),
             null
     );
     return new ResponseEntity<>(apiResponse, e.getStatus());

    }
}
