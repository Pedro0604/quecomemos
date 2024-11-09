package ttps.quecomemos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ttps.quecomemos.modelo.usuario.Administrador;
import ttps.quecomemos.service.usuario.AdministradorService;

@RestController
@RequestMapping("/api/administradores") // URL base para el controlador
public class AdministradorController {

    private final AdministradorService administradorService;

    @Autowired
    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @PostMapping("/register")
    public ResponseEntity<Administrador> registerAdmin(@RequestBody Administrador administrador) {
        Administrador newAdmin = (Administrador) administradorService.save(administrador);
        return ResponseEntity.ok(newAdmin);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Administrador> editAdmin(@RequestBody Administrador administrador, @PathVariable Long id) {
        Administrador existingAdmin = (Administrador) administradorService.findById(id);
        if (existingAdmin != null) {
            existingAdmin = (Administrador) administradorService.update(administrador, administrador.getId());
            return ResponseEntity.ok(existingAdmin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
