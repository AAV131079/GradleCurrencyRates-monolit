package com.example.exchange_rates.Exceptions.Handler;

import com.example.exchange_rates.DTO.Response.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.io.IOException;
import java.text.ParseException;

@ControllerAdvice
public class DefaultControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleException(Exception e) {
        return new ResponseEntity<>(new ErrorResponseDTO("Exception", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ErrorResponseDTO> handleException(IOException e) {
        return new ResponseEntity<>(new ErrorResponseDTO("IOException", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ParseException.class)
    public ResponseEntity<ErrorResponseDTO> handleException(ParseException e) {
        return new ResponseEntity<>(new ErrorResponseDTO("ParseException", e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}