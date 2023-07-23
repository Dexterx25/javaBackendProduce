package com.alibou.security.responses.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@Getter
public class ApiRequestException extends RuntimeException {
    private final HttpStatus status;
    private List<Optional<String>> details;
    public ApiRequestException(String message, HttpStatus status) {
        super(message);
        this.status = status;
        this.details = null;
    }
    public ApiRequestException(String message, HttpStatus status, List<Optional<String>> details, Throwable cause) {
        super(message, cause);
        this.status = status;
        this.details = details;
    }
}

