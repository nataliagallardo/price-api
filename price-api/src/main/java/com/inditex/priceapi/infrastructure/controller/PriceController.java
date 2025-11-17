package com.inditex.priceapi.infrastructure.controller;

import com.inditex.priceapi.application.usecase.FindPriceUseCase;
import com.inditex.priceapi.domain.exception.PriceNotFoundException;
import com.inditex.priceapi.domain.model.BrandId;
import com.inditex.priceapi.domain.model.Price;
import com.inditex.priceapi.domain.model.ProductId;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
public class PriceController {

  private final FindPriceUseCase findPriceUseCase;

  public PriceController(FindPriceUseCase findPriceUseCase) {
    this.findPriceUseCase = findPriceUseCase;
  }

  @Operation(
      summary = "Obtiene el precio aplicable",
      description = "Busca el precio válido para el brandId, productId y fecha de aplicación"
  )
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Precio encontrado"),
      @ApiResponse(responseCode = "404", description = "No se encontró un precio aplicable"),
  })
  @GetMapping
  public ResponseEntity<?> getPrice(
      @RequestParam Long brandId,
      @RequestParam Long productId,
      @RequestParam
      @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
      LocalDateTime applicationDate
  ) {

    Price price = findPriceUseCase.findPrice(
        new BrandId(brandId),
        new ProductId(productId),
        applicationDate
    ).orElseThrow(() -> new PriceNotFoundException(brandId, productId, applicationDate));

    return ResponseEntity.ok(
        new PriceResponseDto(
            price.getProductId().getValue(),
            price.getBrandId().getValue(),
            price.getPriceList(),
            price.getStartDate(),
            price.getEndDate(),
            price.getPrice()
        )
    );
  }
}