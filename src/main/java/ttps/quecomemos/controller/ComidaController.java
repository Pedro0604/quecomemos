package ttps.quecomemos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ttps.quecomemos.modelo.menu.Comida;
import ttps.quecomemos.service.menu.ComidaService;
import java.util.List;

@RestController
@RequestMapping ("/api/comidas")
public class ComidaController {

    private final ComidaService comidaService;

    @Autowired
    public ComidaController(ComidaService comidaService) {
        this.comidaService = comidaService;
    }

    @GetMapping // Maneja las solicitudes GET en /api/comidas
    public ResponseEntity<List<Comida>> getAllComidas() {
        List<Comida> comidas = comidaService.findAll();
        return ResponseEntity.ok(comidas);
    }

    @PostMapping("/create")
    public ResponseEntity<Comida> createComida(@RequestBody Comida comida) {
        Comida newComida = comidaService.save(comida);
        return ResponseEntity.ok(newComida);
    }

    @PostMapping("/update")
    public ResponseEntity<Comida> updateComida(@RequestBody Comida comida) {
        Comida updatedComida = comidaService.update(comida);
        return ResponseEntity.ok(updatedComida);
    }


}
