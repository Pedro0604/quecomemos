package ttps.quecomemos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ttps.quecomemos.modelo.usuario.Administrador;
import ttps.quecomemos.service.usuario.AdministradorService;

@RestController
@RequestMapping("/administradores") // URL base para el controlador
public class AdministradorController {

    private final AdministradorService administradorService;

    @Autowired
    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @PostMapping
    public ResponseEntity<Administrador> createAdmin(@RequestBody Administrador administrador) {
        return ResponseEntity.status(HttpStatus.CREATED).body(administradorService.save(administrador));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrador> editAdmin(@RequestBody Administrador administrador, @PathVariable("id") Long id) {
        administrador.setId(id);
        return ResponseEntity.ok(administradorService.update(administrador, id));
    }

}
