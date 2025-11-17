package com.inditex.priceapi.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("Inditex Price API")
            .description("API para consulta de precios según brand, product y fecha de aplicación")
            .version("1.0.0")
        );
  }
}