package persistencia.usuarios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ttps.quecomemos.modelo.usuario.Administrador;
import ttps.quecomemos.persistencia.dao.classes.FactoryDAO;
import ttps.quecomemos.persistencia.dao.classes.UsuarioDAO;

public class GenericUserDAOHibernateJPATest {

    @BeforeEach
    public void setUp() {
        FactoryDAO.getAdministradorDAO().getAll("id").forEach(FactoryDAO.getAdministradorDAO()::delete);
    }

    @Test
    public void testGetByDniSuccess() {
        UsuarioDAO<Administrador> administradorDAO = FactoryDAO.getAdministradorDAO();
        Administrador administrador = new Administrador(40224974, "clave", "Juan", "Perez", "imagen.png");

        if (administradorDAO.getByDni(40224974) == null) {
            administradorDAO.persist(administrador);
        }

        assertNotNull(administradorDAO.getByDni(40224974));
    }

    @Test
    public void testGetByDniFail() {
        UsuarioDAO<Administrador> administradorDAO = FactoryDAO.getAdministradorDAO();

        assertNull(administradorDAO.getByDni(40224974));
    }

}
