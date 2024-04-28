package ar.com.capitole.application.exception;

public class PriceNotAvailableException extends ResourceNotAvailableException {

    public PriceNotAvailableException() {
        super("Price is not available");
    }
}
