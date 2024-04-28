package ar.com.capitole.infraestructure.adapter.in.controllers.price.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Builder
public class Error {

    private String code;
    private String error;
    private String cause;

    public Error(String code, String error, String cause) {
        this.code = code;
        this.error = error;
        this.cause = cause;
    }
}

