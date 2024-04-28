package ar.com.capitole.factory;

import ar.com.capitole.infraestructure.adapter.out.persistence.price.entity.BrandEntity;
import ar.com.capitole.infraestructure.adapter.out.persistence.price.entity.PriceEntity;
import ar.com.capitole.infraestructure.adapter.out.persistence.price.entity.ProductEntity;

import java.time.LocalDateTime;

public class PricePersistenceFactory {

    public static PriceEntity getPriceEntity() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setId(2L);
        brandEntity.setName("PULL&BEAR");

        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(1L);
        productEntity.setName("JEAN");
        PriceEntity priceEntity = new PriceEntity();
        priceEntity.setId(1L);
        priceEntity.setBrand(brandEntity);
        priceEntity.setStartDate(LocalDateTime.of(2023, 12, 15, 10, 0, 0));
        priceEntity.setEndDate(LocalDateTime.of(2024, 1, 31, 23, 59, 59));
        priceEntity.setProduct(productEntity);
        priceEntity.setPrice(50.0);
        priceEntity.setPriority(2);
        priceEntity.setCurrency("EUR");
        priceEntity.setPriceList(2);
        return priceEntity;
    }
}
