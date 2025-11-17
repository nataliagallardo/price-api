package com.inditex.priceapi.application.usecase;

import com.inditex.priceapi.domain.model.BrandId;
import com.inditex.priceapi.domain.model.Price;
import com.inditex.priceapi.domain.model.ProductId;

import java.time.LocalDateTime;
import java.util.Optional;

public interface FindPriceUseCase {
  Optional<Price> findPrice(BrandId brandId, ProductId productId, LocalDateTime applicationDate);
}