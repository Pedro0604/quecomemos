package ttps.quecomemos.configuration;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ttps.quecomemos.exception.*;

@RestControllerAdvice
public class GlobalExceptionHandler {
    public static String getFormatedMessage(String baseMessage, Exception e) {
        String exceptionMessage = e.getMessage();
        return baseMessage + (exceptionMessage != null && !exceptionMessage.isEmpty() ? " - " + exceptionMessage : "");
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException e) {
        return new ResponseEntity<>(getFormatedMessage("Entidad no encontrada", e), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>(getFormatedMessage("Argumento inválido", e), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ComidaNoVegetarianaException.class)
    public ResponseEntity<String> handleComidaNoVegetarianaException(ComidaNoVegetarianaException e) {
        return new ResponseEntity<>(getFormatedMessage("Error: Un menú vegetariano no puede contener comidas no vegetarianas", e), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TipoComidaNoPermitidoException.class)
    public ResponseEntity<String> handleTipoComidaNoPermitidoException(TipoComidaNoPermitidoException e) {
        return new ResponseEntity<>(getFormatedMessage("Error: Tipo de comida no permitido", e), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TipoComidaDuplicadoException.class)
    public ResponseEntity<String> handleTipoComidaDuplicadoException(TipoComidaDuplicadoException e) {
        return new ResponseEntity<>(getFormatedMessage("Error: Tipo de comida ya presente en el menú", e), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MenuSinComidasException.class)
    public ResponseEntity<String> handleMenuSinComidasException() {
        return new ResponseEntity<>("Error: Un menú debe contener al menos una comida", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MenuDiarioSinMenusException.class)
    public ResponseEntity<String> handleMenuDiarioSinMenusException() {
        return new ResponseEntity<>("Error: Un menú diario debe contener un menú vegetariano y un menú no vegetariano", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity<String> handleEmptyListException() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
