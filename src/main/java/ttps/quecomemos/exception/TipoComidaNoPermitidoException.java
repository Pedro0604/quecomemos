package ttps.quecomemos.exception;

public class TipoComidaNoPermitidoException extends RuntimeException {
    public TipoComidaNoPermitidoException() {
    }

    public TipoComidaNoPermitidoException(String message) {
        super(message);
    }
}