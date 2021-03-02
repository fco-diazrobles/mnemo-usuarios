package es.fcodiazrobles.mnemo.usuarios.util;

public class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable ex) {
        super(message, ex);
    }

    public ValidationException(Throwable ex) {
        super(ex);
    }
}
