package ar.com.capitole.infraestructure.adapter.out.persistence.price.repository;

import ar.com.capitole.infraestructure.adapter.out.persistence.price.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceJpaRepository extends JpaRepository<PriceEntity, Integer> {

    @Query("SELECT p FROM PriceEntity p " +
            "WHERE :brandId = p.brand.id " +
            "AND :productId = p.product.id " +
            "AND (:date BETWEEN p.startDate AND p.endDate) ")
    List<PriceEntity> findPriceWithHigherPriorityForTheDay(
            @Param("brandId") Long brandId,
            @Param("productId") Long productId,
            @Param("date") LocalDateTime date);
}
