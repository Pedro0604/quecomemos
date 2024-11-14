package ttps.quecomemos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ttps.quecomemos.modelo.usuario.ResponsableDeTurno;
import ttps.quecomemos.service.usuario.ResponsableDeTurnoService;

@RestController
@RequestMapping("/responsables") // URL base para el controlador
public class ResponsableDeTurnoController {

    private final ResponsableDeTurnoService responsableDeTurnoService;

    @Autowired
    public ResponsableDeTurnoController(ResponsableDeTurnoService responsableDeTurnoService) {
        this.responsableDeTurnoService = responsableDeTurnoService;
    }

    @PostMapping
    public ResponseEntity<ResponsableDeTurno> registerResponsable(@RequestBody ResponsableDeTurno responsable) {
        return ResponseEntity.status(HttpStatus.CREATED).body(responsableDeTurnoService.save(responsable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponsableDeTurno> editResponsable(@RequestBody ResponsableDeTurno responsable, @PathVariable("id") Long id) {
        responsable.setId(id);
        return ResponseEntity.ok(responsableDeTurnoService.update(responsable, id));
    }

}
