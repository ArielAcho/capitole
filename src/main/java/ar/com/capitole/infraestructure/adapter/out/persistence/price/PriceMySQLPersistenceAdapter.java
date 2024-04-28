package ar.com.capitole.infraestructure.adapter.out.persistence.price;

import ar.com.capitole.application.ports.out.PricePersistencePort;
import ar.com.capitole.domain.model.entity.Brand;
import ar.com.capitole.domain.model.entity.Price;
import ar.com.capitole.domain.model.entity.Product;
import ar.com.capitole.infraestructure.adapter.out.persistence.price.entity.PriceEntity;
import ar.com.capitole.infraestructure.adapter.out.persistence.price.mapper.PriceMapper;
import ar.com.capitole.infraestructure.adapter.out.persistence.price.repository.PriceJpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PriceMySQLPersistenceAdapter implements PricePersistencePort {

    private final PriceJpaRepository jpaRepository;

    public PriceMySQLPersistenceAdapter(PriceJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Price> findPriceWithHigherPriorityForTheDay(Brand brand, Product product, LocalDateTime date) {
        List<PriceEntity> priceEntityList = jpaRepository.findPriceWithHigherPriorityForTheDay(brand.getId(), product.getId(), date);

        return priceEntityList.stream()
                .map(PriceMapper::to)
                .toList();
    }
}