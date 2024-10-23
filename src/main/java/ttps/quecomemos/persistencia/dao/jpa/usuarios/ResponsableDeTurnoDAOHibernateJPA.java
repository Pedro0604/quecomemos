package ttps.quecomemos.persistencia.dao.jpa.usuarios;

import ttps.quecomemos.modelo.usuario.ResponsableDeTurno;

public class ResponsableDeTurnoDAOHibernateJPA extends GenericUserDAOHibernateJPA<ResponsableDeTurno> {
    public ResponsableDeTurnoDAOHibernateJPA() {
        super(ResponsableDeTurno.class);
    }
}
