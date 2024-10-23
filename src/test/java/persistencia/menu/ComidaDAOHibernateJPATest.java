package persistencia.menu;

import org.junit.jupiter.api.Test;
import ttps.quecomemos.modelo.menu.Comida;
import ttps.quecomemos.modelo.menu.TipoComida;
import ttps.quecomemos.persistencia.dao.classes.FactoryDAO;
import ttps.quecomemos.persistencia.dao.classes.menu.ComidaDAO;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ComidaDAOHibernateJPATest {
    private final String name = String.valueOf(Math.random());

    @Test
    public void testGetByName() {
        ComidaDAO comidaDAO = FactoryDAO.getComidaDAO();
        Comida comida = new Comida("Comida carnivora", null, TipoComida.POSTRE, false, 1222);

        if (comidaDAO.getByName("Comida carnivora") == null) {
            comidaDAO.persist(comida);
        }

        assertNotNull(comidaDAO.getByName("Comida carnivora"));
    }
}
