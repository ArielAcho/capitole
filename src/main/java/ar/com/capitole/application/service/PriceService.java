package ar.com.capitole.application.service;

import ar.com.capitole.application.exception.PriceNotAvailableException;
import ar.com.capitole.application.ports.in.PriceServicePort;
import ar.com.capitole.application.ports.out.PricePersistencePort;
import ar.com.capitole.domain.model.entity.Brand;
import ar.com.capitole.domain.model.entity.Price;
import ar.com.capitole.domain.model.entity.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PriceService implements PriceServicePort {

    private final PricePersistencePort pricePersistencePort;

    @Override
    public Price findPriceWithHigherPriorityForTheDay(Brand brand, Product product, LocalDateTime date) {
        List<Price> priceList = pricePersistencePort.findPriceWithHigherPriorityForTheDay(brand, product, date);

        return priceList
                .stream()
                .max(Comparator.comparingInt(Price::getPriority))
                .orElseThrow(() -> {
                    log.error("Price not available for parameters {}, {}, {}", brand.getId(), product.getId(), date);
                    return new PriceNotAvailableException();
                });
    }
}
