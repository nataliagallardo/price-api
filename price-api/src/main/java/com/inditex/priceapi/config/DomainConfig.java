package com.inditex.priceapi.config;

import com.inditex.priceapi.domain.service.PriceSelectorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {

  @Bean
  public PriceSelectorService priceSelectorService() {
    return new PriceSelectorService();
  }
}
