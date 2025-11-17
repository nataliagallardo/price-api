package com.inditex.priceapi.domain.repository;

import com.inditex.priceapi.domain.model.BrandId;
import com.inditex.priceapi.domain.model.Price;
import com.inditex.priceapi.domain.model.ProductId;
import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {
  List<Price> findByBrandProductAndDate(
      BrandId brandId,
      ProductId productId,
      LocalDateTime date
  );
}