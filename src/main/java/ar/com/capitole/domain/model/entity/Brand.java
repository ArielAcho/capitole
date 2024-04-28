package ar.com.capitole.domain.model.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Brand {

    private Long id;

    private String name;
}
