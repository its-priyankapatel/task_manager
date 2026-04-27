package com.taskManager.management.Exception;

import com.taskManager.management.dto.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GenericExceptionHandler {
    @ExceptionHandler(InvalidException.class)
    ResponseEntity<ExceptionResponse> invalidExceptionHandler(InvalidException e)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponse(true,e.getMessage()));
    }
}
