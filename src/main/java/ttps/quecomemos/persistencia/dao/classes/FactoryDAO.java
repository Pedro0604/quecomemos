package ttps.quecomemos.persistencia.dao.classes;

import ttps.quecomemos.modelo.sugerencia.Sugerencia;
import ttps.quecomemos.persistencia.dao.jpa.UsuarioDAOHibernateJPA;
import ttps.quecomemos.persistencia.dao.jpa.SugerenciaDAOHibernateJPA;
import ttps.quecomemos.modelo.menu.Comida;
import ttps.quecomemos.modelo.menu.Menu;
import ttps.quecomemos.modelo.usuario.Administrador;
import ttps.quecomemos.modelo.usuario.Cliente;
import ttps.quecomemos.modelo.usuario.ResponsableDeTurno;
import ttps.quecomemos.modelo.usuario.Usuario;
import ttps.quecomemos.persistencia.dao.jpa.*;

public class FactoryDAO {
    public static GenericDAO<Usuario> getUsuarioDAO() {
        return new UsuarioDAOHibernateJPA();
    }
    public static GenericDAO<Sugerencia> getSugerenciaDAO() {return new SugerenciaDAOHibernateJPA();}

    public static GenericDAO<Cliente> getClienteDAO() {
        return new ClienteDAOHibernateJPA();
    }

    public static GenericDAO<ResponsableDeTurno> getResponsableDeTurnoDAO() {
        return new ResponsableDeTurnoDAOHibernateJPA();
    }

    public static GenericDAO<Administrador> getAdministradorDAO() {
        return new AdministradorDAOHibernateJPA();
    }

    public static GenericDAO<Menu> getMenuDAO() {
        return new MenuDAOHibernateJPA();
    }

    public static GenericDAO<Comida> getComidaDAO() {
        return new ComidaDAOHibernateJPA();
    }
}
