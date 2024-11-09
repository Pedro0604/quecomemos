package ttps.quecomemos.exception;

import jakarta.persistence.PersistenceException;

public class EmptyListException extends PersistenceException {
    public EmptyListException() {
    }
}
