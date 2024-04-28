package ar.com.capitole.infraestructure.adapter.in.controllers.price;

import ar.com.capitole.application.ports.in.PriceServicePort;
import ar.com.capitole.domain.model.entity.Brand;
import ar.com.capitole.domain.model.entity.Price;
import ar.com.capitole.domain.model.entity.Product;
import ar.com.capitole.infraestructure.adapter.in.controllers.price.model.PriceResponse;
import ar.com.capitole.infraestructure.adapter.in.controllers.price.model.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static ar.com.capitole.factory.PriceFactory.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceControllerTest {

    @Mock
    private PriceServicePort priceServicePort;

    @InjectMocks
    private PriceController sut;

    @Test
    void givenBrandProductAndDateParameters_shouldReturnResponseWithPrice() {
        // Given
        Price expectedPrice = buildPrice();

        when(priceServicePort
                .findPriceWithHigherPriorityForTheDay(
                        Brand.builder()
                                .id(2L)
                                .build(),
                        Product.builder()
                                .id(1L)
                                .build(),
                        LocalDateTime.of(2024, 4, 28, 10, 0, 0)))
                .thenReturn(expectedPrice);

        // When
        Response actual = sut.getPriceForDate(2L, 1L, LocalDateTime.of(2024, 4, 28, 10, 0, 0));


        // Then
        assertNotNull(actual);
        PriceResponse actualData = (PriceResponse) actual.getData();
        assertEquals(true, actual.getSuccess());
        assertEquals(2, actualData.getBrandId());
        assertEquals(1, actualData.getProductId());
        assertNull(actual.getError());
    }

}