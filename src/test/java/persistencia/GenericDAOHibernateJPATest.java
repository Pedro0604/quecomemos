package persistencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ttps.quecomemos.modelo.menu.Comida;
import ttps.quecomemos.modelo.menu.TipoComida;
import ttps.quecomemos.persistencia.dao.classes.FactoryDAO;
import ttps.quecomemos.persistencia.dao.classes.GenericDAO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GenericDAOHibernateJPATest {
    GenericDAO<Comida> dao;

    private Comida getComida() {
        return new Comida("Pasta", "urlImagen", TipoComida.PLATO_PRINCIPAL, true, 8.0);
    }

    @BeforeEach
    public void setUp() {
        FactoryDAO.getMenuDAO().getAll("id").forEach(FactoryDAO.getMenuDAO()::delete);

        dao = FactoryDAO.getComidaDAO();
        dao.getAll("id").forEach(dao::delete);
    }

    @Test
    public void persistEntitySuccessfully() {
        Comida persistedComida = dao.persist(this.getComida());
        assertNotNull(persistedComida);
        assertEquals(persistedComida, dao.get(persistedComida.getId()));
    }

    @Test
    public void updateEntitySuccessfully() {
        Comida comida = this.getComida();
        comida.setPrecio(1);
        Comida updatedComida = dao.update(comida);
        assertNotNull(updatedComida);
        assertEquals(1, updatedComida.getPrecio());
        assertEquals(updatedComida, dao.get(updatedComida.getId()));
    }

    @Test
    public void deleteEntitySuccessfully() {
        Comida comida = this.getComida();
        dao.persist(comida);
        assertNotNull(dao.get(comida.getId()));
        dao.delete(comida);
        assertNull(dao.get(comida.getId()));
    }

    @Test
    public void deleteEntityByIdSuccessfully() {
        Comida comida = this.getComida();
        dao.persist(comida);
        assertNotNull(dao.get(comida.getId()));
        dao.delete(comida.getId());
        assertNull(dao.get(comida.getId()));
    }

    @Test
    public void getAllEntitiesOrderedByColumn() {
        Comida comida = this.getComida();
        dao.persist(comida);
        List<Comida> comidas = dao.getAll("nombre");
        assertNotNull(comidas);
        assertEquals(1, comidas.size());
    }

    @Test
    public void getEntityByIdSuccessfully() {
        Comida comida = this.getComida();
        dao.persist(comida);
        Comida foundComida = dao.get(comida.getId());
        assertNotNull(foundComida);
        assertEquals(comida.getId(), foundComida.getId());
    }

    @Test
    public void getEntityByIdReturnsNullIfNotFound() {
        assertNull(dao.get(134232L));
    }

}
