package ar.com.capitole.domain.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Currency {
    private String isoName;
    private Double amount;
}
