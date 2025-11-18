package com.inditex.priceapi.aplication;

import com.inditex.priceapi.application.service.FindPriceService;
import com.inditex.priceapi.domain.model.BrandId;
import com.inditex.priceapi.domain.model.Price;
import com.inditex.priceapi.domain.model.ProductId;
import com.inditex.priceapi.domain.repository.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;

class FindPriceServiceTest {

  @Mock
  private PriceRepository priceRepository;

  @InjectMocks
  private FindPriceService findPriceService;

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void returnPriceWithHighestPriority() {
    BrandId brandId = new BrandId(1L);
    ProductId productId = new ProductId(35455L);
    LocalDateTime date = LocalDateTime.of(2020, 6, 14, 16, 0);

    Price lowPriority = Price.builder()
        .brandId(brandId)
        .productId(productId)
        .priceList(1L)
        .startDate(date)
        .endDate(date)
        .priority(0)
        .price(BigDecimal.valueOf(35.50))
        .curr("EUR")
        .build();

    Price highPriority = Price.builder()
        .brandId(brandId)
        .productId(productId)
        .priceList(2L)
        .startDate(date)
        .endDate(date)
        .priority(1)
        .price(BigDecimal.valueOf(25.45))
        .curr("EUR")
        .build();

    when(priceRepository.findByBrandProductAndDate(brandId, productId, date))
        .thenReturn(List.of(lowPriority, highPriority));

    Optional<Price> result = findPriceService.findPrice(brandId, productId, date);

    assertThat(result).isPresent();
    assertThat(result.get().getPriority()).isEqualTo(1);
    assertThat(result.get().getPriceList()).isEqualTo(2L);

    verify(priceRepository, times(1))
        .findByBrandProductAndDate(brandId, productId, date);
  }

  @Test
  void returnEmptyWhenNoPricesFound() {
    BrandId brandId = new BrandId(1L);
    ProductId productId = new ProductId(35455L);
    LocalDateTime date = LocalDateTime.of(2020, 6, 14, 10, 0);

    when(priceRepository.findByBrandProductAndDate(brandId, productId, date))
        .thenReturn(List.of());

    Optional<Price> result = findPriceService.findPrice(brandId, productId, date);

    assertThat(result).isEmpty();
  }
}
