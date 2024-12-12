package ttps.quecomemos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ttps.quecomemos.modelo.usuario.Administrador;
import ttps.quecomemos.modelo.usuario.CredencialAuth;
import ttps.quecomemos.modelo.usuario.ResponsableDeTurno;
import ttps.quecomemos.service.usuario.ResponsableDeTurnoService;
import ttps.quecomemos.util.JwtUtil;

@CrossOrigin(
        origins = "http://localhost:4200",
        allowedHeaders = {"Authorization", "Content-Type"},
        exposedHeaders = {"Authorization"},
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
@RestController
@RequestMapping("/responsables") // URL base para el controlador
public class ResponsableDeTurnoController {

    private final ResponsableDeTurnoService responsableDeTurnoService;
    private final JwtUtil jwtUtil = new JwtUtil();

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

    @PostMapping("/autenticacion")
    public ResponseEntity<Administrador> authenticateAdmin(@RequestBody CredencialAuth credenciales) {
        Long clienteId = responsableDeTurnoService.autenticar(credenciales.getDni(), credenciales.getClave());
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
