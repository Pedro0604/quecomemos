package ttps.quecomemos.exception;

public class MenuDiarioSinMenusException extends RuntimeException {
    public MenuDiarioSinMenusException() {
    }

    public MenuDiarioSinMenusException(String message) {
        super(message);
    }
}