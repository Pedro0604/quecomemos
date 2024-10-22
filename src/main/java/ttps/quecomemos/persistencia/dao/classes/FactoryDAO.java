package ttps.quecomemos.persistencia.dao.classes;

import ttps.quecomemos.persistencia.dao.jpa.UsuarioDAOHibernateJPA;

public class FactoryDAO {
    public static UsuarioDAO getUsuarioDAO() {
        return new UsuarioDAOHibernateJPA();
    }
}
