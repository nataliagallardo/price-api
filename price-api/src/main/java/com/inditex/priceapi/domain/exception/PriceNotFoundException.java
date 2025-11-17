package com.inditex.priceapi.domain.exception;

public class PriceNotFoundException extends RuntimeException {

  private static final String MESSAGE = "No existe un precio para brandId=%d, productId=%d, applicationDate=%s";

  public PriceNotFoundException(Long brandId, Long productId, String applicationDate) {
    super(String.format(MESSAGE, brandId, productId, applicationDate));
  }
}