package ttps.quecomemos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ttps.quecomemos.modelo.menu.Comida;
import ttps.quecomemos.service.menu.ComidaService;
import ttps.quecomemos.util.JwtUtil;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/comidas", produces = MediaType.APPLICATION_JSON_VALUE)
public class ComidaController {

    private final ComidaService comidaService;
    private final JwtUtil jwtUtil = new JwtUtil();

    @Autowired
    public ComidaController(ComidaService comidaService) {
        this.comidaService = comidaService;
    }

    @GetMapping // Maneja las solicitudes GET en /api/comidas
    public ResponseEntity<List<Comida>> getAllComidas(@RequestHeader("Authorization") String token) {
        if (token != null && jwtUtil.validateToken(token.replace("Bearer ", ""))) {
            return ResponseEntity.ok(comidaService.findAll());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comida> getComida(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        if (token != null && jwtUtil.validateToken(token.replace("Bearer ", ""))) {
            return ResponseEntity.ok(comidaService.findById(id));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping
    public ResponseEntity<Comida> createComida(@RequestBody Comida comida, @RequestHeader("Authorization") String token) {
        if (token != null && jwtUtil.validateToken(token.replace("Bearer ", ""))) {
            return ResponseEntity.status(HttpStatus.CREATED).body(comidaService.save(comida));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comida> editComida(@RequestBody Comida comida,  @PathVariable Long id, @RequestHeader("Authorization") String token) {
        if (token != null && jwtUtil.validateToken(token.replace("Bearer ", ""))) {
            comida.setId(id);
            return ResponseEntity.ok(comidaService.update(comida, id));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Comida> deleteComida(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        if (token != null && jwtUtil.validateToken(token.replace("Bearer ", ""))) {
            comidaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
