package com.inditex.priceapi.domain.exception;

import java.time.LocalDateTime;

public class PriceNotFoundException extends RuntimeException {

  public PriceNotFoundException(Long brandId, Long productId, LocalDateTime date) {
    super("No price found for product " + productId +
        ", brand " + brandId +
        " at date " + date);
  }
}