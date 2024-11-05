package ttps.quecomemos.persistencia.dao.jpa.menu;

import ttps.quecomemos.modelo.menu.MenuDiario;
import ttps.quecomemos.persistencia.dao.classes.GenericDAO;
import ttps.quecomemos.persistencia.dao.jpa.GenericDAOHibernateJPA;

public class MenuDiarioDAOHibernateJPA extends GenericDAOHibernateJPA<MenuDiario> implements GenericDAO<MenuDiario> {
    public MenuDiarioDAOHibernateJPA() {
        super(MenuDiario.class);
    }
}
