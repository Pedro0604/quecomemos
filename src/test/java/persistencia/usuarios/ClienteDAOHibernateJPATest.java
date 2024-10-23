package persistencia.usuarios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ttps.quecomemos.modelo.usuario.Cliente;
import ttps.quecomemos.persistencia.dao.classes.ClienteDAO;
import ttps.quecomemos.persistencia.dao.classes.FactoryDAO;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ClienteDAOHibernateJPATest {

    @BeforeEach
    public void setUp() {
        FactoryDAO.getClienteDAO().getAll("email").forEach(FactoryDAO.getClienteDAO()::delete);
    }

    @Test
    public void testGetByEmailSuccess() {
        ClienteDAO clienteDAO = FactoryDAO.getClienteDAO();
        Cliente cliente = new Cliente(37845902, "clave", "Juan", "Perez", "imagen.png", "juanPerez@gmail.com");

        if (clienteDAO.getByEmail("juanPerez@gmail.com") == null) {
            clienteDAO.persist(cliente);
        }

        assertNotNull(clienteDAO.getByEmail("juanPerez@gmail.com"));
    }

    @Test
    public void testGetByEmailFail() {
        ClienteDAO clienteDAO = FactoryDAO.getClienteDAO();

        assertNull(clienteDAO.getByEmail("juanPerez@gmail.com"));
    }
}
