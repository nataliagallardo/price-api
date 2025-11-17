package com.inditex.priceapi.infrastructure.controller;

import com.inditex.priceapi.domain.exception.PriceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(PriceNotFoundException.class)
  public ResponseEntity<?> handlePriceNotFound(PriceNotFoundException ex) {

    Map<String, Object> body = Map.of(
        "timestamp", LocalDateTime.now(),
        "error", "Price not found",
        "message", ex.getMessage()
    );

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
  }
}
