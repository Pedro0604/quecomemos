package ttps.quecomemos.persistencia.dao.classes.menu;

import ttps.quecomemos.modelo.menu.Menu;
import ttps.quecomemos.persistencia.dao.classes.GenericDAO;

public interface MenuDAO extends GenericDAO<Menu> {
    public Menu getByName(String name);
}
