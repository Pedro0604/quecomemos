package ttps.quecomemos.exception;

public class MenuSinComidasException extends RuntimeException {
    public MenuSinComidasException() {
    }

    public MenuSinComidasException(String message) {
        super(message);
    }
}