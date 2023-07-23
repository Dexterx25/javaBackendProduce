package com.alibou.security.responses;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Getter
public class ApiResponse {

    private final ZonedDateTime timestamp;
    private final Integer statusCode;
    private final String status;
    private final String message;
    private final List<Optional<String>> details;
    private final Object body;

    public ApiResponse(
            String message,
            HttpStatus httpStatus,
            ZonedDateTime zonedDateTime,
            List<Optional<String>> details,
            Object body
    ){
        this.timestamp = zonedDateTime;
        this.statusCode = httpStatus.value();
        this.status = httpStatus.getReasonPhrase();
        this.message = message;
        this.details = details;
        this.body = body;
    }


}
