package ttps.quecomemos.service.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ttps.quecomemos.modelo.menu.Comida;
import ttps.quecomemos.modelo.menu.Menu;
import ttps.quecomemos.modelo.menu.TipoComida;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@Transactional
@SpringBootTest
public class MenuServiceTest {
    @Autowired
    private MenuService menuService;
    @Autowired
    private ComidaService comidaService;

    @BeforeEach
    public void setUp() {
        menuService.deleteAll();
        comidaService.deleteAll();
    }

    @Test
    public void testGetByNameSuccessful() {
        Menu menu = new Menu();
        menu.setNombre("Menu veggie");
        menu.setVegetariano(true);
        menu.setPrecio(1231.22);
        Comida comida = new Comida("Comida 1", null, TipoComida.POSTRE, true, 122);
        menu.addComida(comida);
        comida = new Comida("Comida 2", "urlImagen", TipoComida.PLATO_PRINCIPAL, true, 10.0);
        menu.addComida(comida);
        comida = new Comida("Comida 3", null, TipoComida.ENTRADA, true, 122);
        menu.addComida(comida);
        menuService.save(menu);

        assertNotNull(menuService.getByName("Menu veggie"));
    }

    @Test
    public void testGetByNameReturnsNullWhenNotFound() {
        assertNull(menuService.getByName("Menu veggie"));
    }
}
