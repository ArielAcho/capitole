package ar.com.capitole.application.service;

import ar.com.capitole.application.exception.PriceNotAvailableException;
import ar.com.capitole.application.ports.in.PriceServicePort;
import ar.com.capitole.application.ports.out.PricePersistencePort;
import ar.com.capitole.domain.model.Currency;
import ar.com.capitole.domain.model.DateRange;
import ar.com.capitole.domain.model.entity.Brand;
import ar.com.capitole.domain.model.entity.Price;
import ar.com.capitole.domain.model.entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static ar.com.capitole.factory.PriceFactory.*;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceServiceTest {

    @Mock
    private PricePersistencePort pricePersistencePort;

    @InjectMocks
    private PriceService sut;

    @Test
    void given_findPriceWithHigherPriorityForTheDay_shouldReturnPriceWithHigherPriority() {

        // Given
        LocalDateTime date = LocalDateTime.of(2024, 4, 28, 10, 0, 0);

        Product product = buildProductJean();

        Brand brand = buildBrandPullAndBear();

        when(pricePersistencePort
                .findPriceWithHigherPriorityForTheDay(brand, product, date))
                .thenReturn(buildPricesList());
        Price expected = buildExpectedPrice();

        // When
        Price actual = sut.findPriceWithHigherPriorityForTheDay(brand, product, date);

        // Then
        assertEquals(expected.getPriority(), actual.getPriority());
        assertEquals(expected.getCurrency(), actual.getCurrency());
    }

    @Test
    void givenExecute_shouldThrowException() {
        // Given
        Product product = buildProductJean();

        Brand brand = buildBrandPullAndBear();

        LocalDateTime date = LocalDateTime.of(2024, 4, 28, 10, 0, 0);

        when(pricePersistencePort
                .findPriceWithHigherPriorityForTheDay(brand, product, date))
                .thenReturn(List.of());

        // When
        final PriceNotAvailableException e = new PriceNotAvailableException();

        // Then
        assertThatCode(() -> sut.findPriceWithHigherPriorityForTheDay(brand, product, date))
                .hasMessage("Price is not available");
    }

    private Price buildExpectedPrice() {
        return Price.builder()
                .id(2L)
                .brand(Brand.builder()
                        .id(2L)
                        .name("PULL&BEAR")
                        .build())
                .product(Product.builder()
                        .id(55555L)
                        .name("JEAN")
                        .build())
                .dateRange(DateRange.builder()
                        .startDate(LocalDateTime.of(2024, 4, 1, 0, 0, 0))
                        .endDate(LocalDateTime.of(2024, 4, 30, 23, 59, 59))
                        .build())
                .priority(2)
                .priceList(2)
                .currency(Currency.builder()
                        .amount(50.0)
                        .isoName("EUR")
                        .build())
                .build();
    }
}