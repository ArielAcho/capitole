package ar.com.capitole.application.exception;

public class ResourceNotAvailableException extends RuntimeException {

    public static final String ERROR_CODE = "RESOURCE_NOT_AVAILABLE";

    public ResourceNotAvailableException(String message) {
        super(message);
    }
}
