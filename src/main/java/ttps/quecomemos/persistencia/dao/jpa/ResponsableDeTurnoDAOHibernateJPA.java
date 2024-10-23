package ttps.quecomemos.persistencia.dao.jpa;

import ttps.quecomemos.modelo.usuario.ResponsableDeTurno;
import ttps.quecomemos.persistencia.dao.classes.ResponsableDeTurnoDAO;

public class ResponsableDeTurnoDAOHibernateJPA extends GenericDAOHibernateJPA<ResponsableDeTurno> implements ResponsableDeTurnoDAO {
    public ResponsableDeTurnoDAOHibernateJPA() {
        super(ResponsableDeTurno.class);
    }
}
