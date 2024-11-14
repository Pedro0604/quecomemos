package ttps.quecomemos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    public ResponseEntity<Administrador> registerAdmin(@RequestBody Administrador administrador) {
        if (administradorService.isAdministradorExist(administrador)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        administradorService.save(administrador);
        return new ResponseEntity<Administrador>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrador> editAdmin(@RequestBody Administrador administrador, @PathVariable("id") Long id) {
        Administrador currentAdmin = (Administrador) administradorService.findById(id);

        if (currentAdmin == null) {
            return new ResponseEntity<Administrador>(HttpStatus.NOT_FOUND);
        }

        currentAdmin.setDni(administrador.getDni());
        currentAdmin.setNombre(administrador.getNombre());
        currentAdmin.setApellido(administrador.getApellido());
        currentAdmin.setUrlImagen(administrador.getUrlImagen());
        currentAdmin.setClave(administrador.getClave());

        administradorService.update(currentAdmin, id);
        return new ResponseEntity<Administrador>(currentAdmin, HttpStatus.OK);
    }

}
