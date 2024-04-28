package ar.com.capitole.infraestructure.exception;

import ar.com.capitole.application.exception.ResourceNotAvailableException;
import ar.com.capitole.infraestructure.adapter.in.controllers.price.model.Error;
import ar.com.capitole.infraestructure.adapter.in.controllers.price.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Objects;

@RestControllerAdvice
@Slf4j
public class RestResponseExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response<Object, Error> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
        var errorMessage = String.format("Invalid argument type: %s should be %s",
                ex.getName(),
                Objects.requireNonNull(ex.getRequiredType()).getSimpleName());
        return Response.error(
                Error.builder()
                        .code(ex.getErrorCode())
                        .error(ex.getClass().getSimpleName())
                        .cause(errorMessage)
                        .build());
    }

    @ExceptionHandler(value = {ResourceNotAvailableException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Response<Object, Error> handlePriceNotFoundException(final ResourceNotAvailableException ex) {
        return Response.error(
                Error.builder()
                        .code(ResourceNotAvailableException.ERROR_CODE)
                        .error(ex.getClass().getSimpleName())
                        .cause("Incorrect parameters: Entity not available")
                        .build());
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<Object, Error> handleUncaughtException(final Exception ex) {
        log.error("Uncaught exception", ex);
        return Response.error(
                Error.builder()
                        .code("uncaughtException")
                        .error(ex.getClass().getSimpleName())
                        .cause(ex.getMessage())
                        .build());
    }
}
