package com.inditex.priceapi.domain.exception;

import com.inditex.priceapi.infrastructure.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  public static final String PRICE_NOT_FOUND = "PRICE_NOT_FOUND";

  @ExceptionHandler(PriceNotFoundException.class)
  public ResponseEntity<ErrorResponse> handlePriceNotFound(PriceNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new ErrorResponse( HttpStatus.NOT_FOUND.value(),
            PRICE_NOT_FOUND,
            ex.getMessage()));
  }
}