package ttps.quecomemos.exception;

public class ComidaNoVegetarianaException extends RuntimeException {
    public ComidaNoVegetarianaException() {
    }

    public ComidaNoVegetarianaException(String message) {
        super(message);
    }
}