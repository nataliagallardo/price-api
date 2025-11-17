package com.inditex.priceapi.infrastructure.repository.adapter;

import com.inditex.priceapi.domain.model.BrandId;
import com.inditex.priceapi.domain.model.Price;
import com.inditex.priceapi.domain.model.ProductId;
import com.inditex.priceapi.domain.repository.PriceRepository;
import com.inditex.priceapi.infrastructure.repository.jpa.JpaPriceRepository;
import com.inditex.priceapi.infrastructure.mapper.PriceMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PriceRepositoryAdapter implements PriceRepository {

  private final JpaPriceRepository jpaRepository;
  private final PriceMapper mapper;

  public PriceRepositoryAdapter(JpaPriceRepository jpaRepository, PriceMapper priceMapper) {
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