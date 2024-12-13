package ttps.quecomemos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ttps.quecomemos.dto.MenuDiarioRequest;
import ttps.quecomemos.modelo.menu.MenuDiario;
import ttps.quecomemos.service.menu.MenuDiarioService;
import ttps.quecomemos.util.JwtUtil;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/menus-diarios", produces = MediaType.APPLICATION_JSON_VALUE)

public class MenuDiarioController {

    private final MenuDiarioService menuDiarioService;
    private final JwtUtil jwtUtil = new JwtUtil();

    @Autowired
    public MenuDiarioController(MenuDiarioService menuDiarioService) {
        this.menuDiarioService = menuDiarioService;
    }

    @GetMapping
    public ResponseEntity<List<MenuDiario>> getAllMenusDiarios(@RequestHeader("Authorization") String token) {
        if (token != null && jwtUtil.validateToken(token.replace("Bearer ", ""))) {
            return ResponseEntity.ok(menuDiarioService.findAll());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/semanal")
    public ResponseEntity<List<MenuDiario>> getAllMenusDiariosSemanalas() {
            List<MenuDiario> menus = menuDiarioService.getAllMenusDiariosSemanalas();
            return ResponseEntity.ok(menus);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuDiario> getMenuDiario(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        if (token != null && jwtUtil.validateToken(token.replace("Bearer ", ""))) {
            return ResponseEntity.ok(menuDiarioService.findById(id));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping
    public ResponseEntity<MenuDiario> createMenuDiario(@RequestBody MenuDiarioRequest menuDiarioRequest, @RequestHeader("Authorization") String token) {
        if (token != null && jwtUtil.validateToken(token.replace("Bearer ", ""))) {
            return ResponseEntity.status(HttpStatus.CREATED).body(menuDiarioService.saveMenuDiarioRequest(menuDiarioRequest));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuDiario> updateMenuDiario(@PathVariable Long id, @RequestBody MenuDiarioRequest menuDiarioRequest, @RequestHeader("Authorization") String token) {
        if (token != null && jwtUtil.validateToken(token.replace("Bearer ", ""))) {
            return ResponseEntity.ok(menuDiarioService.updateMenuDiarioRequest(menuDiarioRequest, id));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenuDiario(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        if (token != null && jwtUtil.validateToken(token.replace("Bearer ", ""))) {
            menuDiarioService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
