package ar.com.capitole.domain.model.entity;

import ar.com.capitole.domain.model.Currency;
import ar.com.capitole.domain.model.DateRange;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Price {
    private Long id;
    private Product product;
    private Brand brand;
    private DateRange dateRange;
    private Currency currency;
    private Integer priority;
    private Integer priceList;
}
