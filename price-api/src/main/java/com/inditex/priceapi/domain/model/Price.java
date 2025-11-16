package com.inditex.priceapi.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
public class Price {

    private final BrandId brandId;
    private final ProductId productId;

    private final Long priceList;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;

    private final Integer priority;
    private final BigDecimal price;
    private final String curr;

    public boolean appliesTo(LocalDateTime date) {
      return (date.isEqual(startDate) || date.isAfter(startDate))
          && (date.isBefore(endDate) || date.isEqual(endDate));
    }
}
