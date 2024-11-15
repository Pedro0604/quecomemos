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

import java.util.List;

@RestController
@RequestMapping(path = "/menus", produces = MediaType.APPLICATION_JSON_VALUE)

public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public ResponseEntity<List<Menu>> getAllMenus() {
        return ResponseEntity.ok(menuService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> getMenu(@PathVariable Long id) {
        return ResponseEntity.ok(menuService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Menu> createMenu(@RequestBody MenuRequest menuRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(menuService.saveMenuRequest(menuRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Menu> updateMenu(@PathVariable Long id, @RequestBody MenuRequest menuRequest) {
        return ResponseEntity.ok(menuService.updateMenuRequest(menuRequest, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id) {
        menuService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/comidas")
    public ResponseEntity<List<Comida>> getComidas(@PathVariable Long id) {
        return ResponseEntity.ok(menuService.findById(id).getComidas());
    }
}
