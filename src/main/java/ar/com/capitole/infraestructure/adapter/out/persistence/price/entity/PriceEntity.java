package ar.com.capitole.infraestructure.adapter.out.persistence.price.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "PRICES")
public class PriceEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brandId", referencedColumnName = "id")
    private BrandEntity brand;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private ProductEntity product;

    private Integer priority;

    private Double price;

    @Column(name = "curr")
    private String currency;

    @Column(name = "price_list")
    private Integer priceList;
}
