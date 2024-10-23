package ttps.quecomemos.persistencia.dao.classes;

import ttps.quecomemos.modelo.menu.Comida;
import ttps.quecomemos.modelo.menu.Menu;
import ttps.quecomemos.persistencia.dao.jpa.ComidaDAOHibernateJPA;
import ttps.quecomemos.persistencia.dao.jpa.MenuDAOHibernateJPA;
import ttps.quecomemos.persistencia.dao.jpa.UsuarioDAOHibernateJPA;

public class FactoryDAO {
    public static UsuarioDAO getUsuarioDAO() {
        return new UsuarioDAOHibernateJPA();
    }

    public static GenericDAO<Menu> getMenuDAO() {
        return new MenuDAOHibernateJPA();
    }

    public static GenericDAO<Comida> getComidaDAO() {
        return new ComidaDAOHibernateJPA();
    }
}
