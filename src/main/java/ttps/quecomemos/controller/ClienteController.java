package ttps.quecomemos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ttps.quecomemos.modelo.usuario.Cliente;
import ttps.quecomemos.service.usuario.ClienteService;

@RestController
@RequestMapping("/api/clientes") // URL base para el controlador
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) { this.clienteService = clienteService; }

    @PostMapping("/register")
    public ResponseEntity<Cliente> registerClient(@RequestBody Cliente cliente) {
        Cliente newClient = (Cliente) clienteService.save(cliente);
        return ResponseEntity.ok(newClient);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Cliente> editClient(@RequestBody Cliente cliente, @PathVariable Long id) {
        Cliente existingClient = (Cliente) clienteService.findById(id);
        if (existingClient != null) {
            existingClient = (Cliente) clienteService.update(cliente);
            return ResponseEntity.ok(existingClient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
