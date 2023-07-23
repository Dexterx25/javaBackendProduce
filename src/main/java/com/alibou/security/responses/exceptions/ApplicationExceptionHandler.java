package com.alibou.security.responses.exceptions;

import com.alibou.security.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestControllerAdvice
public class ApplicationExceptionHandler {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse handleInvalidArgument(MethodArgumentNotValidException ex) {
        List<Optional<String>> errorMap = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.add(Optional.of(error.getField() + " " + error.getDefaultMessage()));
        });
        return new ApiResponse(
                "Fields's validation executed",
                HttpStatus.UNPROCESSABLE_ENTITY,
                ZonedDateTime.now(ZoneId.of("Z")),
                errorMap,
                null
                );
    }

}