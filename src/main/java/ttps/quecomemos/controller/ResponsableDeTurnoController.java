package ttps.quecomemos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ttps.quecomemos.modelo.usuario.ResponsableDeTurno;
import ttps.quecomemos.service.usuario.ResponsableDeTurnoService;

@RestController
@RequestMapping("/api/responsables") // URL base para el controlador
public class ResponsableDeTurnoController {

    private final ResponsableDeTurnoService responsableDeTurnoService;

    @Autowired
    public ResponsableDeTurnoController(ResponsableDeTurnoService responsableDeTurnoService) {
        this.responsableDeTurnoService = responsableDeTurnoService;
    }

    @PostMapping("/register")
    public ResponseEntity<ResponsableDeTurno> registerResponsable(@RequestBody ResponsableDeTurno responsable) {
        ResponsableDeTurno newResponsable = (ResponsableDeTurno) responsableDeTurnoService.save(responsable);
        return ResponseEntity.ok(newResponsable);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<ResponsableDeTurno> editResponsable(@RequestBody ResponsableDeTurno responsable, @PathVariable Long id) {
        ResponsableDeTurno existingResponsable = (ResponsableDeTurno) responsableDeTurnoService.findById(id);
        if (existingResponsable != null) {
            existingResponsable = (ResponsableDeTurno) responsableDeTurnoService.update(responsable, id);
            return ResponseEntity.ok(existingResponsable);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
