package com.inditex.priceapi.application.service;

import com.inditex.priceapi.application.dto.PriceResponse;
import com.inditex.priceapi.application.usecase.FindPriceUseCase;
import com.inditex.priceapi.domain.exception.PriceNotFoundException;
import com.inditex.priceapi.domain.model.BrandId;
import com.inditex.priceapi.domain.model.Price;
import com.inditex.priceapi.domain.model.ProductId;
import com.inditex.priceapi.domain.repository.PriceRepository;
import com.inditex.priceapi.domain.service.PriceSelectorService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class FindPriceService implements FindPriceUseCase {


  private final PriceRepository priceRepository;
  private final PriceSelectorService selectorService;

  public FindPriceService(PriceRepository priceRepository, PriceSelectorService selectorService)
  {
    this.priceRepository = priceRepository;
    this.selectorService = selectorService;
  }

  @Override
  public PriceResponse findPrice(BrandId brandId, ProductId productId, LocalDateTime date) {
//    return priceRepository.findByBrandProductAndDate(brandId, productId, date)
//        .stream()
//        .max(Comparator.comparing(Price::getPriority));
//  }

    List<Price> prices = priceRepository.findByBrandProductAndDate(brandId, productId, date);
    Price selectedPrice = selectorService.selectPrice(prices);
    if (Objects.isNull(selectedPrice)) {
      throw new PriceNotFoundException(brandId.getValue(), productId.getValue(), date.toString());
    }
    return new PriceResponse(
        selectedPrice.getProductId().getValue(),
        selectedPrice.getBrandId().getValue(),
        selectedPrice.getPriceList(),
        selectedPrice.getStartDate(),
        selectedPrice.getEndDate(),
        selectedPrice.getPrice()
    );
  }

}
