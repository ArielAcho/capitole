package ar.com.capitole.application.service;

import ar.com.capitole.application.ports.in.PriceServicePort;
import ar.com.capitole.domain.model.entity.Brand;
import ar.com.capitole.domain.model.entity.Price;
import ar.com.capitole.domain.model.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class PriceService implements PriceServicePort {
    @Override
    public Price findPriceWithHigherPriorityForTheDay(Brand brand, Product product, LocalDateTime date) {
        return null;
    }
}
