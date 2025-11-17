package com.inditex.priceapi.domain.exception;

import com.inditex.priceapi.infrastructure.exception.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(PriceNotFoundException.class)
  public ResponseEntity<ErrorDto> handlePriceNotFound(PriceNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new ErrorDto(ex.getMessage()));
  }
}