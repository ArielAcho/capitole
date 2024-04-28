package ar.com.capitole.application.ports.out;

import ar.com.capitole.domain.model.entity.Brand;
import ar.com.capitole.domain.model.entity.Price;
import ar.com.capitole.domain.model.entity.Product;

import java.time.LocalDateTime;
import java.util.List;

public interface PricePersistencePort {

    List<Price> findPriceWithHigherPriorityForTheDay(Brand brand, Product product, LocalDateTime date);
}
