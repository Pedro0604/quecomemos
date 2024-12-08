package ttps.quecomemos.exception;

public class TipoComidaDuplicadoException extends RuntimeException {
    public TipoComidaDuplicadoException() {
    }

    public TipoComidaDuplicadoException(String message) {
        super(message);
    }
}