package ar.com.capitole.infraestructure.adapter.out.persistence.price.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "PRICES")
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
