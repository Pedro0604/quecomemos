package ttps.quecomemos.persistencia.dao.jpa;
import ttps.quecomemos.modelo.sugerencia.Sugerencia;
import ttps.quecomemos.persistencia.dao.classes.SugerenciaDAO;


public class SugerenciaDAOHibernateJPA extends GenericDAOHibernateJPA<Sugerencia> implements SugerenciaDAO {
    public SugerenciaDAOHibernateJPA() {
        super(Sugerencia.class);
    }


}
