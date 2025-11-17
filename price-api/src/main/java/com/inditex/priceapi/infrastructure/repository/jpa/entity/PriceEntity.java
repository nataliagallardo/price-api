package com.inditex.priceapi.infrastructure.repository.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "PRICES")
public class PriceEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long brandId;
  private Long productId;
  private Long priceList;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private Integer priority;
  private BigDecimal price;
  private String curr;
}
