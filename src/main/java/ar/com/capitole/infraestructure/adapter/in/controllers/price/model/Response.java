package ar.com.capitole.infraestructure.adapter.in.controllers.price.model;

import lombok.Getter;

import java.util.Collections;

@Getter
public final class Response<T, E> {

    private final Boolean success;
    private final T data;
    private final E error;

    private Response(Boolean success, T data, E error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }

    @SuppressWarnings("unchecked")
    public static <T, E> Response<T, E> ok(T data) {
        data = data != null ? data : (T) Collections.emptyMap();
        return new Response<>(true, data, null);
    }

    @SuppressWarnings("unchecked")
    public static <T, E> Response<T, E> error(E error) {
        error = error != null ? error : (E) Error.builder().build();
        return new Response<>(false, null, error);
    }

}