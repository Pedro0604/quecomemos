package ttps.quecomemos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ttps.quecomemos.modelo.usuario.Cliente;
import ttps.quecomemos.service.usuario.ClienteService;

@RestController
@RequestMapping("/api/clientes") // URL base para el controlador
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> registerClient(@RequestBody Cliente cliente) {
        if (clienteService.isClienteExist(cliente)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        clienteService.save(cliente);
        return new ResponseEntity<Cliente>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateClient(@RequestBody Cliente cliente, @PathVariable("id") long id) {
        Cliente currentClient = (Cliente) clienteService.findById(id);

        if (currentClient == null) {
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }

        currentClient.setDni(cliente.getDni());
        currentClient.setNombre(cliente.getNombre());
        currentClient.setApellido(cliente.getApellido());
        currentClient.setEmail(cliente.getEmail());
        currentClient.setUrlImagen(cliente.getUrlImagen());
        currentClient.setClave(cliente.getClave());

        clienteService.update(currentClient, id);
        return new ResponseEntity<Cliente>(currentClient, HttpStatus.OK);
    }

}
