package ttps.quecomemos.persistencia.dao.jpa;

import ttps.quecomemos.modelo.pedido.Pedido;
import ttps.quecomemos.persistencia.dao.classes.PedidoDAO;

public class PedidoDAOHibernateJPA extends GenericDAOHibernateJPA<Pedido> implements PedidoDAO {
    public PedidoDAOHibernateJPA() {
        super(Pedido.class);
    }
}
