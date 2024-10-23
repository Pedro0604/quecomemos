package ttps.quecomemos.persistencia.dao.jpa.pago;

import ttps.quecomemos.modelo.pago.Pago;
import ttps.quecomemos.persistencia.dao.classes.GenericDAO;
import ttps.quecomemos.persistencia.dao.jpa.GenericDAOHibernateJPA;

public class PagoDAOHibernateJPA extends GenericDAOHibernateJPA<Pago> implements GenericDAO<Pago> {
    public PagoDAOHibernateJPA() {
        super(Pago.class);
    }
}
