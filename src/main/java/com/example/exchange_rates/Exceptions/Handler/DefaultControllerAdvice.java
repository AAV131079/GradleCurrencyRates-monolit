package com.example.exchange_rates.Exceptions.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class DefaultControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleException(Exception e) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Exception");
        response.put("description", e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<Map<String, String>> handleException(IOException e) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "IOException");
        response.put("description", e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ParseException.class)
    public ResponseEntity<Map<String, String>> handleException(ParseException e) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "ParseException");
        response.put("description", e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}