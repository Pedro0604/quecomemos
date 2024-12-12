package ttps.quecomemos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ttps.quecomemos.modelo.usuario.Administrador;
import ttps.quecomemos.modelo.usuario.CredencialAuth;
import ttps.quecomemos.service.usuario.AdministradorService;
import ttps.quecomemos.util.JwtUtil;

@CrossOrigin(
        origins = "http://localhost:4200",
        allowedHeaders = {"Authorization", "Content-Type"},
        exposedHeaders = {"Authorization"},
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
@RestController
@RequestMapping("/administradores") // URL base para el controlador
public class AdministradorController {

    private final AdministradorService administradorService;
    private final JwtUtil jwtUtil = new JwtUtil();

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

    @PostMapping("/autenticacion")
    public ResponseEntity<Administrador> authenticateAdmin(@RequestBody CredencialAuth credenciales) {
        Long clienteId = administradorService.autenticar(credenciales.getDni(), credenciales.getClave());
        if (clienteId != -1) {
            String token = jwtUtil.generateToken(clienteId.toString());
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer " + token);
            return new ResponseEntity<>(headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
