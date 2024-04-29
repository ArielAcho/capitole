package ar.com.capitole.factory;

import ar.com.capitole.infraestructure.adapter.out.persistence.price.entity.BrandEntity;
import ar.com.capitole.infraestructure.adapter.out.persistence.price.entity.PriceEntity;
import ar.com.capitole.infraestructure.adapter.out.persistence.price.entity.ProductEntity;

import java.time.LocalDateTime;

public class PricePersistenceFactory {

    public static PriceEntity getPriceEntity() {
        BrandEntity brandEntity = BrandEntity.builder()
                .id(2L)
                .name("PULL&BEAR").build();

        ProductEntity productEntity = ProductEntity.builder()
                .id(1L)
                .name("JEAN").build();

        return PriceEntity.builder()
                .id(1L)
                .brand(brandEntity)
                .startDate(LocalDateTime.of(2023, 12, 15, 10, 0, 0))
                .endDate(LocalDateTime.of(2024, 1, 31, 23, 59, 59))
                .product(productEntity)
                .price(50.0)
                .priority(2)
                .currency("EUR")
                .priceList(2)
                .build();
    }
}
