package com.inditex.priceapi.infrastructure.mapper;

import com.inditex.priceapi.domain.model.BrandId;
import com.inditex.priceapi.domain.model.Price;
import com.inditex.priceapi.domain.model.ProductId;
import com.inditex.priceapi.infrastructure.repository.jpa.entity.PriceEntity;
import org.springframework.stereotype.Component;

@Component
public class PriceMapper {

  public Price toDomain(PriceEntity entity) {
    return Price.builder()
        .brandId(new BrandId(entity.getBrandId()))
        .productId(new ProductId(entity.getProductId()))
        .priceList(entity.getPriceList())
        .startDate(entity.getStartDate())
        .endDate(entity.getEndDate())
        .priority(entity.getPriority())
        .price(entity.getPrice())
        .curr(entity.getCurr())
        .build();
  }
}