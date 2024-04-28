package ar.com.capitole.application.ports.in;

import ar.com.capitole.domain.model.entity.Brand;
import ar.com.capitole.domain.model.entity.Price;
import ar.com.capitole.domain.model.entity.Product;

import java.time.LocalDateTime;

public interface PriceServicePort {

    Price findPriceWithHigherPriorityForTheDay(Brand brandId, Product product, LocalDateTime date);
    
}
