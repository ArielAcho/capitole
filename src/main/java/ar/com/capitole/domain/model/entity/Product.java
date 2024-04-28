package ar.com.capitole.domain.model.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Product {

    private Long id;

    private String name;
}
