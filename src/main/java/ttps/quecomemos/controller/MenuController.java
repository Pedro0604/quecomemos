package ttps.quecomemos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ttps.quecomemos.modelo.menu.Comida;
import ttps.quecomemos.modelo.menu.Menu;
import ttps.quecomemos.service.menu.ComidaService;
import ttps.quecomemos.service.menu.MenuService;

import java.util.List;

@RestController
@RequestMapping(path = "/menus", produces = MediaType.APPLICATION_JSON_VALUE)

public class MenuController {

    private final MenuService menuService;
    private final ComidaService comidaService;

    @Autowired
    public MenuController(MenuService menuService, ComidaService comidaService) {
        this.menuService = menuService;
        this.comidaService = comidaService;
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
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu) {
        return ResponseEntity.status(HttpStatus.CREATED).body(menuService.save(menu));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Menu> updateMenu(@PathVariable Long id, @RequestBody Menu menu) {
        menu.setId(id);
        return ResponseEntity.ok(menuService.update(menu, id));
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

    // TODO - MODIFICAR MENU PARA QUE LANCE DIFERENTES TIPOS DE EXCEPCION DE ACUERDO A LOS ERRORES QUE PUEDAN SURGIR AL AÑADIR UNA COMIDA
    @PostMapping("/{id}/comidas")
    public ResponseEntity<Menu> addComida(@PathVariable Long id, @RequestBody Long comida_id) {
        Menu menu = menuService.findById(id);
        Comida comida = comidaService.findById(comida_id);
        menu.addComida(comida);
        return ResponseEntity.ok(menuService.update(menu, id));
    }
}
