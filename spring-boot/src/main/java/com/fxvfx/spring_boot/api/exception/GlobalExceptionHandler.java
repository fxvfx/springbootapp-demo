package com.fxvfx.spring_boot.api.exception;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(FriendNotFoundException.class)
    // public ResponseEntity<String> handleFriendNotFound(FriendNotFoundException e) {
    //     return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    // }
    public ResponseEntity<Map<String, Object>> handleFriendNotFound(FriendNotFoundException e, HttpServletRequest request) {
        
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", Instant.now().toString());
        body.put("status", 404);
        body.put("error", "Resource not found");
        body.put("message", e.getMessage());
        body.put("path", request.getRequestURI());
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
}
