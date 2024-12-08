package ttps.quecomemos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ttps.quecomemos.modelo.usuario.Administrador;
import ttps.quecomemos.modelo.usuario.Cliente;
import ttps.quecomemos.modelo.usuario.CredencialAuth;
import ttps.quecomemos.service.usuario.ClienteService;

@CrossOrigin
@RestController
@RequestMapping("/clientes") // URL base para el controlador
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> registerClient(@RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateClient(@RequestBody Cliente cliente, @PathVariable("id") long id) {
        cliente.setId(id);
        return ResponseEntity.ok(clienteService.update(cliente, id));
    }

    @PostMapping("/autenticacion")
    public ResponseEntity<Administrador> authenticateAdmin(@RequestBody CredencialAuth credenciales) {
        Long clienteId = clienteService.autenticar(credenciales.getDni(), credenciales.getClave());
        if (clienteId.intValue() != -1) {
            String token = clienteId + "123456";
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", token);

            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}
