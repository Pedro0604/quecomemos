package ttps.quecomemos.persistencia.dao.classes.menu;

import ttps.quecomemos.modelo.menu.Comida;
import ttps.quecomemos.persistencia.dao.classes.GenericDAO;

public interface ComidaDAO extends GenericDAO<Comida> {
    public Comida getByName(String name);
}
