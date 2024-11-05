package ttps.quecomemos.service.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ttps.quecomemos.modelo.menu.Comida;
import ttps.quecomemos.modelo.menu.TipoComida;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class ComidaServiceTest {
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
        Comida comida = new Comida("Comida carnivora", null, TipoComida.POSTRE, false, 1222);
        comidaService.save(comida);

        assertNotNull(comidaService.getByName("Comida carnivora"));
    }

    @Test
    public void testGetByNameReturnsNullWhenNotFound() {
        assertNull(comidaService.getByName("Comida carnivora"));
    }
}
