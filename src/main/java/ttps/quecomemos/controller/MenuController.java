package ttps.quecomemos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ttps.quecomemos.dto.MenuRequest;
import ttps.quecomemos.modelo.menu.Comida;
import ttps.quecomemos.modelo.menu.Menu;
import ttps.quecomemos.service.menu.MenuService;
import ttps.quecomemos.utils.JwtUtil;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/menus", produces = MediaType.APPLICATION_JSON_VALUE)

public class MenuController {

    private final MenuService menuService;
    private final JwtUtil jwtUtil = new JwtUtil();

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public ResponseEntity<List<Menu>> getAllMenus(@RequestHeader("Authorization") String token) {
        if (token != null && jwtUtil.validateToken(token.replace("Bearer ", ""))) {
            return ResponseEntity.ok(menuService.findAll());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> getMenu(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        if (token != null && jwtUtil.validateToken(token.replace("Bearer ", ""))) {
            return ResponseEntity.ok(menuService.findById(id));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping
    public ResponseEntity<Menu> createMenu(@RequestBody MenuRequest menuRequest, @RequestHeader("Authorization") String token) {
        if (token != null && jwtUtil.validateToken(token.replace("Bearer ", ""))) {
            return ResponseEntity.status(HttpStatus.CREATED).body(menuService.saveMenuRequest(menuRequest));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Menu> updateMenu(@PathVariable Long id, @RequestBody MenuRequest menuRequest, @RequestHeader("Authorization") String token) {
        if (token != null && jwtUtil.validateToken(token.replace("Bearer ", ""))) {
            return ResponseEntity.ok(menuService.updateMenuRequest(menuRequest, id));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        if (token != null && jwtUtil.validateToken(token.replace("Bearer ", ""))) {
            menuService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/{id}/comidas")
    public ResponseEntity<List<Comida>> getComidas(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        if (token != null && jwtUtil.validateToken(token.replace("Bearer ", ""))) {
            return ResponseEntity.ok(menuService.findById(id).getComidas());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
