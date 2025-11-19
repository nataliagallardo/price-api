package com.inditex.priceapi.application.usecase;

import com.inditex.priceapi.application.dto.PriceResponse;
import com.inditex.priceapi.domain.model.BrandId;
import com.inditex.priceapi.domain.model.ProductId;

import java.time.LocalDateTime;

public interface FindPriceUseCase {
  PriceResponse findPrice(BrandId brandId, ProductId productId, LocalDateTime applicationDate);
}