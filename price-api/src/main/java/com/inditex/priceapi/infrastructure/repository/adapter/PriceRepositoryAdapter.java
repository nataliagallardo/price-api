package com.inditex.priceapi.infrastructure.repository.adapter;

import com.inditex.priceapi.domain.model.BrandId;
import com.inditex.priceapi.domain.model.Price;
import com.inditex.priceapi.domain.model.ProductId;
import com.inditex.priceapi.infrastructure.repository.jpa.PriceRepository;
import com.inditex.priceapi.infrastructure.mapper.PriceMapper;
import java.time.LocalDateTime;
import java.util.List;

public class PriceRepositoryAdapter implements com.inditex.priceapi.domain.repository.PriceRepository {

  private final PriceRepository jpaRepository;
  private final PriceMapper mapper;

  public PriceRepositoryAdapter(PriceRepository jpaRepository, PriceMapper priceMapper) {
    this.jpaRepository = jpaRepository;
    this.mapper = priceMapper;
  }

  @Override
  public List<Price> findByBrandProductAndDate(BrandId brandId, ProductId productId, LocalDateTime date) {
    return jpaRepository
        .findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            brandId.getValue(),
            productId.getValue(),
            date,
            date
        )
        .stream()
        .map(mapper::toDomain)
        .toList();
  }
}