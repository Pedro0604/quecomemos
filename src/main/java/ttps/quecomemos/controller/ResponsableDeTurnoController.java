package ttps.quecomemos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    public ResponseEntity<ResponsableDeTurno> registerResponsable(@RequestBody ResponsableDeTurno responsable) {
        if (responsableDeTurnoService.isResponsableExist(responsable)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        responsableDeTurnoService.save(responsable);
        return new ResponseEntity<ResponsableDeTurno>(HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ResponsableDeTurno> editResponsable(@RequestBody ResponsableDeTurno responsable, @PathVariable("id") Long id) {
        ResponsableDeTurno currentResponsable = (ResponsableDeTurno) responsableDeTurnoService.findById(id);

        if (currentResponsable == null) {
            return new ResponseEntity<ResponsableDeTurno>(HttpStatus.NOT_FOUND);
        }

        currentResponsable.setDni(responsable.getDni());
        currentResponsable.setNombre(responsable.getNombre());
        currentResponsable.setApellido(responsable.getApellido());
        currentResponsable.setUrlImagen(responsable.getUrlImagen());
        currentResponsable.setTurno(responsable.getTurno());
        currentResponsable.setClave(responsable.getClave());

        responsableDeTurnoService.update(currentResponsable, id);
        return new ResponseEntity<ResponsableDeTurno>(currentResponsable, HttpStatus.OK);
    }

}
