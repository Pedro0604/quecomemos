package ttps.quecomemos.persistencia.dao.classes;

import ttps.quecomemos.modelo.menu.Menu;

public interface MenuDAO extends GenericDAO<Menu> {
    public Menu getByName(String name);
}
