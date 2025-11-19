package com.inditex.priceapi.domain.service;

import com.inditex.priceapi.domain.model.Price;

import java.util.Comparator;
import java.util.List;

public class PriceSelectorService {

  public Price selectPrice(List<Price> prices) {
    return prices.stream()
        .max(Comparator.comparingInt(Price::getPriority))
        .orElse(null);
  }
}
