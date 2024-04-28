package ar.com.capitole.infraestructure.adapter.out.persistence.price;

import ar.com.capitole.domain.model.entity.Brand;
import ar.com.capitole.domain.model.entity.Price;
import ar.com.capitole.domain.model.entity.Product;
import ar.com.capitole.infraestructure.adapter.out.persistence.price.entity.BrandEntity;
import ar.com.capitole.infraestructure.adapter.out.persistence.price.entity.PriceEntity;
import ar.com.capitole.infraestructure.adapter.out.persistence.price.entity.ProductEntity;
import ar.com.capitole.infraestructure.adapter.out.persistence.price.repository.PriceJpaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static ar.com.capitole.factory.PriceFactory.*;
import static ar.com.capitole.factory.PricePersistenceFactory.getPriceEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceMySQLPersistenceAdapterTest {

    @Mock
    private PriceJpaRepository jpaRepository;

    @InjectMocks
    private PriceMySQLPersistenceAdapter sut;


    @Test
    void givenFindPriceWithHigherPriorityForTheDay_shouldReturnListOfEntities() {
        // Given
        LocalDateTime date = LocalDateTime.of(2024, 4, 28, 10, 0, 0);

        Product product = buildProductJean();

        Brand brand = buildBrandPullAndBear();

        Price expected = buildPrice();

        List<PriceEntity> priceEntityList = pricesEntityList();

        when(jpaRepository.findPriceWithHigherPriorityForTheDay(brand.getId(),product.getId(),date)).thenReturn(priceEntityList);

        // When
        List<Price> actualList = sut.findPriceWithHigherPriorityForTheDay(brand,product,date);

        assertNotNull(actualList);
        assertEquals(priceEntityList.size(), actualList.size());

        Price actual = actualList.get(0);
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

    private List<PriceEntity> pricesEntityList() {

        PriceEntity onePriceEntity = getPriceEntity();

        return List.of(onePriceEntity);
    }
}