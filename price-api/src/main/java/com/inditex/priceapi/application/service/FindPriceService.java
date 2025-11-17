package com.inditex.priceapi.application.service;

import com.inditex.priceapi.application.usecase.FindPriceUseCase;
import com.inditex.priceapi.domain.exception.PriceNotFoundException;
import com.inditex.priceapi.domain.model.BrandId;
import com.inditex.priceapi.domain.model.Price;
import com.inditex.priceapi.domain.model.ProductId;
import com.inditex.priceapi.domain.repository.PriceRepository;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;

public class FindPriceService implements FindPriceUseCase {

  private final PriceRepository priceRepository;

  public FindPriceService(PriceRepository priceRepository) {
    this.priceRepository = priceRepository;
  }

  @Override
  public Optional<Price> findPrice(BrandId brandId, ProductId productId, LocalDateTime date) {
    return priceRepository.findByBrandProductAndDate(brandId, productId, date)
        .stream()
        .max(Comparator.comparing(Price::getPriority));
  }
}
