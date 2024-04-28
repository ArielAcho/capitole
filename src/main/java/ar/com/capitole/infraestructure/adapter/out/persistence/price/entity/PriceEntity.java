package ar.com.capitole.infraestructure.adapter.out.persistence.price.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "PRICES")
public class PriceEntity {
    @Id
    private Long id;
}
