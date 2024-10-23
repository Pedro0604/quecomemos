package ttps.quecomemos.persistencia.dao.jpa.sugerencia;
import ttps.quecomemos.modelo.sugerencia.Sugerencia;
import ttps.quecomemos.persistencia.dao.classes.GenericDAO;
import ttps.quecomemos.persistencia.dao.jpa.GenericDAOHibernateJPA;


public class SugerenciaDAOHibernateJPA extends GenericDAOHibernateJPA<Sugerencia> implements GenericDAO<Sugerencia> {
    public SugerenciaDAOHibernateJPA() {
        super(Sugerencia.class);
    }
}
