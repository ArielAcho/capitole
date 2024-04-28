package ar.com.capitole.infraestructure.adapter.out.persistence.price.mapper;

import static ar.com.capitole.factory.PriceFactory.buildPrice;
import static org.junit.jupiter.api.Assertions.assertEquals;

import ar.com.capitole.domain.model.entity.Price;
import ar.com.capitole.infraestructure.adapter.out.persistence.price.entity.BrandEntity;
import ar.com.capitole.infraestructure.adapter.out.persistence.price.entity.PriceEntity;
import ar.com.capitole.infraestructure.adapter.out.persistence.price.entity.ProductEntity;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class PriceMapperTest {

    @Test
    void givenTo_shouldReturnPrice() {
        PriceEntity priceEntity = getPriceEntity();

        Price expected = buildPrice();

        Price actual = PriceMapper.to(priceEntity);

        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getProduct().getId(), actual.getProduct().getId());
        assertEquals(expected.getProduct().getName(), actual.getProduct().getName());
        assertEquals(expected.getBrand().getId(), actual.getBrand().getId());
        assertEquals(expected.getBrand().getName(), actual.getBrand().getName());
        assertEquals(expected.getCurrency().getIsoName(), actual.getCurrency().getIsoName());
        assertEquals(expected.getCurrency().getAmount(), actual.getCurrency().getAmount());
        assertEquals(expected.getPriority(), actual.getPriority());
        assertEquals(expected.getPriceList(), actual.getPriceList());
        assertEquals(expected.getDateRange().getEndDate(),actual.getDateRange().getEndDate());
        assertEquals(expected.getDateRange().getStartDate(),actual.getDateRange().getStartDate());


    }

    private static PriceEntity getPriceEntity() {
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