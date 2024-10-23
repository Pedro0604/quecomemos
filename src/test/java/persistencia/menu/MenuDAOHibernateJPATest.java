package persistencia.menu;

import org.junit.jupiter.api.Test;
import ttps.quecomemos.modelo.menu.Comida;
import ttps.quecomemos.modelo.menu.Menu;
import ttps.quecomemos.modelo.menu.TipoComida;
import ttps.quecomemos.persistencia.dao.classes.FactoryDAO;
import ttps.quecomemos.persistencia.dao.classes.menu.MenuDAO;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MenuDAOHibernateJPATest {
    @Test
    public void testGetByName() {
        MenuDAO menuDAO = FactoryDAO.getMenuDAO();

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

        if (menuDAO.getByName("Menu veggie") == null) {
            menuDAO.persist(menu);
        }

        assertNotNull(menuDAO.getByName("Menu veggie"));
    }
}
