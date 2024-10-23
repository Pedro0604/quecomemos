package ttps.quecomemos.persistencia.dao.jpa.pedido;

import ttps.quecomemos.modelo.pedido.Pedido;
import ttps.quecomemos.persistencia.dao.classes.GenericDAO;
import ttps.quecomemos.persistencia.dao.jpa.GenericDAOHibernateJPA;

public class PedidoDAOHibernateJPA extends GenericDAOHibernateJPA<Pedido> implements GenericDAO<Pedido> {
    public PedidoDAOHibernateJPA() {
        super(Pedido.class);
    }
}
