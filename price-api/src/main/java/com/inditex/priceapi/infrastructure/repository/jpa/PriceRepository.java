package com.inditex.priceapi.infrastructure.repository.jpa;

import com.inditex.priceapi.infrastructure.repository.jpa.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

  List<PriceEntity> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
      Long brandId,
      Long productId,
      LocalDateTime date1,
      LocalDateTime date2
  );
}
