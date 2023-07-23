package com.alibou.security.responses.success;

import com.alibou.security.responses.ApiResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Getter
public class ApiRequestSuccess {
    private final String message;
    private final HttpStatus status;
    private List<Optional<String>> details;
    private Object body;
    public ApiRequestSuccess(String message, HttpStatus status, Object body) {
        this.message = message;
        this.status = status;
        this.details = null;
        this.body = body;
    }
    public ApiRequestSuccess(String message, HttpStatus status, Object body, List<Optional<String>> details) {
        this.message = message;
        this.status = status;
        this.details = details;
        this.body = body;
    }
    public ApiResponse res (){
                return new ApiResponse(
                this.getMessage(),
                this.getStatus(),
                ZonedDateTime.now(ZoneId.of("Z")),
                this.getDetails(), this.getBody()
                );
    }
}

