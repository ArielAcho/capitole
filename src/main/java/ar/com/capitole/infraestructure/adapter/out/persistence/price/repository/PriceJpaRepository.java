package ar.com.capitole.infraestructure.adapter.out.persistence.price.repository;

import ar.com.capitole.infraestructure.adapter.out.persistence.price.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceJpaRepository extends JpaRepository<PriceEntity, Integer> {
}
