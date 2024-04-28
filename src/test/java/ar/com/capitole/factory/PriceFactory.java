package ar.com.capitole.factory;

import ar.com.capitole.domain.model.Currency;
import ar.com.capitole.domain.model.DateRange;
import ar.com.capitole.domain.model.entity.Brand;
import ar.com.capitole.domain.model.entity.Price;
import ar.com.capitole.domain.model.entity.Product;

import java.time.LocalDateTime;
import java.util.List;

public class PriceFactory {

    public static List<Price> buildPricesList() {
        return List.of(
                Price.builder()
                        .id(1L)
                        .brand(Brand.builder()
                                .id(1L)
                                .name("ZARA")
                                .build())
                        .product(Product.builder()
                                .id(55555L)
                                .build())
                        .dateRange(DateRange.builder()
                                .startDate(LocalDateTime.of(2024, 11, 21, 10, 0, 0))
                                .endDate(LocalDateTime.of(2024, 12, 31, 23, 59, 59))
                                .build())
                        .priority(1)
                        .priceList(1)
                        .currency(Currency.builder()
                                .amount(55.0)
                                .isoName("EUR")
                                .build())
                        .build(),
                buildPrice()
        );
    }

    public static Price buildPrice() {
        return Price.builder()
                .id(1L)
                .brand(buildBrandPullAndBear())
                .product(buildProductJean())
                .dateRange(DateRange.builder()
                        .startDate(LocalDateTime.of(2023, 12, 15, 10, 0, 0))
                        .endDate(LocalDateTime.of(2024, 1, 31, 23, 59, 59))
                        .build())
                .priority(2)
                .priceList(2)
                .currency(Currency.builder()
                        .amount(50.0)
                        .isoName("EUR")
                        .build())
                .build();
    }


    public static Product buildProductJean() {
        return Product.builder()
                .id(1L)
                .name("JEAN")
                .build();
    }
    public static Brand buildBrandPullAndBear() {
        return Brand.builder()
                .id(2L)
                .name("PULL&BEAR")
                .build();
    }
}
