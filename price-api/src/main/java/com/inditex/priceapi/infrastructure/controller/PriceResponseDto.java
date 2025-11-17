package com.inditex.priceapi.infrastructure.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PriceResponseDto(
    Long productId,
    Long brandId,
    Long priceList,
    LocalDateTime startDate,
    LocalDateTime endDate,
    BigDecimal price
) {

}