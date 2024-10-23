package ttps.quecomemos.persistencia.dao.jpa.menu;

import jakarta.persistence.EntityManager;
import ttps.quecomemos.modelo.menu.Menu;
import ttps.quecomemos.modelo.menu.MenuDiario;
import ttps.quecomemos.persistencia.dao.classes.GenericDAO;
import ttps.quecomemos.persistencia.dao.classes.menu.MenuDAO;
import ttps.quecomemos.persistencia.dao.jpa.GenericDAOHibernateJPA;
import ttps.quecomemos.persistencia.emf.EMF;

public class MenuDiarioDAOHibernateJPA extends GenericDAOHibernateJPA<MenuDiario> implements GenericDAO<MenuDiario> {
    public MenuDiarioDAOHibernateJPA() {
        super(MenuDiario.class);
    }
}
