package ar.com.capitole.infraestructure.adapter.out.persistence.price.mapper;

import ar.com.capitole.domain.model.Currency;
import ar.com.capitole.domain.model.DateRange;
import ar.com.capitole.domain.model.entity.Brand;
import ar.com.capitole.domain.model.entity.Price;
import ar.com.capitole.domain.model.entity.Product;
import ar.com.capitole.infraestructure.adapter.out.persistence.price.entity.PriceEntity;

public class PriceMapper {

    private PriceMapper() {
    }

    public static Price to(PriceEntity priceEntity) {
        return Price.builder().id(priceEntity.getId())
                .brand(Brand.builder()
                        .id(priceEntity.getBrand().getId())
                        .name(priceEntity.getBrand().getName())
                        .build())
                .product(Product.builder()
                        .id(priceEntity.getProduct().getId())
                        .name(priceEntity.getProduct().getName())
                        .build())
                .dateRange(DateRange.builder()
                        .startDate(priceEntity.getStartDate())
                        .endDate(priceEntity.getEndDate())
                        .build())
                .currency(Currency.builder()
                        .isoName(priceEntity.getCurrency())
                        .amount(priceEntity.getPrice())
                        .build())
                .priority(priceEntity.getPriority())
                .priceList(priceEntity.getPriceList())
                .build();
    }
}
