package es.fcodiazrobles.mnemo.usuarios.util;

public class UsuariosException extends Exception {
    public UsuariosException(String message) {
        super(message);
    }

    public UsuariosException(String message, Throwable ex) {
        super(message, ex);
    }

    public UsuariosException(Throwable ex) {
        super(ex);
    }
}
