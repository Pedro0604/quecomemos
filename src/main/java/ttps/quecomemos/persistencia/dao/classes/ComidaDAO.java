package ttps.quecomemos.persistencia.dao.classes;

import ttps.quecomemos.modelo.menu.Comida;
import ttps.quecomemos.modelo.menu.Menu;

public interface ComidaDAO extends GenericDAO<Comida> {
    public Comida getByName(String name);
}
