package ar.com.capitole.infraestructure.adapter.in.controllers.price.model;

import ar.com.capitole.domain.model.entity.Price;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class PriceResponse {
    private Long productId;
    private Long brandId;
    private Integer priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double amount;

    public static PriceResponse from(Price price) {
        return builder()
                .productId(price.getProduct().getId())
                .brandId(price.getBrand().getId())
                .priceList(price.getPriceList())
                .startDate(price.getDateRange().getStartDate())
                .endDate(price.getDateRange().getEndDate())
                .amount(price.getCurrency().getAmount())
                .build();
    }
}
