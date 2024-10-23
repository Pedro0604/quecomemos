package ttps.quecomemos.persistencia.dao.classes;

import ttps.quecomemos.persistencia.dao.jpa.UsuarioDAOHibernateJPA;
import ttps.quecomemos.persistencia.dao.jpa.SugerenciaDAOHibernateJPA;

public class FactoryDAO {
    public static UsuarioDAO getUsuarioDAO() {
        return new UsuarioDAOHibernateJPA();
    }
    public static SugerenciaDAO getSugerenciaDAO() {return new SugerenciaDAOHibernateJPA();}
}
