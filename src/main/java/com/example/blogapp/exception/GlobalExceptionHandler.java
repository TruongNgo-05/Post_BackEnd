package com.example.blogapp.exception;

import com.example.blogapp.Common.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<BaseResponse<Object>> handleBusinessException(ApplicationException ex) {
        return ResponseEntity.badRequest().body(new BaseResponse<>(null, ex.getMessage()));
    }
}
