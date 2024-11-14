package ttps.quecomemos.exception;

public class TipoComidaInvalidoException extends RuntimeException {
    public TipoComidaInvalidoException() {
    }

    public TipoComidaInvalidoException(String message) {
        super(message);
    }
}
