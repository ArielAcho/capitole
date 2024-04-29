package ar.com.capitole.it.controller.adapter.out.persistence.price.mapper;

import static ar.com.capitole.factory.PriceFactory.buildPrice;
import static ar.com.capitole.factory.PricePersistenceFactory.getPriceEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

import ar.com.capitole.domain.model.entity.Price;
import ar.com.capitole.infraestructure.adapter.out.persistence.price.entity.PriceEntity;
import ar.com.capitole.infraestructure.adapter.out.persistence.price.mapper.PriceMapper;
import org.junit.jupiter.api.Test;


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

}