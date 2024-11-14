package ttps.quecomemos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ttps.quecomemos.modelo.menu.Comida;
import ttps.quecomemos.service.menu.ComidaService;

import java.util.List;

@RestController
@RequestMapping("/api/comidas")
public class ComidaController {

    private final ComidaService comidaService;

    @Autowired
    public ComidaController(ComidaService comidaService) {
        this.comidaService = comidaService;
    }

    @GetMapping // Maneja las solicitudes GET en /api/comidas
    public ResponseEntity<List<Comida>> getAllComidas() {
        return ResponseEntity.ok(comidaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comida> getComida(@PathVariable Long id) {
        return ResponseEntity.ok(comidaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Comida> createComida(@RequestBody Comida comida) {
        return ResponseEntity.status(HttpStatus.CREATED).body(comidaService.save(comida));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comida> editComida(@RequestBody Comida comida,  @PathVariable Long id) {

        return ResponseEntity.ok(comidaService.update(comida, id));
    }


}
