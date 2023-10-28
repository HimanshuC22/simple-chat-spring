package com.example.notionpainter.exceptions;

import com.example.notionpainter.models.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<BaseResponse<?>> handleUserNotFoundException(UserNotFoundException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BaseResponse.builder()
                .success(false)
                .message(e.getMessage())
                .build());
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<BaseResponse<?>> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BaseResponse.builder()
                .success(false)
                .message(e.getMessage())
                .build());
    }
}
