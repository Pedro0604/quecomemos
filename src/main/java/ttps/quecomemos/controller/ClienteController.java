package ttps.quecomemos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ttps.quecomemos.modelo.usuario.Cliente;
import ttps.quecomemos.service.usuario.ClienteService;

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

}
